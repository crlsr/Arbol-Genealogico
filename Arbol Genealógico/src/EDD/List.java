/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author carlosrodriguez
 */

/**
 *
 * @author carlosrodriguez
 * @param <T>
 */
public class List<T> {

    private Node<T> pFirst;
    private int size;

    public List() {
        this.pFirst = null;
        this.size = 0;
    }

    public Node<T> getpFirst() {
        return pFirst;
    }

    public void setpFirst(Node<T> pFirst) {
        this.pFirst = pFirst;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        if (this.getpFirst() == null) {
            return true;
        }
        return false;
    }
    
    public void destructor(){
        if(!isEmpty()){
            this.setpFirst(null);
            this.setSize(0);
        }
    }

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
    
    public void delete(){
        if(this.getSize() == 1){
            destructor();
        }
        else if(!isEmpty()){
            Node<T> last = last();
            Node<T> aux = this.getpFirst();
            while (aux.getpNext() != last) {
                aux = aux.getpNext();
            }
            aux.setpNext(null);
            this.setSize(this.getSize() - 1);

        }
    }
    
    public void deleteFirst(){
        if (!isEmpty()) {
            Node<T> oldFirst = this.getpFirst();
            this.setpFirst(oldFirst.getpNext());
            oldFirst.setpNext(null);
            this.setSize(this.getSize() - 1);
        }
    }
    
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

    public void show() {
        if (!isEmpty()) {
            Node<T> aux = this.getpFirst();
            while (aux != null) {
                System.out.println(aux.getData());
                aux = aux.getpNext();
            }
        } else {
            System.out.println("None");
        }
    }
}

