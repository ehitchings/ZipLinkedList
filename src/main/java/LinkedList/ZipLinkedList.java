package LinkedList;

import java.util.Comparator;

/**
 * Created by evanhitchings on 10/20/16.
 */
public class ZipLinkedList <T extends Comparable> {
    public Node head;
    public int size;

    public ZipLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public ZipLinkedList(T head) {
        this();
        this.add(head);

    }

    public void add(T node){
        Node toAdd = new Node(node);
        toAdd.next = this.head;
        this.head = toAdd;
        this.size += 1;
    }

    public void remove(int index){
        if(index < 0 || index > this.size) return;
        Node current = this.head;
        Node previousHead = null;
        for(int i = 0; i < index; i++){
            previousHead = current;
            current = current.next;
        }
        previousHead.next = current.next;
        current.next = null;
        this.size -= 1;
    }

    public boolean contains(T toContain){
        Node current = this.head;
        while(current != null){
            if(current.data.equals(toContain)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int find(T toFind){
        Node current = this.head;
        int count = 0;
        while(current != null){
            if(current.data.equals(toFind)){
                return count;
            }
            current = current.next;
            count++;
        }
        return -1;
    }

    public void reverse(){
        ZipLinkedList reversedZipLinkedList = new ZipLinkedList();
        Node current = this.head;
        while(current != null){
            T dataToAdd = current.data;
            reversedZipLinkedList.add(dataToAdd);
            current = current.next;
        }
        this.head = reversedZipLinkedList.head;
    }

    public int getSize() {
        return size;
    }

    public T get(int index){
        if(index < 0 || index >= this.size){
            return null;
        }
        Node current = this.head;
        int count = 0;
        while(count < index){
            current = current.next;
            count++;
        }
        return current.data;
    }

    public ZipLinkedList copy(){
        ZipLinkedList copyToReturn = new ZipLinkedList();
        int toBegin = this.size -1;
        for(int i = toBegin; i >= 0; i--){
            copyToReturn.add(this.get(i));
        }
        return copyToReturn;
    }

    public ZipLinkedList slice(int start, int end){
        if(end - this.size > 1) return null;
        ZipLinkedList sliced = new ZipLinkedList();
        Node current = this.head;
        int count = 0;
        while(current != null){
            if(count == end) {
                break;
            }
            if(count >= start){
                sliced.add(current.data);
            }
            current = current.next;
            count++;

        }
        sliced.reverse();
        return sliced;
    }

    public void sort(){
        if(!(this.head.data instanceof Comparable) ){
            return;
        }


        boolean changed;
        do {
            changed = false;
            Node currentHead = this.head;
            Node nextHead = currentHead.next;
            Node previousHead = null;
            int compareValue = 0;
            while(nextHead != null){
                java.lang.reflect.Method method;
                try {
                    method = currentHead.data.getClass().getMethod("compareTo", nextHead.data.getClass());
                } catch(NoSuchMethodException e){
                    return;
                }
                try{
                   compareValue = (Integer)method.invoke(currentHead.data, nextHead.data);
                } catch(Exception f){
                    return;
                    }

                if(compareValue != 1){
                    previousHead = currentHead;
                    currentHead = nextHead;
                    nextHead = currentHead.next;
                } else {
                    changed = true;
                    if(previousHead == null){
                        this.head = nextHead;
                        currentHead.next = nextHead.next;
                        nextHead.next = currentHead;
                        previousHead = nextHead;
                        nextHead = currentHead.next;

                    } else{
                        previousHead.next = nextHead;
                        previousHead = nextHead;
                        currentHead.next = nextHead.next;
                        nextHead = currentHead.next;
                        previousHead.next = currentHead;
                    }

            }
           }
        } while(changed);
    }

    @Override
    public String toString(){
        Node current = this.head;
        StringBuilder stringBuilder = new StringBuilder();
        while(current !=null ){
            stringBuilder.append(current.data);
            current = current.next;
        }
        return stringBuilder.toString();

    }

    public class Node {
        T data;
        Node next;


        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public String toString(){
            return this.data + "";
        }
    }



}
