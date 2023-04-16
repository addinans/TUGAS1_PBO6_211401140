/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gamecharacter;

/**
 *
 * @author 62821
 */
public class GameCharacter {

    private String name;
    private int health;
    private int damage;

    public GameCharacter(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void attack(GameCharacter villain) {
        int damageDealt = damage;
        if (villain.getHealth() < damageDealt) {
            damageDealt = villain.getHealth();
        }
        villain.takeDamage(damageDealt);
        System.out.println(name + " attacks " + villain.getName() + " for " + damageDealt + " damage!");
        if (!villain.isAlive()) {
            System.out.println(villain.getName() + " has been defeated!");
        }
    }

    public static void main(String[] args) {
        GameCharacter hero = new GameCharacter("hero", 100, 20);
        GameCharacter villain = new GameCharacter("villain", 50, 10);

        while (hero.isAlive() && villain.isAlive()) {
            hero.attack(villain);
            if (villain.isAlive()) {
                villain.attack(hero);
            }
        }

        if (hero.isAlive()) {
            System.out.println("Selamat kamu menang!");
        } else {
            System.out.println("Cupu! Kamu kalah!");
        }
    }
    
}
