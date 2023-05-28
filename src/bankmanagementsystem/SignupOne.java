package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;  
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
    JButton next;
    JRadioButton male,fmale,other,married,unmarried;
    JDateChooser dateChooser;
    SignupOne(){
        
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway" , Font.BOLD , 30));
        formno.setBounds(200,20,600,40);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("Raleway" , Font.BOLD , 20));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway" , Font.BOLD , 20));
        name.setBounds(120,140,100,30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway" , Font.BOLD , 10));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway" , Font.BOLD , 20));
        fname.setBounds(120,190,200,30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway" , Font.BOLD , 10));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway" , Font.BOLD , 20));
        dob.setBounds(120,240,200,30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway" , Font.BOLD , 20));
        gender.setBounds(120,290,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,100,30);
        male.setBackground(Color.WHITE);
        add(male);
        fmale = new JRadioButton("Female");
        fmale.setBounds(400,290,100,30);
        fmale.setBackground(Color.WHITE);
        add(fmale);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(fmale);
        
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway" , Font.BOLD , 20));
        email.setBounds(120,340,200,30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway" , Font.BOLD , 10));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
        
        JLabel martial = new JLabel("Martial Status:");
        martial.setFont(new Font("Raleway" , Font.BOLD , 20));
        martial.setBounds(120,390,200,30);
        add(martial);
        
        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        other = new JRadioButton("Other");
        other.setBounds(500,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup maritialGroup = new ButtonGroup();
        maritialGroup.add(married);
        maritialGroup.add(unmarried);
        maritialGroup.add(other);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway" , Font.BOLD , 20));
        address.setBounds(120,440,200,30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway" , Font.BOLD , 10));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway" , Font.BOLD , 20));
        city.setBounds(120,490,200,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway" , Font.BOLD , 10));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway" , Font.BOLD , 20));
        state.setBounds(120,540,200,30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway" , Font.BOLD , 10));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway" , Font.BOLD , 20));
        pincode.setBounds(120,590,200,30);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway" , Font.BOLD , 10));
        pincodeTextField.setBounds(300,590,400,30);
        add(pincodeTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = "";
        if(male.isSelected()){
            gender = "Male";
        }else if(fmale.isSelected()){
            gender = " Female";
        }
        String email = emailTextField.getText();
        String marital = "";
        if(married.isSelected()){
            marital = "Married";
        }else if(unmarried.isSelected()){
            marital = "Unmarried";
        }else if(other.isSelected()){
            marital = "Other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pincodeTextField.getText();
        
        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"Father's name is Required");
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"Date of Birth is Required");
            }else if(gender.equals("")){
                JOptionPane.showMessageDialog(null,"Gender is Required");
            }else if(email.equals("")){
                JOptionPane.showMessageDialog(null,"Email is Required");
            }
            else if(marital.equals("")){
                JOptionPane.showMessageDialog(null,"Marital is Required");
            }
            else if(address.equals("")){
                JOptionPane.showMessageDialog(null,"Address is Required");
            }
            else if(city.equals("")){
                JOptionPane.showMessageDialog(null,"Email is Required");
            }else if(state.equals("")){
                JOptionPane.showMessageDialog(null,"State is Required");
            }else if(pin.equals("")){
                JOptionPane.showMessageDialog(null,"Pin Code is Required");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]) {
        new SignupOne();
    }
}
