/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.FileManager;
import model.RoundRobin;
import view.FileSelector;
import view.Input;

/**
 *
 * @author eu
 */
public class Controller {
      private Input janelaInput;
      private FileSelector janelaFiles;
      private int quantum;
      private String inputFilePath;
      private String outputFilesPath;
      private Thread t1 = new Thread();   
      private Thread t2 = new Thread();
      private Thread t3 = new Thread();

    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenHeight = screenSize.height/2;
    int screenWidth = screenSize.width/2;  
    
    public Controller(Input janela) {        
    this.janelaInput = janela;
    this.janelaInput.setBounds((screenWidth-(janela.getWidth()/2)),(screenHeight-(janela.getHeight()/2)),janela.getWidth(),janela.getHeight());
    this.janelaInput.setVisible(true);
    }
    
    public Controller() {
    }
    
    public void execute(int quantum, int time) throws IOException{
        this.quantum = quantum;
        int secTime = time*1000;
        
        FileManager fileManager1 = new FileManager(this.inputFilePath, this.outputFilesPath + "/saidaRR.txt", this.outputFilesPath + "/graficoRR.txt");
        FileManager fileManager2 = new FileManager(this.inputFilePath, this.outputFilesPath + "/saidaFifo.txt", this.outputFilesPath + "/graficoFifo.txt");
        FileManager fileManager3 = new FileManager(this.inputFilePath, this.outputFilesPath + "/saidaSjf.txt", this.outputFilesPath + "/graficoSjf.txt");
        
        RoundRobin roundRobin1 = new RoundRobin(this.quantum, fileManager1.readFile(), fileManager1);
        RoundRobin roundRobin2 = new RoundRobin(this.quantum, fileManager2.readFile(), fileManager2);
        RoundRobin roundRobin3 = new RoundRobin(this.quantum, fileManager3.readFile(), fileManager3);
        
        roundRobin1.schedule();
        roundRobin2.fifoSchedule();
        roundRobin3.sjfSchedule();

        JOptionPane.showMessageDialog(this.janelaInput, "Arquivos gerados com sucesso!", "Execução concluída", JOptionPane.INFORMATION_MESSAGE);
        
        if(this.t1.isAlive()){
            this.t1.stop();
            this.t2.stop();
            this.t3.stop();
        }
        
        this.t1 = new Thread(new Runnable() {@Override public void run() {
            for(String s : roundRobin1.textPaneOutput){
                if(s.equals(";")){
                    try {
                        Thread.sleep(secTime);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    janelaInput.rrTextAreaAppend(s);
                }
            }
        }});
        
        this.t2 = new Thread(new Runnable() {@Override public void run() {
            for(String s : roundRobin2.textPaneOutput){
                if(s.equals(";")){
                    try {
                        Thread.sleep(secTime);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    janelaInput.fifoTextAreaAppend(s);
                }
            }
        }});
        
        this.t3 = new Thread(new Runnable() {@Override public void run() {
            for(String s : roundRobin3.textPaneOutput){
                if(s.equals(";")){
                    try {
                        Thread.sleep(secTime);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    janelaInput.sjfTextAreaAppend(s);
                }
            }
        }});
        
        this.janelaInput.cleanTextAreas();
        
        this.t1.start();
        this.t2.start();
        this.t3.start();
    }
    
    public void lineExecute(int quantum, String inputPath) throws IOException{
        this.quantum = quantum;
        this.inputFilePath = inputPath;
        this.outputFilesPath = ".\\files";
        
        FileManager fileManager1 = new FileManager(this.inputFilePath, this.outputFilesPath + "\\saidaRR.txt", this.outputFilesPath + "\\graficoRR.txt");
        FileManager fileManager2 = new FileManager(this.inputFilePath, this.outputFilesPath + "\\saidaFifo.txt", this.outputFilesPath + "\\graficoFifo.txt");
        FileManager fileManager3 = new FileManager(this.inputFilePath, this.outputFilesPath + "\\saidaSjf.txt", this.outputFilesPath + "\\graficoSjf.txt");
        
        RoundRobin roundRobin1 = new RoundRobin(this.quantum, fileManager1.readFile(), fileManager1);
        RoundRobin roundRobin2 = new RoundRobin(this.quantum, fileManager2.readFile(), fileManager2);
        RoundRobin roundRobin3 = new RoundRobin(this.quantum, fileManager3.readFile(), fileManager3);
        
        roundRobin1.schedule();
        roundRobin2.fifoSchedule();
        roundRobin3.sjfSchedule();
    }
    
    public void mostarFiles(){
//        try{
//            this.quantum = Integer.parseInt(this.janelaInput.getQuantumField().getText());
//        }catch(Exception e){
//             JOptionPane.showMessageDialog(janelaInput, "Formato de número inválido, erro: \n  "
//                     + e, "Erro de formatação", JOptionPane.INFORMATION_MESSAGE);
//        }
        
        this.janelaInput.setVisible(false);
        
        JFileChooser input = new JFileChooser();
        disableNewFolderButton(input);
        int result = input.showSaveDialog(this.janelaInput);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            this.inputFilePath = input.getSelectedFile().getAbsolutePath();
            this.outputFilesPath = input.getCurrentDirectory().getAbsolutePath();
        } else if (result == JFileChooser.CANCEL_OPTION) {
            this.janelaInput.setjTextPanelSaida(" ");
            this.inputFilePath = " ";
            this.outputFilesPath = " ";
//            this.janelaInput.setSizejFrameWindow();
        }
        
        this.janelaInput.setVisible(true);
        this.janelaInput.setjTextPanelSaida(String.format("Arquivo: %s \nDiretório de saída: %s", this.inputFilePath, this.outputFilesPath) );
        
//        this.janelaFiles.setBounds((screenWidth-(janelaFiles.getWidth()/2)),(screenHeight-(janelaFiles.getHeight()/2)),janelaFiles.getWidth(),janelaFiles.getHeight());
//        this.janelaFiles.setVisible(true);
    }
    
//     public void fecharFiles(){
//        try{
//            this.inputFilePath = this.janelaFiles.getFilePath();            
//            this.outputFilesPath = this.janelaFiles.getOutputPath();
//            
//            this.janelaFiles.dispose();
//        }catch(Exception e){}
//        
//        this.janelaInput.setVisible(true);
//        this.janelaInput.setjTextPanelSaida(String.format("Arquivo: %s \nDiretório de saída: %s", this.inputFilePath, this.outputFilesPath) );
//        
////        Input janelaInput = new Input();
////        janelaInput.setBounds((screenWidth-(janelaInput.getWidth()/2)),(screenHeight-(janelaInput.getHeight()/2)),janelaInput.getWidth(),janelaInput.getHeight());
////        janelaInput.setVisible(true);
////        janelaInput.setQuantumField(this.quantum != 0 ? String.format("%d", quantum) : "Digite um valor");
//    }
     
     public void disableNewFolderButton(Container c) {
        int len = c.getComponentCount();
        for (int i = 0; i < len; i++) {
            Component comp = c.getComponent(i);
            if (comp instanceof JButton) {
                JButton b = (JButton) comp;
                Icon icon = b.getIcon();
                if (icon != null && icon == UIManager.getIcon("FileChooser.newFolderIcon")){
                    b.setVisible(false);
                }
            } else if (comp instanceof Container) {
                disableNewFolderButton((Container) comp);
            }
        }
    }
}
