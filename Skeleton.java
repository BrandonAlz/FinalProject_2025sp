package characters;

public class Skeleton extends EnemyCharacter {
	private int moveSpeed;
	String name, int health, int damage, int energy, int xpReward = super("Skeleton", 28, 14, 55, 35); // name, health, damage, energy, xp reward
	public static void main(String[] args) {
        this.moveSpeed = 2; // Skeletons barely move at all
        Skeleton mySkeleton = new Skeleton();
        mySkeleton.scaleToPlayerLevel(3);
        mySkeleton.setDifficulty(2);
    }
    
    public int getMoveSpeed() {
        return moveSpeed;
    }
    
    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }
}
