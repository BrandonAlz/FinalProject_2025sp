package characters;

public class Spider extends EnemyCharacter {
    private int moveSpeed;
    String name, int health, int damage, int energy, int xpReward = super("Spider", 35, 8, 50, 25);
    public static void main(String[] args) {
        this.moveSpeed = 8; // Spiders move quickly
        Spider mySpider = new Spider();
        mySpider.scaleToPlayerLevel(3);
        mySpider.setDifficulty(2);
        
        EnemyAbilities.Poison poison = new EnemyAbilities.Poison();
        poison.setDescription("Inflicts damage over time on target");
        addAbility(poison); //i know this line is wrong, will fix later, designed to poison specific characters so they take damage over time
    }
    
    public int getMoveSpeed() {
        return moveSpeed;
    }
    
    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }
}
