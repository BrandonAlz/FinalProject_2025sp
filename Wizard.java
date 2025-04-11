/**
 * 
 */
package characters;

/**
 * 
 */
public class Wizard extends PlayerCharacter {

	
	public Wizard(String name) {
        super(name, 40, 10, 120, 30); // name, health, damage, energy, crit

        //  Wizard abilities 
        PlayerAbilities.Fireball fireball = new PlayerAbilities.Fireball();
        fireball.setDescription("Launches a large fireball that damages enemies in a radius.");
        addAbility(fireball);
	}
}