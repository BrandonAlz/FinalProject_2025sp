/**
 * 
 */
package characters;

/**
 * 
 */
public class EnemyAbilities {
    
    // SPIDER ABILITIES
    public static class Poison extends Ability {
        private int damagePerSecond;
        private int duration;
        
        public Poison() {
            super("Poison", 6, 8);
            this.damagePerSecond = 3;
            this.duration = 5; // seconds
        }
        
        public int getDamagePerSecond() {
            return damagePerSecond;
        }
        
        public int getDuration() {
            return duration;
        }
        
        @Override
        public void use(Character user) {
            // Implementation would apply poison effect to target
        }
    }
    
    // FINAL BOSS ABILITIES
    public static class Explosion extends Ability {
        private int damage;
        private int radius;
        
        public Explosion() {
            super("Explosion", 15, 25);
            this.damage = 40;
            this.radius = 5;
        }
        
        public int getDamage() {
            return damage;
        }
        
        public int getRadius() {
            return radius;
        }
        
        @Override
        public void use(Character user) {
            // Implementation would create massive area explosion
        }
    }
    
    public static class ExplodingShot extends Ability {
        private int initialDamage;
        private int explosionDamage;
        
        public ExplodingShot() {
            super("Shot that Explodes", 8, 15);
            this.initialDamage = 15;
            this.explosionDamage = 20;
        }
        
        public int getInitialDamage() {
            return initialDamage;
        }
        
        public int getExplosionDamage() {
            return explosionDamage;
        }
        
        @Override
        public void use(Character user) {
            // Implementation would fire projectile that explodes on impact
        }
    }
    
    public static class Charge extends Ability {
        private int damage;
        private int knockbackDistance;
        
        public Charge() {
            super("Charge", 12, 18);
            this.damage = 30;
            this.knockbackDistance = 4;
        }
        
        public int getDamage() {
            return damage;
        }
        
        public int getKnockbackDistance() {
            return knockbackDistance;
        }
        
        @Override
        public void use(Character user) {
            // Implementation would rush at player and knock them back
        }
    }
    
    public static class SpawnMobs extends Ability {
        private String mobType;
        private int spawnCount;
        
        public SpawnMobs() {
            super("Spawn Mobs", 20, 30);
            this.mobType = "minions";
            this.spawnCount = 3;
        }
        
        public String getMobType() {
            return mobType;
        }
        
        public int getSpawnCount() {
            return spawnCount;
        }
        
        @Override
        public void use(Character user) {
            // Implementation would summon minions to fight
        }
    }
}