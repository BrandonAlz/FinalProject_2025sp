package character;


public class Archer extends PlayerCharacter {
    public Archer(String name) {
        super(name, 50, 20, 80, 25);
        
        PlayerAbilities.TripleShot tripleShot = new PlayerAbilities.TripleShot();
        tripleShot.setDescription("Fires three arrows in rapid succession, dealing damage to the target.");
        addAbility(tripleShot);
    }
}

