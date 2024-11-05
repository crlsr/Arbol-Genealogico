/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author pseba
 */
public class Persona {
    
    private String fullName;
    private int numeral;
    private String eyesColor;
    private String hairColor;
    private String father;
    private String mother;
    private String kwownAs;
    private String heldTitle;
    private String wedTo;
    private List<String> sons;
    private String notes;
    private String fate;

    public Persona(String fullName, int numeral, String eyesColor, String hairColor, String father) {
        this.fullName = fullName;
        this.numeral = numeral;
        this.eyesColor = eyesColor;
        this.hairColor = hairColor;
        this.father = father;
        this.mother = null;
        this.kwownAs= null;
        this.heldTitle = null;
        this.wedTo = null;
        this.sons = null;
        this.notes = null;
        this.fate = null;
        
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getNumeral() {
        return numeral;
    }

    public void setNumeral(int numeral) {
        this.numeral = numeral;
    }

    public String getEyesColor() {
        return eyesColor;
    }

    public void setEyesColor(String eyesColor) {
        this.eyesColor = eyesColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getKwownAs() {
        return kwownAs;
    }

    public void setKwownAs(String kwownAs) {
        this.kwownAs = kwownAs;
    }

    public String getHeldTitle() {
        return heldTitle;
    }

    public void setHeldTitle(String heldTitle) {
        this.heldTitle = heldTitle;
    }

    public String getWedTo() {
        return wedTo;
    }

    public void setWedTo(String wedTo) {
        this.wedTo = wedTo;
    }

    public List getSons() {
        return sons;
    }

    public void setSons(List sons) {
        this.sons = sons;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getFate() {
        return fate;
    }

    public void setFate(String fate) {
        this.fate = fate;
    }    
    
}
