package com.cifo.apartmentpredictoralpy.utils;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Utils {

    /**
     * Prints all elements contained in any Iterable collection.
     *
     * Why Iterable<?>:
     * - Iterable allows this method to work with any collection that can be iterated
     *   (List, Set, Queue, etc.).
     * - The wildcard '?' means the element type is unknown and irrelevant here.
     * - This method is READ-ONLY: it only iterates and prints elements,
     *   it does not modify the collection.
     *
     * Key concept:
     * - All Java collections implement Iterable.
     * - Using Iterable<?> makes the method flexible and type-safe,
     *   without depending on a specific generic type.
     *
     * Typical use cases:
     * - Displaying data from different collections
     * - Utility methods that only need to traverse elements
     *
     * Note:
     * - Elements are treated as Object because the exact type is unknown.
     */
    public static void printAllDataObject (Iterable<?> list){
        // Display all apartments in the database
        int index = 0;
        System.out.println("\n=== Apartments in the Database ===");
        for (Object object : list) {
            index++;
            System.out.println("#" + index);
            System.out.println(object);
        }

    }


}
