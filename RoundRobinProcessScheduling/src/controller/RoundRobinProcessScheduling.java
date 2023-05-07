/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import model.FileManager;
import model.RoundRobin;

/**
 *
 * @author lmoraes
 */
public class RoundRobinProcessScheduling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String filePath;
        int quantum;
        
        if(args.length == 2){
            quantum = Integer.parseInt(args[0]);
            filePath = args[1];
        }
        
        FileManager fileManager = new FileManager("/home/eu/Documentos/projectProcessScheduling/RoundRobinProcessScheduling/src/controller/teste.txt");
        
        RoundRobin roundRobin = new RoundRobin(4, fileManager.readFile(), fileManager);
        
        roundRobin.schedule();
    }
}
