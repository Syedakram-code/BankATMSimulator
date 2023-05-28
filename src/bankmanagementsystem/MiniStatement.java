package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
    String pinnumber;
    MiniStatement(String pinnumber){
        this.pinnumber = pinnumber;
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(20, 110, 400, 200);
        add(mini);
        
        JLabel bankName = new JLabel("Indian Bank");
        bankName.setBounds(150,20,100,20);
        bankName.setFont(new Font("System",Font.BOLD,16));
        add(bankName);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);
        try{
            Conn conn = new Conn();
            ResultSet rs1 = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs1.next()){   
                card.setText("Card Number:  "+ rs1.getString("cardnumber").substring(0,4)+"-XXXX-XXXX-"+rs1.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            int balance = 0;
            Conn conn = new Conn();
            ResultSet rs2 = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs2.next()){
                mini.setText(mini.getText() + "<html>"+rs2.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs2.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs2.getString("amount") + "<br><html>");
                if(rs2.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs2.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs2.getString("amount"));
                }
            }
            l4.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
            System.out.println(e);
        }
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
    
    }
    public static void main(String args[]) {
        new MiniStatement("");
    }
}
