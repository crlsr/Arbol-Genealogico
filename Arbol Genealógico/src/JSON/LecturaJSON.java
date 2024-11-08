/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSON;

import EDD.Hashtable;
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

    public void dataConstructor(Tree lineageTree) {
        List<Persona> monarchy = new List<>();
        String keyWord = this.getData().keys().next();
        JSONArray innerData = this.getData().getJSONArray(keyWord);

        for (int i = 0; i < innerData.length(); i++) {
            JSONObject personJSON = innerData.getJSONObject(i);
            String personKey = personJSON.keys().next();
            JSONArray personData = personJSON.getJSONArray(personKey);
            Persona person = personBuilder(personData, personKey);
            monarchy.add(person);
            lineageTree.addNode(person);
            if (person.getKwownAs() == null) {
                lineageTree.getNombres().addPersona(person, false);
            } else {
                lineageTree.getNombres().addPersona(person, true);
            }
        }

        setLineage(monarchy, lineageTree);
    }

    public Persona personBuilder(JSONArray data, String name) {
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
                    if (father.equals("[Unknown]")) {
                        father = null;
                    }
                    result.setFather(father);
                    break;
                case "Known throughout as":
                    mote = jsonData.getString(key);
                    result.setKwownAs(mote);
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

        return result;
    }

    public void setLineage(List<Persona> data, Tree lineage) {
        Node<Persona> aux = data.getpFirst();
        while (aux != aux) {
            if (aux.getData().getFather() != null) {
                //lineage.getNombres().searchPersona();
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
