package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    String pinnumber;
    JButton back;
    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(310,462,140,25);
        back.addActionListener(this);
        image.add(back);
        int bal = 0;
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        JLabel text = new JLabel("Your Account Balance is Rs "+bal);
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,30);
        image.add(text);
        
        setSize(800,760);
        setLocation(300,20);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}
