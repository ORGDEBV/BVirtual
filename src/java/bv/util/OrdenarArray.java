/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.util;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author virtual
 */
public class OrdenarArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList arrayListInt = new ArrayList<>();

        // Guardo datos en el ArrayList
        arrayListInt.add(1);
        arrayListInt.add(5);
        arrayListInt.add(6);
        arrayListInt.add(10);
        arrayListInt.add(2);
        arrayListInt.add(3);
        arrayListInt.add(9);
        
        System.out.println(arrayListInt);
        Collections.sort(arrayListInt);
        System.out.println(arrayListInt);
        
    }

}
