package characters;

public class PlayerAbilities {
    
    // KNIGHT ABILITIES
    public static class Dash extends Ability {
        private int dashDistance;
        
        public Dash() {
            super("Dash", 5, 10); // name, cooldown in seconds, energy cost
            this.dashDistance = 3; // move 3 units forward
        }
        
        public int getDashDistance() {
            return dashDistance;
        }
        
        @Override
        public void use(Character user) {
            // Implementation would move the character and avoid attacks
        }
    }
    
    // WIZARD ABILITIES
    public static class Fireball extends Ability {
        private int damage;
        private int radius;
        
        public Fireball() {
            super("Big Fireball", 8, 15); // name, cooldown in seconds, energy cost
            this.damage = 25;
            this.radius = 2;
        }
        
        public int getDamage() {
            return damage;
        }
        
        public int getRadius() {
            return radius;
        }
        
        @Override
        public void use(Character user) {
            // Implementation would damage all enemies in radius
        }
    }
    
    // Gambler ABILITIES
    public static class Gambler extends Ability {
        private int damageCount;
        
        public GroundPound() {
            super("Gamble", 10, 20); // name, cooldown in seconds, energy cost
            this.damageCount = 0; // to be finished later
        }
        
        public int getDamage() {
            return damage;
        }
        
        @Override
        public void use(Character user) {
            // Implementation will bet
        }
    }
    
    // ARCHER ABILITIES
    public static class TripleShot extends Ability {
        private int damagePerArrow;
        private int arrowCount;
        
        public TripleShot() {
            super("Triple Shot", 7, 12); // name, cooldown in seconds, energy cost
            this.damagePerArrow = 10;
            this.arrowCount = 3;
        }
        
        public int getDamagePerArrow() {
            return damagePerArrow;
        }
        
        public int getArrowCount() {
            return arrowCount;
        }
        
        public int getTotalDamage() {
            return damagePerArrow * arrowCount;
        }
        
        @Override
        public void use(Character user) {
            // Implementation would fire multiple arrows at a single target
        }
    }
}
