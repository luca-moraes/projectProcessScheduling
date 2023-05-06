/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lmoraes
 */
public class RoundRobin {
    public List<Process> processList = new ArrayList<>();
    public float quantum;
    
    public RoundRobin(float quantum, List<Process> list){
        processList = list;
        this.quantum = quantum;
    }
}
