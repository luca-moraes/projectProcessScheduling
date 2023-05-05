/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
    }
    
    public List<String> readFile() throws FileNotFoundException{
        scan = new Scanner(new FileReader(this.filePath))
            .useDelimiter("\\n");
        
        while (scan.hasNext()) {
            lines.add(scan.next());
        }
    
        return lines;
    }
}
