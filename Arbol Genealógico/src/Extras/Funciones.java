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
    
    public void calculateLevel(int level, TreeNode node){
        if (node == null) {
            return;
        }
        node.getTinfo().setNivel(level);
        Node<TreeNode> aux = node.getHijos().getpFirst();
        while(aux!= null){
            calculateLevel(level+1, aux.getData());
            aux = aux.getpNext();
        }
    }
    
    public void appendGraph(Tree originalTree, TreeNode node, TreeNode padre){
        if (node == null) {
            return;
        }
        originalTree.addNode(node.getTinfo());
        if(padre!=null){
           originalTree.connectNodes(node.getTinfo(), padre.getTinfo()); 
        }
        Node<TreeNode> aux = node.getHijos().getpFirst();
        while(aux!= null){
            appendGraph(originalTree, aux.getData(), node);
            aux = aux.getpNext();
        }
    }
    
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
        for (String part: name2){
            ultimaCadena = part;
        }
        if(!apellido.equals(ultimaCadena)){
            persona.setFullName(persona.getFullName()+ " " +apellido);
        }
        while(aux!=null){
            if(aux.getData()!=null){
            if(aux.getData().getTinfo().getFullName().toLowerCase().equals(persona.getFullName().toLowerCase())){
                encontrado = true;
                break;
            }
            }
            aux = aux.getpNext();
        }
        return encontrado;
    }
    
    public String deleteBlankSpaces(String cadena){
        if(cadena.contains(" ")){
            String[] cutted = cadena.split(" ");
            String newCadena = "";
            for(String palabra: cutted){
                if(!palabra.equals("")){
                newCadena += palabra+" ";
                }
            }
            newCadena = newCadena.trim();
            return newCadena;
        }else{
            return cadena;
        }
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
    
    public Tree constructAncestors(Persona persona, Tree originalTree) {
        List<Persona> listPersona = new List<Persona>();
        this.viewAncestors(originalTree, listPersona, persona);
        Tree ancestorTree = new Tree(listPersona.getSize(),listPersona.getSize());
        Node<Persona> aux = listPersona.getpFirst();
        ancestorTree.mostrarArbol();
        ancestorTree.getNombres().addPersona(aux.getData(), false);
        if (aux.getData().getKwownAs() != null) {
            ancestorTree.getMotes().addPersona(aux.getData(), true);
        }
        
        ancestorTree.addNode(aux.getData());
        TreeNode padre= originalTree.getNombres().searchPersona(aux.getData(), false);
        if(aux.getData() != persona){
            insertSonsAncestors(ancestorTree, padre, persona);
        }else{
            ancestorTree.getGraph().getNode(persona.getFullName()+ "/" + persona.getNumeral()+ "/" + persona.getFather()).setAttribute("ui.style", "fill-color: yellow; shape: circle; size: 30px;");
        }
            
        return ancestorTree;
    }
    
    public void insertSonsAncestors(Tree ancestorTree, TreeNode padre, Persona buscada){
        Node<TreeNode> aux2 = padre.getHijos().getpFirst();
            while(aux2!=null){
                ancestorTree.getNombres().addPersona(aux2.getData().getTinfo(), false);
                if (aux2.getData().getTinfo().getKwownAs() != null) {
                    ancestorTree.getMotes().addPersona(aux2.getData().getTinfo(), true);
                }
                ancestorTree.addNode(aux2.getData().getTinfo());
                ancestorTree.connectNodes(aux2.getData().getTinfo(), padre.getTinfo());
                if(aux2.getData().getTinfo() == buscada){
                    ancestorTree.getGraph().getNode(buscada.getFullName()+ "/" + buscada.getNumeral()+ "/" + buscada.getFather()).setAttribute("ui.style", "fill-color: yellow; shape: circle; size: 30px;");
                }
                if(aux2.getData().getHijos().getpFirst() != null && aux2.getData().getTinfo() != buscada){
                    this.insertSonsAncestors(ancestorTree, aux2.getData(), buscada);
                }
                aux2= aux2.getpNext();
            }
    }

    public void viewAncestors(Tree originalTree, List<Persona> ancestros, Persona persona){
        ancestros.addByIndex(0, persona);
        if(persona.getFather()!= null){
            Persona fatherPersona;
            if(persona.getFather().contains(",")){
                String[] partesNombre = persona.getFather().split(", ");
                String numeral = partesNombre[1].split(" ")[0].trim();
                fatherPersona = new Persona(partesNombre[0], numeral, "");
            }else{
                fatherPersona = new Persona("", "", persona.getFather().trim());
            }
            TreeNode padre = originalTree.searchPersonaTree(fatherPersona);
            this.viewAncestors(originalTree, ancestros, padre.getTinfo());
        }
    }
    

    public List<Persona> constructListHeldTitle(Tree originalTree, String heldTitle){
        List<Persona> personasTitulo = new List<Persona>();
        TreeNode proot = originalTree.getpRoot();
        searchByHeldTitle(proot, heldTitle, personasTitulo);
        return personasTitulo;
    } 
    
    public void searchByHeldTitle(TreeNode node, String heldTitle, List<Persona> personasTitulo){
        if (node == null) {
            return;
        }
        if(node.getTinfo().getHeldTitle()!= null){
            if(node.getTinfo().getHeldTitle().toLowerCase().equals(heldTitle.toLowerCase().trim())){
                personasTitulo.add(node.getTinfo());
            } 
        }
        Node<TreeNode> aux = node.getHijos().getpFirst();
        while(aux!= null){
            searchByHeldTitle(aux.getData(), heldTitle, personasTitulo);
            aux = aux.getpNext();
        }
    }
    
    public List<Persona> constructListGeneration(Tree originalTree, int nGeneration){
        List<Persona> generacion = new List<Persona>();
        TreeNode proot = originalTree.getpRoot();
        getGeneration(proot, nGeneration, generacion);
        return generacion;
    } 
    
    public void getGeneration(TreeNode node, int nGeneration, List<Persona> generacion){
        if (node == null) {
            return;
        }
        if(node.getTinfo().getNivel() == nGeneration){
            generacion.add(node.getTinfo());
        } 
        Node<TreeNode> aux = node.getHijos().getpFirst();
        while(aux!= null){
            if(aux.getData().getTinfo().getNivel() <= nGeneration){
                getGeneration(aux.getData(), nGeneration, generacion);
            }
            aux = aux.getpNext();
        }
    }
}
