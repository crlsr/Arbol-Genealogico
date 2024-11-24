/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
/**
 * Representa una lista enlazada.
 *
 * @param <T> el tipo de dato almacenado en la lista
 * @Carlos Rodriguez
 */
public class List<T> {

    private Node<T> pFirst;
    private int size;

    /**
     * Construye una nueva lista vacía.
     */
    public List() {
        this.pFirst = null;
        this.size = 0;
    }

    /**
     * Devuelve el primer nodo de la lista.
     * 
     * @return el primer nodo
     */
    public Node<T> getpFirst() {
        return pFirst;
    }

    /**
     * Establece el primer nodo de la lista.
     * 
     * @param pFirst el primer nodo
     */
    public void setpFirst(Node<T> pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Devuelve el tamaño de la lista.
     * 
     * @return el tamaño de la lista
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño de la lista.
     * 
     * @param size el tamaño de la lista
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Verifica si la lista está vacía.
     * 
     * @return true si la lista está vacía, de lo contrario false
     */
    public boolean isEmpty() {
        if (this.getpFirst() == null) {
            return true;
        }
        return false;
    }
    
    /**
     * Destruye la lista, eliminando todos sus elementos.
     */
    public void destructor(){
        if(!isEmpty()){
            this.setpFirst(null);
            this.setSize(0);
        }
    }

    /**
     * Devuelve el último nodo de la lista.
     * 
     * @return el último nodo, o null si la lista está vacía
     */
    public Node<T> last() {
        if (!isEmpty()) {
            Node<T> aux = this.getpFirst();
            while (aux.getpNext() != null) {
                aux = aux.getpNext();
            }
            return aux;
        }
        return null;
    }

    /**
     * Agrega un nuevo nodo con los datos proporcionados al final de la lista.
     * 
     * @param newData los datos a ser almacenados en el nuevo nodo
     */
    public void add(T newData) {
        Node<T> newNode = new Node<>(newData);
        if (!isEmpty()) {
            Node<T> lastNode = last();
            lastNode.setpNext(newNode);
        } else {
            this.setpFirst(newNode);
        }
        this.setSize(this.getSize() + 1);
    }

    /**
     * Agrega un nuevo nodo con los datos proporcionados al principio de la lista.
     * 
     * @param data los datos a ser almacenados en el nuevo nodo
     */
    public void newFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (!isEmpty()) {
            Node<T> currentFirst = this.getpFirst();
            this.setpFirst(newNode);
            newNode.setpNext(currentFirst);
        } else {
            this.setpFirst(newNode);
        }
        this.setSize(this.getSize() + 1);
    }

    /**
     * Elimina el último nodo de la lista.
     */
    public void delete(){
        if(this.getSize() == 1){
            destructor();
        } else if(!isEmpty()){
            Node<T> last = last();
            Node<T> aux = this.getpFirst();
            while (aux.getpNext() != last) {
                aux = aux.getpNext();
            }
            aux.setpNext(null);
            this.setSize(this.getSize() - 1);
        }
    }
    
    /**
     * Elimina el primer nodo de la lista.
     */
    public void deleteFirst(){
        if (!isEmpty()) {
            Node<T> oldFirst = this.getpFirst();
            this.setpFirst(oldFirst.getpNext());
            oldFirst.setpNext(null);
            this.setSize(this.getSize() - 1);
        }
    }

    /**
     * Elimina el nodo en el índice especificado.
     * 
     * @param index el índice del nodo a eliminar
     */
    public void deleteByIndex(int index) {
        if (index < 0 || index >= this.getSize()) {
            return;
        } else if (index == 0) {
            deleteFirst();
        } else if (index == this.getSize()-1) {
            delete();
        } else {
            Node<T> aux = this.getpFirst();
            for (int i = 0; i < index-1; i++) {
                aux = aux.getpNext();
            }
            Node<T> deleteable = aux.getpNext();
            aux.setpNext(deleteable.getpNext());
            deleteable.setpNext(null);
            this.setSize(this.getSize() - 1);
        }
    }

    /**
     * Agrega un nuevo nodo con los datos proporcionados en el índice especificado.
     * 
     * @param index el índice donde agregar el nuevo nodo
     * @param data los datos a ser almacenados en el nuevo nodo
     */
    public void addByIndex(int index, T data) {
        if (index < 0 || index > this.getSize()) {
            return;
        } else if (index == 0) {
            newFirst(data);
        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> aux = this.getpFirst();
            for (int i = 0; i < index - 1; i++) {
                aux = aux.getpNext();
            }
            Node<T> next = aux.getpNext();
            aux.setpNext(newNode);
            newNode.setpNext(next);
            this.setSize(this.getSize() + 1);
        }
    }

    /**
     * Muestra los datos de todos los nodos en la lista.
     */
    public void show() {
        if (!isEmpty()) {
            Node<T> aux = this.getpFirst();
            while (aux != null) {
                System.out.println(aux.getData());
                aux = aux.getpNext();
            }
        } else {
            System.out.println("Ninguno");
        }
    }
}
