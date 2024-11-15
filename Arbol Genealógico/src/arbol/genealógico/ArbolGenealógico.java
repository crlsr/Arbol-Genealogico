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
import Extras.Funciones;

/**
 *
 * @author carlosrodriguez
 */
public class ArbolGenealógico {

    private static LecturaJSON json;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LecturaJSON object;
        Tree newTree = null;
        JFileChooser finder = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos JSON", "json");
        finder.setFileFilter(filter);
        int response = finder.showOpenDialog(null);
        
        if (response == JFileChooser.APPROVE_OPTION) {
            File selected = finder.getSelectedFile();
            object = new LecturaJSON(selected); //Se crea el JSON
            newTree = object.dataConstructor(newTree);
            newTree.mostrarArbol();//2do arbol
            object.eddInsert(newTree);
            Funciones func = new Funciones();
            String nombre= "Aegon Targaryen, Fourth of his name";
            Persona fatherPersona;
            if(nombre.contains(",")){
                String[] partesNombre = nombre.split(", ");
                String numeral = partesNombre[1].split(" ")[0].trim();
                fatherPersona = new Persona(partesNombre[0], numeral, "");
            }else{
                fatherPersona = new Persona("", "", nombre.trim());
            }
            TreeNode persona = newTree.searchPersonaTree(fatherPersona);
            if (persona!=null){
            func.constructAncestors(persona.getTinfo(), newTree);
            }else{
                System.out.println(nombre + " no ha sido encontrado");
            }
        }
        MENU main = new MENU(newTree, json);
        main.setVisible(true);
    } 
}