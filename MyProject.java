/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class MyProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
        JFrame frame =new JFrame("Pet Registration System");
        
        JLabel jlbtittle =new JLabel("Login Sistem");
        jlbtittle.setBounds(10,0,100,20);
        
         JLabel Jlb =new JLabel ("Name");
        Jlb.setBounds(40,40,150,20);
        JLabel Jlb2=new JLabel("Password");
        Jlb2.setBounds(40,80,180,20);
        JTextField Jtf1 =new JTextField ();
        Jtf1.setBounds(120,40,200,20);
        JTextField Jtf2=new JTextField();
        Jtf2.setBounds(120,80,200,20);     
        JButton btn1=new JButton("Login");
        btn1.setBounds(120,120,90,20);
        JButton btn2=new JButton("Cancel");
        btn2.setBounds(220,120,80,20);
        
       
                frame.add(Jtf1);
                frame.add(Jtf2);
                frame.add(Jlb);
                frame.add(Jlb2);
                frame.add (jlbtittle);
                frame.add(btn1);
                frame.add(btn2);
         
                frame.setSize(400,200);
                frame.setLayout(null);
                frame.setVisible(true);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
              btn1.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                    String name = Jtf1.getText();
                    String pass = Jtf2.getText();
                    if (name.equals("Clarin") && (pass.equals("12345"))){
                        JOptionPane.showMessageDialog(null, "Welcome to the System");
                        frame.setVisible(false);
                        new MainInterface();
                    }else{
                        JOptionPane.showMessageDialog(null, "Login Failed");
                    }
             }
         });
              btn2.addActionListener(new ActionListener(){ //CANCEL BUTTON
                  @Override
                  public void actionPerformed(ActionEvent e){
                      frame.setVisible(false);
                      frame.dispose();
                      
                  }
              });
                        }
}


    
    

