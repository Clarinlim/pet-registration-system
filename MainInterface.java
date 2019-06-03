/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class MainInterface {
public static ArrayList<Pet> pet = new <Pet>ArrayList();
public static File outFile = new File("Clarin.txt");
public static String[] columnNames = { " No.","ID", "Type", "Name" }; 
public static DefaultTableModel tablemodel =new DefaultTableModel(columnNames,0);

    private static void insertFile(){
        try{
           FileWriter outFileStream =new FileWriter(outFile); // STORE INTO FILE
           PrintWriter outStream = new PrintWriter(outFileStream);
           
           for(int i =0;i<pet.size();i++){
               outStream.print (Integer.toString(i+1)+",");
               outStream.print(pet.get(i).getID()+",");
               outStream.print(pet.get(i).getType()+",");
               outStream.println(pet.get(i).getName());
        }
           outStream.close();
        }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,"Error in insertFile");
         }   
    }
    public static void loadFile(){
        try{
            Scanner scanner =new Scanner (outFile);
            String data;
            int i =1;
            
            while(scanner.hasNextLine()){
                data=scanner.nextLine();
                String dataArr[]=data.split(",");
                
                dataArr[0] = Integer.toString(i);
                pet.add(new Pet(dataArr[1],dataArr[2],dataArr[3]));//add the id, type,name back to arraylist.
                tablemodel.addRow(dataArr);
                i++;
                
            }
            scanner.close();
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null,"empty file");
        }
    }
    
        
        
public static void showFoundItem(int i){
            JOptionPane.showMessageDialog(null,"Search item found!\nID: "+pet.get(i).getID() +"\nType:"+pet.get(i).getType() +"\nName:"+ pet.get(i).getName());
       }
    public static void replaceData(){ //delete old data and replace with a new data
        try{
     outFile.delete();
     outFile.createNewFile();
     FileWriter fileOutStream = new FileWriter(outFile);
     PrintWriter outStream= new PrintWriter(fileOutStream); //store the data into a file
     for (int i=0;i<pet.size();i++){
            outStream.print(Integer.toString(i+1)+",");
            outStream.print(pet.get(i).getID()+",");
            outStream.print(pet.get(i).getType()+",");
            outStream.println(pet.get(i).getName());
        }
            outStream.close();
            
            Scanner scanner = new Scanner (outFile);
            String data;
            int i =1; // to assign row number
            while(scanner.hasNextLine()){
                data = scanner.nextLine(); // scan the first row 
                String dataArr[]=data.split(","); // e.g （hi, hihi)
                dataArr[0] = Integer.toString(i);
                
                tablemodel.addRow(dataArr);// put the data into the table
                i++;
            }
            scanner.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"empty file");
        }
        
    }
    public MainInterface() {
        JFrame frame = new JFrame("Pet Registration System");
        
         JLabel jlbtittle =new JLabel("MainInterface");
        jlbtittle.setBounds(10,0,100,20);
        
        JLabel Jlb =new JLabel ("Pet's id");
        Jlb.setBounds(40,40,180,20);
        JLabel Jlb2=new JLabel("Type of Pet");
        Jlb2.setBounds(40,80,180,20);
        JLabel Jlb3 = new JLabel("Name of Pet");
        Jlb3.setBounds(40,120,180,20);
        JTextField Jtf1 =new JTextField ();
        Jtf1.setBounds(120,40,100,20);
        JTextField Jtf2=new JTextField();
        Jtf2.setBounds(120,80,200,20);
        JTextField Jtf3=new JTextField();
        Jtf3.setBounds(120,120,200,20);
        JButton btn1=new JButton("Insert");
        btn1.setBounds(40,150,80,20);
        JButton btn2=new JButton("Delete");
        btn2.setBounds(120,150,80,20);
        JButton btn3=new JButton("Search");
        btn3.setBounds(200,150,80,20);
        JButton btn4=new JButton("Update");
        btn4.setBounds(280,150,80,20);
        JTable jt=new JTable(tablemodel);
        JScrollPane jsptable =new JScrollPane(jt);
        jsptable.setBounds(40,200,300,200);
        jsptable.setVisible(true);
        
                frame.add(Jtf1);
                frame.add(Jtf2);
                frame.add(Jtf3);
                frame.add(Jlb);
                frame.add(Jlb2);
                frame.add(Jlb3);
                frame.add (jlbtittle);
                frame.add(btn1);
                frame.add(btn2);
                frame.add(btn3);
                frame.add(btn4);
                frame.add(jsptable);
                
                
               
                frame.setSize(400,500);
                frame.setLayout(null);
                frame.setVisible(true);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                loadFile();
                
                btn1.addActionListener(new ActionListener() { //add button
             @Override
             public void actionPerformed(ActionEvent e) {
                    String ID = Jtf1.getText(); // id
                    String Type = Jtf2.getText(); //type
                    String Name =Jtf3.getText(); //name
                 pet.add(new Pet(ID,Type,Name));
               insertFile(); //save to file.txt
            
               for(int i=pet.size()-1;i<pet.size();i++){ // display input in table
                    String[] data =new String [4];
                    
                    data[0]=String.valueOf(i+1);
                    data[1]=pet.get(i).getID();
                    data[2]=pet.get(i).getType();
                    data[3]=pet.get(i).getName();
                    
                    tablemodel.addRow(data); // display in row
                }
               
             }
});
                btn2.addActionListener(new ActionListener (){ //delete button
                   @Override
                  public void actionPerformed(ActionEvent e){
                      String ID =Jtf1.getText(); 
                      boolean delete =false; //to run joptionpane if not item found in for loop
                      for(int i=0;i<pet.size();i++){
                          if(ID.equals(pet.get(i).getID())){
                           pet.remove(pet.get(i)); //delete the object
                           tablemodel.getDataVector().removeAllElements(); //remove all rows in jtable
                           replaceData(); //delete ,create display in table 
                           delete=true;
                          }
                      }
                      if(pet.isEmpty()){ // if array is empty
                          tablemodel.fireTableDataChanged(); //reset the table
                      }else if(delete == false){
                          JOptionPane.showMessageDialog(null,"Can't find the data");
                      }
                  }
 });
                btn3.addActionListener(new ActionListener (){
                    @Override
        public void actionPerformed(ActionEvent e)   { //search button
           String ID =Jtf1.getText();
           boolean search = false;
           for(int i=0;i<pet.size(); i++){
           if(ID.equals(pet.get(i).getID())){
               showFoundItem(i);
               search=true;
           }
           }
           if(search==false){
               JOptionPane.showMessageDialog(null,"Cannot find this item!");
           }
        }
    });
        btn4.addActionListener(new ActionListener(){ //update button
        @Override
        public void actionPerformed(ActionEvent e){
            String ID,Type,Name;
            ID=Jtf1.getText();
            boolean update= false;
            for(int i=0;i<pet.size();i++){
                
                if(ID.equals(pet.get(i).getID())){
                
                   Type=Jtf2.getText(); //write new type
                   Name=Jtf3.getText(); // write new name
                   
                   pet.get(i).setType(Type); //set a new data
                   pet.get(i).setName(Name); //set a new data(setter method)
                   
                   tablemodel.getDataVector().removeAllElements(); //remove all data in table
                   replaceData();
                   update=true;
                  
                }
            }
            if(pet.isEmpty()){
            JOptionPane.showMessageDialog(null,"No data found");
            
        }
            else if(update == false)
                JOptionPane.showMessageDialog(null,"Item Not Found");
        }
    });
}

}