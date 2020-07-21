/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMicroProject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.Logistic;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Abhimanyu
 */
public class LogisticRegressor {
   
    public static void classifymessage(String msg, Logistic l) throws Exception
    {
        DataSource src = new DataSource("store.csv");
        Instances data = src.getDataSet();
        Instance i = getInstance(msg, data);
        src = null;
        System.gc();
        classify(i,l);
        
        File f = new File("temp.csv");
        f.delete();
        
        
    }
    public static Logistic train_model() throws Exception
    {
        String path = "store.csv"; 
        DataSource src = new DataSource(path);
        
        Instances data = src.getDataSet();
        src = null;
        System.gc();
        data.setClassIndex(data.numAttributes()-1);
        Logistic l = new Logistic();
        Evaluation e = new Evaluation(data);
        e.crossValidateModel(l, data, 10, new Random(1));
        JOptionPane.showMessageDialog(null,e.toSummaryString(false)); //Msg Dialog
        l.buildClassifier(data);
        return l;
    }
    public static void classify(Instance i, Logistic l) throws Exception
    {
        JFrame f;
       if(l.classifyInstance(i) < 0.5)
        {
            System.out.println("The message is spam");
            //f = new JFrame();
            JOptionPane.showMessageDialog(null, "This message is spam");
            //JOptionPane.
        }
        else
        {
            System.out.println("The message is not spam");
             //f = new JFrame();
            JOptionPane.showMessageDialog(null, "This message is not spam");
        }
        //System.out.println(i);
        
        System.out.println(l.classifyInstance(i));
    }
    public static Instance getInstance(String msg, Instances dataset) throws Exception
    {
        TextPreprocess tp = new TextPreprocess();
        String[] preprocessed = tp.preprocess(msg);
        List <String> atts = new ArrayList();
        for(int i = 0; i < dataset.numAttributes(); i++)
        {
            atts.add(dataset.attribute(i).name());
        }
       // System.out.println(msg);
        preparedataset(atts, msg);
        DataSource ipsrc = new DataSource("temp.csv");
        Instances ins = ipsrc.getDataSet();
        ins.setClassIndex(ins.numAttributes()-1);
        ipsrc = null;
        System.gc();
        return ins.get(0);
        
    }
    public static void preparedataset(List <String> si, String s) throws Exception
    {
    String[] preprocessed;    
    TextPreprocess t = new TextPreprocess();
   
    //String s = new String();
    int ctr = 0;
    List <String> op = new ArrayList();
  //  for(int q = 0; q <f.length(); q++)
       
   
    //si.remove("spam");
    try{preprocessed = t.preprocess(s);   
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
    
    
    //System.out.println(si);
    //System.out.println(op);
    CSVwriter writer = new CSVwriter();
    writer.write(si, 0, "temp.csv");
    writer.write(op, 0, "temp.csv");
    } catch(Exception e){}
    }
}
