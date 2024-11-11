/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
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

    public Clicks(Graph grafo) {
        Graph graph = grafo;
        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.CLOSE_VIEWER);
        viewer.getDefaultView().enableMouseOptions();
        ViewerPipe fromViewer = viewer.newViewerPipe();
        fromViewer.addViewerListener(this); 
        fromViewer.addSink(graph);

            while (loop) {
                fromViewer.pump();
            }

    }

    @Override
    public void viewClosed(String id) {
        loop = false;
    }

    @Override
    public void buttonPushed(String id) {
        System.out.println("Button pushed on node " + id);
    }

    @Override
    public void buttonReleased(String id) {
        System.out.println("Button released on node " + id);
    }

    @Override
    public void mouseOver(String id) {
        System.out.println("Mouse over node " + id);
    }

    @Override
    public void mouseLeft(String id) {
        System.out.println("Mouse left node " + id);
    }
}

