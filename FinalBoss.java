/**
 * 
 */
package characters;

/**
 * 
 */
public class FinalBoss extends EnemyCharacter {
    private int projectileSpeed;
    private int currentPhase;
    private int maxPhases;
    
    public FinalBoss() {
        super("Crusher", 2000, 25, 300, 500); // name, health, damage, energy, xp
        setDifficulty(5); // Maximum difficulty
        this.projectileSpeed = 7;
        this.currentPhase = 1;
        this.maxPhases = 3;
        
        // Add boss abilities with descriptions
        EnemyAbilities.Explosion explosion = new EnemyAbilities.Explosion();
        explosion.setDescription("Massive area damage attack affecting all players");
        addAbility(explosion);
        
        EnemyAbilities.ExplodingShot explodingShot = new EnemyAbilities.ExplodingShot();
        explodingShot.setDescription("Ranged attack that explodes on impact for extra damage");
        addAbility(explodingShot);
        
        EnemyAbilities.Charge charge = new EnemyAbilities.Charge();
        charge.setDescription("Rush attack that knocks back players and deals heavy damage");
        addAbility(charge);
        
        EnemyAbilities.SpawnMobs spawnMobs = new EnemyAbilities.SpawnMobs();
        spawnMobs.setDescription("Summons minions to assist in battle");
        addAbility(spawnMobs);
    }
    
    public int getProjectileSpeed() {
        return projectileSpeed;
    }
    
    public int getCurrentPhase() {
        return currentPhase;
    }
    
    /**
     * Advance to the next boss phase, getting stronger
     */
    private void advancePhase() {
        if (currentPhase < maxPhases) {
            currentPhase++;
            
            // Boss gets stronger with each phase
            int healthBoost = 500;
            int damageBoost = 10;
            int energyBoost = 100;
            
            setMaxHealth(getMaxHealth() + healthBoost);
            setHealth(getMaxHealth() / 2); // Restore some health on phase change
            setDamage(getDamage() + damageBoost);
            setMaxEnergy(getMaxEnergy() + energyBoost);
            setEnergy(getMaxEnergy());
        }
    }
    
\
    /**
     * Boss can use multiple abilities per turn in later phases
     */
    @Override
    public void takeTurn(Character target) {
        // In phase 1, just use one ability or attack
        if (currentPhase == 1) {
            super.takeTurn(target);
            return;
        }
        
        // In phase 2, use two abilities/attacks
        if (currentPhase == 2) {
            useRandomAbility();
            attack(target);
            return;
        }
        
        // In phase 3, use three abilities/attacks
        if (currentPhase == 3) {
            useRandomAbility();
            useRandomAbility();
            attack(target);
        }
    }
    
    /**
     * Use a random ability from the list
     */
    private void useRandomAbility() {
        if (abilities.isEmpty() || getEnergy() < 10) {
            return;
        }
        
        int index = (int)(Math.random() * abilities.size());
        Ability ability = abilities.get(index);
        
        if (getEnergy() >= ability.getEnergyCost()) {
            ability.use(this);
            setEnergy(getEnergy() - ability.getEnergyCost());
        }
    }

}