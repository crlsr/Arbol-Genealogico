/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import Extras.Persona;
import javax.swing.JOptionPane;
import static java.lang.Math.abs;
/**
 *
 * @author pseba
 */
public class Hashtable {
    
    private int size;
    private List<TreeNode>[] arrayPersonas;

    public Hashtable(int size) {
        this.size = size;
        this.arrayPersonas = new List[size];
    }
    
    public boolean spaceEmpty(int indice){
        return this.getArrayPersonas()[indice] == null;
    }
    
    public int funHash(Persona persona, boolean mote) {
        if(!mote){
            int indice = abs(persona.getFullName().hashCode() + persona.getNumeral().hashCode());
            indice = indice % this.getSize();
            return indice;
        }else{
            int indice = abs(persona.getKwownAs().hashCode());
            indice = indice % this.getSize();
            return indice;
        }
    }
    
    public void addPersona(Persona nueva, boolean mote){
        int i = this.funHash(nueva, mote);
        boolean existe = false;
        TreeNode newPersona = new TreeNode(nueva);
        if (this.spaceEmpty(i)){
            this.getArrayPersonas()[i] = new List<TreeNode>();
            this.getArrayPersonas()[i].add(newPersona);
        }else{
            Node<TreeNode> aux = this.getArrayPersonas()[i].getpFirst();
            if (aux.getData().getTinfo().getFullName().equals(nueva.getFullName()) && aux.getData().getTinfo().getNumeral().equals(nueva.getNumeral())) {
                existe = true;
            } else {
                while (aux != null) {
                    if (aux.getData().getTinfo().getFullName().equals(nueva.getFullName()) && aux.getData().getTinfo().getNumeral().equals(nueva.getNumeral())) {
                        existe = true;
                        break;
                    } else {
                        aux = aux.getpNext();
                    }

                }
                if (existe == false) {
                    this.getArrayPersonas()[i].add(newPersona);
                }
        }
        }
    }
    
    public void deletePersona(Persona persona, boolean mote) {
        int i = this.funHash(persona, mote);
        Node<TreeNode> aux = this.getArrayPersonas()[i].getpFirst();
        if ((aux.getData().getTinfo().getFullName().equals(persona.getFullName()) && aux.getData().getTinfo().getNumeral().equals(persona.getNumeral())) && (aux.getpNext() == null)) {
            this.getArrayPersonas()[i] = null;
            JOptionPane.showMessageDialog(null, persona.getFullName() +", "+ persona.getNumeral()+ " of his name, ha sido eliminado con exito");  
        } else {
            while (aux.getpNext() != null) {
                Node<TreeNode> prev = aux;
                aux = aux.getpNext();
                if (aux.getData().getTinfo().getFullName().equals(persona.getFullName()) && aux.getData().getTinfo().getNumeral().equals(persona.getNumeral())) {
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
    
    public TreeNode searchPersona(Persona persona, boolean mote) {
        if (this.getArrayPersonas()[this.funHash(persona, mote)] != null) {
            Node<TreeNode> aux = this.getArrayPersonas()[this.funHash(persona, mote)].getpFirst();
            if(!mote){
            if (aux.getData().getTinfo().getFullName().toLowerCase().equals(persona.getFullName().toLowerCase())
                    && aux.getData().getTinfo().getNumeral().toLowerCase().equals(persona.getNumeral().toLowerCase())) {
                if(aux.getData().getTinfo().getFather()!= null && persona.getFather()!=null){
                    if(aux.getData().getTinfo().getFather().toLowerCase().equals(persona.getFather().toLowerCase())){
                        return aux.getData();
                    }
                }else{
                    return aux.getData();
                }
            } else {
                while (aux.getpNext() != null) {
                    aux = aux.getpNext();
                    if (aux.getData().getTinfo().getFullName().toLowerCase().equals(persona.getFullName().toLowerCase())
                    && aux.getData().getTinfo().getNumeral().toLowerCase().equals(persona.getNumeral().toLowerCase())) {
                        if(aux.getData().getTinfo().getFather()!= null && persona.getFather()!=null){
                            if(aux.getData().getTinfo().getFather().toLowerCase().equals(persona.getFather().toLowerCase())){
                            return aux.getData();
                            }
                        }else{
                            return aux.getData();
                        }
                    }
                }
            }
            }else{
                if (aux.getData().getTinfo().getKwownAs().toLowerCase().equals(persona.getKwownAs().toLowerCase())) {
                    return aux.getData();
                } else {
                while (aux.getpNext() != null) {
                    aux = aux.getpNext();
                    if (aux.getData().getTinfo().getKwownAs().toLowerCase().equals(persona.getKwownAs().toLowerCase())) {
                        return aux.getData();
                    }
                }  
            }
            }
        }
        return null;
    }
    
    public void printHashTable() {
        Node<TreeNode> aux = null;
        for (int i = 0; i < this.getSize(); i++) {
            if (this.getArrayPersonas()[i] != null) {
                aux = this.getArrayPersonas()[i].getpFirst();
                System.out.println(aux.getData().getTinfo().getFullName() +" " +aux.getData().getTinfo().getNumeral() + i);
                aux = aux.getpNext();
                while (aux != null) {
                    System.out.println(aux.getData().getTinfo().getFullName() +" " +aux.getData().getTinfo().getNumeral() + i);
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

    public List[] getArrayPersonas() {
        return arrayPersonas;
    }

    public void setArrayPersonas(List[] arrayPersonas) {
        this.arrayPersonas = arrayPersonas;
    }
    
}
