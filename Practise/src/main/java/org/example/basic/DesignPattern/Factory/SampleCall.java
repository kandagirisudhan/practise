package org.example.basic.DesignPattern.Factory;

public class SampleCall {

    public static void main(String args[]) {
        Factory f = new Factory();
        Animal s = f.createAnimal("Cat");

        System.out.println(s.Character());

        Animal c = f.createAnimal("Dog");
        System.out.println(c.Character());
    }
}
