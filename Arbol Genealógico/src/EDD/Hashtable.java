/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import Extras.Persona;
import javax.swing.JOptionPane;
import static java.lang.Math.abs;
/**
 * Clase Hashtable
 * Representa una tabla hash que almacena objetos de tipo Persona en nodos de árbol.
 * 
 * @author Pedro Sebastiano
 * @version 1.0
 */
public class Hashtable {
    
    /**
     * @param size Tamaño de la tabla hash.
     * @param arrayPersonas Array que almacena listas de nodos de árbol, cada uno conteniendo una Persona.
     */
    private int size;
    private List<TreeNode>[] arrayPersonas;

    /**
     * Constructor de la clase Hashtable.
     * Inicializa la tabla hash con un tamaño dado y crea el array de listas.
     * 
     * @param size Tamaño de la tabla hash.
     * @author Pedro Sebastiano
     */
    public Hashtable(int size) {
        this.size = size;
        this.arrayPersonas = new List[size];
    }
    
    /**
     * Verifica si un índice específico de la tabla hash está vacío.
     * 
     * @param indice Índice a verificar.
     * @return true si el espacio está vacío, false en caso contrario.
     * @author Pedro Sebastiano
     */
    public boolean spaceEmpty(int indice){
        return this.getArrayPersonas()[indice] == null;
    }
    
    /**
     * Función hash que calcula el índice para almacenar una persona.
     * 
     * @param persona Objeto Persona para el cual se calculará el índice.
     * @param mote Booleano que indica el modo de hashing (true para mote, false para nombre completo).
     * @return Índice calculado.
     * @author Pedro Sebastiano
     */
    public int funHash(Persona persona, boolean mote) {
        if(!mote){
            int indice = abs(persona.getFullName().toLowerCase().hashCode() + persona.getNumeral().toLowerCase().hashCode());
            indice = indice % this.getSize();
            return indice;
        }else{
            int indice = abs((persona.getKwownAs().toLowerCase().hashCode()) % 7);
            indice = indice % this.getSize();
            return indice;
        }
    }
    
    /**
     * Agrega una persona a la tabla hash.
     * 
     * @param nueva Objeto Persona que será agregado.
     * @param mote Booleano que indica el modo de hashing (true para mote, false para nombre completo).
     * @author Pedro Sebastiano
     */
    public void addPersona(Persona nueva, boolean mote){
        int i = this.funHash(nueva, mote);
        TreeNode newPersona = new TreeNode(nueva);
        if (this.spaceEmpty(i)){
            this.getArrayPersonas()[i] = new List<TreeNode>();
            this.getArrayPersonas()[i].add(newPersona);
        }else{
            this.getArrayPersonas()[i].add(newPersona);
        }
    }
    
    /**
     * Busca una persona en la tabla hash.
     * 
     * @param persona Objeto Persona que será buscado.
     * @param mote Booleano que indica el modo de hashing (true para alias, false para nombre completo).
     * @return Nodo del árbol que contiene la persona buscada, o null si no se encuentra.
     * @author Pedro Sebastiano
     */
    public TreeNode searchPersona(Persona persona, boolean mote) {
        if (this.getArrayPersonas()[this.funHash(persona, mote)] != null) {
            Node<TreeNode> aux = this.getArrayPersonas()[this.funHash(persona, mote)].getpFirst();
            if(!mote){
                if (aux.getData().getTinfo().getFullName().toLowerCase().equals(persona.getFullName().toLowerCase())
                    && aux.getData().getTinfo().getNumeral().toLowerCase().equals(persona.getNumeral().toLowerCase())) {
                    if(aux.getData().getTinfo().getFather() != null && persona.getFather() != null){
                        if(aux.getData().getTinfo().getFather().toLowerCase().equals(persona.getFather().toLowerCase())){
                            return aux.getData();
                        }
                    }else{
                        return aux.getData();
                    }
                }
                while (aux.getpNext() != null) {
                    aux = aux.getpNext();
                    if (aux.getData().getTinfo().getFullName().toLowerCase().equals(persona.getFullName().toLowerCase())
                    && aux.getData().getTinfo().getNumeral().toLowerCase().equals(persona.getNumeral().toLowerCase())) {
                        if(aux.getData().getTinfo().getFather() != null && persona.getFather() != null){
                            if(aux.getData().getTinfo().getFather().toLowerCase().equals(persona.getFather().toLowerCase())){
                                return aux.getData();
                            }
                        }else{
                            return aux.getData();
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
    
    /**
     * Imprime el contenido de la tabla hash.
     * @author Pedro Sebastiano
     */
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
    
    /**
     * Obtiene el tamaño de la tabla hash.
     * 
     * @return Tamaño de la tabla hash.
     * @author Pedro Sebastiano
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño de la tabla hash.
     * 
     * @param size Tamaño de la tabla hash.
     * @author Pedro Sebastiano
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Obtiene el array de listas de nodos de árbol.
     * 
     * @return Array de listas de nodos de árbol.
     * @author Pedro Sebastiano
     */
    public List[] getArrayPersonas() {
        return arrayPersonas;
    }

    /**
     * Establece el array de listas de nodos de árbol.
     * 
     * @param arrayPersonas Array de listas de nodos de árbol.
     * @author Pedro Sebastiano
     */
    public void setArrayPersonas(List[] arrayPersonas) {
        this.arrayPersonas = arrayPersonas;
    }
}
