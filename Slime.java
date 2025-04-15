package characters;

public class Slime extends EnemyCharacter {
	private int moveSpeed;
	String name, int health, int damage, int energy, int xpReward = super("Slime", 50, 10, 40, 30);
	public static void main(String[] args) {
		this.moveSpeed = 5.5; // Slimes move average speed
		Slime mySlime = new Slime();
		mySlime.scaleToPlayerLevel(3);
		mySlime.setDifficulty(2);
    }
    
    public int getMoveSpeed() {
        return moveSpeed;
    }
    
    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }
}
