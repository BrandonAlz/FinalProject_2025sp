package characters;

public class Archer extends PlayerCharacter {
	public Archer(String name) {
		super(name, 25, 13, 80, 26); // name, health, damage, energy, crit
		int projectileSpeed = 7;		
	        // Archer abilities 
	        PlayerAbilities.TripleShot tripleShot = new PlayerAbilities.TripleShot();
	        tripleShot.setDescription("Fires a spread shot of 3 arrows, one 15 degrees higher, one 15 degrees lower.");
	        addAbility(tripleShot);
	}
}
