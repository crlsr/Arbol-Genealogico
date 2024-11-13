/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import Extras.Persona;
import org.graphstream.graph.Graph;
import org.graphstream.ui.view.ViewerPipe;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerListener;
/**
 *
 * @author pseba
 */
public class Clicks implements ViewerListener {
    protected boolean loop = true;
    private Tree arbol;

    public Clicks(Graph grafo, Tree arbol) {
        this.arbol = arbol;
        Graph graph = grafo;
        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
        viewer.getDefaultView().enableMouseOptions();
        ViewerPipe fromViewer = viewer.newViewerPipe();
        fromViewer.addViewerListener(this); 
        fromViewer.addSink(graph);
        new Thread(() -> {
            while (loop) {
                fromViewer.pump();  // Procesa los eventos que ocurren en el viewer
                try {
                    Thread.sleep(50);  // Evita el uso excesivo de CPU
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();  // Restaura la interrupción
                    break;
                }
            }
        }).start();
            
    }
    
    @Override
    public void viewClosed(String id) {
        loop = false;
    }

    @Override
    public void buttonPushed(String id) {
        String[] idString = id.split("-");
        Persona aux = new Persona(idString[0], idString[2]);
        aux.setNumeral(idString[1]);
        TreeNode personaBuscada = arbol.getNombres().searchPersona(aux,false);
        System.out.println(personaBuscada.getTinfo().generarDescripcion());
    }

    @Override
    public void buttonReleased(String id) {
        System.out.println("Button released on node " + id);
    }

    @Override
    public void mouseOver(String id) {
        String[] idString = id.split("-");
        Persona aux = new Persona(idString[0], idString[2]);
        aux.setNumeral(idString[1]);
        TreeNode personaBuscada = arbol.getNombres().searchPersona(aux,false);
        System.out.println(personaBuscada.getTinfo().generarDescripcion());
    }

    @Override
    public void mouseLeft(String id) {
        System.out.println("Mouse left node " + id);
    }
}

