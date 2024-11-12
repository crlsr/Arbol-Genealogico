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
            newTree.mostrarArbol();//2do arbol
            object.eddInsert(newTree);
        }
        MENU main = new MENU();
        main.setVisible(true);
    } 
}