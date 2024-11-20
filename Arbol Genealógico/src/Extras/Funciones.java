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
 * Clase Funciones
 * Contiene métodos auxiliares para operar sobre nodos y árboles genealógicos.
 * 
 * @author Pedro Sebastiano
 */
public class Funciones {
    
    private String auxiliar;

    /**
     * Calcula y establece el nivel de un nodo en el árbol.
     * 
     * @param level Nivel inicial.
     * @param node Nodo del árbol.
     * @author Pedro Sebastiano
     */
    public void calculateLevel(int level, TreeNode node) {
        if (node == null) {
            return;
        }
        node.getTinfo().setNivel(level);
        Node<TreeNode> aux = node.getHijos().getpFirst();
        while (aux != null) {
            calculateLevel(level + 1, aux.getData());
            aux = aux.getpNext();
        }
    }

    /**
     * Agrega un nodo y sus conexiones al gráfico original.
     * 
     * @param originalTree Árbol original al que se agregará el nodo.
     * @param node Nodo a agregar.
     * @param padre Nodo padre del nodo a agregar.
     * @author Pedro Sebastiano
     */
    public void appendGraph(Tree originalTree, TreeNode node, TreeNode padre) {
        if (node == null) {
            return;
        }
        String[] colors = { "red", "blue", "green", "yellow", "purple", "cyan", "magenta", "orange", "pink", "gold", "violet"};
        String color;
        originalTree.addNode(node.getTinfo());
        if (node.getTinfo().getNivel() <= colors.length) {
            color = colors[node.getTinfo().getNivel() - 1];
        }else{
            color = colors[node.getTinfo().getNivel() - 12];
        }
        originalTree.getGraph().getNode(node.getTinfo().getFullName() + "/" + node.getTinfo().getNumeral() + "/" + node.getTinfo().getFather()).setAttribute("ui.style", "fill-color: " + color + "; shape: circle; size: 30px;");
        if (padre != null) {
            originalTree.connectNodes(node.getTinfo(), padre.getTinfo());
        }
        Node<TreeNode> aux = node.getHijos().getpFirst();
        while (aux != null) {
            appendGraph(originalTree, aux.getData(), node);
            aux = aux.getpNext();
        }
    }

    /**
     * Verifica si una persona está en el árbol a partir de un nodo padre.
     * 
     * @param father Nodo padre desde donde se iniciará la búsqueda.
     * @param persona Persona a buscar.
     * @return true si la persona está en el árbol, false en caso contrario.
     * @author Pedro Sebastiano
     */
    public boolean isInTree(TreeNode father, Persona persona) {
        boolean encontrado = false;
        Node<TreeNode> aux = father.getHijos().getpFirst();
        String[] name = father.getTinfo().getFullName().split(" ");
        String apellido = name[0];
        for (String part : name) {
            apellido = part;
        }
        String[] name2 = persona.getFullName().split(" ");
        String ultimaCadena = name2[0];
        for (String part : name2) {
            ultimaCadena = part;
        }
        if (!apellido.equals(ultimaCadena)) {
            persona.setFullName(persona.getFullName() + " " + apellido);
        }
        while (aux != null) {
            if (aux.getData() != null) {
                if (aux.getData().getTinfo().getFullName().toLowerCase().equals(persona.getFullName().toLowerCase())) {
                    encontrado = true;
                    break;
                }
            }
            aux = aux.getpNext();
        }
        return encontrado;
    }

    /**
     * Elimina los espacios en blanco en una cadena de texto.
     * 
     * @param cadena Cadena de texto a procesar.
     * @return Cadena sin espacios en blanco adicionales.
     * @author Pedro Sebastiano
     */
    public String deleteBlankSpaces(String cadena) {
        if (cadena.contains(" ")) {
            String[] cutted = cadena.split(" ");
            String newCadena = "";
            for (String palabra : cutted) {
                if (!palabra.equals("")) {
                    newCadena += palabra + " ";
                }
            }
            newCadena = newCadena.trim();
            return newCadena;
        } else {
            return cadena;
        }
    }
    
    /**
     * Realiza la busqueda por mote y nombre y anade a una lista de personas
     * 
     * @param arbol arbol original del programa.
     * @param cadenaaBuscar string ingresado por el usuario.
     * @return Lista de personas que contienen la cadena
     * @author Pedro Sebastiano
     */
    public List<Persona> searchByNameandMote(Tree arbol, String cadenaaBuscar){
       List<Persona> encontrados = new List<>();
       this.addNamesandMote(arbol.getpRoot(), cadenaaBuscar, encontrados);
       if(encontrados.getSize() == 1){
           mostrarDescendencia(arbol.getNombres().searchPersona(encontrados.getpFirst().getData(), false), arbol);
       }
       return encontrados;
        
    }
    
    /**
     * verifica si una persona tiene la cadena, si la tiene lo anade a la lista
     * 
     * @param node nodo en el que se reaaliza la busqueda y se compara si contiene la cadena.
     * @param cadenaBuscar string ingresado por el usuario.
     * @param lista lista de personas donde se guardan las que contienen la cadena.
     * @author Pedro Sebastiano
     */
    public void addNamesandMote(TreeNode node, String cadenaBuscar, List<Persona> lista) {
        if (node.getTinfo().getFullName().toLowerCase().contains(cadenaBuscar.toLowerCase().trim())) {
            lista.add(node.getTinfo());
        } else {
            if (node.getTinfo().getKwownAs() != null && !node.getTinfo().getKwownAs().equals("")) {
                if (node.getTinfo().getKwownAs().toLowerCase().contains(cadenaBuscar.toLowerCase().trim())) {
                    lista.add(node.getTinfo());
                }
            }
        }
        Node<TreeNode> aux = node.getHijos().getpFirst();
        while (aux != null) {
            addNamesandMote(aux.getData(), cadenaBuscar, lista);
            aux = aux.getpNext();
        }
    }

    /**
     * Muestra la descendencia de un nodo raíz en el árbol original.
     * 
     * @param pRoot Nodo raíz cuya descendencia será mostrada.
     * @param originalTree Árbol original.
     * @author Pedro Sebastiano
     */
    public void mostrarDescendencia(TreeNode pRoot, Tree originalTree) {
        Tree subArbol = new Tree(pRoot);
        if (pRoot != null) {
            if (pRoot.getHijos().getpFirst() != null) {
                subArbol.mostrarArbol(originalTree);
                subArbol.addNode(pRoot.getTinfo());
                subArbol.getGraph().getNode(pRoot.getTinfo().getFullName() + "/" + pRoot.getTinfo().getNumeral() + "/" + pRoot.getTinfo().getFather()).setAttribute("ui.style", "fill-color: yellow; shape: circle; size: 30px;");
                crearDescendencia(pRoot.getHijos(), pRoot, subArbol);
            } else {
                JOptionPane.showMessageDialog(null, pRoot.getTinfo().getFullName() + ", no posee descendencia");
            }
        }
    }

    /**
     * Crea la descendencia de un nodo padre en un subárbol.
     * 
     * @param hijos Lista de descendientes del nodo.
     * @param padre Nodo padre.
     * @param subArbol Subárbol donde se agregará la descendencia.
     * @author Pedro Sebastiano
     */
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

    /**
     * Construye un árbol de ancestros de una persona a partir del árbol original.
     * 
     * @param persona Persona cuyas ancestros serán construidos.
     * @param originalTree Árbol original.
     * @return srting con los ancesstros de la persona desde el mayor hasta el menor
     * @author Pedro Sebastiano
     */
    public String constructAncestors(Persona persona, Tree originalTree) {
        List<Persona> listPersona = new List<>();
        this.viewAncestors(originalTree, listPersona, persona);
        if(listPersona.getSize() == 1){
            JOptionPane.showMessageDialog(null, "La persona " + persona.getFullName()+", "+ persona.getNumeral()+" of his name no tiene ancestros");
            return "La persona " + persona.getFullName()+", "+ persona.getNumeral()+" of his name no tiene ancestros";
        }else{
        Tree ancestorTree = new Tree(0, 0);
        Node<Persona> aux1 = listPersona.getpFirst();
        Node<Persona> aux2 = null;
        String contenido = "Ancestros de " + persona.getFullName();
        if(!persona.getNumeral().equals("")&& persona.getNumeral()!= null){
            contenido += ", "+ persona.getNumeral()+" of his name";
        }
        contenido += "\n";
        ancestorTree.mostrarArbol(originalTree);
        while(aux1!=null){
            for (int i = 1; i < aux1.getData().getNivel(); i++) {
                contenido += "-";
            }
            contenido += ">";
            if(aux1.getData().getNumeral().equals("")){
                 contenido += aux1.getData().getFullName()+ "\n";
            }else{
                contenido += aux1.getData().getFullName() + ", " + aux1.getData().getNumeral() + " of his name" + "\n";
            }
            ancestorTree.addNode(aux1.getData());
            if (aux1.getData() == persona) {
                ancestorTree.getGraph().getNode(aux1.getData().getFullName() + "/" + aux1.getData().getNumeral() + "/" + aux1.getData().getFather()).setAttribute("ui.style", "fill-color: yellow; shape: circle; size: 30px;");
            }
            if(aux2!=null){
                ancestorTree.connectNodes(aux1.getData(), aux2.getData());
            }
            aux2 = aux1;
            aux1 = aux1.getpNext();

        }
        return contenido;
        }
        
    }
    
    public void stringAncestros(TreeNode persona,Persona buscada){ 
        Node<TreeNode> aux = persona.getHijos().getpFirst();
        while (aux != null) {
            for (int i = 1; i < aux.getData().getTinfo().getNivel(); i++) {
                auxiliar += "-";
            }
            auxiliar += ">";
            if(aux.getData().getTinfo().getNumeral().equals("")){
                 auxiliar += aux.getData().getTinfo().getFullName()+ "\n";
            }else{
                auxiliar += aux.getData().getTinfo().getFullName() + ", " + aux.getData().getTinfo().getNumeral() + " of his name" + "\n";
            }
            aux = aux.getpNext();
        }
        aux = persona.getHijos().getpFirst();
        while(aux!=null){
            if (aux.getData().getHijos().getpFirst() != null && aux.getData().getTinfo() != buscada) {
                this.stringAncestros(aux.getData(), buscada);
            }
            aux = aux.getpNext();
        }
    }

    
    /**
     * Inserta los hijos de un ancestro en el árbol de ancestros.
     * 
     * @param ancestorTree Árbol de ancestros.
     * @param padre Nodo padre.
     * @param buscada Persona buscada.
     * @author Pedro Sebastiano
     */
    /*
    public void insertSonsAncestors(Tree ancestorTree, TreeNode padre, Persona buscada) {
        Node<TreeNode> aux2 = padre.getHijos().getpFirst();
        while (aux2 != null) {
            ancestorTree.addNode(aux2.getData().getTinfo());
            ancestorTree.connectNodes(aux2.getData().getTinfo(), padre.getTinfo());
            if (aux2.getData().getTinfo() == buscada) {
                ancestorTree.getGraph().getNode(buscada.getFullName() + "/" + buscada.getNumeral() + "/" + buscada.getFather()).setAttribute("ui.style", "fill-color: yellow; shape: circle; size: 30px;");
            }
            if (aux2.getData().getHijos().getpFirst() != null && aux2.getData().getTinfo() != buscada) {
                this.insertSonsAncestors(ancestorTree, aux2.getData(), buscada);
            }
            aux2 = aux2.getpNext();
        }
    }
    */
    

    /**
     * Muestra los ancestros de una persona en el árbol original.
     * 
     * @param originalTree Árbol original.
     * @param ancestros Lista de ancestros.
     * @param persona Persona cuyas ancestros serán mostrados.
     * @author Pedro Sebastiano
     */
    public void viewAncestors(Tree originalTree, List<Persona> ancestros, Persona persona) {
        ancestros.addByIndex(0, persona);
        if (persona.getFather() != null) {
            Persona fatherPersona;
            if (persona.getFather().contains(",")) {
                String[] partesNombre = persona.getFather().split(", ");
                String numeral = partesNombre[1].split(" ")[0].trim();
                fatherPersona = new Persona(partesNombre[0], numeral, "");
            } else {
                fatherPersona = new Persona("", "", persona.getFather().trim());
            }
            TreeNode padre = originalTree.searchPersonaTree(fatherPersona);
            this.viewAncestors(originalTree, ancestros, padre.getTinfo());
        }
    }

    /**
     * Construye una lista de personas que tienen un título específico.
     * 
     * @param originalTree Árbol original.
     * @param heldTitle Título a buscar.
     * @return Lista de personas que tienen el título.
     * @author Pedro Sebastiano
     */
    public List<Persona> constructListHeldTitle(Tree originalTree, String heldTitle) {
        List<Persona> personasTitulo = new List<Persona>();
        TreeNode proot = originalTree.getpRoot();
        searchByHeldTitle(proot, heldTitle, personasTitulo);
        return personasTitulo;
    }

    /**
     * Busca personas que tienen un título específico en un nodo y sus descendientes.
     * 
     * @param node Nodo a buscar.
     * @param heldTitle Título a buscar.
     * @param personasTitulo Lista de personas que tienen el título.
     * @author Pedro Sebastiano
     */
    public void searchByHeldTitle(TreeNode node, String heldTitle, List<Persona> personasTitulo) {
        if (node == null) {
            return;
        }
        if (node.getTinfo().getHeldTitle() != null) {
            if (node.getTinfo().getHeldTitle().toLowerCase().equals(heldTitle.toLowerCase().trim())) {
                personasTitulo.add(node.getTinfo());
            }
        }
        Node<TreeNode> aux = node.getHijos().getpFirst();
        while (aux != null) {
            searchByHeldTitle(aux.getData(), heldTitle, personasTitulo);
            aux = aux.getpNext();
        }
    }

    /**
     * Construye una lista de personas de una generación específica.
     * 
     * @param originalTree Árbol original.
     * @param nGeneration Generación a buscar.
     * @return Lista de personas de la generación.
     * @author Pedro Sebastiano
     */
    public List<Persona> constructListGeneration(Tree originalTree, int nGeneration) {
        List<Persona> generacion = new List<Persona>();
        TreeNode proot = originalTree.getpRoot();
        getGeneration(proot, nGeneration, generacion);
        return generacion;
    }

    /**
     * Obtiene personas de una generación específica en un nodo y sus descendientes.
     * 
     * @param node Nodo a buscar.
     * @param nGeneration Generación a buscar.
     * @param generacion Lista de personas de la generación.
     * @author Pedro Sebastiano
     */
    public void getGeneration(TreeNode node, int nGeneration, List<Persona> generacion) {
        if (node == null) {
            return;
        }
        if (node.getTinfo().getNivel() == nGeneration) {
            generacion.add(node.getTinfo());
        }
        Node<TreeNode> aux = node.getHijos().getpFirst();
        while (aux != null) {
            if (aux.getData().getTinfo().getNivel() <= nGeneration) {
                getGeneration(aux.getData(), nGeneration, generacion);
            }
            aux = aux.getpNext();
        }
    }
}
