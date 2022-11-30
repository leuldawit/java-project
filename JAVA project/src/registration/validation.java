package registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class validation   {
	
	Scanner s =new Scanner(System.in); 
	String connectionstring="jdbc:sqlserver://LAPTOP-T23BOQMU:1433;Database=university;encrypt=true;trustServerCertificate=true"	;
	String user="sa";
	String pass="1234";
	

	public boolean checkgpa(String str) { 
		  try {  
		    Double gpa=Double.parseDouble(str); 
		    if(gpa>1 &&gpa<=4) {
		    
		    return true;}
		  } catch(NumberFormatException e){  
		    return false;  
		  }
		return false;  
		}
	public boolean checkteacher(String str) {
		
		String query="select * from teacher "; 
		
		try {
		try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
			System.out.println("done");
			Statement st=connection.createStatement();
			 try {  
				    int id=Integer.parseInt(str); 
				    
				    
				      
				
			 
			ResultSet results = st.executeQuery(query);
			while (results.next()) {
				
				if( id == results.getInt(1))	{
					return true;
					
					
					}
				
				 	}
			connection.close();
		st.close();
		results.close();		
			} catch(NumberFormatException e){  
				    return false;  
				  }
			
	

			}
		
	}catch(SQLException e) {
		System.out.println("error");
		e.printStackTrace();
	}
		return false;

		
	}
	
public boolean checkCID(int cid) {
	
	

	String query="select * from course where maxstudents!=numberofstudents"; 
	
		try {
		try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
			System.out.println("done");
			Statement st=connection.createStatement();	
			 
			ResultSet results = st.executeQuery(query);
			while (results.next()) {
				
				if( cid == results.getInt(1))	{
					return true;
					
					
					}
				
				 	}
			connection.close();
		st.close();
		results.close();		
			
			
	

			}
		
	}catch(SQLException e) {
		System.out.println("error");
		e.printStackTrace();
	}
		return false;
	
	
	
	
	
	

}


public int validateCID(int cid) {
	
	
	boolean bool=false;
	String query="select * from course where maxstudents!=numberofstudents"; 
	do {
		try {
		try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
			System.out.println("done");
			Statement st=connection.createStatement();	
			 
			ResultSet results = st.executeQuery(query);
			while (results.next()) {
				
				if( cid == results.getInt(1))	bool=true;
				
				 	}
			if(bool==false) {
				System.out.println("The course ID you entered is not available! Please Re-enter.");
				boolean bool1;
				
				try  {	
					bool1=true;
				cid=s.nextInt();
				
				
						
						}catch(InputMismatchException e){
							bool1=false;
							do {
								bool1=true;
								try {
									
									cid=s.nextInt();
								
							}catch(InputMismatchException a){
								bool1=false;
							}
								if(bool1==false) {
									System.out.println("please enter the course ID only");}
									} while(bool1==false);
							
						}
				
		        
				
				
				
			}
			
		connection.close();
		st.close();
		results.close();
	

			}
		
	}catch(SQLException e) {
		System.out.println("error");
		e.printStackTrace();
	}
	
	
	}while(bool==false);
	
	return cid;
	

}




public boolean validateSID(String ssid) {
	
	
	boolean bool=false;
	int sid;
	try {
        sid = Integer.parseInt(ssid);
    
      
       //cid=valid.validateCID(cid);
  } catch (NumberFormatException e) {
      return false;}
  
	String query="select * from student"; 
	
		try {
		try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
			System.out.println("done");
			Statement st=connection.createStatement();	
			 
			ResultSet results = st.executeQuery(query);
			while (results.next()) {
				
				if( sid == results.getInt(1))	{
					connection.close();
		st.close();
		results.close();
		return true;
		}
				
				 	}
			
			}
						
		
	}catch(SQLException e) {
		System.out.println("error");
		e.printStackTrace();
	}
		return false;
	
	
	
	
	

}


 boolean validatecourseName(String name) {
	
	String query="select * from course where maxstudents!=numberofstudents"; 
	
		try {
		try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
			System.out.println("done");
			Statement st=connection.createStatement();	
			 
			ResultSet results = st.executeQuery(query);
			while (results.next()) {
				
				if( name.equals(results.getString(2)) )	return true;
				
				 	}
	
			
		connection.close();
		st.close();
		results.close();
	

			}
		
	}catch(SQLException e) {
		System.out.println("error");
		e.printStackTrace();
	}
	
	
	
	
		
		return false;

	
}


public boolean checkcourseName(String name) {
	
	try {
		String query="select * from course where maxstudents!=numberofstudents"; 
		
		try {
		try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
			System.out.println("done");
			Statement st=connection.createStatement();	
			 
			ResultSet results = st.executeQuery(query);
			while (results.next()) {
				
				if( name.equals(results.getString(2)) )	{
					
					connection.close();
					st.close();
					results.close();
					return true;
				}
				
				 	}
			
		connection.close();
		st.close();
		results.close();
		

			}
		
	}catch(SQLException e) {
		System.out.println("error");
		e.printStackTrace();
	}

    
      
       //cid=valid.validateCID(cid);
  } catch (NumberFormatException e) {
      return false;}
		
	
	
	
		
		return false;

	
}

}