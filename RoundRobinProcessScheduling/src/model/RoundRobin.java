/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
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
    
    public void orderList(){
        Collections.sort(processList, new ProcessComparator());
    }
    
    public void schedule(){
        this.orderList();
        List<Process> queue = new ArrayList<>();
        Process cpu = processList.get(0);
        int time = 0;
        int event = 0;
        
        
        
    }
    
    public void printTime(int time){
        System.out.println(String.format("********** TEMPO %d ************** ", time));
    }
    
    public void printCpu(List<Process> queue, Process cpu){
        System.out.print("FILA: ");
        
        for(Process p : queue){
            System.out.printf("%s (%d) ", p.pidName, p.duration);
        }
        
        System.out.printf("\nCPU: %s (%d) ", cpu.pidName, cpu.duration);
    }
    
    public void printEvent(int event, Process pEvent){
        String eventMsg = " ";
        
        switch(event){
            case 0:
                eventMsg = "";
            break;
            case 1:
                eventMsg =String.format("#[evento] CHEGADA <%s>", pEvent.pidName);
            break;
            case 2:
                eventMsg = String.format("#[evento] OPERACAO I/O <%s>", pEvent.pidName);
            break;
            case 3:
                eventMsg = String.format("#[evento] FIM QUANTUM <%s>", pEvent.pidName);
            break;
            case 4:
                eventMsg =String.format("#[evento] ENCERRANDO <%s>", pEvent.pidName);
            break;
        }
        
        System.out.println(eventMsg);
    }
    
    public void printInit(){
        System.out.println(
                "***********************************\n" +
                "***** ESCALONADOR ROUND ROBIN *****\n" +
                "-----------------------------------\n" +
                "------- INICIANDO SIMULACAO -------\n" +
                "-----------------------------------"
        );
    }
    
    public void printEnd(){
        System.out.println(
                "-----------------------------------\n"+
                "------- Encerrando simulacao ------\n"+
                "-----------------------------------"
        );
    }
    
}
