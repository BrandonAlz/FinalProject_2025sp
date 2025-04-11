package characters;

public class Archer extends PlayerCharacter {

	
	 public Archer(String name) {
	        super(name, 50, 20, 80, 25); // name, health, damage, energy, crit

	        // Archer abilities 
	        PlayerAbilities.TripleShot tripleShot = new PlayerAbilities.TripleShot();
	        tripleShot.setDescription("Fires three arrows in rapid succession, dealing damage to the target.");
	        addAbility(tripleShot);
	
}

	        
	    }
	}



