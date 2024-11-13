/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Extras;

/**
 *
 * @author pseba
 */
public class Persona {
    
    private String fullName;
    private String numeral;
    private String eyesColor;
    private String hairColor;
    private String father;
    private String mother;
    private String kwownAs;
    private String heldTitle;
    private String wedTo;
    private String sons;
    private String notes;
    private String fate;

    public Persona(String fullName, String numeral, String eyesColor, String hairColor, String father) {
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

    public Persona(String fullName, String numeral, String knownAs) {
        this.fullName = fullName;
        this.numeral = numeral;
        this.kwownAs= knownAs;
    }
    
    public Persona(String fullName, String father){
        this.fullName = fullName;
        this.father = father;
        this.numeral = "";
        this.eyesColor = null;
        this.hairColor = null;
        this.mother = null;
        this.kwownAs= null;
        this.heldTitle = null;
        this.wedTo = null;
        this.sons = null;
        this.notes = null;
        this.fate = null;
    }
    
    public String generarDescripcion() {
        String descripcion = "Full Name: " + this.getFullName();
        if(this.getNumeral() != null){
            descripcion += ", " + this.getNumeral() + " of his name"+ "\n";
        }else{
           descripcion +="\n";
        }
        if(this.getEyesColor() != null){
            descripcion += "Eyes color: " + this.getEyesColor() + "\n";
        }
        if(this.getHairColor() != null){
            descripcion += "Hair color: " + this.getHairColor() + "\n";
        }
        if (this.getFather() != null) {
            descripcion += "Father: " + this.getFather() + "\n";
        }else{
            descripcion += "Father: Unknown \n";
        }
        if (this.getMother()!= null) {
            descripcion += "Mother: " + this.getMother() + "\n";
        }
        if (this.getKwownAs() != null) {
            descripcion += "Known throughout as: " + this.getKwownAs() + "\n";
        }
        if (this.getHeldTitle() != null) {
            descripcion += "Held title: " + this.getHeldTitle() + "\n";
        }
        if (this.getWedTo() != null) {
            descripcion += "Wed to: " + this.getWedTo() + "\n";
        }
        if (this.getSons() != null) {
            descripcion += "Father to: " + this.getSons();
            descripcion = descripcion.substring(0, descripcion.length() - 2); 
            descripcion += "\n";
        }
       if (this.getNotes() != null) {
            descripcion += "Notes: " + this.getNotes() + "\n";
        }
        if (this.getFate()!= null) {
            descripcion += "Fate: " + this.getFate();
        }
        descripcion = descripcion.trim();
        return descripcion;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNumeral() {
        return numeral;
    }

    public void setNumeral(String numeral) {
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

    public String getSons() {
        return sons;
    }

    public void setSons(String sons) {
        if(this.getSons()==null){
            this.sons = sons+ ", ";
        }else{
            this.sons += sons + ", ";
        }
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
