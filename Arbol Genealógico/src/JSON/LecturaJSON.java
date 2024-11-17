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

    public LecturaJSON(File endpoint) {
        this.ineerFilePath = endpoint.getAbsolutePath();
        try (FileReader reader = new FileReader(endpoint)) {
            this.data = new JSONObject(new JSONTokener(reader));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar abrir: " + e.getMessage());
        }
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    public String getIneerFilePath() {
        return ineerFilePath;
    }

    public void setIneerFilePath(String ineerFilePath) {
        this.ineerFilePath = ineerFilePath;
    }

    public Tree dataConstructor(Tree newTree) {
        monarchy = new List<>();
        String keyWord = this.getData().keys().next();
        JSONArray innerData = this.getData().getJSONArray(keyWord);
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
    
    public void eddInsert(Tree tree){
        treeConstructor(tree, monarchy);
        setLineage(monarchy, tree);
        setNullSons(tree);
        funGetter.calculateLevel(1, tree.getpRoot());
    }

    public void setNullSons(Tree lineageTree) {
        String keyWord = this.getData().keys().next();
        JSONArray innerData = this.getData().getJSONArray(keyWord);
        for (int i = 0; i < innerData.length(); i++) {
            JSONObject personJSON = innerData.getJSONObject(i);
            String personKey = personJSON.keys().next();
            JSONArray personData = personJSON.getJSONArray(personKey);
            parseSons(personData, lineageTree, personKey);
            
            
            /*
            try {
                JSONArray sonsOf = personJSON.getJSONArray("Father to");
                for (int j = 0; j < sonsOf.length(); j++) {
                    father = new Persona(personKey, null, null);
                    treeFather = lineageTree.searchPersonaTree(father);
                    currentSon = new Persona(sonsOf.getString(j), personKey);
                    state = this.funGetter.isInTree(treeFather, currentSon);

                    if (!state) {
                        lineageTree.getNombres().addPersona(currentSon, false);
                        lineageTree.addNode(currentSon);
                        lineageTree.connectNodes(currentSon, treeFather.getTinfo());
                        treeFather.getHijos().add(lineageTree.searchPersonaTree(currentSon));
                    }
                }
            } catch (Exception e) {
            }
*/
        }
    }
    
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

    public void treeConstructor(Tree lineageTree, List<Persona> monarchy) {
        Node<Persona> aux = monarchy.getpFirst();
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

    public void setLineage(List<Persona> data, Tree lineageTree) {
        Node<Persona> aux = data.getpFirst();
        String[] innerData;
        TreeNode father;
        TreeNode son;
        Persona fatherPersona;

        while (aux != null) {
            if (aux.getData().getFather() == null) { //fix
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
                    lineageTree.setListFather(son.getTinfo(), father.getTinfo());

                }
            }
            aux = aux.getpNext();
        }
    }

    /*
    public void updateData(){
        try(FileWriter overwrite = new FileWriter(this.getIneerFilePath())){
            overwrite.write(this.getData().toString(4));
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al intentar sobre escribir: " + e.getMessage());
        }
    }
     */
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
