package Entity.Enemy;

public class Enemy {
    // Base stats
    protected String name;
    protected int hp;
    protected int strength;
    protected int agility;
    protected int intelligence;

    // Derived stats
    protected int defense;
    protected double critChance;
    protected double dodgeChance;
    protected int mana;
    protected int manaRegen;
    protected int magicPower;

    public Enemy() {
        this.name = "Unknown";
        this.hp = 0;
        this.strength = 0;
        this.agility = 0;
        this.intelligence = 0;
    }

    public Enemy (String name, int totalPoints, int hpFocus, int strFocus, int agiFocus, int intFocus) {
        this.name = name;

        int totalFocus = hpFocus + strFocus + agiFocus + intFocus;

        double hpRatio = (double) hpFocus / totalFocus;
        double strRatio = (double) strFocus / totalFocus;
        double agiRatio = (double) agiFocus / totalFocus;
        double intRatio = (double) intFocus / totalFocus;

        this.hp = (int) (hpRatio * totalPoints / 1);
        this.strength = (int) (strRatio * totalPoints / 2);
        this.agility = (int) (agiRatio * totalPoints / 3);
        this.intelligence = (int) (intRatio * totalPoints / 4);

        calculateDerivedStats();
    }

    private void calculateDerivedStats() {
        // Derived from strength
        this.defense = (strength * 2) - agility;             // Example: each STR gives 2 defense
        this.critChance = ((strength + agility) * 0.3) - (intelligence * 5); // CritChance influenced by STR + AGI

        if (critChance < 0) {
            critChance = 0; // Ensure crit chance doesn't go negative
        }

        // Derived from agility
        this.dodgeChance = agility * 0.3;         // Example: 0.3% per AGI

        // Derived from intelligence
        this.mana = intelligence * 10;
        this.manaRegen = intelligence / 2;
        this.magicPower = intelligence * 3;
    }

    public void showStats() {
        System.out.println("Character: " + name);
        System.out.println("---- Main Stats ----");
        System.out.println("  HP           : " + hp);
        System.out.println("  Strength     : " + strength);
        System.out.println("  Agility      : " + agility);
        System.out.println("  Intelligence : " + intelligence);
        System.out.println("---- Derived Stats ----");
        System.out.println("  Defense      : " + defense);
        System.out.println("  Crit Chance  : " + critChance + "%");
        System.out.println("  Dodge Chance : " + dodgeChance + "%");
        System.out.println("  Mana         : " + mana);
        System.out.println("  Mana Regen   : " + manaRegen + "/turn");
        System.out.println("  Magic Power  : " + magicPower);
        System.out.println("----------------------------------");
    }
}
