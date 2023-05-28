package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    String form;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    SignupThree(String form){
        this.form = form;
        setLayout(null);
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,20));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,20));
        type.setBounds(100,140,200,30);
        add(type);
        
        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,150,30);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,250,30);
        add(r2);
        
        r3 = new JRadioButton("Current Acccount");
        r3.setFont(new Font("Raleway",Font.BOLD,14));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,150,30);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,14));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,30);
        add(r4);
        
        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(r1);
        accountGroup.add(r2);
        accountGroup.add(r3);
        accountGroup.add(r4);
        
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,20));
        card.setBounds(100,300,200,30);
        add(card);
        JLabel cardDetail = new JLabel("(Your 16 Digit Card Number)");
        cardDetail.setFont(new Font("Raleway",Font.BOLD,10));
        cardDetail.setBounds(100,330,200,20);
        add(cardDetail);
        
        JLabel cNumber = new JLabel("XXXX-XXXX-XXXX-1234");
        cNumber.setFont(new Font("Raleway",Font.BOLD,20));
        cNumber.setBounds(330,300,300,30);
        add(cNumber);
        
        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,360,200,30);
        add(pin);
        JLabel pinDetail = new JLabel("(Your 4 Digit Pin Number)");
        pinDetail.setFont(new Font("Raleway",Font.BOLD,10));
        pinDetail.setBounds(100,390,200,20);
        add(pinDetail);
        
        JLabel pNumber = new JLabel("XXXX");
        pNumber.setFont(new Font("Raleway",Font.BOLD,20));
        pNumber.setBounds(330,360,300,30);
        add(pNumber);
        
        JLabel servicesRequired = new JLabel("Services required");
        servicesRequired.setFont(new Font("Raleway",Font.BOLD,20));
        servicesRequired.setBounds(100,430,200,30);
        add(servicesRequired);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,12));
        c1.setBounds(100,470,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,12));
        c2.setBounds(310,470,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,12));
        c3.setBounds(510,470,200,30);
        add(c3);
        
        c4 = new JCheckBox("EMAIL / SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,12));
        c4.setBounds(100,510,200,30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,12));
        c5.setBounds(310,510,200,30);
        add(c5);
        
        c6 = new JCheckBox("E-STATEMENT");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,12));
        c6.setBounds(510,510,200,30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that the above enterted details are correct to the best of my Knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,10));
        c7.setBounds(100,590,500,30);
        add(c7);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(520,650,100,40);
        cancel.addActionListener(this);
        add(cancel);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(630,650,100,40);
        submit.addActionListener(this);
        add(submit);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = "";
            if(r1.isSelected()){
                accountType = "Savings Account";
            }else if(r2.isSelected()){
                accountType = "Fixed Deposite Account";
            }else if(r3.isSelected()){
                accountType = "Current Account";
            }else if(r4.isSelected()){
                accountType = "Recurring Deposit Account";
            }
            
            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            String servicesRq = "";
            if(c1.isSelected()){
                servicesRq = servicesRq + " ATM Card";
            }else if(c2.isSelected()){
                servicesRq = servicesRq + " Internet Banking";
            }else if(c3.isSelected()){
                servicesRq = servicesRq + " Mobile Banking";
            }else if(c4.isSelected()){
                servicesRq = servicesRq + " EMAIL/SMS Alerts";
            }else if(c5.isSelected()){
                servicesRq = servicesRq + " Cheque Book";
            }else if(c6.isSelected()){
                servicesRq = servicesRq + " E-STATEMENT";
            }
            
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                }else if(servicesRq.equals("")){
                    JOptionPane.showMessageDialog(null, "Select atleast one Service");
                }else{
                    Conn conn = new Conn();
                    String q = "insert into signupthree values('"+form+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+servicesRq+"')";
                    String q2 = "insert into login values('"+form+"','"+cardNumber+"','"+pinNumber+"')";
                    conn.s.executeUpdate(q);
                    conn.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null,"Card Number:"+cardNumber+"\n Pin: "+pinNumber);
                    
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                }   
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String args[]) {
       new SignupThree("");
    }
}
