/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Extras;

import EDD.List;
import EDD.Tree;
import EDD.Hashtable;
import EDD.Node;
import EDD.TreeNode;
import javax.swing.JOptionPane;

/**
 *
 * @author pseba
 */
public class Funciones {
    
    public boolean isInTree(TreeNode father, Persona persona){
        boolean encontrado = false;
        Node<TreeNode> aux= father.getHijos().getpFirst();
        String[] name = father.getTinfo().getFullName().split(" ");
        String apellido= name[0];
        for (String part: name){
            apellido = part;
        }
        String[] name2 = persona.getFullName().split(" ");
        String ultimaCadena= name2[0];
        for (String part: name){
            ultimaCadena = part;
        }
        if(apellido != ultimaCadena){
            persona.setFullName(persona.getFullName()+ " " +apellido);
        }
        while(aux!=null){
            if(aux.getData().getTinfo().getFullName().toLowerCase() == persona.getFullName().toLowerCase()){
                encontrado = true;
                break;
            }
            aux = aux.getpNext();
        }
        return encontrado;
    }
    
    public void searchbyMote(Tree arbol, String cadenaBuscar){
        TreeNode elemBuscado = arbol.getMotes().searchPersona(new Persona("","",cadenaBuscar), true);
        if(elemBuscado == null){
            JOptionPane.showMessageDialog(null, "El mote: " + cadenaBuscar + " no ha sido encontrado");  
        }else{
            this.mostrarDescendencia(elemBuscado);
        }
    }
    
    public List<TreeNode> searchbyName(Tree arbol, String cadenaBuscar){
       List<TreeNode> encontrados = new List<TreeNode>();
       arbol.preOrden(arbol.getpRoot(), encontrados, cadenaBuscar);
       return encontrados;
       //Hacer funcion con hashtable mejor
       //Verificar si poner funcion que convierta a str los objetos de la lista, y llamar a la otra funcion para ver la descencencia del seleccionado
       //Verificar si la lista tiene solo 1 elemento
    }
    
    public void mostrarDescendencia(TreeNode pRoot) {
        Tree subArbol = new Tree(pRoot); 
        if (pRoot != null) {
            subArbol.addNode(pRoot.getTinfo());
            crearDescendencia(pRoot.getHijos(), pRoot, subArbol);
            subArbol.mostrarArbol();
        }
    }

    public void crearDescendencia(List<TreeNode> hijos, TreeNode padre, Tree subArbol) {
        if (hijos == null || padre == null) return;
        Node<TreeNode> aux = hijos.getpFirst();
        while (aux != null) {
            TreeNode hijo = aux.getData();
            subArbol.addNode(hijo.getTinfo());
            subArbol.connectNodes(hijo.getTinfo(), padre.getTinfo());
            crearDescendencia(hijo.getHijos(), hijo, subArbol);
            aux = aux.getpNext();
        }
    }
    
    

}
