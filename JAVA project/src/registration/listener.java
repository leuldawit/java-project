package registration;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class listener extends student implements ActionListener{
	student a;
	
	public listener(student a) {
		this.a = a;
	}
	
public void actionPerformed(ActionEvent e) {
	
	if(e.getSource()==a.allcoursesb) {
			
		studentViewAllCourses();
		
		
	}
	else if(e.getSource()==a.availableb) {
		
		
		
		viewAvailableCourses();
		
		
	}
	else if(e.getSource()==a.registerb) {
		 
		 Thread hilo = new Thread(new Runnable() {

             @Override
             public void run() {

                 //here your code
            	registerToCourse();

             }
         });         
         hilo.start();
		
		
		
		
	}
	else if(e.getSource()==a.withdrawb) {
		 
		withdrawFromCourse();  
				
	}
		
//		if(e.getSource()==a.continueb) {
//			String Id=a.tmno.getText();
//			validation v=new validation();
//			if(v.validateSID(Id)) {
//			a.remove = new JButton("Remove");
//			a.remove.setFont(new Font("Arial", Font.PLAIN, 15));
//			a.remove.setSize(100, 20);
//			a.remove.setLocation(150, 450);
//			 l = new listener(this);
//			 a.remove.addActionListener(l);
//		    a.c.add(a.remove);
//a.frame.setLayout(null);
//		    a.reset = new JButton("Reset");
//		    a.reset.setFont(new Font("Arial", Font.PLAIN, 15));
//		    a. reset.setSize(100, 20);
//		    a.reset.setLocation(270, 450);
//		    l = new listener(this);
//		    a.reset.addActionListener(l);
//		   a. c.add(a.reset);
//		    
//		   a. name = new JLabel("Enter course Name to withdraw from");
//		   a.name.setFont(new Font("Arial", Font.PLAIN, 13));
//		   a. name.setSize(190, 100);
//		   a. name.setLocation(80, 200);
//		    
//		    a.c.add(a.name);
//
//		    a.tname = new JTextField();
//		    a.tname.setFont(new Font("Arial", Font.PLAIN, 15));
//		    a. tname.setSize(190, 20);
//		    a. tname.setLocation(200, 200);
//		   a. c.add(a.tname);
//		    a.frame.setVisible(true);
//		    
//		    
//			}
//			else {
//				a.res =new JLabel();
//				a.res.setText("please enter the sid properly ");
//				a. res.setBounds(80, 255,300, 100);
//		          a. frame.setVisible(true);
//		           } 
//			
//			
//
//			
//		
//		
//		
//	}
	
		if(e.getSource()==a.withdraw) {
			
			String Id=a.tmno.getText();
			System.out.println(Id);
			String cname=a.tname.getText();
			validation v=new validation();
		     String connectionstring="jdbc:sqlserver://LAPTOP-T23BOQMU:1433;Database=university;encrypt=true;trustServerCertificate=true"	;
			    String user="sa";
			    String pass="1234";
			  
			    try {
			    	try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
			    		
			    		Statement st=connection.createStatement();	
			    		
			 ResultSet results = st.executeQuery("select distinct * from courses_taken left join course on courses_taken.cid=course.cid  ");
			int id=0;
			int cid=0;
				while (results.next()) {
					
					if(v.validateSID(Id)&&v.checkcourseName(cname)) {
						 id = Integer.parseInt(Id);
					if( id==results.getInt(1)&& cname.equals(results.getString(5) )) {
						cid=results.getInt(4);
						break;
						}
					
					}
					}
				System.out.println(cid);
						String Query=" update course set numberofstudents-=1 where cid=? ";
					      PreparedStatement preparedStmt = connection.prepareStatement(Query);
					      preparedStmt.setInt (1, cid);
					      preparedStmt.executeUpdate(); 
					      
						Query="delete from courses_taken where cid=? and sid=?";
						 preparedStmt = connection.prepareStatement(Query);
					      preparedStmt.setInt (1, cid);
					      preparedStmt.setInt (2, id);
					      preparedStmt.executeUpdate();  	
						System.out.println("succcessfully removed");
						
						
						connection.close();
						st.close();
						preparedStmt.close();
						results.close();

					
						
					
					
					

		    
		     
		     
			  a.frame.setVisible(true);
		    
		   	 } 
			
		}catch(SQLException c) {
		 		System.out.println("error");
				c.printStackTrace();
			}	
		}
		
	 if(e.getSource()==a.registeredb) {
//		panel.removeAll();
//		frame.setVisible(false); 
		viewAllRegisteredCourses();
		

	}
	
	if(e.getSource()==a.sub) {
		try {
			String connectionstring="jdbc:sqlserver://LAPTOP-T23BOQMU:1433;Database=university;encrypt=true;trustServerCertificate=true"	;
		String user="sa";
		String pass="1234";
			try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
				
				Statement st=connection.createStatement();	
				
				
				String query="select count(*) from course where maxstudents!=numberofstudents"; 
				ResultSet results = st.executeQuery(query);
				
				 query="select * from course where maxstudents!=numberofstudents";
				 results = st.executeQuery(query);
				System.out.println("Available courses are ");
				System.out.println("course ID \t course name\t availabe places");
				
				while (results.next()) {
					int id = results.getInt(1);
					 String coursename = results.getString(2);
					 int maxst=results.getInt(3);
					 int NoSt=results.getInt(4);
					 int available=maxst-NoSt;
					 
					 System.out.println( id + "\t\t" + coursename+ "\t\t" + "\t\t" +available);	}
				
				
			

		    if (e.getSource() == a.sub) {
		    	String id=a.tmno.getText();
		    	String cname=a.tname.getText();
		            validation v=new validation();
		        	System.out.println(v.validateSID(id));
		        	System.out.println(v.checkcourseName(cname));
//		          
		        if ( v.validateSID(id) && v.checkcourseName(cname)) {
		        	int sid = Integer.parseInt(id); 
		        	int cid=0;
		        	int tid=0;
		        	String Query="update course set numberofstudents+=1 where coursename=?";
				     PreparedStatement preparedStmt = connection.prepareStatement(Query);
				      preparedStmt.setString (1,cname);
				      preparedStmt.executeUpdate();    
				    
				      results =st.executeQuery("select * from course");
				     while (results.next()) {
				    	 if(cname.equals(results.getString(2))) {
								cid=results.getInt(1);
								tid=results.getInt(5);
								break;
							}
							
				     }
			      Query="insert into courses_taken(sid,cid,tid) values(?,?,?)";
			      System.out.println("1");
				      preparedStmt = connection.prepareStatement(Query);
				      preparedStmt.setInt (1, sid);
				      preparedStmt.setInt (2, cid);	
				      preparedStmt.setInt (3, tid);	
				      preparedStmt.executeUpdate();
				      
				     System.out.println("succesfully added to the course");
				     
				     a.frame.setVisible(true);
				     
				connection.close();
				st.close();
				preparedStmt.close();
				results.close();
		            a.res.setText("Registered Successfully..");
		        
		        }
		        else {
		            if(!v.validateSID(id)) {
		          a. res.setText("please enter the sid properly ");
		          a. res.setBounds(80, 255,300, 100);
		            }
		            
		            if(!v.checkcourseName(cname)) {
		            	
		            a.res.setText("please enter the course name properly ");
		                a. res.setBounds(80, 180,300, 100);
		                 
		            	}
//		            
		        }
		    }

		connection.close();
		st.close();
		//preparedStmt.close();
		results.close();}




		}catch(SQLException a) {
		System.out.println("error");
		a.printStackTrace();
			
		}
	}
	
	 if (e.getSource() == a.reset) {
        String def = "";
       a. tname.setText(def);
   //     tadd.setText(def);
        a.tmno.setText(def);
//        res.setText(def);
//        tout.setText(def);
//        term.setSelected(false);
//        date.setSelectedIndex(0);
//        month.setSelectedIndex(0);
//        year.setSelectedIndex(0);
//        resadd.setText(def);
    }
	 
	 if(e.getSource()==a.view) {
		 try {
				String connectionstring="jdbc:sqlserver://LAPTOP-T23BOQMU:1433;Database=university;encrypt=true;trustServerCertificate=true"	;
			String user="sa";
			String pass="1234";
				try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
					
					Statement st=connection.createStatement();	
		    		String query="select distinct count (*)  from courses_taken left join course on courses_taken.cid=course.cid ";
		   		ResultSet results = st.executeQuery(query);
		   		String Id=a.tmno.getText();
		   		int countrow=0;
		    while(results.next()) {
				 countrow = results.getInt(1);
				 break;
			}
			
		   		String [][] row=new String [countrow][2];
		   		String[] column={"Course ID", "Course Name"};
		   	    int i=0;
		   		int id = 0;
		   		int cid=0;

		   	    query="select distinct * from courses_taken left join course on courses_taken.cid=course.cid ";
		   	    results = st.executeQuery(query);
		   	    validation v=new validation();
		   	   if(v.validateSID(Id)) { 
		   	 while (results.next()) {
		   		 
		   		
		   		 id = Integer.parseInt(Id);
		   			if(results.getInt(1)==id) {
		   				 cid = results.getInt(2);
		   				 row[i][0]=String.valueOf(cid);
		   				String coursename = results.getString(5);
		   				row[i][1]=coursename;
		   				System.out.println(cid+coursename);
		   				i++;
		   		}
		   			
		   			
		   		}
		   	   }
		   	   System.out.println(cid +""+ id);
		   	   if(cid==0) {
		   		   
		   		   
		   	   }
		   	 table=new JTable(row,column);
		     
		   	 
		  
		   	rightPanel= new JPanel();
		   	 rightPanel.add(new Label("THE COURSES YOU ARE TAKING"));
		     a.frame.setSize(1000,500);
		     a.frame.setLayout(null);
		    // rightPanel.setBounds(470, 65, 500, 400);
		   	// rightPanel.setLayout(null);
		    
		  // a.leftPanel.setBounds(0, 0,0 ,0);
		     a.leftPanel.setSize(500,900);
			    rightPanel.setBounds(500, 0, 500, 400);
			    table.setBounds(470,0,100, 50);
		     //table.setBounds(0, 0,50, 50);
		     rightPanel.add(new JScrollPane(table));
		     a.frame.add(a.leftPanel);
		     a.frame.add( rightPanel);
		     
		     a.leftPanel.setVisible(true);
					
				
				connection.close();
				st.close();
				results.close();
				a.frame.add(a.leftPanel);
				a.frame.add(rightPanel);
			a.frame.setVisible(true);

					
				}}catch(SQLException c) {
					System.out.println("error");
				}
		 
	 }
	
	}
	



}
