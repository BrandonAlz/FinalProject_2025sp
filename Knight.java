package characters;

public class Knight extends PlayerCharacter {
        public Knight(String name) {
                super(name, 60, 15, 100, 25); // name, health, damage, energy, crit
                // Knight's base attack will be a close-range sword swing, dealing 15 damage to all enemies in the sword swipe
                boolean knightAlive = true;
                int lives = 3;
                if (lives = 0) { // we can add a while true here if necessary
                        knightAlive = false;
                }
                // Knight abilities
                PlayerAbilities.Dash dash = new PlayerAbilities.Dash();
                dash.setDescription("Quick movement that deals damage and repositions the knight, can be used for getaway or attack");
                addAbility(dash);

                public void loseLife {
                        lives = lives - 1;
                }
    
                public int getLives {
                        return lives;
                }

                public void isAlive {
                        return knightAlive;
                }
        }
}
