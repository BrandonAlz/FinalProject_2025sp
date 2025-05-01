package character;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Archer");
        Wizard wizard = new Wizard("Wizard");
        Bull bull = new Bull("Bull");
        Knight knight = new Knight("Knight");

        // Test ability usage
        System.out.println(" Abilits");
        for (Ability ability : archer.getAbilities()) {
            ability.use(archer);
        }
        for (Ability ability : wizard.getAbilities()) {
            ability.use(wizard);
        }
        for (Ability ability : bull.getAbilities()) {
            ability.use(bull);
        }
        for (Ability ability : knight.getAbilities()) {
            ability.use(knight);
        }
    }
}
