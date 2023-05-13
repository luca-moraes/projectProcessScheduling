/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import model.FileManager;
import model.RoundRobin;
import view.Input;

/**
 *
 * @author lmoraes
 */
public class RoundRobinProcessScheduling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screenSize.height/2;
        int screenWidth = screenSize.width/2;

        
        Input janela = new Input();
        janela.setBounds((screenWidth-(janela.getWidth()/2)),(screenHeight-(janela.getHeight()/2)),janela.getWidth(),janela.getHeight());
        janela.setVisible(true);
        
        String filePath;
        int quantum;
        
        if(args.length == 2){
            quantum = Integer.parseInt(args[0]);
            filePath = args[1];
        }
        
//        FileManager fileManager1 = new FileManager("C:\\Users\\unielumoraes\\Downloads\\projectProcessScheduling-main\\RoundRobinProcessScheduling\\src\\files\\teste.txt");
//        FileManager fileManager2 = new FileManager("C:\\Users\\unielumoraes\\Downloads\\projectProcessScheduling-main\\RoundRobinProcessScheduling\\src\\files\\teste.txt");
//        FileManager fileManager3 = new FileManager("C:\\Users\\unielumoraes\\Downloads\\projectProcessScheduling-main\\RoundRobinProcessScheduling\\src\\files\\teste.txt");
//
//        fileManager2.escalonadorFile = "C:\\Users\\unielumoraes\\Downloads\\projectProcessScheduling-main\\RoundRobinProcessScheduling\\src\\files\\saidaFifo.txt";
//        fileManager3.escalonadorFile = "C:\\Users\\unielumoraes\\Downloads\\projectProcessScheduling-main\\RoundRobinProcessScheduling\\src\\files\\saidaSjf.txt";
//        
//        fileManager2.graficoFile = "C:\\Users\\unielumoraes\\Downloads\\projectProcessScheduling-main\\RoundRobinProcessScheduling\\src\\files\\graficoFifo.txt";
//        fileManager3.graficoFile = "C:\\Users\\unielumoraes\\Downloads\\projectProcessScheduling-main\\RoundRobinProcessScheduling\\src\\files\\graficoSjf.txt";
//        
//        RoundRobin roundRobin1 = new RoundRobin(4, fileManager1.readFile(), fileManager1);
//        RoundRobin roundRobin2 = new RoundRobin(4, fileManager2.readFile(), fileManager2);
//        RoundRobin roundRobin3 = new RoundRobin(4, fileManager3.readFile(), fileManager3);
//        
//        roundRobin1.schedule();
//        roundRobin2.fifoSchedule();
//        roundRobin3.sjfSchedule();
        
    }
    
}
