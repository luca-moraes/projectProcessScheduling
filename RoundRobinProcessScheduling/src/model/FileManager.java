/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lmoraes
 */
public class FileManager {
    public Scanner scan;
    public String filePath;
    public List<String> lines;
    
    public FileManager(String path){
        filePath = path;
        this.lines = new ArrayList<>();
    }
    
    public List<Process> readFile() throws FileNotFoundException{
        scan = new Scanner(new FileReader(this.filePath))
            .useDelimiter("\\n");
        
        while (scan.hasNext()) {
            lines.add(scan.next());
        }
        
        List<Process> processList = new ArrayList<>();
        
        for(String line : lines){
            String[] tempList = line.split(" ");
            
            Process newProcess = new Process(
                    tempList[0],
                    Integer.parseInt(tempList[1]),
                    Integer.parseInt(tempList[2])
            );
            
            if(tempList.length > 3){
                String[] ioList = tempList[3].split(",");
                
                for(String io : ioList){
                    newProcess.addIo(Integer.parseInt(io));            
                }
            }
            
            processList.add(newProcess);
        }
        
        return processList;
    }
}
