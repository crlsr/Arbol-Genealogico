/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VENTANAS;

import EDD.List;
import EDD.Node;
import EDD.Tree;
import EDD.TreeNode;
import Extras.Funciones;
import Extras.Persona;
import JSON.LecturaJSON;
import static VENTANAS.MENU.jsoncargado;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import org.graphstream.graph.implementations.MultiGraph;

/**
 *
 * @author marco
 */
public class CONTROL_REGISTROS extends javax.swing.JFrame {
    static LecturaJSON json;
    static Tree newTree;
    static Funciones func = new Funciones();

    /**
     * Creates new form AÑADIR_MIEMBRO
     */

    public CONTROL_REGISTROS(Tree newTree, LecturaJSON json) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.newTree = newTree;
        this.json = json;
        llenarDesplegable();
        TipoDejson();
    }
    
    /**
     * Limpia y reinicializa las listas desplegables.
     * Este método se utiliza para limpiar las listas desplegables 
     * "DESCENDIENTES_TITULONB" y "NOMBRE_APODO" y agregarles la opción por defecto
     * "Selecciona un familiar". Se suele llamar antes de llenar estas listas 
     * con nuevos datos, por ejemplo, después de una búsqueda.
     * @author Marco Betancourt
     */
    private void llenarDesplegable() {
        DESCENDIENTES_TITULONB.removeAllItems();
        DESCENDIENTES_TITULONB.addItem("Selecciona un familiar");
        NOMBRE_APODO.removeAllItems();
        NOMBRE_APODO.addItem("Selecciona un familiar"); 
    }
    
    
    /**
     * Muestra el título del JSON cargado.
     * Este método verifica si se ha cargado un archivo JSON previamente. Si es así, 
     * obtiene el valor del atributo "title" del objeto JSON y lo muestra en mayúsculas 
     * en el componente `JSON_CARGADO`. Si no se ha cargado ningún JSON, muestra un mensaje de error.
     * @author Marco Betancourt
     */
    private void TipoDejson() {
        if (jsoncargado){
            JSON_CARGADO.setText(json.title.toUpperCase());
        }
        else{
            JOptionPane.showMessageDialog(this, "Asegurate de cargar un archivo json primero");
        }    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TITULO = new javax.swing.JLabel();
        REGRESAR = new javax.swing.JButton();
        INSTRUCCIONES = new javax.swing.JButton();
        INPUT_NAME = new javax.swing.JTextField();
        LABELNOMBRE_APODO = new javax.swing.JLabel();
        CERRAR = new javax.swing.JButton();
        BUSCAR_NOMBRE_APODO = new javax.swing.JButton();
        VER_ARBOL = new javax.swing.JButton();
        ICONO = new javax.swing.JLabel();
        DESCENDIENTES_TITULONB = new javax.swing.JComboBox<>();
        LABELTITULONB = new javax.swing.JLabel();
        INPUT_TITULONB = new javax.swing.JTextField();
        LABELGENERACION = new javax.swing.JLabel();
        INPUT_GENERACION = new javax.swing.JTextField();
        LABELANCESTROS = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        INFO = new javax.swing.JTextArea();
        BUSCAR_TITULO = new javax.swing.JButton();
        BUSCAR_GENERACIÓN = new javax.swing.JButton();
        INPUT_ANCESTROS = new javax.swing.JTextField();
        ANCESTROS = new javax.swing.JButton();
        NOMBRE_APODO = new javax.swing.JComboBox<>();
        JSON_CARGADO = new javax.swing.JLabel();
        LABEL_DESPLEGABLE_TITULONB_DESCENDIENTES = new javax.swing.JLabel();
        LABEL_DESPLEGABLE_NOMBRE_APODO = new javax.swing.JLabel();
        FONDO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONTROL DE REGISTROS");
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TITULO.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TITULO.setForeground(new java.awt.Color(255, 255, 255));
        TITULO.setText("CONTROL DE REGISTROS");
        getContentPane().add(TITULO, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        REGRESAR.setBackground(new java.awt.Color(0, 0, 0));
        REGRESAR.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        REGRESAR.setForeground(new java.awt.Color(255, 255, 255));
        REGRESAR.setText("REGRESAR");
        REGRESAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REGRESARActionPerformed(evt);
            }
        });
        getContentPane().add(REGRESAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, -1, -1));

        INSTRUCCIONES.setBackground(new java.awt.Color(0, 0, 0));
        INSTRUCCIONES.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        INSTRUCCIONES.setForeground(new java.awt.Color(255, 255, 255));
        INSTRUCCIONES.setText("INSTRUCCIONES");
        INSTRUCCIONES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INSTRUCCIONESActionPerformed(evt);
            }
        });
        getContentPane().add(INSTRUCCIONES, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 510, -1, -1));

        INPUT_NAME.setBackground(new java.awt.Color(0, 0, 0));
        INPUT_NAME.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        INPUT_NAME.setForeground(new java.awt.Color(255, 255, 255));
        INPUT_NAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INPUT_NAMEActionPerformed(evt);
            }
        });
        getContentPane().add(INPUT_NAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 350, -1));

        LABELNOMBRE_APODO.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LABELNOMBRE_APODO.setForeground(new java.awt.Color(255, 255, 255));
        LABELNOMBRE_APODO.setText("INGRESA EL NOMBRE O APODO DEL FAMILIAR:");
        getContentPane().add(LABELNOMBRE_APODO, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 340, -1));

        CERRAR.setBackground(new java.awt.Color(255, 0, 0));
        CERRAR.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CERRAR.setForeground(new java.awt.Color(255, 255, 255));
        CERRAR.setText("X");
        CERRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CERRARActionPerformed(evt);
            }
        });
        getContentPane().add(CERRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, -1, -1));

        BUSCAR_NOMBRE_APODO.setBackground(new java.awt.Color(0, 0, 0));
        BUSCAR_NOMBRE_APODO.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BUSCAR_NOMBRE_APODO.setForeground(new java.awt.Color(255, 255, 255));
        BUSCAR_NOMBRE_APODO.setText("BUSCAR POR NOMBRE/APODO");
        BUSCAR_NOMBRE_APODO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUSCAR_NOMBRE_APODOActionPerformed(evt);
            }
        });
        getContentPane().add(BUSCAR_NOMBRE_APODO, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 110, 250, -1));

        VER_ARBOL.setBackground(new java.awt.Color(0, 0, 0));
        VER_ARBOL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        VER_ARBOL.setForeground(new java.awt.Color(255, 255, 255));
        VER_ARBOL.setText("VER ARBOL GENEALÓGICO");
        VER_ARBOL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VER_ARBOLActionPerformed(evt);
            }
        });
        getContentPane().add(VER_ARBOL, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        ICONO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/PERSONA.png"))); // NOI18N
        getContentPane().add(ICONO, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 440, -1, 110));

        DESCENDIENTES_TITULONB.setBackground(new java.awt.Color(0, 0, 0));
        DESCENDIENTES_TITULONB.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        DESCENDIENTES_TITULONB.setForeground(new java.awt.Color(255, 255, 255));
        DESCENDIENTES_TITULONB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OPCIÓN 1", "OPCIÓN 2", "OPCIÓN 3", "OPCIÓN 4" }));
        DESCENDIENTES_TITULONB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DESCENDIENTES_TITULONBActionPerformed(evt);
            }
        });
        getContentPane().add(DESCENDIENTES_TITULONB, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 290, -1));

        LABELTITULONB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LABELTITULONB.setForeground(new java.awt.Color(255, 255, 255));
        LABELTITULONB.setText("INGRESA EL TITULO NOBILIARIO:");
        getContentPane().add(LABELTITULONB, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        INPUT_TITULONB.setBackground(new java.awt.Color(0, 0, 0));
        INPUT_TITULONB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        INPUT_TITULONB.setForeground(new java.awt.Color(255, 255, 255));
        INPUT_TITULONB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INPUT_TITULONBActionPerformed(evt);
            }
        });
        getContentPane().add(INPUT_TITULONB, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 350, -1));

        LABELGENERACION.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LABELGENERACION.setForeground(new java.awt.Color(255, 255, 255));
        LABELGENERACION.setText("INGRESA LA GENERACIÓN:");
        getContentPane().add(LABELGENERACION, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        INPUT_GENERACION.setBackground(new java.awt.Color(0, 0, 0));
        INPUT_GENERACION.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        INPUT_GENERACION.setForeground(new java.awt.Color(255, 255, 255));
        INPUT_GENERACION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INPUT_GENERACIONActionPerformed(evt);
            }
        });
        getContentPane().add(INPUT_GENERACION, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 350, -1));

        LABELANCESTROS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LABELANCESTROS.setForeground(new java.awt.Color(255, 255, 255));
        LABELANCESTROS.setText("ANCESTROS:");
        getContentPane().add(LABELANCESTROS, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        INFO.setEditable(false);
        INFO.setBackground(new java.awt.Color(0, 0, 0));
        INFO.setColumns(20);
        INFO.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        INFO.setForeground(new java.awt.Color(255, 255, 255));
        INFO.setRows(5);
        INFO.setFocusable(false);
        jScrollPane1.setViewportView(INFO);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 350, -1));

        BUSCAR_TITULO.setBackground(new java.awt.Color(0, 0, 0));
        BUSCAR_TITULO.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BUSCAR_TITULO.setForeground(new java.awt.Color(255, 255, 255));
        BUSCAR_TITULO.setText("BUSCAR POR TITULO NOBILIARIO");
        BUSCAR_TITULO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUSCAR_TITULOActionPerformed(evt);
            }
        });
        getContentPane().add(BUSCAR_TITULO, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, -1, -1));

        BUSCAR_GENERACIÓN.setBackground(new java.awt.Color(0, 0, 0));
        BUSCAR_GENERACIÓN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BUSCAR_GENERACIÓN.setForeground(new java.awt.Color(255, 255, 255));
        BUSCAR_GENERACIÓN.setText("BUSCAR POR GENERACIÓN");
        BUSCAR_GENERACIÓN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUSCAR_GENERACIÓNActionPerformed(evt);
            }
        });
        getContentPane().add(BUSCAR_GENERACIÓN, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, -1, -1));

        INPUT_ANCESTROS.setBackground(new java.awt.Color(0, 0, 0));
        INPUT_ANCESTROS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        INPUT_ANCESTROS.setForeground(new java.awt.Color(255, 255, 255));
        INPUT_ANCESTROS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INPUT_ANCESTROSActionPerformed(evt);
            }
        });
        getContentPane().add(INPUT_ANCESTROS, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 350, -1));

        ANCESTROS.setBackground(new java.awt.Color(0, 0, 0));
        ANCESTROS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ANCESTROS.setForeground(new java.awt.Color(255, 255, 255));
        ANCESTROS.setText("BUSCAR ANCESTROS");
        ANCESTROS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ANCESTROSActionPerformed(evt);
            }
        });
        getContentPane().add(ANCESTROS, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, -1, 30));

        NOMBRE_APODO.setBackground(new java.awt.Color(0, 0, 0));
        NOMBRE_APODO.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        NOMBRE_APODO.setForeground(new java.awt.Color(255, 255, 255));
        NOMBRE_APODO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OPCIÓN 1", "OPCIÓN 2", "OPCIÓN 3", "OPCIÓN 4" }));
        NOMBRE_APODO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NOMBRE_APODOActionPerformed(evt);
            }
        });
        getContentPane().add(NOMBRE_APODO, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 290, -1));

        JSON_CARGADO.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JSON_CARGADO.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(JSON_CARGADO, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 150, -1));

        LABEL_DESPLEGABLE_TITULONB_DESCENDIENTES.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LABEL_DESPLEGABLE_TITULONB_DESCENDIENTES.setForeground(new java.awt.Color(255, 255, 255));
        LABEL_DESPLEGABLE_TITULONB_DESCENDIENTES.setText("GENERACIÓN / TITULO NOBILIARIO:");
        getContentPane().add(LABEL_DESPLEGABLE_TITULONB_DESCENDIENTES, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, -1, 20));

        LABEL_DESPLEGABLE_NOMBRE_APODO.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LABEL_DESPLEGABLE_NOMBRE_APODO.setForeground(new java.awt.Color(255, 255, 255));
        LABEL_DESPLEGABLE_NOMBRE_APODO.setText("DESCENDENCIA:");
        getContentPane().add(LABEL_DESPLEGABLE_NOMBRE_APODO, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, -1, -1));

        FONDO.setBackground(new java.awt.Color(0, 0, 0));
        FONDO.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        FONDO.setForeground(new java.awt.Color(255, 255, 255));
        FONDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/FONDO.png"))); // NOI18N
        getContentPane().add(FONDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * @param evt 
     * Termina con la ejecución al oprimir el botón.
     * Cierra la interfaz.
     * @author Marco Betancourt
     */
    private void CERRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CERRARActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CERRARActionPerformed

    /**
     * @return icono 
     * Se carga una imagen desde el package de imagenes, usando la libreria toolkit 
     * se obtiene una una representacion de dicha imagen.
     * retorna una variable de tipo imagen igualada a la instacia antes mencionada.
     * @author Marco Betancourt
     */
    public Image getIconImage() {
        Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/ICONO_TRONO.png"));
        return icono;
    }
    
    /**
     * @param evt 
     * Abre la ventana "MENU" y cierra esta ventana.
     * @author Marco Betancourt
     */
    private void REGRESARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REGRESARActionPerformed
        MENU M = new MENU(newTree, json);
        M.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_REGRESARActionPerformed

    
    /**
     * @param evt
     * Busca una persona por su nombre o apodo.
     * Busca en el json a todas las personas cuyo nombre o apodo coincida
     * con el texto ingresado por el usuario. Los resultados de la búsqueda se muestran
     * en una lista desplegable.
     * @author Marco Betancourt 
     */
    private void BUSCAR_NOMBRE_APODOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUSCAR_NOMBRE_APODOActionPerformed
        try {
            INFO.setText("");
            DESCENDIENTES_TITULONB.removeAllItems();
            NOMBRE_APODO.removeAllItems();
            DESCENDIENTES_TITULONB.addItem("Selecciona un familiar");
            NOMBRE_APODO.addItem("Selecciona un familiar");
            String nombrePersona = INPUT_NAME.getText();
            if (!nombrePersona.isBlank()) {
                List<Persona> nombresymotes= func.searchByNameandMote(newTree, nombrePersona);
                if (nombresymotes.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No hay personas con este Nombre/Apodo 👤❌️");
                } else {
                    Node<Persona> aux = nombresymotes.getpFirst();
                    int num = 0;
                    String persona = "Nombre/Apodo: " + INPUT_NAME.getText() + "\n";
                    while (aux != null) {
                        num += 1;
                        if (aux.getData().getNumeral().equals("") || aux.getData().getNumeral() == null) {
                            persona += num + ". " + aux.getData().getFullName() + "\n";
                            NOMBRE_APODO.addItem(aux.getData().getFullName());
                        } else {
                            persona += num + ". " + aux.getData().getFullName() + ", " + aux.getData().getNumeral() + " of his name" + "\n";
                            NOMBRE_APODO.addItem(aux.getData().getFullName() + ", " + aux.getData().getNumeral() + " of his name");
                        }
                        aux = aux.getpNext();
                    }
                    INFO.setText("Seleccione una persona en el desplegable de " + "\n" + "(DESCENDENCIA) para ver " + "\n" + "la descendencia de esa persona." + "\n" +persona);
                }
            } 
            else {
                JOptionPane.showMessageDialog(this, "Debe ingresar el nombre de la persona que desea buscar 👤️");
            }
            INPUT_NAME.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado!!!");
        }
    }//GEN-LAST:event_BUSCAR_NOMBRE_APODOActionPerformed

    
    /**
     * @param evt
     * Crea un JOptionPane el cual devuelve un mensaje con las instrucciones que se encuentran en esa ventana.
     * @author Marco Betancourt
     */
    private void INSTRUCCIONESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INSTRUCCIONESActionPerformed
        JOptionPane.showMessageDialog(this, 
                        "Para buscar por NOMBRE O APODO:  "+ "Escriba en el text field "
                        + "Nombre O Apodo una cadena de texto\n" +
                        "Haga clic en el boton BUSCAR POR NOMBRE/APODO\n" +
                        "Seleccione en el desplegable de DESCENDENCIA alguna de las personas para ver su descendencia\n️"+"\n️"+
                        
                        "Para buscar por el TITULO NOBILIARIO:  "+ "Escriba en el text field "
                        + "TITULO NOBILIARIO un Título Nobiliario\n" +
                        "Haga clic en el boton BUSCAR POR TITULO NOBILIARIO\n" +
                        "Seleccione en el desplegable de GENERACIÓN / TITULO NOBILIARIO alguna de las personas para ver su registro\n️"+"\n️"+
                        
                        "Para buscar por LA GENERACIÓN:  "+ "Escriba en el text field "
                        + "GENERACIÓN un numero de generación\n" +
                        "Haga clic en el boton BUSCAR POR GENERACIÓN\n" +
                        "Seleccione en el desplegable de GENERACIÓN / TITULO NOBILIARIO alguna de las personas para ver su registro\n️"+"\n️"+
        
                        "Para buscar por ANCESTROS:  "+ "Escriba en el text field "
                        + "ANCESTROS el nombre de una persona (Nombre Apellido, Numeral (en caso de tenerlo))\n" +
                        "Haga clic en el boton BUSCAR ANCESTROS\n"+
        
                        "Para ver el arbol genealogico de la casa seleccionada:\n"
                        + "Haga clic en el boton VER ARBOL GENEALOGICO\n" +
                        "Nota: El nodo de color rojo, sera el nodo raiz de este arbol\n");
    }//GEN-LAST:event_INSTRUCCIONESActionPerformed

    
    /**
     * @param evt 
     * Visualiza el árbol genealógico.
     * Este método se ejecuta cuando el usuario hace clic en el botón "VER_ARBOL".
     * Limpia las listas desplegables y crea una representación gráfica del árbol genealógico.
     * A continuación, muestra el árbol en una ventana o panel, permitiendo al usuario
     * explorar la estructura familiar.
     * @author Marco Betancourt
     */
    private void VER_ARBOLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VER_ARBOLActionPerformed
        try {
            newTree.setGraph(new MultiGraph("Árbol Genealógico"));
            newTree.mostrarArbol(newTree);
            func.appendGraph(newTree, newTree.getpRoot(), null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado!!!");
        }
    }//GEN-LAST:event_VER_ARBOLActionPerformed

    
    /**
     * @param evt 
     * Este método se ejecuta cuando se selecciona un nombre de la lista desplegable 
     * "DESCENDIENTES_TITULONB". Busca a la persona seleccionada en el árbol genealógico
     * y muestra información como su nombre completo, apodo y otros detalles relevantes.
     * Si el nombre seleccionado incluye un numeral
     * se considera este numeral al realizar la búsqueda.
     * @author Marco Betancourt
     */
    private void DESCENDIENTES_TITULONBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DESCENDIENTES_TITULONBActionPerformed
        String seleccionado = (String) DESCENDIENTES_TITULONB.getSelectedItem();
        if (!"Selecciona un familiar".equals(seleccionado) && seleccionado != null) {
            if (seleccionado.contains(",")) {
                String[] Selected = seleccionado.split(", ");
                String[] Numeral = Selected[1].split(" ");
                Persona aux = new Persona(Selected[0], Numeral[0], "");
                TreeNode personaBuscada = newTree.getNombres().searchPersona(aux, false);
                JOptionPane.showMessageDialog(null, personaBuscada.getTinfo().generarDescripcion());
            }else{
                Persona aux = new Persona(seleccionado, "", "");
                TreeNode personaBuscada = newTree.getNombres().searchPersona(aux, false);
                JOptionPane.showMessageDialog(null, personaBuscada.getTinfo().generarDescripcion());
            }
        }
    }//GEN-LAST:event_DESCENDIENTES_TITULONBActionPerformed

    
    private void INPUT_TITULONBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INPUT_TITULONBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_INPUT_TITULONBActionPerformed

    /**
     * @param evt 
     * Busca en el árbol genealógico 
     * a todas las personas que poseen el título nobiliario ingresado en el campo 
     * "INPUT_TITULONB". Los resultados se muestran en una lista desplegable.
     * @author Marco Betancourt
     */
    private void BUSCAR_TITULOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUSCAR_TITULOActionPerformed
        try {
            INFO.setText("");
            DESCENDIENTES_TITULONB.removeAllItems();
            NOMBRE_APODO.removeAllItems();
            DESCENDIENTES_TITULONB.addItem("Selecciona un familiar");
            NOMBRE_APODO.addItem("Selecciona un familiar");
            String titulinb = INPUT_TITULONB.getText();
            if (!titulinb.isBlank()) {
                List<Persona> listPersonas = func.constructListHeldTitle(newTree, titulinb.trim());
                if (listPersonas.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No hay personas con este titulo nobiliario 👤❌️");
                } else {
                    Node<Persona> aux = listPersonas.getpFirst();
                    int num = 0;
                    String persona = "Titulo Nobiliario: " + INPUT_TITULONB.getText() + "\n";
                    while (aux != null) {
                        num += 1;
                        persona += num + ". " + aux.getData().getFullName() + ", " + aux.getData().getNumeral() + " of his name" + "\n";
                        DESCENDIENTES_TITULONB.addItem(aux.getData().getFullName() + ", " + aux.getData().getNumeral() + " of his name");
                        aux = aux.getpNext();
                    }
                    INFO.setText("Seleccione una persona en el desplegable de" +"\n"+ "(GENERACIÓN / TITULO NOBILIARIO)" + "\n" + "para ver su registro." + "\n" +persona);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe ingresar el titulo nobilario de la persona que desea buscar 👤️");
            }
            INPUT_TITULONB.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado!!!");
        }
    }//GEN-LAST:event_BUSCAR_TITULOActionPerformed

    
    private void INPUT_ANCESTROSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INPUT_ANCESTROSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_INPUT_ANCESTROSActionPerformed

    /**
     * @param evt 
     * Busca un ancestro y muestra sus descendientes.
     * Este método se ejecuta cuando el usuario busca un ancestro específico.
     * Busca al ancestro ingresado en el árbol genealógico y muestra una lista de sus descendientes.
     * Si el ancestro no se encuentra, se muestra un mensaje de error.
     * @author Marco Betancourt
     */
    private void ANCESTROSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ANCESTROSActionPerformed
        try {
            INFO.setText("");
            DESCENDIENTES_TITULONB.removeAllItems();
            NOMBRE_APODO.removeAllItems();
            DESCENDIENTES_TITULONB.addItem("Selecciona un familiar");
            NOMBRE_APODO.addItem("Selecciona un familiar");
            String nombre = INPUT_ANCESTROS.getText();
            Persona fatherPersona;
            if (nombre.contains(",")) {
                String[] partesNombre = nombre.split(",");
                String numeral = partesNombre[1].trim().split(" ")[0];
                fatherPersona = new Persona(partesNombre[0].trim(), numeral.trim(), "");
            } else {
                fatherPersona = new Persona(nombre.trim(), "", "");
            }
            TreeNode persona = newTree.searchPersonaTree(fatherPersona);
            if (persona != null) {
                INFO.setText(func.constructAncestors(persona.getTinfo(), newTree));
            } else {
                JOptionPane.showMessageDialog(this,"El ancestro "+ nombre + " no ha sido encontrado");
            }
            INPUT_ANCESTROS.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado!!!");
        }
    }//GEN-LAST:event_ANCESTROSActionPerformed

    
    private void INPUT_GENERACIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INPUT_GENERACIONActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_INPUT_GENERACIONActionPerformed

    /**
     * @param evt 
     * Busca personas por generación.
     * Este método se ejecuta cuando el usuario busca a todas las personas 
     * que pertenecen a una generación específica.
     * Busca en el árbol genealógico a todas las personas de la generación ingresada 
     * y muestra sus nombres en una lista desplegable.
     * @author Marco Betancourt
     */
    private void BUSCAR_GENERACIÓNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUSCAR_GENERACIÓNActionPerformed
        try {
            INFO.setText("");
            DESCENDIENTES_TITULONB.removeAllItems();
            NOMBRE_APODO.removeAllItems();
            DESCENDIENTES_TITULONB.addItem("Selecciona un familiar");
            NOMBRE_APODO.addItem("Selecciona un familiar");
            String generacion = INPUT_GENERACION.getText();
            INPUT_GENERACION.setText("");
            int gen = Integer.parseInt(generacion);
            if (!generacion.isBlank()) {
                List<Persona> Generacion = func.constructListGeneration(newTree, gen);
                if (Generacion.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No hay personas en esta generación 👤❌️");
                } else {
                    Node<Persona> aux = Generacion.getpFirst();
                    int num = 0;
                    String persona = "Generación: " + generacion + "\n";
                    while (aux != null) {
                        num += 1;
                        if (aux.getData().getNumeral().equals("") || aux.getData().getNumeral() == null) {
                            persona += num + ". " + aux.getData().getFullName() + "\n";
                            DESCENDIENTES_TITULONB.addItem(aux.getData().getFullName());

                        } else {
                            persona += num + ". " + aux.getData().getFullName() + ", " + aux.getData().getNumeral() + " of his name" + "\n";
                            DESCENDIENTES_TITULONB.addItem(aux.getData().getFullName() + ", " + aux.getData().getNumeral() + " of his name");
                        }
                        aux = aux.getpNext();
                    }
                    INFO.setText("Seleccione una persona en el desplegable de" +"\n"+ "(GENERACIÓN / TITULO NOBILIARIO)" + "\n" + "para ver su registro." + "\n" +persona);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Asegúrese de ingresar un valor numérico 👤️");
            }
            INPUT_GENERACION.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado!!! Asegúrese de ingresar un valor numérico");
        }
    }//GEN-LAST:event_BUSCAR_GENERACIÓNActionPerformed

    /**
     * @param evt 
     * Muestra la descendencia de una persona seleccionada.
     * Este método se ejecuta cuando el usuario selecciona un nombre de la lista desplegable 
     * "NOMBRE_APODO". Busca a la persona seleccionada en el árbol genealógico y, 
     * si se encuentra, muestra la lista de sus descendientes.
     * @author Marco Betancourt
     */
    private void NOMBRE_APODOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NOMBRE_APODOActionPerformed
        String seleccionado = (String) NOMBRE_APODO.getSelectedItem();
        if (!"Selecciona un familiar".equals(seleccionado) && seleccionado != null) {
            TreeNode personaBuscada;
            if (seleccionado.contains(",")) {
                String[] Selected = seleccionado.split(", ");
                String[] Numeral = Selected[1].split(" ");
                Persona aux = new Persona(Selected[0], Numeral[0], "");
                personaBuscada = newTree.getNombres().searchPersona(aux, false);
            }else{
                Persona aux = new Persona(seleccionado, "", "");
                personaBuscada = newTree.getNombres().searchPersona(aux, false);
            }
        func.mostrarDescendencia(personaBuscada,newTree);
        }
    }//GEN-LAST:event_NOMBRE_APODOActionPerformed

    
    private void INPUT_NAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INPUT_NAMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_INPUT_NAMEActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CONTROL_REGISTROS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CONTROL_REGISTROS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CONTROL_REGISTROS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CONTROL_REGISTROS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CONTROL_REGISTROS(newTree, json).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ANCESTROS;
    private javax.swing.JButton BUSCAR_GENERACIÓN;
    private javax.swing.JButton BUSCAR_NOMBRE_APODO;
    private javax.swing.JButton BUSCAR_TITULO;
    private javax.swing.JButton CERRAR;
    private javax.swing.JComboBox<String> DESCENDIENTES_TITULONB;
    private javax.swing.JLabel FONDO;
    private javax.swing.JLabel ICONO;
    private javax.swing.JTextArea INFO;
    private javax.swing.JTextField INPUT_ANCESTROS;
    private javax.swing.JTextField INPUT_GENERACION;
    private javax.swing.JTextField INPUT_NAME;
    private javax.swing.JTextField INPUT_TITULONB;
    private javax.swing.JButton INSTRUCCIONES;
    private javax.swing.JLabel JSON_CARGADO;
    private javax.swing.JLabel LABELANCESTROS;
    private javax.swing.JLabel LABELGENERACION;
    private javax.swing.JLabel LABELNOMBRE_APODO;
    private javax.swing.JLabel LABELTITULONB;
    private javax.swing.JLabel LABEL_DESPLEGABLE_NOMBRE_APODO;
    private javax.swing.JLabel LABEL_DESPLEGABLE_TITULONB_DESCENDIENTES;
    private javax.swing.JComboBox<String> NOMBRE_APODO;
    private javax.swing.JButton REGRESAR;
    private javax.swing.JLabel TITULO;
    private javax.swing.JButton VER_ARBOL;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
