/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller;

import java.io.FileNotFoundException;
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
    public static void main(String[] args) throws FileNotFoundException {
        FileManager fileManager = new FileManager("/home/eu/Documentos/projectProcessScheduling/RoundRobinProcessScheduling/src/controller/teste.txt");
        
        RoundRobin roundRobin = new RoundRobin(5, fileManager.readFile());
        
        roundRobin.schedule();
    }
}
