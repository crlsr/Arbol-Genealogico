/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSON;

import EDD.List;
import EDD.Node;
import EDD.Tree;
import EDD.TreeNode;
import Extras.Persona;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import Extras.Funciones;

/**
 *
 * @author carlosrodriguez
 */
public class LecturaJSON {
    
    Funciones funGetter = new Funciones();
    private JSONObject data;
    private String ineerFilePath;
    int counter = 0;
    int counter2 = 0;
    List<Persona> monarchy;
    public String title;
    
    /**
     * Este método fue creado con el fin de poder extraer los datos del JSON y almacenarlos dentro del objeto
     * @param endpoint Endpoint del JSON
     * 
     */
    public LecturaJSON(File endpoint) {
        this.ineerFilePath = endpoint.getAbsolutePath();
        try (FileReader reader = new FileReader(endpoint)) {
            this.data = new JSONObject(new JSONTokener(reader));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar abrir: " + e.getMessage());
        }
    }
    
    /**
     * Retorna el atributo data.
     * @return data 
     */
    public JSONObject getData() {
        return data;
    }
    
    /**
     * Modifica el atributo data.
     * @param data 
     */
    public void setData(JSONObject data) {
        this.data = data;
    }
    
    /**
     * Retorna el atributo ruta del JSON
     * @return innerFilePath 
     */
    public String getIneerFilePath() {
        return ineerFilePath;
    }
    
    /**
     * Modifica el atributo ruta del JSON, esto con el fin de por ejemplo cambiar de JSON
     * @param ineerFilePath 
     */
    public void setIneerFilePath(String ineerFilePath) {
        this.ineerFilePath = ineerFilePath;
    }
    
    /**
     * Genera el arbol en base a los datos obtenidos en el JSON.
     * Este llama a PersonBuilder para contruir a las personas y agregarlas a una lista. Lista que se usara despues para formatear el arbol.
     * Se retorna el arbol con el tamaño para los hashtables dados.
     * @return lineageTree Se retorna el arbol ya seteado con sus hashtables inicializadas.
     */
    public Tree dataConstructor() {
        monarchy = new List<>();
        this.title = this.getData().keys().next();
        JSONArray innerData = this.getData().getJSONArray(this.title);
        for (int i = 0; i < innerData.length(); i++) {
            JSONObject personJSON = innerData.getJSONObject(i);
            String personKey = personJSON.keys().next();
            JSONArray personData = personJSON.getJSONArray(personKey);
            Persona person = personBuilder(personData, personKey, this.counter);
            monarchy.add(person);
        }
        
        Tree lineageTree = new Tree(this.counter2 + 1, this.counter);
        return lineageTree;
    }
    
    /**
     * Función para insertar valores al arbol y formatearlo, llama a:
     * - treeConstructor() -> Para construir los datos en el arbol
     * - setLineage() -> Para concectar adecuadamente los nodos en el arbol
     * - setNullSons() -> Para concectar los hijos sin nombre
     * - calculateLevel() -> Asigna un nivel en el arbol a cada persona.
     * 
     * @param tree Retorna el arbol formateado.
     */
    public void eddInsert(Tree tree){
        treeConstructor(tree);
        setLineage(tree);
        setNullSons(tree);
        funGetter.calculateLevel(1, tree.getpRoot());
    }
    
    /**
     * Formatea los hijos sin nombre o sin formato de objeto del JSON en el arbol
     * 
     * @param lineageTree Se le pasa el arbol a modificas
     */
    public void setNullSons(Tree lineageTree) {
        String keyWord = this.getData().keys().next();
        JSONArray innerData = this.getData().getJSONArray(keyWord);
        for (int i = 0; i < innerData.length(); i++) {
            JSONObject personJSON = innerData.getJSONObject(i);
            String personKey = personJSON.keys().next();
            JSONArray personData = personJSON.getJSONArray(personKey);
            parseSons(personData, lineageTree, personKey);

        }
    }
    
    /**
     * Organiza a los objetos personas al momento de recorrer el JSON.
     * 
     * @param person Se le pasa el jsonArray total.
     * @param lineageTree Se le pasa el arbol a modificar
     * @param personKey Se le pasa el nombre de la persona para acceder a su jsonArray
     */
    public void parseSons(JSONArray person, Tree lineageTree, String personKey){
        JSONArray sonsOf;
        Persona father;
        TreeNode treeFather;
        Persona currentSon;
        String numeral = "";
        boolean state;
        
        for (int i = 0; i < person.length(); i++) {
            JSONObject data = person.getJSONObject(i);
            String selectedKey = data.keys().next();
            if(selectedKey.equals("Of his name")){
                numeral = data.getString(selectedKey);
            }
            if(selectedKey.equals("Father to")){
                sonsOf = data.getJSONArray(selectedKey);
                for (int j = 0; j < sonsOf.length(); j++) {
                    father = new Persona(personKey, numeral, "");
                    treeFather = lineageTree.searchPersonaTree(father);
                    currentSon = new Persona(sonsOf.getString(j), personKey + ", "+ numeral + " of his name");
                    state = this.funGetter.isInTree(treeFather, currentSon);

                    if (!state) {
                        lineageTree.getNombres().addPersona(currentSon, false);
                        lineageTree.setListFather(currentSon, treeFather.getTinfo());
                    }
                }
            }
        }
    }

    /**
     * Función en la que se recorre la lista de perosnas y se agrega al arbol 
     * @param lineageTree se le pasa el arbol a modificar

     */
    public void treeConstructor(Tree lineageTree) {
        Node<Persona> aux = this.monarchy.getpFirst();
        while (aux != null) {

            lineageTree.getNombres().addPersona(aux.getData(), false);
            if (aux.getData().getKwownAs() != null) {
                lineageTree.getMotes().addPersona(aux.getData(), true);
            }
            aux = aux.getpNext();
        }
    }

    public Persona personBuilder(JSONArray data, String name, int counter) {
        String lineagePosition = "";
        String father = "";
        String mote;
        String heldTitle;
        String eyeColor = "";
        String hairColor = "";
        String description;
        String fate;
        String wedTo;

        Persona result = new Persona(funGetter.deleteBlankSpaces(name), lineagePosition, eyeColor, hairColor, father);

        for (int i = 0; i < data.length(); i++) {
            JSONObject jsonData = data.getJSONObject(i);
            String key = jsonData.keys().next();
            switch (key) {
                case "Of his name":
                    lineagePosition = jsonData.getString(key);
                    result.setNumeral(lineagePosition);
                    break;
                case "Born to":
                    father = jsonData.getString(key);
                    if (result.getFather().equals("")) {
                        result.setFather(father);
                    } else {
                        result.setMother(father);
                    }
                    if (father.equals("[Unknown]")) {
                        result.setFather(null);
                    }

                    break;
                case "Known throughout as":
                    mote = jsonData.getString(key);
                    result.setKwownAs(mote);
                    this.counter = this.counter + 1;
                    break;
                case "Held title":
                    heldTitle = jsonData.getString(key);
                    result.setHeldTitle(heldTitle);
                    break;
                case "Of eyes":
                    eyeColor = jsonData.getString(key);
                    result.setEyesColor(eyeColor);
                    break;
                case "Of hair":
                    hairColor = jsonData.getString(key);
                    result.setHairColor(hairColor);
                    break;
                case "Notes":
                    description = jsonData.getString(key);
                    result.setNotes(description);
                    break;
                case "Fate":
                    fate = jsonData.getString(key);
                    result.setFate(fate);
                    break;
                case "Wed to":
                    wedTo = jsonData.getString(key);
                    result.setWedTo(wedTo);
                    break;
                case "Father to":
                    this.counter2 = this.counter2 + jsonData.getJSONArray(key).length();
            }
        }
        return result;
    }

    public void setLineage(Tree lineageTree) {
        Node<Persona> aux = this.monarchy.getpFirst();
        String[] innerData;
        TreeNode father;
        TreeNode son;
        Persona fatherPersona;

        while (aux != null) {
            if (aux.getData().getFather() == null) { 
                TreeNode node = lineageTree.searchPersonaTree(aux.getData());
                lineageTree.setpRoot(node);
            } else {
                if (aux.getData().getFather().contains(",")) {
                    innerData = aux.getData().getFather().split(", ");
                    String numeral = innerData[1].split(" ")[0].trim();
                    fatherPersona = new Persona(innerData[0], numeral, "");
                    father = lineageTree.searchPersonaTree(fatherPersona);
                    son = lineageTree.searchPersonaTree(aux.getData());
                    lineageTree.setListFather(son.getTinfo(), father.getTinfo());

                } else {
                    fatherPersona = new Persona("", "", aux.getData().getFather().trim());
                    father = lineageTree.searchPersonaTree(fatherPersona);
                    son = lineageTree.searchPersonaTree(aux.getData());
                    if(father==null){
                        Node<Persona> aux2= this.monarchy.getpFirst();
                        while(aux2!=null){
                            if(aux2.getData().getFullName().toLowerCase().equals(son.getTinfo().getFather().toLowerCase())){
                                son.getTinfo().setFather(aux2.getData().getFullName()+", "+ aux2.getData().getNumeral()+" of his name");
                                father = lineageTree.searchPersonaTree(new Persona(aux2.getData().getFullName(), aux2.getData().getNumeral(), ""));
                                break;
                            }
                            aux2= aux2.getpNext();
                        }
                    }
                    lineageTree.setListFather(son.getTinfo(), father.getTinfo());

                }
            }
            aux = aux.getpNext();
        }
    }


    public void changeJSON(File newEndpoint, Tree newTree) {
        String newPath = newEndpoint.getAbsolutePath();
        this.setIneerFilePath(newPath);
        try (FileReader reader = new FileReader(newEndpoint)) {
            JSONObject newData = new JSONObject(new JSONTokener(reader));
            this.setData(newData);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar abrir: " + e.getMessage());
        }
    }

}
