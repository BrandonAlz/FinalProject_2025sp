import { Amplify, API, graphqlOperation } from 'aws-amplify';
import awsExports from './aws-exports.js';
import { createPlayer, createMatch, updateMatch, updatePlayer } from './graphql/mutations.js';
import { getMatch, listMatches } from './graphql/queries.js';

Amplify.configure(awsExports);

export async function joinGame(name, charClass) {
  const player = await API.graphql(graphqlOperation(createPlayer, {
    input: {
      name,
      characterClass: charClass
    }
  }));

  const playerId = player.data.createPlayer.id;

  const openMatches = await API.graphql(graphqlOperation(listMatches, {
    filter: { gameStarted: { eq: false } }
  }));

  let matchId;

  if (openMatches.data.listMatches.items.length > 0) {
    const match = openMatches.data.listMatches.items[0];
    matchId = match.id;

    await API.graphql(graphqlOperation(updatePlayer, {
      input: {
        id: playerId,
        matchId
      }
    }));

    await API.graphql(graphqlOperation(updateMatch, {
      input: {
        id: matchId,
        gameStarted: true
      }
    }));

    window.location.href = `/game.html?matchId=${matchId}&playerId=${playerId}`;
  } else {
    const newMatch = await API.graphql(graphqlOperation(createMatch, {
      input: {
        gameStarted: false
      }
    }));

    matchId = newMatch.data.createMatch.id;

    await API.graphql(graphqlOperation(updatePlayer, {
      input: {
        id: playerId,
        matchId
      }
    }));

    waitForOpponent(matchId, playerId);
  }
}

function waitForOpponent(matchId, playerId) {
  const check = setInterval(async () => {
    const res = await API.graphql(graphqlOperation(getMatch, { id: matchId }));
    const match = res.data.getMatch;

    if (match.gameStarted) {
      clearInterval(check);
      window.location.href = `/game.html?matchId=${matchId}&playerId=${playerId}`;
    }
  }, 3000);
}
