package org.example.basic.Altimetrik;

public class Singleton {

    private static Singleton  val =null;


    static Singleton getInstance(){

        if (val == null)
             val =new Singleton();

        return val;
    }


    public static void main(String args[]){
        Singleton x =Singleton.getInstance();
        Singleton y =Singleton.getInstance();

        System.out.println("------------->"+x);
        System.out.println("------------->"+y);
    }
}
