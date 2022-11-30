package registration;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.*;

public class user  extends admin{
	

	Scanner s= new Scanner(System.in);
	
	JPanel panel;
	JFrame frame;
	 JLabel userlabel;
	 JTextField usertext;
	 JLabel frontlabel;
	 JPasswordField passtext;
	 JButton studentB;
	 JButton adminB;
	JLabel successlabel;
	
	 user() {		
		 
			frame=new JFrame();
		 	panel=new JPanel();
		 	frame. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 	frame.setSize(450,200);
		 	frame.add(panel);
			panel.setLayout(null);
			frame.setLocationRelativeTo(null); 
				Color c1=new Color(	51,204,255);//blue color code
				
				frontlabel=new JLabel("login as");
 				frontlabel.setFont(new Font("Serif", Font.PLAIN, 22));
 				panel.setBackground(c1);
 				frontlabel.setBounds(60,60,185,25);
 				panel.add(frontlabel);
 				
				
			
			
 				studentB=new JButton("student");
 				studentB.setBounds(150, 65, 110, 25);
 				panel.add(studentB);
 				
 				studentB.addActionListener(new ActionListener() {
 				public void actionPerformed(ActionEvent e) {
 					
 						System.out.println("student");
 						student st=new student();
 						frame.dispose();
 						st.login();
 						
 						
 					
 				}});
 				
 				
 				adminB=new JButton("admin");
 				adminB.setBounds(280, 65, 110, 25);
 				panel.add(adminB);
 				
 				adminB.addActionListener(new ActionListener() {
 	 				public void actionPerformed(ActionEvent e) {
 	 					System.out.println("admin");
 	 					///admin a=new admin();
 	 					frame.dispose();
 	 					login();	
 	 				}});
 				
 				frame.add(panel);
 				
 				frame.setVisible(true);

	}

	
}
