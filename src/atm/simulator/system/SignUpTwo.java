package atm.simulator.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{
   
   
   JTextField panTextField,aadharTextField;
   JButton next;
   JRadioButton Exyes,Exno,no,yes;
   JComboBox rel,cat,inc,edu,occup;
   String formno;

   
   SignUpTwo(String formno){ 
       this.formno = formno;
       setLayout(null);
       
       setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
       
       
       
       JLabel additionalDetails = new JLabel("Page 2: Additional Details" );
       additionalDetails.setFont(new Font("Raleway", Font.BOLD,20));
       additionalDetails.setBounds(290,80,400,30);
       add(additionalDetails);
       
       JLabel religion = new JLabel("Religion : " );
       religion.setFont(new Font("Raleway", Font.BOLD,20));
       religion.setBounds(100,140,100,30);
       add(religion);
       
       String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
       rel = new JComboBox(valReligion);
       rel.setBounds(300,140,400,30);
       rel.setBackground(Color.WHITE);
       add(rel);
       
       JLabel category = new JLabel("Category : " );
       category.setFont(new Font("Raleway", Font.BOLD,20));
       category.setBounds(100,190,200,30);
       add(category);
       
       String valCategory[] = {"General","OBC","SC","ST","Other"};
       cat = new JComboBox(valCategory);
       cat.setBounds(300,190,400,30);
       cat.setBackground(Color.WHITE);
       add(cat);
       
       JLabel income = new JLabel("Income : " );
       income.setFont(new Font("Raleway", Font.BOLD,20));
       income.setBounds(100,240,200,30);
       add(income);
       
       String incomeCategory[] = {"Null","< 1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
       inc = new JComboBox(incomeCategory);
       inc.setBounds(300,240,400,30);
       inc.setBackground(Color.WHITE);
       add(inc);    

       
       JLabel education = new JLabel("Educational : " );
       education.setFont(new Font("Raleway", Font.BOLD,20));
       education.setBounds(100,290,200,30);
       add(education);
       
       JLabel qualification = new JLabel("Qualification : " );
       qualification.setFont(new Font("Raleway", Font.BOLD,20));
       qualification.setBounds(100,315,200,30);
       add(qualification);
       
       String educationValue[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
       edu = new JComboBox(educationValue);
       edu.setBounds(300,315,400,30);
       edu.setBackground(Color.WHITE);
       add(edu);  
       
       JLabel occupation = new JLabel("Occupation : " );
       occupation.setFont(new Font("Raleway", Font.BOLD,20));
       occupation.setBounds(100,390,200,30);
       add(occupation);
       
       String occupationValue[] = {"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
       occup  = new JComboBox(occupationValue);
       occup.setBounds(300,390,400,30);
       occup.setBackground(Color.WHITE);
       add(occup); 
       
       
       JLabel pan = new JLabel("PAN Number : " );
       pan.setFont(new Font("Raleway", Font.BOLD,20));
       pan.setBounds(100,440,200,30);
       add(pan);
       
       panTextField = new JTextField();
       panTextField.setFont(new Font("Raleway", Font.BOLD,14));
       panTextField.setBounds(300,440,400,30);
       add(panTextField);
       
       JLabel aadhar = new JLabel("Aadhar Number : " );
       aadhar.setFont(new Font("Raleway", Font.BOLD,20));
       aadhar.setBounds(100,490,200,30);
       add(aadhar);
       
       aadharTextField = new JTextField();
       aadharTextField.setFont(new Font("Raleway", Font.BOLD,14));
       aadharTextField.setBounds(300,490,400,30);
       add(aadharTextField);
       
       JLabel seniorcitizen = new JLabel("Senior Citizen : " );
       seniorcitizen.setFont(new Font("Raleway", Font.BOLD,20));
       seniorcitizen.setBounds(100,540,200,30);
       add(seniorcitizen);
       
       yes = new JRadioButton("Yes");
       yes.setBounds(300,540,100,30);
       yes.setBackground(Color.WHITE);
       add(yes);
       
       no = new JRadioButton("No");
       no.setBounds(450,540,100,30);
       no.setBackground(Color.WHITE);       
       add(no);
       
       ButtonGroup senCitizen = new ButtonGroup();
       senCitizen.add(yes);
       senCitizen.add(no);
          
       
       JLabel account = new JLabel("Existing Account : " );
       account.setFont(new Font("Raleway", Font.BOLD,20));
       account.setBounds(100,590,200,30);
       add(account);
       
       Exyes = new JRadioButton("Yes");
       Exyes.setBounds(300,590,100,30);
       Exyes.setBackground(Color.WHITE);
       add(Exyes);
       
       Exno = new JRadioButton("No");
       Exno.setBounds(450,590,100,30);
       Exno.setBackground(Color.WHITE);       
       add(Exno);
       
       ButtonGroup Exist = new ButtonGroup();
       Exist.add(yes);
       Exist.add(no);
       
       next = new JButton("Next");
       next.setBackground(Color.BLACK);
       next.setForeground(Color.WHITE);
       next.setFont(new Font("Raleway", Font.BOLD,14));
       next.setBounds(620,660,80,30);
       next.addActionListener(this);
       add(next);
       
       
       getContentPane().setBackground(Color.WHITE);
       
       setSize(850,800);
       setLocation(350,10);
       setVisible(true);
   }
   
   public void actionPerformed(ActionEvent ae){
       
       String sreligion = (String)rel.getSelectedItem();
       String scategory = (String)cat.getSelectedItem();
       String sincome = (String)inc.getSelectedItem();
       String seducation = (String)edu.getSelectedItem();
       String soccupation = (String)occup.getSelectedItem();
       String seniCitizen = null;

       if(yes.isSelected()){
           seniCitizen = "Yes";
       }
       else if (no.isSelected()){
            seniCitizen = "No";
       }
    
       String Existacc = null;
       if(Exyes.isSelected()){
           Existacc = "Yes";
       }
       else if (Exno.isSelected()){
           Existacc = "No";
       }
       
       String pan = panTextField.getText();
       String aadhar = aadharTextField.getText();

       
       try{
              Conn c = new Conn();
              String query = "insert into signuptwo values('"+ formno + "', '"+ sreligion + "', '"+ scategory + "', '"+ sincome + "', '"+ seducation + "', '"+ soccupation + "', '"+ seniCitizen + "', '"+ Existacc + "', '"+ pan + "', '"+ aadhar + "')";
              c.s.executeUpdate(query);
              
              setVisible(false);
                    
              new SignUpThree(formno).setVisible(true);
        
       }catch(Exception e){
           System.out.println(e);
       }

          
   }
    
   public static void main(String[] args){
       new SignUpTwo("");
   } 
}
