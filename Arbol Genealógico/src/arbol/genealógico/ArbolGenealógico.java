/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbol.genealógico;
import EDD.Tree;
import Extras.Persona;
/**
 *
 * @author carlosrodriguez
 */
public class ArbolGenealógico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Tree arbolGenealogico = new Tree(10);

    Persona padreFundador = new Persona("John Doe", "I", "blue", "brown", null);
    Persona hijo1 = new Persona("John Doe", "II", "green", "black", "John Doe I");
    Persona hijo2 = new Persona("Jane Doe", "I", "green", "blonde", "John Doe II");
    Persona nieto = new Persona("John Doe", "III", "brown", "brown", "John Doe II");


    arbolGenealogico.addNode(padreFundador);
    arbolGenealogico.addNode(hijo1);
    arbolGenealogico.addNode(hijo2);
    arbolGenealogico.addNode(nieto);

    arbolGenealogico.connectNodes(hijo1, padreFundador);  
    arbolGenealogico.connectNodes(hijo2, hijo1);         
    arbolGenealogico.connectNodes(nieto, hijo1);   
    arbolGenealogico.mostrarArbol();
    }
    
}
