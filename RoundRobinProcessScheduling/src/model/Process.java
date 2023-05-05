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
    public float duration;
    public float inputTime;
    public List<Float> ioTimes;

    public Process(String name, float duration, float inputTime) {
        this.ioTimes = new ArrayList<>();
        this.pidName = name;
        this.duration = duration;
        this.inputTime = inputTime;
    }
    
    public void addIo(float ioTime){
        this.ioTimes.add(ioTime);
    }
}
