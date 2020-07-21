/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMicroProject;

/**
 *
 * @author Abhimanyu
 */
  

import opennlp.tools.stemmer.PorterStemmer;

public class TextPreprocess {

    public String[] preprocess(String k) {
      //String i = "http://192.168.182.201:9085/Kolkatasouth1/WISHN/Home.jsp the broqn fox, jumps over the lazy dog.";
        Array_OP a = new Array_OP();
        String[] output = a.master(k);
       // a.array_of_string_print(output
       String[] preprocessed = output;
       PorterStemmer p = new PorterStemmer();
        for (int i = 0; i < preprocessed.length; i++)
        {
           preprocessed[i] = p.stem(preprocessed[i]);
        }
        return preprocessed;
        
         
          
          
    }
    
}
