package characters;

public class Knight extends PlayerCharacter {
    public Knight(String name) {
        super(name, 60, 15, 100, 25); // name, health, damage, energy, crit
        // knight abilities
        PlayerAbilities.Dash dash = new PlayerAbilities.Dash();
        dash.setDescription("Quick movement that avoids enemy attacks and repositions the Knight");
        addAbility(dash);
        boolean abilityAvailable = true;
        long elapsedTime = 0;
        while (true) {
        	elapsedTime = System.currentTimeMillis() - startTime;
            long elapsedSeconds = elapsedTime / 1000;
        	if (elapsedSeconds > 20) {
            abilityAvailable = true; // 20 second ability cooldown
        	}
        }
    }
}
