package characters;

public class Archer extends PlayerCharacter {
	public Archer(String name) {
		super(name, 25, 13, 80, 26); // name, health, damage, energy, crit
		int projectileSpeed = 7;		
	        // Archer's base attack is a long-range, high speed arrow
		boolean archerAlive = true;
                int lives = 3;
                if (lives = 0) { // we can add a while true here if necessary
                        archerAlive = false;
                }
                // Archer abilities 
	        PlayerAbilities.TripleShot tripleShot = new PlayerAbilities.TripleShot();
	        tripleShot.setDescription("Fires a spread shot of 3 arrows, one 15 degrees higher, one 15 degrees lower.");
	        addAbility(tripleShot);

                public void loseLife {
                        lives = lives - 1;
                }
    
                public int getLives {
                        return lives;
                }

		public void isAlive {
			return archerAlive;
		}
	}
}
