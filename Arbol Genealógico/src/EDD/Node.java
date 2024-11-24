/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 * Representa un nodo en una lista enlazada.
 *
 * @param <T> el tipo de dato almacenado en el nodo
 * @Carlos Rodriguez
 */
public class Node<T> {
    private Node pNext;
    private T data;

    /**
     * Construye un nuevo nodo con los datos proporcionados.
     * 
     * @param data los datos a ser almacenados en el nodo
     */
    public Node(T data) {
        this.pNext = null;
        this.data = data;
    }

    /**
     * Devuelve el siguiente nodo en la lista.
     * 
     * @return el siguiente nodo
     */
    public Node getpNext() {
        return pNext;
    }

    /**
     * Establece el siguiente nodo en la lista.
     * 
     * @param pNext el siguiente nodo
     */
    public void setpNext(Node pNext) {
        this.pNext = pNext;
    }

    /**
     * Devuelve los datos almacenados en el nodo.
     * 
     * @return los datos
     */
    public T getData() {
        return data;
    }

    /**
     * Establece los datos almacenados en el nodo.
     * 
     * @param data los datos
     */
    public void setData(T data) {
        this.data = data;
    }
}

