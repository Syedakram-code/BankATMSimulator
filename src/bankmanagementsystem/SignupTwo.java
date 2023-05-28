package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    JTextField pan,aadhar;
    JButton next;
    JRadioButton existingYes,existingNo,seniorYes,seniorNo;
    JComboBox religion,categories,incomeCategories,educationalDropdown,occupationDropdown;
    String formno; 
    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
            
        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway" , Font.BOLD , 20));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel rel = new JLabel("Religion:");
        rel.setFont(new Font("Raleway" , Font.BOLD , 20));
        rel.setBounds(120,140,100,30);
        add(rel);
        
        String valrelg[] = {"Hindu","Muslim","Sikh","Christian","Other"}; 
        religion = new JComboBox(valrelg);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway" , Font.BOLD , 20));
        category.setBounds(120,190,200,30);
        add(category);
        
        String valCategories[] = {"General","OBC","SC","ST","Other"};
        categories = new JComboBox(valCategories);
        categories.setBounds(300,190,400,30);
        categories.setBackground(Color.WHITE);
        add(categories);
        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway" , Font.BOLD , 20));
        income.setBounds(120,240,200,30);
        add(income);
        
        String incomeCategory[] = {"null","< 1,50,000","< 2,50,000","< 3,50,000","< 5,00,000","< 10,00,000"};
        incomeCategories = new JComboBox(incomeCategory);
        incomeCategories.setBounds(300,240,400,30);
        incomeCategories.setBackground(Color.WHITE);
        add(incomeCategories);
        
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway" , Font.BOLD , 20));
        qualification.setBounds(120,340,200,30);
        add(qualification);
        
        String valEducation[] = {"Non-Graduation","Graduate","Post Graduation","Doctrate","Other"};
        educationalDropdown = new JComboBox(valEducation);
        educationalDropdown.setBounds(300,340,400,30);
        educationalDropdown.setBackground(Color.WHITE);
        add(educationalDropdown);
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway" , Font.BOLD , 20));
        occupation.setBounds(120,390,200,30);
        add(occupation);
        
        String valOccupation[] = {"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
        occupationDropdown = new JComboBox(valOccupation);
        occupationDropdown.setBounds(300,390,400,30);
        occupationDropdown.setBackground(Color.WHITE);
        add(occupationDropdown);
      
        JLabel panNo = new JLabel("PAN Number:");
        panNo.setFont(new Font("Raleway" , Font.BOLD , 20));
        panNo.setBounds(120,440,200,30);
        add(panNo);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway" , Font.BOLD , 10));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel aadharNo = new JLabel("Aadhar Number:");
        aadharNo.setFont(new Font("Raleway" , Font.BOLD , 20));
        aadharNo.setBounds(120,490,200,30);
        add(aadharNo);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway" , Font.BOLD , 10));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway" , Font.BOLD , 20));
        seniorCitizen.setBounds(120,540,200,30);
        add(seniorCitizen);
        
        seniorYes = new JRadioButton("Yes");
        seniorYes.setBounds(300,540,100,30);
        seniorYes.setBackground(Color.WHITE);
        add(seniorYes);
        seniorNo = new JRadioButton("No");
        seniorNo.setBounds(400,540,100,30);
        seniorNo.setBackground(Color.WHITE);
        add(seniorNo);
        
        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(seniorYes);
        seniorGroup.add(seniorNo);
               
        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway" , Font.BOLD , 20));
        existingAccount.setBounds(120,590,200,30);
        add(existingAccount);
        
        existingYes = new JRadioButton("Yes");
        existingYes.setBounds(300,590,100,30);
        existingYes.setBackground(Color.WHITE);
        add(existingYes);
        existingNo = new JRadioButton("No");
        existingNo.setBounds(400,590,100,30);
        existingNo.setBackground(Color.WHITE);
        add(existingNo);
        
        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(existingYes);
        existingGroup.add(existingNo);
              
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
        String form = "" + formno;
        String sReligion = religion.getSelectedItem().toString();
        String sCatogories = (String) categories.getSelectedItem();
        String sIncome = (String)incomeCategories.getSelectedItem();
        String sEducation = (String) educationalDropdown.getSelectedItem();
        String sOccupation = (String) occupationDropdown.getSelectedItem();
        String sSeniorCitizen = "";
        if(seniorYes.isSelected()){
            sSeniorCitizen = "Yes";
        }else if(seniorNo.isSelected()){
            sSeniorCitizen = "No";
        }
        String sExistingAccount = "";
        if(existingYes.isSelected()){
            sExistingAccount = "Yes";
        }else if(existingNo.isSelected()){
            sExistingAccount = "No";
        }
        String sPan = pan.getText();
        String sAadhar = aadhar.getText();
        
        try {
            if(sReligion.equals("")){
                JOptionPane.showMessageDialog(null,"Religion is Required");
            }else if(sCatogories.equals("")){
                JOptionPane.showMessageDialog(null,"Category is Required");
            }else if(sIncome.equals("")){
                JOptionPane.showMessageDialog(null,"Income is Required");
            }else if(sEducation.equals("")){
                JOptionPane.showMessageDialog(null,"Education is Required");
            }else if(sOccupation.equals("")){
                JOptionPane.showMessageDialog(null,"Occupation is Required");
            }
            else if(sSeniorCitizen.equals("")){
                JOptionPane.showMessageDialog(null,"SeniorCitizen is Required");
            }
            else if(sExistingAccount.equals("")){
                JOptionPane.showMessageDialog(null,"Existing Account is Required");
            }
            else if(sPan.equals("")){
                JOptionPane.showMessageDialog(null,"Pan Number is Required");
            }else if(sAadhar.equals("")){
                JOptionPane.showMessageDialog(null,"Aadhar Number is Required");
            }else{
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+form+"','"+sReligion+"','"+sCatogories+"','"+sIncome+"','"+sEducation+"','"+sOccupation+"','"+sSeniorCitizen+"','"+sExistingAccount+"','"+sPan+"','"+sAadhar+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(form).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]) {
        new SignupTwo("");
    }
}
