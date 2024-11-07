/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import Extras.Persona;
import javax.swing.JOptionPane;
/**
 *
 * @author pseba
 */
public class Hashtable {
    
    private int size;
    private Persona[] arrayPersonas;

    public Hashtable(int size) {
        this.size = size;
        this.arrayPersonas = new Persona[size];
    }
    
    public boolean spaceEmpty(int indice){
        return this.getArrayPersonas()[indice] == null;
    }
    
    public int funHash(Persona persona, boolean mote) {
        if(!mote){
            int indice = persona.getFullName().hashCode() + persona.getNumeral().hashCode();
            indice = indice % this.getSize();
            return indice;
        }else{
            int indice = persona.getKwownAs().hashCode();
            indice = indice % this.getSize();
            return indice;
        }
    }
    
    public void addPersona(Persona nueva, boolean mote){
        int i = this.funHash(nueva, mote);
        boolean existe = false;
        if (this.spaceEmpty(i)){
            this.getArrayPersonas()[i]= nueva;
        }else{
            if (this.getArrayPersonas()[i].getFullName().equals(nueva.getFullName()) && this.getArrayPersonas()[i].getNumeral().equals(nueva.getNumeral())) {
                JOptionPane.showMessageDialog(null, nueva.getFullName() +", "+ nueva.getNumeral()+ " of his name, ya existe");
                existe = true;
            } else {
                Persona aux = this.getArrayPersonas()[i];
                while (aux.getpNext() != null) {
                    if (this.getArrayPersonas()[i].getFullName().equals(nueva.getFullName()) && this.getArrayPersonas()[i].getNumeral().equals(nueva.getNumeral())) {
                        JOptionPane.showMessageDialog(null, nueva.getFullName() +", "+ nueva.getNumeral()+ " of his name, ya existe");
                        existe = true;
                        break;
                    } else {
                        aux = aux.getpNext();
                    }

                }
                if (existe == false) {
                    aux.setpNext(nueva);
                }
        }
        if (existe == false) {
            JOptionPane.showMessageDialog(null, nueva.getFullName() +", "+ nueva.getNumeral()+ " of his name, ha sido agregado con exito");           
        }
        }
    }
    
    public void deletePersona(Persona persona, boolean mote) {
        int i = this.funHash(persona, mote);
        Persona aux = this.getArrayPersonas()[i];
        if ((aux.getFullName().equals(persona.getFullName()) && aux.getNumeral().equals(persona.getNumeral())) && (aux.getpNext() == null)) {
            this.getArrayPersonas()[i] = null;
            JOptionPane.showMessageDialog(null, persona.getFullName() +", "+ persona.getNumeral()+ " of his name, ha sido eliminado con exito");  
        } else {
            while (aux.getpNext() != null) {
                Persona prev = aux;
                aux = aux.getpNext();
                if (aux.getFullName().equals(persona.getFullName()) && aux.getNumeral().equals(persona.getNumeral())) {
                    prev.setpNext(aux.getpNext());
                    aux.setpNext(null);
                    JOptionPane.showMessageDialog(null, persona.getFullName() +", "+ persona.getNumeral()+ " of his name, ha sido eliminado con exito");  
                    break;
                } else {
                    System.out.println("El usuario no existe");
                    break;
                }

            }
        }

    }
    
    public Persona searchPersona(Persona persona, boolean mote) {
        if (this.getArrayPersonas()[this.funHash(persona, mote)] != null) {
            Persona aux = this.getArrayPersonas()[this.funHash(persona, mote)];
            if (aux.getFullName().equals(persona.getFullName()) && aux.getNumeral().equals(persona.getNumeral())) {
                return aux;
            } else {
                while (aux.getpNext() != null) {
                    aux = aux.getpNext();
                    if (aux.getFullName().equals(persona.getFullName()) && aux.getNumeral().equals(persona.getNumeral())) {
                        return aux;
                    }
                }
            }
        }
        System.out.println("Usuario no encontrado");
        return null;
    }
    
    public void printHashTable() {
        for (int i = 0; i < this.getSize(); i++) {
            if (this.getArrayPersonas()[i] != null) {
                System.out.println(this.getArrayPersonas()[i].getFullName()+" " +this.getArrayPersonas()[i].getNumeral() + i);
                Persona aux = this.getArrayPersonas()[i].getpNext();
                while (aux != null) {
                    System.out.println(aux.getFullName()+ " "+ aux.getNumeral() + i);
                    aux = aux.getpNext();
                }
            }
        }
    }
    
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Persona[] getArrayPersonas() {
        return arrayPersonas;
    }

    public void setArrayPersonas(Persona[] arrayPersonas) {
        this.arrayPersonas = arrayPersonas;
    }
    
}
