/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import Extras.Persona;

/**
 * Clase TreeNode
 * Representa un nodo del arbol, el cual contiene su informacion y una lista de sus hijos.
 * 
 * @author Pedro Sebastiano
 * @version 1.0
 */
public class TreeNode {
    /**
     * @param tinfo variable privada de tipo Persona que contiene la información del nodo.
     * @param pnext variable privada de tipo Lista de TreeNodes que contiene los hijos de un nodo.
     */
    private Persona tinfo;
    private List<TreeNode> hijos;
    
    /**
     * Constructor de la clase TreeNode.
     * Crea un Treenode con la información de tipo Persona y crea una lista vacia con sus hijos.
     * 
     * @param tinfo variable de tipo Persona que contiene la información del Treenoede.
     * @author Pedro Sebastiano
     */
    public TreeNode(Persona tinfo) {
        this.tinfo = tinfo;
        this.hijos = new List();
    }
    
    /**
     * Obtiene la información del Treenode.
     * 
     * @return variable de tipo Persona con la información del Treenode.
     * @author Pedro Sebastiano
     */
    public Persona getTinfo() {
        return tinfo;
    }
    
    /**
     * Cambia la información del Treenode.
     * 
     * @param tinfo variable de tipo Persona con la nueva información del Treenode.
     * @author Pedro Sebastiano
     */
    public void setTinfo(Persona tinfo) {
        this.tinfo = tinfo;
    }

    /**
     * Obtiene los hijos de un TreeNode.
     * 
     * @return variable de tipo Lista de TreeNode que contiene una lista de hijos de un TreeNode.
     * @author Pedro Sebastiano
     */
    public List<TreeNode> getHijos() {
        return hijos;
    }

    /**
     * Cambia la lista de hijos de un TreeNode.
     * 
     * @param hijos variable de tipo lista de TreeNode que contiene los nuevos hijos de un TreeNode.
     * @author Pedro Sebastiano
     */
    public void setHijos(List<TreeNode> hijos) {
        this.hijos = hijos;
    }
    
}
