package characters;

public class Gambler extends PlayerCharacter {
	public Gambler(String name) {
		super(name, 65, 20, 120, 44); // name, health, damage, energy, crit
	        // Gambler abilities 
	        PlayerAbilities.Gamble = new PlayerAbilities.Gamble();
	        Gamble.setDescription("Bets 5 coins that he will do more damage in the next 10 seconds than archer. If he wins, he takes 5 coins from them, if her loses, he gives them 5 coins."); // we may change this ability because it is too complex to code
	        addAbility(Gamble);
	}
}
