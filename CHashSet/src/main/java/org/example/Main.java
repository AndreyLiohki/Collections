package org.example;
import org.example.CHashSet;
public class Main {
    public static void main(String[] args) {
        CHashSet<String> set = new CHashSet<>();

        set.add("Hello");
        set.add("World");
        set.add("Java");

        for (String s : set) {
            System.out.println(s);
        }
        System.out.println();

        if(set.contains("Hello")){
            System.out.println("Set contains word Hello");
        }
        System.out.println();

        if(!set.contains("BSU")){
            System.out.println("Set doesn't contain word BSU");
        }
        set.delete("Hello");
        System.out.println();

        for (String s : set) {
            System.out.println(s);
        }
        System.out.println("Size of set: " + set.size());
    }
}