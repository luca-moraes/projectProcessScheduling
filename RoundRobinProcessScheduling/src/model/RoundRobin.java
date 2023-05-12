/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.IOException;
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
    public FileManager fileManager;
    
    public RoundRobin(float quantum, List<Process> list, FileManager fileManager){
        processList = list;
        this.quantum = quantum;
        this.fileManager = fileManager;
    }
    
    private void orderList(){
        Collections.sort(processList, new ProcessComparator());
    }
    
    private void ordelSJF(){
        Collections.sort(processList, new SJFComparator());
    }
    
    public void schedule() throws IOException{
        this.orderList();
        fileManager.openBuffer();
        
        int lastListProcess = 0;
        List<Process> queue = new ArrayList<>();
        Process cpu = processList.isEmpty() ? null : processList.get(lastListProcess);
        lastListProcess++;
        
        int time = 0;
        int pQuantum = 0;
        
        this.printInit();
        this.printTime(time);
        this.printCpu(queue, cpu);
        
        time++;
        pQuantum++;
        cpu.timeRunned++;
        
        while(cpu != null){
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
                lastListProcess = lastListProcess == processList.size() - 1 ? lastListProcess : lastListProcess + 1;
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
                }catch(Exception e){}
            }
            
            printCpu(queue, cpu);
            
            if(cpu != null){
                cpu.timeRunned++;
                time++;
                pQuantum++;
            }
        }
        
        this.printEnd();
        fileManager.closeBuffer();
    }
    
    public void fifoSchedule() throws IOException{
        this.orderList();
        fileManager.openBuffer();
        
        int lastListProcess = 0;
        List<Process> queue = new ArrayList<>();
        Process cpu = processList.isEmpty() ? null : processList.get(lastListProcess);
        lastListProcess++;
        
        int time = 0;
        
        this.printInit();
        this.printTime(time);
        this.printCpu(queue, cpu);
        
        time++;
        cpu.timeRunned++;
        
        while(cpu != null){
            printTime(time);
            
            //check if the process have an io operation
            if(cpu.ioTimes.contains(cpu.timeRunned)){
                printEvent(0, cpu);
                queue.add(cpu);
                cpu = queue.get(0);
                queue.remove(0);
            }
            
            //check if a new process has arrived
            if(processList.get(lastListProcess).inputTime == time){
                printEvent(1, processList.get(lastListProcess));
                queue.add(processList.get(lastListProcess));
                lastListProcess = lastListProcess == processList.size() - 1 ? lastListProcess : lastListProcess + 1;
            }
            
            //check if a process has ended
            if(cpu.timeRunned == cpu.duration){
                printEvent(3, cpu);
                cpu = queue.size() > 0 ? queue.get(0) : null;
                
                try{
                    queue.remove(0);
                }catch(Exception e){}
            }
            
            printCpu(queue, cpu);
            
            if(cpu != null){
                cpu.timeRunned++;
                time++;
            }
        }
        
        this.printEnd();
        fileManager.closeBuffer();
    }
    
    public void sjfSchedule() throws IOException{
        this.orderList();
        fileManager.openBuffer();
        
        int lastListProcess = 0;
        List<Process> queue = new ArrayList<>();
        Process cpu = processList.isEmpty() ? null : processList.get(lastListProcess);
        lastListProcess++;
        
        int time = 0;
        
        this.printInit();
        this.printTime(time);
        this.printCpu(queue, cpu);
        
        time++;
        cpu.timeRunned++;
        
        while(cpu != null){
            printTime(time);
            
            //check if the process have an io operation
            if(cpu.ioTimes.contains(cpu.timeRunned)){
                printEvent(0, cpu);
                Collections.sort(queue, new SJFComparator());
                queue.add(cpu);
                cpu = queue.get(0);
                queue.remove(0);
            }
            
            //check if a new process has arrived
            if(processList.get(lastListProcess).inputTime == time){
                printEvent(1, processList.get(lastListProcess));
                queue.add(processList.get(lastListProcess));
                lastListProcess = lastListProcess == processList.size() - 1 ? lastListProcess : lastListProcess + 1;
            }
            
            //check if a process has ended
            if(cpu.timeRunned == cpu.duration){
                printEvent(3, cpu);
                Collections.sort(queue, new SJFComparator());
                cpu = queue.size() > 0 ? queue.get(0) : null;
                
                try{
                    queue.remove(0);
                }catch(Exception e){}
            }
            
            printCpu(queue, cpu);
            
            if(cpu != null){
                cpu.timeRunned++;
                time++;
            }
        }
        
        this.printEnd();
        fileManager.closeBuffer();
    }
    
    private void printTime(int time) throws IOException{
        System.out.println(String.format("********** TEMPO %d ************** ", time));
        fileManager.escritor(String.format("********** TEMPO %d ************** \n", time));
    }
    
    private void printCpu(List<Process> queue, Process cpu) throws IOException{
        System.out.print("FILA: ");
        fileManager.escritor("FILA: ");
        
        if(!queue.isEmpty()){
            for(Process p : queue){
                System.out.printf("%s(%d) ", p.pidName, (p.duration - p.timeRunned));
                fileManager.escritor(String.format("%s(%d) ", p.pidName, (p.duration - p.timeRunned)));
            }
            System.out.println();
            fileManager.escritor("\n");
        }else{
            System.out.println("Nao ha processos na fila");
            fileManager.escritor("\n");
        }
        
        if(cpu != null){
            System.out.printf("CPU: %s(%d) \n", cpu.pidName, (cpu.duration - cpu.timeRunned));
            fileManager.escritor(String.format("CPU: %s(%d) \n", cpu.pidName, (cpu.duration - cpu.timeRunned)));
        }else{
            System.out.println("ACABARAM OS PROCESSOS!!!");
            fileManager.escritor("ACABARAM OS PROCESSOS!!!\n");
        }
    }
    
    private void printEvent(int event, Process pEvent) throws IOException{
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
        fileManager.escritor(eventMsg);
        fileManager.escritor("\n");
    }
    
    private void printInit() throws IOException{
        System.out.println(
                "***********************************\n" +
                "***** ESCALONADOR ROUND ROBIN *****\n" +
                "-----------------------------------\n" +
                "------- INICIANDO SIMULACAO -------\n" +
                "-----------------------------------"
        );
        
        fileManager.escritor(String.format(
                "***********************************\n" +
                "***** ESCALONADOR ROUND ROBIN *****\n" +
                "-----------------------------------\n" +
                "------- INICIANDO SIMULACAO -------\n" +
                "-----------------------------------\n"
        ));
    }
    
    private void printEnd() throws IOException{
        System.out.println(
                "-----------------------------------\n"+
                "------- Encerrando simulacao ------\n"+
                "-----------------------------------"
        );
        
        fileManager.escritor(String.format(
                 "-----------------------------------\n"+
                "------- Encerrando simulacao ------\n"+
                "-----------------------------------"
        ));
    }
}