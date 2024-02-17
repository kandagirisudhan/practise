package org.example.DS;

import java.util.Arrays;

public class CustomArrayList<E> {

    private int size = 0;

    private int DEFAULT_CAPACITY = 10;

    private Object[] elements;


    CustomArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }


    void add(E element) {

        if (size == elements.length) {
            int increaseCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, increaseCapacity);
        }
        System.out.println(element);
        elements[size++] = element;

    }

    public E get(int index) {
        if (index > 0 || index <= size)
            return (E) elements[index];

        return null;
    }

    Boolean remove(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                removeAtIndex(i);
                return true;

            }
        }
        return false;

    }

    private void removeAtIndex(int index) {
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    int size(){
        return size;
    }

    Boolean contains(E element){

        for(int i=0;i<size;i++){
            if(elements[i] == element){
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        CustomArrayList<String> inputVAl = new CustomArrayList<>();
        inputVAl.add("A");
        inputVAl.add("B");
        inputVAl.add("C");

        System.out.println("Size " + inputVAl);
        System.out.println("Get Elements" + inputVAl.get(1));
        System.out.println("Get Elements" + inputVAl.get(2));
        System.out.println("Get Elements" + inputVAl.size());

        System.out.println("Size " + inputVAl);
        System.out.println("Remove Elements" + inputVAl.remove("A"));
        System.out.println("Size" + inputVAl.size());

        System.out.println("Contains " +inputVAl.contains("C"));
    }


}
