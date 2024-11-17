/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Extras;

/**
 * Clase Persona
 * Representa una persona del arbol genealogico.
 * 
 * @author Pedro Sebastiano
 * @version 1.0
 */
public class Persona {
    /**
     * @param fullName Variable privada de tipo String que contiene el nombre completo de la persona.
     * @param numeral Variable privada de tipo String que contiene el numeral de la persona (ej. First, Second).
     * @param eyesColor Variable privada de tipo String que indica el color de ojos de la persona.
     * @param hairColor Variable privada de tipo String que indica el color de pelo de la persona.
     * @param father Variable privada de tipo String que contiene el nombre del padre de la persona.
     * @param mother Variable privada de tipo String que contiene el nombre de la madre de la persona.
     * @param kwownAs Variable privada de tipo String que indica el apodo o nombre conocido de la persona.
     * @param heldTitle Variable privada de tipo String que contiene el título nobiliario que posee la persona.
     * @param wedTo Variable privada de tipo String que indica con quién está casada la persona.
     * @param sons Variable privada de tipo String que contiene los nombres de los hijos de la persona.
     * @param notes Variable privada de tipo String que contiene notas adicionales sobre la persona.
     * @param fate Variable privada de tipo String que indica el destino o situación final de la persona.
     * @param nivel Variable privada de tipo int que representa el nivel jerárquico de la persona en el árbol.
     */
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
    private int nivel;

    /**
     * Constructor de la clase Persona.
     * Crea una instancia con información básica de la persona.
     * 
     * @param fullName Nombre completo de la persona.
     * @param numeral Numeral de la persona (ej. First, Second).
     * @param eyesColor Color de ojos de la persona.
     * @param hairColor Color de pelo de la persona.
     * @param father Nombre del padre de la persona.
     * @author Pedro Sebastiano
     */
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
        this.nivel = 0;
    }

    /**
     * Constructor de la clase Persona.
     * Crea una instancia con nombre completo, numeral y apodo.
     * 
     * @param fullName Nombre completo de la persona.
     * @param numeral Numeral de la persona (ej. First, Second).
     * @param knownAs Apodo o nombre conocido de la persona.
     * @author Pedro Sebastiano
     */
    public Persona(String fullName, String numeral, String knownAs) {
        this.fullName = fullName;
        this.numeral = numeral;
        this.kwownAs= knownAs;
    }
    
    /**
     * Constructor de la clase Persona.
     * Crea una instancia con nombre completo y nombre del padre, comstructor usado para los hijos que no aparecen en el JSON como
     * persona pero si en la lista de hijos de otras personas.
     * 
     * @param fullName Nombre completo de la persona.
     * @param father Nombre del padre de la persona.
     * @author Pedro Sebastiano
     */
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
        this.nivel = 0;
    }
    
    /**
     * Genera una descripción detallada de la persona, dependiendo de sus atributos.
     * 
     * @return Una cadena con la descripción de la persona.
     * @author Pedro Sebastiano
     */
    public String generarDescripcion() {
        String descripcion = "Full Name: " + this.getFullName();
        if(this.getNumeral() != null && !this.getNumeral().equals("")){
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

    /**
     * Obtiene el nombre completo de la persona.
     * 
     * @return Nombre completo de la persona.
     * @author Pedro Sebastiano
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Establece el nombre completo de la persona.
     * 
     * @param fullName Nombre completo de la persona.
     * @author Pedro Sebastiano
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Obtiene el numeral de la persona.
     * 
     * @return Numeral de la persona.
     * @author Pedro Sebastiano
     */
    public String getNumeral() {
        return numeral;
    }
    
     /**
     * Establece el numeral de la persona.
     * 
     * @param numeral Numeral de la persona (ej. First, Second).
     * @author Pedro Sebastiano
     */
    public void setNumeral(String numeral) {
        this.numeral = numeral;
    }
    
    /**
     * Obtiene el color de ojos de la persona.
     * 
     * @return Color de ojos de la persona.
     * @author Pedro Sebastiano
     */
    public String getEyesColor() {
        return eyesColor;
    }

    /**
     * Establece el color de ojos de la persona.
     * 
     * @param eyesColor Color de ojos de la persona.
     * @author Pedro Sebastiano
     */
    public void setEyesColor(String eyesColor) {
        this.eyesColor = eyesColor;
    }

    /**
     * Obtiene el color de pelo de la persona.
     * 
     * @return Color de pelo de la persona.
     * @author Pedro Sebastiano
     */
    public String getHairColor() {
        return hairColor;
    }

    /**
     * Establece el color de pelo de la persona.
     * 
     * @param hairColor Color de pelo de la persona.
     * @author Pedro Sebastiano
     */
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * Obtiene el nombre del padre de la persona.
     * 
     * @return Nombre del padre de la persona.
     * @author Pedro Sebastiano
     */
    public String getFather() {
        return father;
    }

    /**
     * Establece el nombre del padre de la persona.
     * 
     * @param father Nombre del padre de la persona.
     * @author Pedro Sebastiano
     */
    public void setFather(String father) {
        this.father = father;
    }

    /**
     * Obtiene el nombre de la madre de la persona.
     * 
     * @return Nombre de la madre de la persona.
     * @author Pedro Sebastiano
     */
    public String getMother() {
        return mother;
    }

    /**
     * Establece el nombre de la madre de la persona.
     * 
     * @param mother Nombre de la madre de la persona.
     * @author Pedro Sebastiano
     */
    public void setMother(String mother) {
        this.mother = mother;
    }

    /**
     * Obtiene el apodo o nombre conocido de la persona.
     * 
     * @return Apodo o nombre conocido de la persona.
     * @author Pedro Sebastiano
     */
    public String getKwownAs() {
        return kwownAs;
    }

    /**
     * Establece el apodo o nombre conocido de la persona.
     * 
     * @param kwownAs Apodo o nombre conocido de la persona.
     * @author Pedro Sebastiano
     */
    public void setKwownAs(String kwownAs) {
        this.kwownAs = kwownAs;
    }

    /**
     * Obtiene el título que posee la persona.
     * 
     * @return Título que posee la persona.
     * @author Pedro Sebastiano
     */
    public String getHeldTitle() {
        return heldTitle;
    }

    /**
     * Establece el título que posee la persona.
     * 
     * @param heldTitle Título que posee la persona.
     * @author Pedro Sebastiano
     */
    public void setHeldTitle(String heldTitle) {
        this.heldTitle = heldTitle;
    }

    /**
     * Obtiene el nombre de la persona con quien está casada.
     * 
     * @return Nombre de la persona con quien está casada.
     * @author Pedro Sebastiano
     */
    public String getWedTo() {
        return wedTo;
    }

    /**
     * Establece el nombre de la persona con quien está casada.
     * 
     * @param wedTo Nombre de la persona con quien está casada.
     * @author Pedro Sebastiano
     */
    public void setWedTo(String wedTo) {
        this.wedTo = wedTo;
    }

    /**
     * Obtiene los nombres de los hijos de la persona.
     * 
     * @return Nombres de los hijos de la persona.
     * @author Pedro Sebastiano
     */
    public String getSons() {
        return sons;
    }

    /**
     * Establece los nombres de los hijos de la persona.
     * Si ya hay hijos agregados, se concatenan a la lista existente.
     * 
     * @param sons Nombre de un hijo de la persona.
     * @author Pedro Sebastiano
     */
    public void setSons(String sons) {
        if(this.getSons()==null){
            this.sons = sons+ ", ";
        }else{
            this.sons += sons + ", ";
        }
    }

    /**
     * Obtiene las notas adicionales sobre la persona.
     * 
     * @return Notas adicionales sobre la persona.
     * @author Pedro Sebastiano
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Establece las notas adicionales sobre la persona.
     * 
     * @param notes Notas adicionales sobre la persona.
     * @author Pedro Sebastiano
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Obtiene el destino o situación final de la persona.
     * 
     * @return Destino o situación final de la persona.
     * @author Pedro Sebastiano
     */
    public String getFate() {
        return fate;
    }

    /**
     * Establece el destino o situación final de la persona.
     * 
     * @param fate Destino o situación final de la persona.
     * @author Pedro Sebastiano
     */
    public void setFate(String fate) {
        this.fate = fate;
    }        

    /**
     * Obtiene el nivel jerárquico de la persona en el árbol genealógico.
     * 
     * @return Nivel jerárquico de la persona.
     * @author Pedro Sebastiano
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Establece el nivel jerárquico de la persona en el árbol genealógico.
     * 
     * @param nivel Nivel jerárquico de la persona.
     * @author Pedro Sebastiano
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

}
