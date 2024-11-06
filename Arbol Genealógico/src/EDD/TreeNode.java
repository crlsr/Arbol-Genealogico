/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import Extras.Persona;

/**
 *
 * @author pseba
 */
public class TreeNode {
    
    private Persona tinfo;
    private List<TreeNode> hijos;

    public TreeNode(Persona tinfo) {
        this.tinfo = tinfo;
        this.hijos = new List();
    }

    public Persona getTinfo() {
        return tinfo;
    }

    public void setTinfo(Persona tinfo) {
        this.tinfo = tinfo;
    }

    public List<TreeNode> getHijos() {
        return hijos;
    }

    public void setHijos(List<TreeNode> hijos) {
        this.hijos = hijos;
    }
    
}
