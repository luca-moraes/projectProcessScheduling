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
        String filePath;
        int quantum;
        
        if(args.length == 2){
            quantum = Integer.parseInt(args[0]);
            filePath = args[1];
            
            Controller control = new Controller();
            control.lineExecute(quantum, filePath);
        }else{
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int screenHeight = screenSize.height/2;
            int screenWidth = screenSize.width/2;


            Input janela = new Input();
            janela.setTitle("Scheduling Interface");
            janela.setBounds((screenWidth-(janela.getWidth()/2)),(screenHeight-(janela.getHeight()/2)),janela.getWidth(),janela.getHeight());
            janela.setVisible(true);
        }
    }
}
