package Entity.EntityStatDistribution;

import Entity.Entity;

public class EntityStatMain extends Entity {
    public static void main(String[] args) {
        Entity Guts = new Entity("Guts",1000 , 6, 10, 3, 1); // Fokus HP dan Strength
        Entity Altair = new Entity("Altair", 1000, 2, 6, 6, 1); // Fokus Agility dan Strength
        Entity Merlin = new Entity("Merlin",1000 , 2, 1, 2, 6);   // Fokus Intelligence 

        
        Guts.showStats();
        Altair.showStats();
        Merlin.showStats();
        
    }
}
