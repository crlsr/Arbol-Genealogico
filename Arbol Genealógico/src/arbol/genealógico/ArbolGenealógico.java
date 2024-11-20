/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbol.genealógico;

import EDD.List;
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
        MENU main = new MENU();
        main.setVisible(true); 
        
        
        /*
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
            newTree.mostrarArbol(newTree);//2do arbol
            object.eddInsert(newTree);
            Funciones func = new Funciones();
            
            List<Persona> nombresymotes= func.searchByNameandMote(newTree, "Viserys");
            System.out.println(nombresymotes.getSize());
            
            //Aqui comienza lo de crear arbol con ancestros
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
                System.out.println(func.constructAncestors(persona.getTinfo(), newTree));
            }else{
                System.out.println(nombre + " no ha sido encontrado");
            }++++++++++++++++
            
            //Aqui comienza la busqueda por titulo nobiliario
            List<Persona> listPersonas =func.constructListHeldTitle(newTree, "King of the Andals and the First Men, Lord of the Seven Kingdoms");
            listPersonas.show();
            System.out.println("+++++++++");
            
            ++++++++++++++++++++++++
            
            
            //Aqui comienza la creacion de la lista con la generacion seleccionada
            List<Persona> Generacion = func.constructListGeneration(newTree, 7);
            Generacion.show();
            //Aqui comienza la creacion del arbol con la descencencia de una persona
            String nombre1= "Daeron Targaryen, Second of his name";Persona fatherPersona1;
            if(nombre1.contains(",")){
                String[] partesNombre = nombre1.split(", ");
                String numeral = partesNombre[1].split(" ")[0].trim();
                fatherPersona1 = new Persona(partesNombre[0], numeral, "");
            }else{
                fatherPersona1 = new Persona("", "", nombre1.trim());
            }
            TreeNode persona1 = newTree.searchPersonaTree(fatherPersona1);
            if (persona1!=null){
                func.mostrarDescendencia(persona1, newTree);
            }else{
                System.out.println(nombre1 + " no ha sido encontrado");
            }
*/
        }     
}