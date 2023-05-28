
package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    String pinnumber;
    JTextField amountTextField;
    JButton withdraw,back;
    Withdrawl(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,14));
        text.setBounds(155,270,400,20);
        image.add(text);
        
        amountTextField = new JTextField("500");
        amountTextField.setFont(new Font("Raleway",Font.BOLD,12));
        amountTextField.setBounds(155,320,280,30);
        amountTextField.setBackground(Color.gray);
        image.add(amountTextField);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(310,430,140,25);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
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
        if(ae.getSource() == withdraw){
            String wAmount = amountTextField.getText();
            Date date = new Date();
            
            if(wAmount.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            }else{
                try{
                   Conn conn = new Conn();
                   ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                   int bal = 0;
                   while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            bal += Integer.parseInt(rs.getString("amount"));
                        } else {
                            bal -= Integer.parseInt(rs.getString("amount"));
                        }
                   }
                   System.out.println(bal);
                   if (bal < Integer.parseInt(wAmount)) {
                       JOptionPane.showMessageDialog(null, "Insufficient Balance");
                       return;
                   }
                   
                   String q = "insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+wAmount+"')";
                   conn.s.executeUpdate(q);
                   
                   JOptionPane.showMessageDialog(null, "Rs."+wAmount+" withdraw Successfully");
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
       new Withdrawl("");
    }
}

