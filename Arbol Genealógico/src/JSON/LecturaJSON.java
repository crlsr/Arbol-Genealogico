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

/**
 *
 * @author carlosrodriguez
 */
public class LecturaJSON {

    private JSONObject data;
    private String ineerFilePath;

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

    public Tree dataConstructor() {
        List<Persona> monarchy = new List<>();
        String keyWord = this.getData().keys().next();
        JSONArray innerData = this.getData().getJSONArray(keyWord);
        int counterMotes = 0;
        for (int i = 0; i < innerData.length(); i++) {
            JSONObject personJSON = innerData.getJSONObject(i);
            String personKey = personJSON.keys().next();
            JSONArray personData = personJSON.getJSONArray(personKey);
            Persona person = personBuilder(personData, personKey, counterMotes);
            monarchy.add(person);
        }

        Tree lineageTree = new Tree(monarchy.getSize() - 1, counterMotes);
        treeConstructor(lineageTree, monarchy);
        setLineage(monarchy, lineageTree);

        return lineageTree;

    }

    public void treeConstructor(Tree lineageTree, List<Persona> monarchy) {
        Node<Persona> aux = monarchy.getpFirst();
        while (aux != null) {
            lineageTree.addNode(aux.getData());
            
            lineageTree.getNombres().addPersona(aux.getData(), false);
            if (aux.getData().getKwownAs() != null) {
                lineageTree.getNombres().addPersona(aux.getData(), false);
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
        Persona result = new Persona(name, lineagePosition, eyeColor, hairColor, father);

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
                    if (father == null) {
                        result.setFather(father);
                    }
                    if (father.equals("[Unknown]")) {
                        father = null;
                    }

                    break;
                case "Known throughout as":
                    mote = jsonData.getString(key);
                    result.setKwownAs(mote);
                    counter++;
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
            }
        }
        System.out.println(result.getFullName());
        return result;
    }

    public void setLineage(List<Persona> data, Tree lineageTree) {
        Node<Persona> aux = data.getpFirst();
        String[] innerData;
        TreeNode father;
        Persona fatherPersona;

        while (aux != null) {
            if (aux.getData().getFather() != null) { //fix
                TreeNode node = lineageTree.searchPersonaTree(aux.getData());
                lineageTree.setpRoot(node);
            }
            if (aux.getData().getFather().contains(",")) {
                innerData = aux.getData().getFather().split(",");
                String numeral = innerData[1].split(" ")[0].trim();
                fatherPersona = new Persona(innerData[0], numeral, null);
                father = lineageTree.searchPersonaTree(fatherPersona);
                lineageTree.connectNodes(father.getTinfo(), aux.getData());
                lineageTree.setListFather(aux.getData(), father.getTinfo());

            } else {
                fatherPersona = new Persona(null, null, aux.getData().getFather().trim());
                father = lineageTree.searchPersonaTree(fatherPersona);
                lineageTree.connectNodes(aux.getData(), father.getTinfo());
                lineageTree.setListFather(aux.getData(), father.getTinfo());
            }
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
    public void changeJSON(File newEndpoint) {
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
