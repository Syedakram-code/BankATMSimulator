
package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    String pinnumber;
    JTextField amountTextField;
    JButton deposit,back;
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(155,270,400,20);
        image.add(text);
        
        amountTextField = new JTextField("500");
        amountTextField.setFont(new Font("Raleway",Font.BOLD,12));
        amountTextField.setBounds(155,320,280,30);
        amountTextField.setBackground(Color.gray);
        image.add(amountTextField);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(310,430,140,25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back = new JButton("Back");
        back.setBounds(310,460,140,25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(800,760);
        setLocation(300,20);
//        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            String dAmount = amountTextField.getText();
            Date date = new Date();
            
            if(dAmount.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }else{
                try{
                   Conn conn = new Conn();
                   String q = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+dAmount+"')";
                   conn.s.executeUpdate(q);
                   
                   JOptionPane.showMessageDialog(null, "Rs."+dAmount+" has been Deposited Successfully");
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
                }catch(SQLException e){
                    System.out.println(e);
                }
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
       new Deposit("");
    }
}
