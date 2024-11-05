/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author carlosrodriguez
 */
public class Node<T> {
    private Node pNext;
    private T data;

    public Node(T data) {
        this.pNext = null;
        this.data = data;
    }

    public Node getpNext() {
        return pNext;
    }

    public void setpNext(Node pNext) {
        this.pNext = pNext;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
    
    
    
}
