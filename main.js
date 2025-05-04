import { joinGame } from './multiplayer.js';

window.startMultiplayer = () => {
  const name = document.getElementById('name').value;
  const charClass = document.getElementById('class').value;
  if (!name || !charClass) return alert('Please enter name and class');
  joinGame(name, charClass);
};
