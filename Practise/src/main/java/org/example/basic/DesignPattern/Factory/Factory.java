package org.example.basic.DesignPattern.Factory;

import org.example.basic.DesignPattern.Factory.Animal;
import org.example.basic.DesignPattern.Factory.Cat;
import org.example.basic.DesignPattern.Factory.Dog;

public class Factory {

    Animal createAnimal(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("Cat")) {
            return new Cat();
        } else if (type.equalsIgnoreCase("Dog")) {
            return new Dog();
        }

        return null;
    }
}