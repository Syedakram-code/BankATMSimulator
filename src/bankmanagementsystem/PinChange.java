package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    String pinnumber;
    JPasswordField pinField,rePinField;
    JButton change,back;
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(240,260,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        JLabel pinText = new JLabel("New PIN:");
        pinText.setBounds(150,320,180,35);
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System",Font.BOLD,16));
        image.add(pinText);
        
        pinField = new JPasswordField();
        pinField.setFont(new Font("Raleway",Font.BOLD,16));
        pinField.setBounds(265,320,180,35);
        image.add(pinField);
        
        JLabel rePinText = new JLabel("Re-Enter PIN:");
        rePinText.setBounds(150,360,180,35);
        rePinText.setForeground(Color.WHITE);
        rePinText.setFont(new Font("System",Font.BOLD,16));
        image.add(rePinText);
        
        rePinField = new JPasswordField();
        rePinField.setFont(new Font("Raleway",Font.BOLD,16));
        rePinField.setBounds(265,360,180,35);
        image.add(rePinField);
        
        change = new JButton("CHANGE");
        change.setBounds(310,432,140,25);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(310,462,140,25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(800,760);
        setLocation(300,20);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == change){
             try{
             String newPin = pinField.getText();
             String rePin = rePinField.getText();
             if(!newPin.equals(rePin)){
                 JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                 return;
             }
             if(newPin.equals("")){
                 JOptionPane.showMessageDialog(null,"Please Enter New Pin");
                 return;
             }
             if(rePin.equals("")){
                 JOptionPane.showMessageDialog(null,"Please Re-Enter New Pin");
                 return;
             }
             Conn conn = new Conn();
             String query1 = "update bank set pin = '"+rePin+"' where pin = '"+pinnumber+"'";
             String query2 = "update login set pin = '"+rePin+"' where pin = '"+pinnumber+"'";
             String query3 = "update signupthree set pinNumber = '"+rePin+"' where pinNumber = '"+pinnumber+"'";
             
             conn.s.executeUpdate(query1);
             conn.s.executeUpdate(query2);
             conn.s.executeUpdate(query3);
              
             JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
             
             setVisible(false);
             new Transactions(rePin).setVisible(true);
             }catch(Exception e){
             System.out.println(e);
         }
         }else{
             setVisible(false);
             new Transactions(pinnumber).setVisible(true);
         }
    }
    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}
