/**
 * 
 */
package characters;

/**
 * 
 */
public class Gambler extends PlayerCharacter {
	
	 public Gambler(String name) {
	        super(name, 70, 26, 120, 50); // name, health, damage, energy, crit

	        // Gambler abilities 
	        
	        PlayerAbilities.Gamble = new PlayerAbilities.Gamble();
	        stomp.setDescription("Bets 5 coins that he will do more damage in the next 10 seconds than archer. If he wins, he takes 5 coins from");
	        addAbility(stomp);
    
	 }
	}
