package characters;

public class Skeleton extends EnemyCharacter {
	private int moveSpeed;
    public Spider() {
    	String name, int health, int damage, int energy, int xpReward = super("Skeleton", 28, 14, 55, 35); // name, health, damage, energy, xp reward
        setDifficulty(2);
        this.moveSpeed = 2; // Skeletons barely move at all
    }
    
    public int getMoveSpeed() {
        return moveSpeed;
    }
    
    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }
}
