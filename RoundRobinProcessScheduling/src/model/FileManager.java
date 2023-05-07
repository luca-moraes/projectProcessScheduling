/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lmoraes
 */
public class FileManager {
    public Scanner scan;
    public BufferedWriter buffWrite;
    public String filePath;
    public String outputFile = "/home/eu/Documentos/projectProcessScheduling/RoundRobinProcessScheduling/src/controller/saida.txt";
    public List<String> lines;
    public Charset encoding = Charset.forName("UTF-8");
    
    public FileManager(String path){
        filePath = path;
        this.lines = new ArrayList<>();
        this.createFile();
    }
    
    public List<Process> readFile() throws FileNotFoundException, IOException{
        scan = new Scanner(new FileReader(this.filePath, encoding))
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
        
        scan.close();
        
        return processList;
    }
    
    private void createFile(){
        try {
            Path path= Paths.get(this.outputFile);
            Files.delete(path);
        }
        catch (IOException e) {}
        
        try {
            PrintWriter writer = new PrintWriter(this.outputFile, this.encoding);
            writer.println("Output result: ");
            writer.close();
        }
        catch (IOException e) {}
    }
    
    public void openBuffer() throws IOException{
      buffWrite = new BufferedWriter(new FileWriter(this.outputFile, encoding));  
    }
    
    public void escritor(String content) throws IOException {
        buffWrite.append(content);
    }
    
    public void closeBuffer() throws IOException{
        buffWrite.close();
    }
}
