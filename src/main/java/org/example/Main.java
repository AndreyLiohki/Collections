package org.example;

import org.example.CArrayList;

import java.util.Calendar;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    
        CArrayList<Integer> defaultArray = new CArrayList<Integer>(Integer.class);
        CArrayList<Integer> arrayNSize = new CArrayList<Integer>(Integer.class, 10);
        CArrayList<Integer> arrayNSizeFilled = new CArrayList<Integer>(Integer.class, 10, -2);

        System.out.println(arrayNSizeFilled.get(2));
        arrayNSizeFilled.put(1234, 2);
        System.out.println(arrayNSizeFilled.get(2));
        arrayNSizeFilled.push(1111111);
        System.out.println(arrayNSizeFilled.get(arrayNSizeFilled.arraySize()-2));

        System.out.println();
        CArrayList<String> list = new CArrayList<>(String.class);
        list.push("Hello");
        list.push("World");
        list.push("Java");

        System.out.println("Before deletion:");
        for (int i = 0; i < list.arraySize(); i++) {
            System.out.println(list.get(i));
        }
        
        System.out.println();
        list.delete(1);

        System.out.println("After deletion:");
        for (int i = 0; i < list.arraySize(); i++) {
            System.out.println(list.get(i));
        }







    }
}