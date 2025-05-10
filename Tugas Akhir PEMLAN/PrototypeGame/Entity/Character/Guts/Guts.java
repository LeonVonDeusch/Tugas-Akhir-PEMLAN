package Entity.Character.Guts;

import Entity.Entity;
import java.util.*;

public class Guts extends Entity{
    public Guts() {
        super("Guts", 1000, 2, 1, 2, 6);
    }

    public static void main(String[] args) {
    List<String> skills = new ArrayList<>();
    skills.add("Dash");
    skills.add("DMG Immunity");
    skills.add("Berserk");

    List<String> items = new ArrayList<>();
    items.add("Heal Potion");
    items.add("Stamina Potion");

    System.out.println("Guts's Skills: " + skills);
    }

    
    // public void showSkills() {
    //     System.out.println("Skills: ");
    //     for (String skill : skills) {
    //         System.out.println("- " + skill);
    //     }
    // }
    
    

}
