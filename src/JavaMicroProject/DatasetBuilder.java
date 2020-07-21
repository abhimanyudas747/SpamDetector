/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMicroProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;


/**
 *
 * @author Abhimanyu
 */
public class DatasetBuilder {

  
    public static void build( String rawdata) throws Exception {
        // TODO code application logic here
        TextPreprocess t = new TextPreprocess();
       
        String[] preprocessed;
        StringBuffer Big = new StringBuffer();
        String[] Bigsplit;
        
        File f = new File(rawdata);  //This is the raw dataset
    InputStream is = new FileInputStream(f);
    BufferedReader bf = new BufferedReader(new InputStreamReader(is));
    bf.readLine();
    String s;
   // int ctr = 0;
    for(int j = 0; j <f.length(); j++)
    try{s = bf.readLine();
        if(s.split(",")[0].equals("spam"))
        {
            preprocessed = t.preprocess(s.split(",")[1]);
            for (String i : preprocessed)
            {
                Big.append("-"+i);
            }    
            
        }
        
    }
    catch(Exception e){}
//    System.out.println(ctr);
    
    
            
          //  System.out.println(Big);
     Bigsplit = Big.toString().split("-");
      List <String> spam_words = new ArrayList();
      Bigsplit = freq(Bigsplit);
      for(String i : Bigsplit)
      {
        if(!(i.equals("a")||i.equals("in") ||i.equals("")|| i.equals("the")||i.equals("p")||i.equals("u")||i.equals("the")||i.equals("to")||i.equals("or")||i.equals("on")||i.equals("is")||i.equals("for")||i.equals("have")||i.equals("�") ))
        {
           spam_words.add(i);
           //System.out.println(i);
        } 
        //System.out.println(i);

      }
      spam_words.add("spam");
      CSVwriter writer = new CSVwriter();
      /* List <String> n = new ArrayList();
      n.add("fdf");
      writer.write(n, fd);*/
    
      writer.write(spam_words, 0, "store.csv"); //This is the final dataset for weka
      //System.out.println(t.preprocess("www.google.com")[0]);
      bf.close();
      InputStream io = new FileInputStream(f);
      BufferedReader bf2 = new BufferedReader(new InputStreamReader(io));
     // bf2.reset();
      bf2.readLine();
      for(int j = 0; j <f.length(); j++)
      {
          s = bf2.readLine();
          preparedataset(spam_words ,s);
         // System.out.println(s);
      }
     
        
}
        
     public static String[] freq(String[] ls)
     {
         HashMap<String, Integer> elementcount = new HashMap<String, Integer>();
    String[] spam_words;
    StringBuffer s = new StringBuffer();
    for (String i : ls)
    {
        if(elementcount.containsKey(i))
        {
            elementcount.put(i, elementcount.get(i)+1);
        }
        else
        {
            elementcount.put(i,1);
        }
    }
    Set<Entry<String, Integer>> entryset = elementcount.entrySet();
    for (Entry<String, Integer> entry : entryset)
    {
        if(entry.getValue() > 50)
        {
            s.append("-"+entry.getKey());
        }
    }
    //System.out.print(elementcount.entrySet());
    spam_words = s.toString().split("-");
    return spam_words;
   }
   
    public static void preparedataset(List <String> si, String s) throws Exception
    {
    String[] preprocessed;    
    TextPreprocess t = new TextPreprocess();
   
    //String s = new String();
    int ctr = 0;
    List <String> op = new ArrayList();
  //  for(int q = 0; q <f.length(); q++)
       
   
    si.remove("spam");
    try{preprocessed = t.preprocess(s.split(",")[1]);   
    for(String i : si)
    {
      ctr = 0;
      for (String j : preprocessed)
      {
          if(i.equals(j))
          {
              ctr++;
          }
      }
      //System.out.println(ctr);
      op.add(String.valueOf(ctr));
    }
    } catch(Exception e){}
    //System.out.println(op);
    CSVwriter writer = new CSVwriter();
  try{  if(s.split(",")[0].equalsIgnoreCase("spam"))
    {
     writer.write(op, 1, "store.csv");  //1 means the message is spam
    }
    else
        writer.write(op,2, "store.csv");  //2 means the message is not spam
  }
  catch(Exception e)
  {}
}

    
    
}
    
    

           
   
    
    

