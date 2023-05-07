/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Comparator;

/**
 *
 * @author eu
 */
public class ProcessComparator implements Comparator<Process>{
    
    @Override
    public int compare(Process t, Process t1) {
        return t.inputTime - t1.inputTime;
    }
}
