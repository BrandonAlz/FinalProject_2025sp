package character;


public abstract class Ability {
    private String name;
    private int cooldown;
    private int energyCost;
    private String description;

    public Ability(String name, int cooldown, int energyCost) {
        this.name = name;
        this.cooldown = cooldown;
        this.energyCost = energyCost;
    }

    public abstract void use(PlayerCharacter user);

    public String getName() {
        return name;
    }

    public int getCooldown() {
        return cooldown;
    }

    public int getEnergyCost() {
        return energyCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }
}