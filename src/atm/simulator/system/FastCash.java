package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton one,two,three,four,five,six,back;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Select withdrawal amount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);
        
        one = new JButton("Rs 100");
        one.setBounds(170,415,150,30);
        one.addActionListener(this);
        image.add(one);
        
        two = new JButton("Rs 500");
        two.setBounds(355,415,150,30);
        two.addActionListener(this);
        image.add(two);
        
        three = new JButton("Rs 1000");
        three.setBounds(170,450,150,30);
        three.addActionListener(this);
        image.add(three);
        
        four = new JButton("Rs 2000");
        four.setBounds(355,450,150,30);
        four.addActionListener(this);
        image.add(four);
        
        five = new JButton("Rs 5000");
        five.setBounds(170,485,150,30);
        five.addActionListener(this);
        image.add(five);
        
        six = new JButton("Rs 10000");
        six.setBounds(355,485,150,30);
        six.addActionListener(this);
        image.add(six);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("Select * from bank where pin ='" +pinnumber+"'" );
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw', '"+amount+"' )";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " +amount+ " Debited Successfully");
                
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
        }
        }
    }
    
    public static void main(String[] args){
        new FastCash("");
    }
}
