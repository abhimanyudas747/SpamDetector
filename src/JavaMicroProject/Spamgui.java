/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMicroProject;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import weka.classifiers.functions.Logistic;

/**
 *
 * @author admin
 */
public class Spamgui extends javax.swing.JFrame 
{

  
    public Spamgui() {
        initComponents();
        classify.setEnabled(false);
        train.setEnabled(false);
        panel.setVisible(false);
        jLabel4.setVisible(false);
    }
     
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        showpath = new javax.swing.JTextField();
        train = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        accept = new javax.swing.JLabel();
        classify = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Email Spam Detector");
        setResizable(false);
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Load Dataset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 70, 160, 30);

        showpath.setEditable(false);
        showpath.setBackground(new java.awt.Color(255, 255, 255));
        showpath.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        getContentPane().add(showpath);
        showpath.setBounds(10, 30, 960, 30);

        train.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        train.setText("Train Model");
        train.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trainMouseClicked(evt);
            }
        });
        train.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainActionPerformed(evt);
            }
        });
        getContentPane().add(train);
        train.setBounds(220, 70, 150, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Status:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(420, 70, 50, 30);

        accept.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        accept.setText("Not Trained");
        getContentPane().add(accept);
        accept.setBounds(470, 70, 90, 30);

        classify.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        classify.setText("Classify Email");
        classify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classifyActionPerformed(evt);
            }
        });
        getContentPane().add(classify);
        classify.setBounds(750, 70, 220, 30);

        panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon("D:\\Projects\\SpamDetector_final\\SpamDetector\\gear.gif")); // NOI18N
        panel.add(jLabel3);

        getContentPane().add(panel);
        panel.setBounds(260, 130, 430, 290);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 110, 960, 420);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Selected Dataset For Training :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 0, 280, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(590, 70, 130, 30);

        setSize(new java.awt.Dimension(1009, 574));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       JFileChooser chooser= new JFileChooser();
       chooser.showOpenDialog(null);
       File f=chooser.getSelectedFile();
       String filename=f.getAbsolutePath();
       showpath.setText(filename);
      
        JOptionPane.showMessageDialog(this,"Dataset Loaded");
        train.setEnabled(true);
        
       
       
    }//GEN-LAST:event_jButton1ActionPerformed
    Logistic l;
    public class trainModel extends Thread{
        
        public  void run(){
            panel.setVisible(true);
            jLabel4.setVisible(true);
            int i = 0;
            while(i<97)
            {
               try{ Thread.sleep(1000);}catch(Exception e){}
                i = i + 1;
                
                jLabel4.setText("Building Model "+i+"%");
            }
            //System.out.println("Thread running");
    }
    }
    public class threadtrain extends Thread{
        public void run(){
            String m,n;
         m="Trained";
         
         
            try
        {
                        
            
          //  File f = new File("store.csv");
           // f.delete();
            new File("store.csv").delete();
            DatasetBuilder db = new DatasetBuilder();
            db.build(showpath.getText());
            LogisticRegressor lr = new LogisticRegressor();
            l = lr.train_model();
            classify.setEnabled(true);
            train.setEnabled(false);
            panel.setVisible(false);
            jLabel3.setVisible(false);
            accept.setText(m);
            jLabel4.setVisible(false);
            new File("store.csv").deleteOnExit();
            
        }
                 
        catch
        (Exception e)
        {
            
        }
            
        }
    }
    
    private void trainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainActionPerformed
      
       trainModel object = new trainModel();
       threadtrain obj2 = new threadtrain();
       object.start();
       obj2.start();
       
    /*String m,n;
         m="Trained";
         
         
            try
        {
                        accept.setText(m);
            
          //  File f = new File("store.csv");
           // f.delete();
            new File("store.csv").delete();
            DatasetBuilder db = new DatasetBuilder();
            db.build(showpath.getText());
            LogisticRegressor lr = new LogisticRegressor();
            this.l = lr.train_model();
            classify.setEnabled(true);
            train.setEnabled(false);
            new File("store.csv").deleteOnExit();
            //panel.setVisible(false);
            //jLabel3.setVisible(false);
        }
                 
        catch
        (Exception e)
        {
            
        }*/
    }//GEN-LAST:event_trainActionPerformed

    private void classifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classifyActionPerformed
        // TODO add your handling code here:
       
        LogisticRegressor lr = new LogisticRegressor();
        try{
        lr.classifymessage(jTextArea1.getText(), this.l);
   
         
        //File f = new File("temp.csv");
        //f.delete();
        
        } catch(Exception e){}
    }//GEN-LAST:event_classifyActionPerformed

    private void trainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trainMouseClicked
        // TODO add your handling code here:
        //panel.setVisible(true);
        //jLabel3.setVisible(true);
    }//GEN-LAST:event_trainMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Spamgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Spamgui().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accept;
    private javax.swing.JButton classify;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField showpath;
    private javax.swing.JButton train;
    // End of variables declaration//GEN-END:variables
}
