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
        
        int lastListProcess = 0;
        List<Process> queue = new ArrayList<>();
        Process cpu = processList.get(lastListProcess);
        lastListProcess++;
        
        int time = 0;
        int pQuantum = 0;
        int event = 0;
        
        this.printInit();
        this.printTime(time);
        this.printCpu(queue, cpu);
        
        time++;
        pQuantum++;
        cpu.timeRunned++;
        
        while(!queue.isEmpty() && cpu != null){
            printTime(time);
            
            //check if the process have an io operation
            if(cpu.ioTimes.contains(cpu.timeRunned)){
                printEvent(0, cpu);
                queue.add(cpu);
                cpu = queue.get(0);
                queue.remove(0);
                pQuantum = 0;
            }
            
            //check if a new process has arrived
            if(processList.get(lastListProcess).inputTime == time){
                printEvent(1, processList.get(lastListProcess));
                queue.add(processList.get(lastListProcess));
            }
            
            //check if a process has reached the quantum limit
            if(pQuantum == this.quantum){
                printEvent(2, cpu);
                queue.add(cpu);
                cpu = queue.remove(0);
                pQuantum = 0;
            }
            
            //check if a process has ended
            if(cpu.timeRunned == cpu.duration){
                printEvent(3, cpu);
                cpu = queue.size() > 0 ? queue.get(0) : null;
                pQuantum = 0;
                
                try{
                    queue.remove(0);
                }catch(Exception e){
                    System.out.println("Lista vazia: "  +e);
                }
            }
            
            printCpu(queue, cpu);
            
            if(cpu != null){
                cpu.timeRunned++;
                time++;
                pQuantum++;
            }
        }
        
        this.printEnd();
    }
    
    public void printTime(int time){
        System.out.println(String.format("********** TEMPO %d ************** ", time));
    }
    
    public void printCpu(List<Process> queue, Process cpu){
        System.out.print("FILA: ");
        
        if(!queue.isEmpty()){
            for(Process p : queue){
                System.out.printf("%s (%d) ", p.pidName, (cpu.duration - cpu.timeRunned));
            }
            System.out.println();
        }else{
            System.out.println("Nao ha processos na fila");
        }
        
        if(cpu != null){
            System.out.printf("CPU: %s (%d) \n", cpu.pidName, (cpu.duration - cpu.timeRunned));
        }else{
            System.out.println("ACABARAM OS PROCESSOS!!!");
        }
    }
    
    public void printEvent(int event, Process pEvent){
        String eventMsg = " ";
        
        switch(event){
            case 0:
                eventMsg = String.format("#[evento] OPERACAO I/O <%s>", pEvent.pidName);
            break;
            case 1:
                eventMsg =String.format("#[evento] CHEGADA <%s>", pEvent.pidName);
            break;
            case 2:
                eventMsg = String.format("#[evento] FIM QUANTUM <%s>", pEvent.pidName);
            break;
            case 3:
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
