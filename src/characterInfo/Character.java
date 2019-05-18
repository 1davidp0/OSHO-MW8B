/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characterInfo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author DavidGD
 */

public class Character {
    ArrayList<Character> listCh = new ArrayList();
    Character character;
    
    private String name;
    private String skill;
    private String weapon;
    private int score = 0;
    
    public int total = 0;
    
    public Character() {
        
    }
    
    public Character(String nombre, String habilidad, String arma) {
        this.name = nombre;
        this.skill = habilidad;
        this.weapon = arma;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getSkill() {
        return skill;
    }

    /**
     * @param skill the skill to set
     */
    public void setSkill(String skill) {
        this.skill = skill;
    }

    /**
     * @return the tool
     */
    public String getWeapon() {
        return weapon;
    }

    /**
     * @param weapon the tool to set
     */
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
    
    //*************** METHODS ***************
    public String saveData(String name, String skill, String weapon) {
        listCh.add(character = new Character(name, skill, weapon));
        return "";
    }
    
    public void print() {
        Iterator it = listCh.iterator();
        
        while (it.hasNext()) {            
            Character chara = (Character)it.next();
            System.out.println("Nombre: " + chara.getName() + "\nSkill: " + chara.getSkill() + "\nArma: " + chara.getWeapon());
        }
    }
    
    public void suma(int s1, int s2, int s3) {
        total = total + (s1 + s2 + s3);
        System.out.println(total);
    }
    
    //***************************************
}