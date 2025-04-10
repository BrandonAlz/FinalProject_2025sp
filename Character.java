package characters;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for all characters in the game.
 */
public abstract class Character {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int damage;
    protected int energy;
    protected int maxEnergy;
    protected List<Ability> abilities;
    
    public Character(String name, int health, int damage, int energy) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.damage = damage;
        this.energy = energy;
        this.maxEnergy = energy;
        this.abilities = new ArrayList<>();
    }
    
    // Getters and setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        this.health = Math.min(health, maxHealth);
    }
    
    public int getMaxHealth() {
        return maxHealth;
    }
    
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }
    
    public int getDamage() {
        return damage;
    }
    
    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    public int getEnergy() {
        return energy;
    }
    
    public void setEnergy(int energy) {
        this.energy = Math.min(energy, maxEnergy);
    }
    
    public int getMaxEnergy() {
        return maxEnergy;
    }
    
    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
        if (energy > maxEnergy) {
            energy = maxEnergy;
        }
    }
    
    public List<Ability> getAbilities() {
        return abilities;
    }
    
    public void addAbility(Ability ability) {
        abilities.add(ability);
    }
    
 
}