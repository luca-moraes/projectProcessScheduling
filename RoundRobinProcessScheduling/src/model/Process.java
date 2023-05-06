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
public class Process {
    public String pidName;
    public int duration;
    public int inputTime;
    public List<Float> ioTimes;
    public int waitTime;
    public int turnaround;

    public Process(String name, int duration, int inputTime) {
        this.ioTimes = new ArrayList<>();
        this.pidName = name;
        this.duration = duration;
        this.inputTime = inputTime;
        this.waitTime = 0;
        this.turnaround = 0;
    }
    
    public void addIo(float ioTime){
        this.ioTimes.add(ioTime);
    }
}
