package Entity;

public  abstract class Entity {
    // Base stats
    protected String name;
    protected int hp;
    protected int strength;
    protected int agility;
    protected int intelligence;

    // Derived stats
    protected double attackPower;
    protected double defense;
    protected double critChance;
    protected double dodgeChance;
    protected int mana;
    protected int manaRegen;
    protected int magicPower;

    public Entity() {
        this.name = "Unknown";
        this.hp = 0;
        this.strength = 0;
        this.agility = 0;
        this.intelligence = 0;
    }

    public Entity (String name, int totalPoints, int hpFocus, int strFocus, int agiFocus, int intFocus) {
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

    public void calculateDerivedStats() {
        this.attackPower = strength * 0.45;
        this.defense = (strength * 1.25) - agility;
        
        this.critChance = ((strength + agility) * 0.3) - (intelligence * 5);
        if (critChance < 0) {
            critChance = 0;
        }

        this.dodgeChance = agility * 0.3;
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
        System.out.println("  Attack Power : " + attackPower);
        System.out.println("  Defense      : " + defense);
        System.out.println("  Crit Chance  : " + critChance + "%");
        System.out.println("  Dodge Chance : " + dodgeChance + "%");
        System.out.println("  Mana         : " + mana);
        System.out.println("  Mana Regen   : " + manaRegen + "/turn");
        System.out.println("  Magic Power  : " + magicPower);
        System.out.println("----------------------------------");
    }

    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public int getStrength() {
        return strength;
    }
    public int getAgility() {
        return agility;
    }
    public int getIntelligence() {
        return intelligence;
    }
    public double getAttackPower() {
        return attackPower;
    }
    public double getDefense() {
        return defense;
    }
    public double getCritChance() {
        return critChance;
    }
    public double getDodgeChance() {
        return dodgeChance;
    }
    public int getMana() {
        return mana;
    }
    public int getManaRegen() {
        return manaRegen;
    }
    public int getMagicPower() {
        return magicPower;
    }
    public double getDamage() {
        return magicPower;
    }

    public void Attack(Entity Target){
        // Calculate damage based on attack power and target's defense
        double damage = attackPower - (Target.getDefense() / 2);
        if (damage < 0) {
            damage = 0;
        }
    }
    public void Defend(String Target){
        // Calculate damage reduction based on defense
        double damageReduction = defense / 2;
        if (damageReduction < 0) {
            damageReduction = 0;
        }
    }
    public void UseItem(String Target){

    }
    public void UseSkill(String Target){

    }
}
