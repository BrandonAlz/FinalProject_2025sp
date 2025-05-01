package character;

import java.util.ArrayList;
import java.util.List;

public abstract class PlayerCharacter {
    private String name;
    protected int health;
    protected int damage;
    protected int energy;
    protected int crit;
    protected List<Ability> abilities = new ArrayList<>();

    public PlayerCharacter(String name, int health, int damage, int energy, int crit) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.energy = energy;
        this.crit = crit;
    }

    public String getName() {
        return name;
    }

    public void addAbility(Ability ability) {
        abilities.add(ability);
    }

    public int getCritChance() {
        return crit;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }
}