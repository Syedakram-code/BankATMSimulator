
package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    String pinnumber;
    JButton deposite,cashWithdrawl,fastCash,miniStatement,pinChange,balEnquiry,exit;
   
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(212,260,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,12));
        image.add(text);
        
        deposite = new JButton("Deposit");
        deposite.setBounds(150,370,140,25);
        deposite.addActionListener(this);
        image.add(deposite);
        
        cashWithdrawl = new JButton("Cash Widthdrawl");
        cashWithdrawl.setBounds(310,370,140,25);
        cashWithdrawl.addActionListener(this);
        image.add(cashWithdrawl);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(150,401,140,25);
        fastCash.addActionListener(this);
        image.add(fastCash);
         
        miniStatement = new JButton("Mini-Statement");
        miniStatement.setBounds(310,401,140,25);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(150,432,140,25);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balEnquiry = new JButton("Balance Enquiry");
        balEnquiry.setBounds(310,432,140,25);
        balEnquiry.addActionListener(this);
        image.add(balEnquiry);
        
        exit = new JButton("Exit");
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
            System.exit(0);
        }else if(ae.getSource() == deposite){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource() == cashWithdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource() == fastCash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource() == pinChange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource() == balEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource() == miniStatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
        new Transactions("");
    }
}
