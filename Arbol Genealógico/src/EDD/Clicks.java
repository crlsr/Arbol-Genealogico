/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import Extras.Persona;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.ui.view.ViewerPipe;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerListener;
/**
 * Clase Clicks
 * Implementa un listener para los eventos de la visualización del gráfico.
 * 
 * @author Pedro Sebastiano
 */
public class Clicks implements ViewerListener {
    
    /**
     * @param loop Controla el ciclo de eventos del viewer.
     * @param arbol Árbol genealógico asociado.
     */
    protected boolean loop = true;
    private Tree arbol;

    /**
     * Constructor de la clase Clicks.
     * Configura el gráfico y el viewer para manejar eventos.
     * 
     * @param grafo Gráfico que será visualizado.
     * @param arbol Árbol genealógico asociado.
     * @author Pedro Sebastiano
     */
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
                fromViewer.pump(); 
                try {
                    Thread.sleep(50);  
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();  
                    break;
                }
            }
        }).start();
    }

    /**
     * Método llamado cuando la vista se cierra.
     * 
     * @param id Identificador de la vista cerrada.
     * @author Pedro Sebastiano
     */
    @Override
    public void viewClosed(String id) {
        loop = false;
    }

    /**
     * Método llamado cuando se presiona un botón en la visualización.
     * 
     * @param id Identificador del nodo donde se presionó el botón.
     * @author Pedro Sebastiano
     */
    @Override
    public void buttonPushed(String id) {
        String[] idString = id.split("/");
        Persona aux = new Persona(idString[0], idString[2]);
        aux.setNumeral(idString[1]);
        TreeNode personaBuscada = arbol.getNombres().searchPersona(aux, false);
        JOptionPane.showMessageDialog(null, personaBuscada.getTinfo().generarDescripcion());
    }

    /**
     * Método llamado cuando se libera un botón en la visualización. No utilizado
     * 
     * @param id Identificador del nodo donde se liberó el botón.
     * @author Pedro Sebastiano
     */
    @Override
    public void buttonReleased(String id) {
    }

    /**
     * Método llamado cuando el ratón pasa sobre un nodo en la visualización.No utilizado
     * 
     * @param id Identificador del nodo.
     * @author Pedro Sebastiano
     */
    @Override
    public void mouseOver(String id) {
    }

    /**
     * Método llamado cuando el ratón deja de estar sobre un nodo en la visualización.No utilizado
     * 
     * @param id Identificador del nodo.
     * @author Pedro Sebastiano
     */
    @Override
    public void mouseLeft(String id) {
    }
}
