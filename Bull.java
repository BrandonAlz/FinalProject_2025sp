/**
 * 
 */
package characters;

/**
 * 
 */
public class Bull extends PlayerCharacter {
	
	 public Bull(String name) {
	        super(name, 100, 30, 120, 10); // name, health, damage, energy, crit

	        // Bull abilities 
	        
	        PlayerAbilities.GroundPound stomp = new PlayerAbilities.GroundPound();
	        stomp.setDescription("A powerful stomp that damages and stuns enemies within range.");
	        addAbility(stomp);
    
	 }
	}