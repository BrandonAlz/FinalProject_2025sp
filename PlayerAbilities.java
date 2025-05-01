package character;


import java.util.Random;

public class PlayerAbilities {
    private static final Random rand = new Random();

    public static class Dash extends Ability {
        private int dashDistance;

        public Dash() {
            super("Dash", 5, 10);
            this.dashDistance = 3;
        }

        @Override
        public void use(PlayerCharacter user) {
            System.out.println(user.getName() + " dashes forward " + dashDistance + " units, avoiding attacks.");
        }
    }

    public static class Fireball extends Ability {
        private int damage;
        private int radius;

        public Fireball() {
            super("Big Fireball", 8, 15);
            this.damage = 25;
            this.radius = 2;
        }

        @Override
        public void use(PlayerCharacter user) {
            boolean isCrit = rand.nextInt(100) < user.getCritChance();
            int finalDamage = isCrit ? (int)(damage * 1.5) : damage;

            System.out.println(user.getName() + " casts Fireball, dealing " + finalDamage +
                               " damage in a " + radius + "-unit radius" + (isCrit ? " [CRIT!]" : "") + ".");
        }
    }

    public static class GroundPound extends Ability {
        private int damage;
        private int stunDuration;

        public GroundPound() {
            super("Ground Pound", 10, 20);
            this.damage = 30;
            this.stunDuration = 2;
        }

        @Override
        public void use(PlayerCharacter user) {
            boolean isCrit = rand.nextInt(100) < user.getCritChance();
            int finalDamage = isCrit ? (int)(damage * 1.5) : damage;

            System.out.println(user.getName() + " uses Ground Pound, dealing " + finalDamage +
                               " damage and stunning for " + stunDuration + "s" + (isCrit ? " [CRIT!]" : "") + ".");
        }
    }

    public static class TripleShot extends Ability {
        private int damagePerArrow;
        private int arrowCount;

        public TripleShot() {
            super("Triple Shot", 7, 12);
            this.damagePerArrow = 10;
            this.arrowCount = 3;
        }

        @Override
        public void use(PlayerCharacter user) {
            int totalDamage = 0;
            int crits = 0;
            for (int i = 0; i < arrowCount; i++) {
                boolean isCrit = rand.nextInt(100) < user.getCritChance();
                int arrowDamage = isCrit ? (int)(damagePerArrow * 1.5) : damagePerArrow;
                totalDamage += arrowDamage;
                if (isCrit) crits++;
            }

            System.out.println(user.getName() + " fires Triple Shot for total " + totalDamage +
                               " damage (" + crits + " critical hits).");
        }
    }
}