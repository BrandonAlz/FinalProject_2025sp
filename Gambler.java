package characters;

public class Gambler extends PlayerCharacter {
	public Gambler(String name) {
		super(name, 65, 16, 120, 34); // name, health, damage, energy, crit
	        // Gambler's base attack will be a close-range punch
		boolean gamblerAlive = true;
                int lives = 3;
                if (lives = 0) { // we can add a while true here if necessary
                        gamblerAlive = false;
                }
                // Gambler abilities
	        PlayerAbilities.Gamble = new PlayerAbilities.Gamble();
	        Gamble.setDescription("Bets 5 coins that he will do more damage in the next 10 seconds than archer. If he wins, he takes 5 coins from them, if her loses, he gives them 5 coins."); // we may change this ability because it is too complex to code
	        addAbility(Gamble);

                public void loseLife {
                        lives = lives - 1;
                }
    
                public int getLives {
                        return lives;
                }

                public void isAlive {
                        return gamblerAlive;
                }
	}
}
