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
    private Hashtable nombres;
    private Hashtable motes;
    private int size;

    public Tree(int hashtableSize1, int hashtableSize2) {
        this.pRoot = null;
        this.graph = new MultiGraph("Árbol Genealógico");
        this.nombres = new Hashtable(hashtableSize1);
        this.motes = new Hashtable(hashtableSize2);
        this.size = 0;
    }

    public Tree(TreeNode pRoot) {
        this.pRoot = pRoot;
        this.graph = new MultiGraph("Árbol Genealógico");
        this.size = 0;
        this.nombres = null;
        this.motes = null;
    }
    
    public void addNode(Persona persona){
        if(persona!= null){
            if(graph.getNode(persona.getFullName() + "/" + persona.getNumeral()+"/"+persona.getFather())== null){
                graph.addNode(persona.getFullName()+ "/" + persona.getNumeral()+ "/" + persona.getFather()).setAttribute("ui.label", persona.getFullName()+ " " + persona.getNumeral());
                this.graph.getNode(persona.getFullName()+ "/" + persona.getNumeral()+ "/" + persona.getFather()).setAttribute("ui.style", "fill-color: lightblue; shape: circle; size: 30px;");
                this.setSize(this.getSize()+1); 
                int x = (this.getSize() % 10) * 80;  
                int y = persona.getNivel()*-100;  
                graph.getNode(persona.getFullName()+ "/" + persona.getNumeral()+ "/" + persona.getFather()).setAttribute("xy", x, y);
            }
            
        }
    }
    
    public void connectNodes(Persona hijo, Persona padre){
        if(hijo!= null && padre!= null){
            if (graph.getNode(padre.getFullName()+ "/" + padre.getNumeral()+ "/" + padre.getFather()) == null) {
                this.addNode(padre);
            }
            if (graph.getNode(hijo.getFullName()+ "/" + hijo.getNumeral()+ "/" + hijo.getFather()) == null) {
                this.addNode(hijo);
            }
            String edgeId =  padre.getFullName()+ "/" + padre.getNumeral()+ "/" + padre.getFather() + "/" + hijo.getFullName()+ "/" + hijo.getNumeral()+ "/" + hijo.getFather();
            if (graph.getEdge(edgeId) == null) {
                graph.addEdge(edgeId, padre.getFullName()+ "/" + padre.getNumeral()+ "/" + padre.getFather(), hijo.getFullName()+ "/" + hijo.getNumeral()+ "/" + hijo.getFather(), true);  
                graph.getEdge(edgeId).setAttribute("ui.style", "fill-color: brown;");  
            }
        }
    }
    
    public void setListFather(Persona hijo, Persona padre){
        TreeNode padreArbol = this.getNombres().searchPersona(padre, false);
        padreArbol.getHijos().add(this.getNombres().searchPersona(hijo, false));
        padreArbol.getTinfo().setSons(hijo.getFullName()+ " " + hijo.getNumeral());
    }
    
    public void preOrden(TreeNode node, List<TreeNode> lista, String cadenaBuscar) {
        if (node == null) {
            return;
        }
        if(node.getTinfo().getFullName().toLowerCase().contains(cadenaBuscar.toLowerCase())){
            lista.add(node);
        }
        Node<TreeNode> aux = node.getHijos().getpFirst();
        while(aux!= null){
            preOrden(aux.getData(), lista, cadenaBuscar);
            aux = aux.getpNext();
        }
    }
    
    public TreeNode searchPersonaTree(Persona buscado){
        Hashtable hashnames = this.getNombres();
        TreeNode nodoBuscado=hashnames.searchPersona(buscado, false);
        if(nodoBuscado == null){
            Hashtable hashmotes = this.getMotes();
            nodoBuscado=hashmotes.searchPersona(buscado, true);
        }
        return nodoBuscado;
    }
    
    public void mostrarArbol() {
        System.setProperty("org.graphstream.ui", "swing");
        Clicks visualizador = new Clicks(graph, this);
        
    }

    public TreeNode getpRoot() {
        return pRoot;
    }

    public void setpRoot(TreeNode pRoot) {
        this.pRoot = pRoot;
    }

    public Hashtable getNombres() {
        return nombres;
    }

    public void setNombres(Hashtable nombres) {
        this.nombres = nombres;
    }

    public Hashtable getMotes() {
        return motes;
    }

    public void setMotes(Hashtable motes) {
        this.motes = motes;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }  
}
