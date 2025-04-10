/**
 * 
 */
package characters;

/**
 * 
 */
public abstract class Ability {
    protected String name;
    protected int cooldown;
    protected int energyCost;
    protected String description;
    
    public Ability(String name, int cooldown, int energyCost) {
        this.name = name;
        this.cooldown = cooldown;
        this.energyCost = energyCost;
        this.description = "";
    }
    
    public Ability(String name, int cooldown, int energyCost, String description) {
        this.name = name;
        this.cooldown = cooldown;
        this.energyCost = energyCost;
        this.description = description;
    }
    
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
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    // Abstract method to be implemented by each specific ability
    public abstract void use(Character user);
    

}