package character;

public class Knight extends PlayerCharacter {
    public Knight(String name) {
        super(name, 60, 15, 100, 15);
        PlayerAbilities.Dash dash = new PlayerAbilities.Dash();
        dash.setDescription("Quick movement that avoids enemy attacks and repositions the Knight.");
        addAbility(dash);
    }
}