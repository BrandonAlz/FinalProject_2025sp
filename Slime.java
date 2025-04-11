package characters;

public class Slime extends EnemyCharacter {
	private int moveSpeed;
    public Spider() {
    	String name, int health, int damage, int energy, int xpReward = super("Slime", 50, 10, 40, 30); // name, health, damage, energy, xp reward
        setDifficulty(2);
        this.moveSpeed = 5.5; // Slimes move average speed
    }
    
    public int getMoveSpeed() {
        return moveSpeed;
    }
    
    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }
}
