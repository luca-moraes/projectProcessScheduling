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
    public List<String> textPaneOutput = new ArrayList<>();
    public float quantum;
    public FileManager fileManager;
    public StringBuilder saidaEscalonador = new StringBuilder();
    public StringBuilder saidaGrafico = new StringBuilder();
    
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
    
    private void incrementarTempoMedio(List<Process> queue){
        for(Process p : this.processList){
            p.waitTime += queue.contains(p) ? 1 : 0;
        }
    }
    
    public void schedule() throws IOException{
        this.orderList();
        
        int lastListProcess = 0;
        List<Process> queue = new ArrayList<>();
        Process cpu = processList.isEmpty() ? null : processList.get(lastListProcess);
        lastListProcess++;
        
        int time = 0;
        int pQuantum = 0;
        
        //file escalonador
        this.printInit("ROUND ROBIN");
        this.printTime(time);
        this.printCpu(queue, cpu);
        
        //file grafico
        this.printInitGrafico("ROUND ROBIN");
        this.printProcessoGrafico(time, cpu);
        
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
                
                this.printProcessoGrafico(time, cpu);
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
                
                this.printProcessoGrafico(time, cpu);
            }
            
            //check if a process has ended
            if(cpu.timeRunned == cpu.duration){
                printEvent(3, cpu);
                cpu = queue.size() > 0 ? queue.get(0) : null;
                pQuantum = 0;
                
                this.printProcessoGrafico(time, cpu);
                
                try{
                    queue.remove(0);
                }catch(Exception e){}
            }
            
            printCpu(queue, cpu);
            
            if(cpu != null){
                cpu.timeRunned++;
                time++;
                pQuantum++;
                this.incrementarTempoMedio(queue);
                this.textPaneOutput.add(";");
            }
        }
        
        //file escalonador
        this.printEnd();
        
        //file grafico
        this.printEndGrafico();
        
        this.salvarEscalondor();
        this.salvarGrafico();
    }
    
    public void fifoSchedule() throws IOException{
        this.orderList();
        
        int lastListProcess = 0;
        List<Process> queue = new ArrayList<>();
        Process cpu = processList.isEmpty() ? null : processList.get(lastListProcess);
        lastListProcess++;
        
        int time = 0;
        
        //file escalonador
        this.printInit("FIFO");
        this.printTime(time);
        this.printCpu(queue, cpu);
        
        //file grafico
        this.printInitGrafico("FIFO");
        this.printProcessoGrafico(time, cpu);
        
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
                
                this.printProcessoGrafico(time, cpu);
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
                
                this.printProcessoGrafico(time, cpu);
                
                try{
                    queue.remove(0);
                }catch(Exception e){}
            }
            
            printCpu(queue, cpu);
            
            if(cpu != null){
                cpu.timeRunned++;
                time++;
                
                this.incrementarTempoMedio(queue);
                this.textPaneOutput.add(";");
            }
        }
        
        //file escalonador
        this.printEnd();
        
        //file grafico
        this.printEndGrafico();
        
        this.salvarEscalondor();
        this.salvarGrafico();
    }
    
    public void sjfSchedule() throws IOException{
        this.orderList();
        
        int lastListProcess = 0;
        List<Process> queue = new ArrayList<>();
        Process cpu = processList.isEmpty() ? null : processList.get(lastListProcess);
        lastListProcess++;
        
        int time = 0;
        
        //file escalonador
        this.printInit("SJF");
        this.printTime(time);
        this.printCpu(queue, cpu);
        
        //file grafico
        this.printInitGrafico("SJF");
        this.printProcessoGrafico(time, cpu);
        
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
                
                this.printProcessoGrafico(time, cpu);
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
                
                this.printProcessoGrafico(time, cpu);
                
                try{
                    queue.remove(0);
                }catch(Exception e){}
            }
            
            printCpu(queue, cpu);
            
            if(cpu != null){
                cpu.timeRunned++;
                time++;
                
                this.incrementarTempoMedio(queue);
                this.textPaneOutput.add(";");
            }
        }
        
        //file escalonador
        this.printEnd();
        
        //file grafico
        this.printEndGrafico();
        
        this.salvarEscalondor();
        this.salvarGrafico();
    }
    
    public void salvarEscalondor() throws IOException{
        fileManager.fileEscalonador(this.saidaEscalonador.toString());
    }
    
    public void salvarGrafico() throws IOException{
        fileManager.fileGrafico(this.saidaGrafico.toString());
    }
    
    private void printTime(int time) throws IOException{
        this.saidaEscalonador.append(String.format("********** TEMPO %d **************\n", time));
        this.textPaneOutput.add(String.format("********** TEMPO %d **************\n", time));
    }
    
    private void printCpu(List<Process> queue, Process cpu) throws IOException{
        this.saidaEscalonador.append("FILA: ");
        this.textPaneOutput.add("FILA: ");
        
        if(!queue.isEmpty()){
            for(Process p : queue){
                this.saidaEscalonador.append(String.format("%s(%d) ", p.pidName, (p.duration - p.timeRunned)));
                this.textPaneOutput.add(String.format("%s(%d) ", p.pidName, (p.duration - p.timeRunned)));
            }
            
            this.saidaEscalonador.append("\n");
            this.textPaneOutput.add("\n");
        }else{
            this.saidaEscalonador.append("Nao ha processos na fila");
            this.textPaneOutput.add("Nao ha processos na fila");
            
            this.saidaEscalonador.append("\n");
            this.textPaneOutput.add("\n");
        }
        
        if(cpu != null){
            this.saidaEscalonador.append(String.format("CPU: %s(%d) \n", cpu.pidName, (cpu.duration - cpu.timeRunned)));
            this.textPaneOutput.add(String.format("CPU: %s(%d) \n", cpu.pidName, (cpu.duration - cpu.timeRunned)));
            
        }else{
            this.saidaEscalonador.append("ACABARAM OS PROCESSOS!!!\n");
            this.textPaneOutput.add("ACABARAM OS PROCESSOS!!!\n");
        }
    }
    
    private void printEvent(int event, Process pEvent) throws IOException{
        String eventMsg = " ";
        
        switch(event){
            case 0:
                eventMsg = String.format("#[evento] OPERACAO I/O <%s>", pEvent.pidName);
            break;
            case 1:
                eventMsg = String.format("#[evento] CHEGADA <%s>", pEvent.pidName);
            break;
            case 2:
                eventMsg = String.format("#[evento] FIM QUANTUM <%s>", pEvent.pidName);
            break;
            case 3:
                eventMsg = String.format("#[evento] ENCERRANDO <%s>", pEvent.pidName);
            break;
        }
        
        this.saidaEscalonador.append(eventMsg);
        this.saidaEscalonador.append("\n");
        
        this.textPaneOutput.add(eventMsg);
        this.textPaneOutput.add("\n");
    }
    
    private void printInit(String tipo) throws IOException{
        this.saidaEscalonador.append("***********************************\n");
        this.textPaneOutput.add("***********************************\n");
                
        this.saidaEscalonador.append(String.format("***** ESCALONADOR %s *****\n", tipo));
        this.textPaneOutput.add(String.format("***** ESCALONADOR %s *****\n", tipo));
                
        this.saidaEscalonador.append (
                "-----------------------------------\n" +
                "------- INICIANDO SIMULACAO -------\n" +
                "-----------------------------------\n"  
        );
        this.textPaneOutput.add(
                "-----------------------------------\n" +
                "------- INICIANDO SIMULACAO -------\n" +
                "-----------------------------------\n"
        );
    }
    
    private void printEnd() throws IOException{
        this.saidaEscalonador.append(
                "-----------------------------------\n"+
                "------- Encerrando simulacao ------\n"+
                "-----------------------------------"
        );
        
        this.textPaneOutput.add(
                "-----------------------------------\n"+
                "------- Encerrando simulacao ------\n"+
                "-----------------------------------"
        );
    }
    
    private void printInitGrafico(String tipo) throws IOException{
        this.saidaGrafico.append(String.format("****** GRÁFICO DO ESCALONADOR %s******\n", tipo));
    }
    
    private void printProcessoGrafico(int tempInit, Process cpu) throws IOException{
        if(cpu != null){
            this.saidaGrafico.append(String.format("|(%d)%s ", tempInit, cpu.pidName));
        }
    }

    private void printEndGrafico() throws IOException{
        this.saidaGrafico.append("| \nTempo de espera de cada processo:\n");
        this.textPaneOutput.add("\nTempo de espera de cada processo:\n");
        float tempMedio = 0;
        
        for(Process p : this.processList){
            this.saidaGrafico.append(String.format("%s: %d\n", p.pidName, p.waitTime));
            this.textPaneOutput.add(String.format("%s: %d\n", p.pidName, p.waitTime));
            tempMedio += p.waitTime;
        }
        
        tempMedio /= this.processList.size();
        
        this.saidaGrafico.append(String.format("Tempo de espera médio: %.2f", tempMedio));
        
        this.textPaneOutput.add(String.format("Tempo de espera médio: %.2f ", tempMedio));
        this.textPaneOutput.add("\n-----------------------------------\n");
        this.textPaneOutput.add("Finis Simulatione!\n");
        this.textPaneOutput.add("Gratias Quia Attendere!");
    }
}