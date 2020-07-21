/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMicroProject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author Abhimanyu
 */
public class CSVwriter {
    public void write(List <String> s, int flag, String path) throws Exception
    {
        if(flag == 1)
        {
            s.add("Y");
        }
        if(flag == 2)
        {
            s.add("N");
        }
        
            
        String s_joined = String.join(",", s);
        //System.out.println(s_joined);
        FileWriter f = new FileWriter(path, true); //This is the prepared dataset for weka
        BufferedWriter bw = new BufferedWriter(f);
        PrintWriter p = new PrintWriter(bw);
        
        p.println(s_joined);
        p.flush();
        p.close();
       
        //PrintStream p = new PrintStream("D:/Projects/dataset.txt");
        //System.setOut(p);
        //System.out.println(s_joined);
    }
}
