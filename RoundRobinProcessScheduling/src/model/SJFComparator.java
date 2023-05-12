/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Comparator;

/**
 *
 * @author unielumoraes
 */
public class SJFComparator implements Comparator<Process> {

    @Override
    public int compare(Process p1, Process p2) {
        return p1.duration - p2.duration;
    }
    
}
