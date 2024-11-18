/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import Extras.Persona;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
/**
 * Clase Tree
 * Representa un árbol genealógico con Treenodes y relaciones.
 * 
 * @author Pedro Sebastiano
 * @version 1.0
 */
public class Tree {

    /**
     * @param pRoot Nodo raíz del árbol.
     * @param graph Gráfico que representa el árbol.
     * @param nombres Tabla hash para almacenar nombres.
     * @param motes Tabla hash para almacenar alias.
     * @param size Tamaño del árbol.
     */
    private TreeNode pRoot;
    private Graph graph;
    private Hashtable nombres;
    private Hashtable motes;
    private int size;

    /**
     * Constructor de la clase Tree. Inicializa un árbol vacío con tablas hash
     * de tamaños dados.
     *
     * @param hashtableSize1 Tamaño de la tabla hash para nombres.
     * @param hashtableSize2 Tamaño de la tabla hash para alias.
     * @author Pedro Sebastiano
     */
    public Tree(int hashtableSize1, int hashtableSize2) {
        this.pRoot = null;
        this.graph = new MultiGraph("Árbol Genealógico");
        this.nombres = new Hashtable(hashtableSize1);
        this.motes = new Hashtable(hashtableSize2);
        this.size = 0;
    }

    /**
     * Constructor de la clase Tree. Inicializa un árbol con un nodo raíz dado.
     *
     * @param pRoot Nodo raíz del árbol.
     * @author Pedro Sebastiano
     */
    public Tree(TreeNode pRoot) {
        this.pRoot = pRoot;
        this.graph = new MultiGraph("Árbol Genealógico");
        this.size = 0;
        this.nombres = null;
        this.motes = null;
    }

    /**
     * Agrega un nodo al gráfico.
     *
     * @param persona Objeto Persona que será agregado como nodo.
     * @author Pedro Sebastiano
     */
    public void addNode(Persona persona) {
        if (persona != null) {
            if (graph.getNode(persona.getFullName() + "/" + persona.getNumeral() + "/" + persona.getFather()) == null) {
                graph.addNode(persona.getFullName() + "/" + persona.getNumeral() + "/" + persona.getFather()).setAttribute("ui.label", persona.getFullName() + " " + persona.getNumeral());
                this.graph.getNode(persona.getFullName() + "/" + persona.getNumeral() + "/" + persona.getFather()).setAttribute("ui.style", "fill-color: lightblue; shape: circle; size: 30px;");
                this.setSize(this.getSize() + 1);
                int x = (this.getSize() % 10) * 80;
                int y = persona.getNivel() * -100;
                graph.getNode(persona.getFullName() + "/" + persona.getNumeral() + "/" + persona.getFather()).setAttribute("xy", x, y);
            }
        }
    }

    /**
     * Conecta dos nodos en el gráfico.
     *
     * @param hijo Objeto Persona que representa al hijo.
     * @param padre Objeto Persona que representa al padre.
     * @author Pedro Sebastiano
     */
    public void connectNodes(Persona hijo, Persona padre) {
        if (hijo != null && padre != null) {
            if (graph.getNode(padre.getFullName() + "/" + padre.getNumeral() + "/" + padre.getFather()) == null) {
                this.addNode(padre);
            }
            if (graph.getNode(hijo.getFullName() + "/" + hijo.getNumeral() + "/" + hijo.getFather()) == null) {
                this.addNode(hijo);
            }
            String edgeId = padre.getFullName() + "/" + padre.getNumeral() + "/" + padre.getFather() + "/" + hijo.getFullName() + "/" + hijo.getNumeral() + "/" + hijo.getFather();
            if (graph.getEdge(edgeId) == null) {
                graph.addEdge(edgeId, padre.getFullName() + "/" + padre.getNumeral() + "/" + padre.getFather(), hijo.getFullName() + "/" + hijo.getNumeral() + "/" + hijo.getFather(), true);
                graph.getEdge(edgeId).setAttribute("ui.style", "fill-color: brown;");
            }
        }
    }

    /**
     * Establece la relación padre-hijo en la lista de hijos del nodo padre.
     *
     * @param hijo Objeto Persona que representa al hijo.
     * @param padre Objeto Persona que representa al padre.
     * @author Pedro Sebastiano
     */
    public void setListFather(Persona hijo, Persona padre) {
        TreeNode padreArbol = this.getNombres().searchPersona(padre, false);
        padreArbol.getHijos().add(this.getNombres().searchPersona(hijo, false));
        padreArbol.getTinfo().setSons(hijo.getFullName() + " " + hijo.getNumeral());
    }


    /**
     * Busca una persona en el árbol utilizando las tablas hash de nombres y
     * alias.
     *
     * @param buscado Objeto Persona que será buscado.
     * @return TreeNode del árbol que contiene la persona buscada, o null si no se
     * encuentra.
     * @author Pedro Sebastiano
     */
    public TreeNode searchPersonaTree(Persona buscado) {
        Hashtable hashnames = this.getNombres();
        TreeNode nodoBuscado = hashnames.searchPersona(buscado, false);
        if (nodoBuscado == null) {
            Hashtable hashmotes = this.getMotes();
            nodoBuscado = hashmotes.searchPersona(buscado, true);
        }
        return nodoBuscado;
    }

    /**
     * Muestra el árbol en una interfaz gráfica.
     *
     * @param arbol Objeto Tree que será mostrado.
     * @author Pedro Sebastiano
     */
    public void mostrarArbol(Tree arbol) {
        System.setProperty("org.graphstream.ui", "swing");
        Clicks visualizador = new Clicks(graph, arbol);
    }

    /**
     * Muestra el contenido de las tablas hash de nombres y alias.
     *
     * @author Pedro Sebastiano
     */
    public void viewHash() {
        List<TreeNode>[] x = this.getNombres().getArrayPersonas();
        Node<TreeNode> aux;
        for (List<TreeNode> elem : x) {
            System.out.println("+++++++++++++++++++++");
            if (elem != null) {
                aux = elem.getpFirst();
                while (aux != null) {
                    System.out.println(aux.getData().getTinfo().getFullName() + aux.getData().getTinfo().getNumeral());
                    aux = aux.getpNext();
                }
            }
        }
        System.out.println("////////////////////////////////");
        List<TreeNode>[] m = this.getMotes().getArrayPersonas();
        Node<TreeNode> aux1;
        for (List<TreeNode> elem : m) {
            System.out.println("+++++++++++++++++++++");
            if (elem != null) {
                aux1 = elem.getpFirst();
                while (aux1 != null) {
                    System.out.println(aux1.getData().getTinfo().getFullName() + aux1.getData().getTinfo().getNumeral());
                    aux1 = aux1.getpNext();
                }
            }
        }
    }

    /**
     * Obtiene el nodo raíz del árbol.
     *
     * @return Nodo raíz del árbol.
     * @author Pedro Sebastiano
     */
    public TreeNode getpRoot() {
        return pRoot;
    }

    /**
     * Establece el nodo raíz del árbol.
     *
     * @param pRoot Nodo raíz del árbol.
     * @author Pedro Sebastiano
     */
    public void setpRoot(TreeNode pRoot) {
        this.pRoot = pRoot;
    }

    /**
     * Obtiene la tabla hash de nombres.
     *
     * @return Tabla hash de nombres.
     * @author Pedro Sebastiano
     */
    public Hashtable getNombres() {
        return nombres;
    }

    /**
     * Establece la tabla hash de nombres.
     *
     * @param nombres Tabla hash de nombres.
     * @author Pedro Sebastiano
     */
    public void setNombres(Hashtable nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene la tabla hash de alias.
     *
     * @return Tabla hash de motes
     * @author Pedro Sebastiano
     */
    public Hashtable getMotes() {
        return motes;
    }

    /**
     * Establece la tabla hash de alias.
     *
     * @param motes Tabla hash de alias.
     * @author Pedro Sebastiano
     */
    public void setMotes(Hashtable motes) {
        this.motes = motes;
    }

    /**
     * Obtiene el tamaño del árbol.
     *
     * @return Tamaño del árbol.
     * @author Pedro Sebastiano
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño del árbol.
     *
     * @param size Tamaño del árbol.
     * @author Pedro Sebastiano
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Obtiene el gráfico que representa el árbol.
     *
     * @return Gráfico que representa el árbol.
     * @author Pedro Sebastiano
     */
    public Graph getGraph() {
        return graph;
    }

    /**
     * Establece el gráfico que representa el árbol.
     *
     * @param graph Gráfico que representa el árbol.
     * @author Pedro Sebastiano
     */
    public void setGraph(Graph graph) {
        this.graph = graph;
    }

}
