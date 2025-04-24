package characters;

public class Wizard extends PlayerCharacter {
	public Wizard(String name) {
        	super(name, 40, 12, 120, 22); // name, health, damage, energy, crit
        	// Wizard's base attack will be a fireball with decent range, low speed, and area damage
		boolean wizardAlive = true;
                int lives = 3;
                if (lives = 0) { // we can add a while true here if necessary
                        wizardAlive = false;
                }
                // Wizard abilities 
        	PlayerAbilities.Fireball fireball = new PlayerAbilities.Fireball();
        	fireball.setDescription("Launches a large fireball that damages enemies in a radius.");
        	addAbility(fireball);

                public void loseLife {
                        lives = lives - 1;
                }
    
                public int getLives {
                        return lives;
                }

		public void isAlive {
			return wizardAlive;
		}
	}
}
