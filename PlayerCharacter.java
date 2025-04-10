/**
 * 
 */
package characters;

/**
 * 
 */
public abstract class PlayerCharacter extends Character {
    protected int crit;
    protected int level;
    protected int experience;
    
    public PlayerCharacter(String name, int health, int damage, int energy, int crit) {
        super(name, health, damage, energy);
        this.crit = crit;
        this.level = 1;
        this.experience = 0;
    }
    
    public int getCrit() {
        return crit;
    }
    
    public void setCrit(int crit) {
        this.crit = crit;
    }
    
    public int getLevel() {
        return level;
    }
    
    public int getExperience() {
        return experience;
    }
    
    public void gainExperience(int amount) {
        if (amount <= 0) {
            return;
        }
        
        experience += amount;
        
        // Check for level up (formula: 100 * current level to level up)
        if (experience >= level * 100) {
            levelUp();
        }
    }
    
    private void levelUp() {
        level++;
        experience = 0; // Reset experience for next level
        
        // Increase stats on level up
        int healthIncrease = 10;
        int damageIncrease = 2;
        int energyIncrease = 5;
        int critIncrease = 1;
        
        maxHealth += healthIncrease;
        health = maxHealth; // Heal to full on level up
        damage += damageIncrease;
        maxEnergy += energyIncrease;
        energy = maxEnergy; // Restore full energy on level up
        crit += critIncrease;
    }
    


}