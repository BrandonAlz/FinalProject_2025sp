/**
 * 
 */
package characters;

/**
 * 
 */
public abstract class EnemyCharacter extends Character {
    protected int experienceReward;
    protected int difficulty;
    
    public EnemyCharacter(String name, int health, int damage, int energy, int experienceReward) {
        super(name, health, damage, energy);
        this.experienceReward = experienceReward;
        this.difficulty = 1;
    }
    
    public int getExperienceReward() {
        return experienceReward;
    }
    
    public void setExperienceReward(int experienceReward) {
        this.experienceReward = experienceReward;
    }
    
    public int getDifficulty() {
        return difficulty;
    }
    
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
    
    /**
     * Scale this enemy's stats based on a player's level
     * @param playerLevel The level to scale to
     */
    public void scaleToPlayerLevel(int playerLevel) {
        if (playerLevel <= 1) {
            return; // No scaling needed for level 1
        }
        
        // Scale health and damage based on player level and difficulty
        double scaleFactor = 1.0 + ((playerLevel - 1) * 0.1 * difficulty);
        
        int newMaxHealth = (int)(maxHealth * scaleFactor);
        maxHealth = newMaxHealth;
        health = maxHealth;
        
        int newDamage = (int)(damage * scaleFactor);
        damage = newDamage;
        
        // Scale rewards
        experienceReward = (int)(experienceReward * scaleFactor);
    }
        
 
}