/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
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
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenHeight = screenSize.height/2;
    int screenWidth = screenSize.width/2;  
    
    public Controller(Input janela) {        
    this.janelaInput = janela;
    this.janelaInput.setBounds((screenWidth-(janela.getWidth()/2)),(screenHeight-(janela.getHeight()/2)),janela.getWidth(),janela.getHeight());
    this.janelaInput.setVisible(true);
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
            System.out.println("Open was selected");
            this.inputFilePath = input.getSelectedFile().getAbsolutePath();
            this.outputFilesPath = input.getCurrentDirectory().getAbsolutePath();
        } else if (result == JFileChooser.CANCEL_OPTION) {
            this.inputFilePath = " ";
            this.outputFilesPath = " ";
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
