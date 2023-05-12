/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import view.Input;

/**
 *
 * @author eu
 */
public class Controller {
      private Input janela;
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenHeight = screenSize.height/2;
    int screenWidth = screenSize.width/2;  
    
    public Controller(Input janela) {        
    this.janela = janela;
    this.janela.setBounds((screenWidth-(janela.getWidth()/2)),(screenHeight-(janela.getHeight()/2)),janela.getWidth(),janela.getHeight());
    this.janela.setVisible(true);
    }
    
    
}
