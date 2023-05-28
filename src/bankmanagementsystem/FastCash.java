package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    String pinnumber;
    JButton deposite,cashWithdrawl,fastCash,miniStatement,pinChange,balEnquiry,exit;
   
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);
        
        JLabel text = new JLabel("Select FastCash Withdrawl Amount");
        text.setBounds(212,260,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,12));
        image.add(text);
        
        deposite = new JButton("Rs 100");
        deposite.setBounds(150,370,140,25);
        deposite.addActionListener(this);
        image.add(deposite);
        
        cashWithdrawl = new JButton("Rs 500");
        cashWithdrawl.setBounds(310,370,140,25);
        cashWithdrawl.addActionListener(this);
        image.add(cashWithdrawl);
        
        fastCash = new JButton("Rs 1000");
        fastCash.setBounds(150,401,140,25);
        fastCash.addActionListener(this);
        image.add(fastCash);
         
        miniStatement = new JButton("Rs 2000");
        miniStatement.setBounds(310,401,140,25);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinChange = new JButton("Rs 5000");
        pinChange.setBounds(150,432,140,25);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balEnquiry = new JButton("Rs 10000");
        balEnquiry.setBounds(310,432,140,25);
        balEnquiry.addActionListener(this);
        image.add(balEnquiry);
        
        exit = new JButton("Back");
        exit.setBounds(310,462,140,25);
        exit.addActionListener(this);
        image.add(exit);
       
        setSize(800,760);
        setLocation(300,20);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String wAmount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try{
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int bal = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                     bal += Integer.parseInt(rs.getString("amount"));
                    }else{
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != exit && bal < Integer.parseInt(wAmount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+wAmount+"')";
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Rs."+wAmount+" Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(SQLException e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]) {
        new FastCash("");
    }
}

