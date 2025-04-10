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
    
    // FIGHTER ABILITIES
    public static class GroundPound extends Ability {
        private int damage;
        private int stunDuration;
        
        public GroundPound() {
            super("Ground Pound", 10, 20); // name, cooldown in seconds, energy cost
            this.damage = 30;
            this.stunDuration = 2; // seconds
        }
        
        public int getDamage() {
            return damage;
        }
        
        public int getStunDuration() {
            return stunDuration;
        }
        
        @Override
        public void use(Character user) {
            // Implementation would damage and stun all nearby enemies
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