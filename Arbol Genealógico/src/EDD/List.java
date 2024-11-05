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

    private Node pFirst;
    private int size;

    public List() {
        this.pFirst = null;
        this.size = 0;
    }

    public Node getpFirst() {
        return pFirst;
    }

    public void setpFirst(Node pFirst) {
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

    public Node last() {
        if (!isEmpty()) {
            Node aux = this.getpFirst();
            while (aux.getpNext() != null) {
                aux = aux.getpNext();
            }
            return aux;
        }
        return null;
    }

    public void add(T newData) {
        Node newNode = new Node(newData);
        if (!isEmpty()) {
            Node lastNode = last();
            lastNode.setpNext(newNode);

        } else {
            this.setpFirst(newNode);
        }
        this.setSize(this.getSize() + 1);
    }

    public void newFirst(T data) {
        Node newNode = new Node(data);
        if (!isEmpty()) {
            Node currentFirst = this.getpFirst();
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
            Node last = last();
            Node aux = this.getpFirst();
            while (aux.getpNext() != last) {
                aux = aux.getpNext();
            }
            aux.setpNext(null);
            this.setSize(this.getSize() - 1);

        }
    }
    
    public void deleteFirst(){
        if (!isEmpty()) {
            Node oldFirst = this.getpFirst();
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
            Node aux = this.getpFirst();
            for (int i = 0; i < index-1; i++) {
                aux = aux.getpNext();
            }
            Node deleteable = aux.getpNext();
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
            Node newNode = new Node(data);
            Node aux = this.getpFirst();
            for (int i = 0; i < index - 1; i++) {
                aux = aux.getpNext();
            }
            Node next = aux.getpNext();
            aux.setpNext(newNode);
            newNode.setpNext(next);
            this.setSize(this.getSize() + 1);
        }

    }

    public void show() {
        if (!isEmpty()) {
            Node aux = this.getpFirst();
            while (aux != null) {
                System.out.println(aux.getData());
                aux = aux.getpNext();
            }
        } else {
            System.out.println("None");
        }
    }
}

