/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbol.genealógico;

import EDD.Tree;
import Extras.Persona;
import EDD.TreeNode;
import VENTANAS.MENU;
import JSON.LecturaJSON;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author carlosrodriguez
 */
public class ArbolGenealógico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Tree arbolGenealogico = new Tree(10, 10);

        Persona padreFundador = new Persona("John Doe", "I", "blue", "brown", null);
        Persona hijo1 = new Persona("John Doe", "II", "green", "black", "John Doe I");
        Persona hijo2 = new Persona("Jane Doe", "I", "green", "blonde", "John Doe II");
        Persona nieto = new Persona("John Doe", "III", "brown", "brown", "John Doe II");

        arbolGenealogico.getNombres().addPersona(padreFundador, false);
        arbolGenealogico.getNombres().addPersona(hijo1, false);
        arbolGenealogico.getNombres().addPersona(hijo2, false);
        arbolGenealogico.getNombres().addPersona(nieto, false);
        TreeNode p1 = arbolGenealogico.searchPersonaTree(padreFundador);
        TreeNode p2 = arbolGenealogico.searchPersonaTree(hijo1);
        TreeNode p3 = arbolGenealogico.searchPersonaTree(hijo2);
        TreeNode p4 = arbolGenealogico.searchPersonaTree(nieto);
        arbolGenealogico.addNode(p1.getTinfo());
        arbolGenealogico.addNode(p2.getTinfo());
        arbolGenealogico.addNode(p3.getTinfo());
        arbolGenealogico.addNode(p4.getTinfo());
        arbolGenealogico.connectNodes(p2.getTinfo(), p1.getTinfo());
        arbolGenealogico.connectNodes(p3.getTinfo(), p2.getTinfo());
        arbolGenealogico.connectNodes(p4.getTinfo(), p2.getTinfo());

        LecturaJSON object;
        Tree newTree;
        JFileChooser finder = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos JSON", "json");
        finder.setFileFilter(filter);
        int response = finder.showOpenDialog(null);

        
        
        if (response == JFileChooser.APPROVE_OPTION) {
            File selected = finder.getSelectedFile();
            object = new LecturaJSON(selected); //Se crea el JSON
            newTree = object.dataConstructor();
        
        }
        
        MENU main = new MENU();
        main.setVisible(true);
    } 

}
