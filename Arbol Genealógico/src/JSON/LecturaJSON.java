/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSON;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
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
        try(FileReader reader = new FileReader(endpoint)){
            this.data = new JSONObject(new JSONTokener(reader));
        } catch(IOException e){
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
    
    
    
    public void updateData(){
        try(FileWriter overwrite = new FileWriter(this.getIneerFilePath())){
            overwrite.write(this.getData().toString(4));
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al intentar sobre escribir: " + e.getMessage());
        }
    }
    
    
    public void changeJSON(File newEndpoint){
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
