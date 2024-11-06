/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import Extras.Persona;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.view.Viewer;
/**
 *
 * @author pseba
 */
public class Tree {
        
    private TreeNode pRoot;
    private Graph graph;

    public Tree() {
        this.pRoot = null;
        this.graph = new MultiGraph("Árbol Genealógico");
        System.setProperty("org.graphstream.ui", "swing");
    }
    
    public void addNode(Persona persona){
        //llamada a funcion para buscar en el hashtable
    }

    public TreeNode getpRoot() {
        return pRoot;
    }

    public void setpRoot(TreeNode pRoot) {
        this.pRoot = pRoot;
    }
}
