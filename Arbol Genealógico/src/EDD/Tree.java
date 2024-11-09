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
    
    public void addNode(Persona persona){
        if(persona!= null){
            if(graph.getNode(persona.getFullName() + "-" + persona.getNumeral())== null){
                graph.addNode(persona.getFullName()+ "-" + persona.getNumeral()).setAttribute("ui.label", persona.getFullName()+ "-" + persona.getNumeral());
                this.graph.getNode(persona.getFullName()+ "-" + persona.getNumeral()).setAttribute("ui.style", "fill-color: lightblue; shape: circle; size: 50px;");
                this.setSize(this.getSize()+1);
                int generacion = getGeneracion(persona);  
                int x = (this.getSize() % 10) * 80;  
                int y = generacion * 100;  
                graph.getNode(persona.getFullName()+ "-" + persona.getNumeral()).setAttribute("xy", x, y);
            }
            
        }
    }
    
    public void connectNodes(Persona hijo, Persona padre){
        if(hijo!= null && padre!= null){
            if (graph.getNode(padre.getFullName()+ "-" + padre.getNumeral()) == null) {
                this.addNode(padre);
            }
            if (graph.getNode(hijo.getFullName()+ "-" + hijo.getNumeral()) == null) {
                this.addNode(hijo);
            }
            String edgeId =  padre.getFullName()+ "-" + padre.getNumeral() + "-" + hijo.getFullName()+ "-" + hijo.getNumeral();
            if (graph.getEdge(edgeId) == null) {
                TreeNode padreArbol = this.getNombres().searchPersona(padre, false);
                padreArbol.getHijos().add(this.getNombres().searchPersona(hijo, false));
                padreArbol.getTinfo().setSons(hijo.getFullName()+ "-" + hijo.getNumeral());
                graph.addEdge(edgeId, padre.getFullName()+ "-" + padre.getNumeral(), hijo.getFullName()+ "-" + hijo.getNumeral(), true);  
                graph.getEdge(edgeId).setAttribute("ui.style", "fill-color: black;");  
            }
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
        /*
        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.CLOSE_VIEWER);
        viewer.getDefaultView().enableMouseOptions();
        */
        Clicks visualizador = new Clicks(graph);
    }
    
     private int getGeneracion(Persona persona) {
        
        int generacion = 0;
        /*
        Persona actual = persona;
        while (actual.getFather() != null) {
            generacion++;  
            actual = actual.getFather();  
        }
        */

        return generacion; 
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
    
    
}
