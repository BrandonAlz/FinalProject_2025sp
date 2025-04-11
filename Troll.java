package characters;

public class Troll extends EnemyCharacter {
	private int moveSpeed;
    public Spider() {
    	String name, int health, int damage, int energy, int xpReward = super("Troll", 120, 15, 83, 50); // name, health, damage, energy, xp reward
        setDifficulty(2);
        this.moveSpeed = 3.5; // Trolls move slowly
        
        EnemyAbilities.Heal heal = new EnemyAbilities.Heal();
        Heal.setDescription("Heals 4 health every second/every turn, unless already at full health");
    }
    
    public int getMoveSpeed() {
        return moveSpeed;
    }
    
    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }
}
