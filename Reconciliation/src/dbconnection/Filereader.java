package myapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dbconnection.Jdbc;

public class Filereader {
	//private static Object string;
//	private static String sql;

	public static void main(String args[]) throws IOException, SQLException {
		Jdbc jd=new Jdbc();
		final String COMMA_DELIMITER = ",";
		int i,j;
		 String sql="INSERT INTO BANK_BOOK (ABCODE,BANK_NAME,ENT_DATE,CHALLAN_NO,CHALLAN_DT,APPL_NAME,DEP_HEAD,DEP_AMT) VALUES(?,?,?,?,?,?,?,?)";
	
	BufferedReader br=new BufferedReader(new FileReader("E:\\Reconciliation_Data/challan_LDAR.csv"));
	
	String line=null;
	  Connection con = jd.getConnection();
	  
	  PreparedStatement ps=null;
	  ps=con.prepareStatement(sql);
	  int count=0;
	while ((line = br.readLine()) != null)
	  {
		  count++;
		  if(count==1)
		  {
			  continue;
			  
		  }
		  
		 // System.out.println(line);
	  String[] challan=line.split(COMMA_DELIMITER);
      System.out.println(challan[4]);
      System.out.println(challan[15]);
	   String[] a=challan[4].split("-|\\/");
	   String c="0";
	   if(a[0].length()==1)
	   {
		   a[0]=c+a[0];
		   
	   }
	   else if(a[1].length()==1)
	   {
		   a[1]=c+a[1];
	   }
	//  System.out.println(a[1]+"-"+a[0]);
	  String challannew = null;
	  try {
	  challannew=a[2]+"-"+a[0]+"-"+a[1];
	  
	  System.out.println(challannew);
	  }catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  System.out.println(challan[6]);
	   String[] b=challan[6].split("-|\\/");
	   if(b[0].length()==1)
	   {
		   b[0]=c+b[0];
		   
	   }
	   else if(b[1].length()==1)
	   {
		   b[1]=c+b[1];
	   }
	   
	  String challannew1 = null;
	  try {
	  challannew1=b[2]+"-"+b[0]+"-"+b[1];
	  
	  System.out.println(challannew1);
	  }catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  
       try {
	 
	 System.out.println(challan);
	  //create preparedstatement here and
	
	
	  
	  ps.setString(1,challan[0]);
	  ps.setString(2,challan[1]);
	  
	  ps.setString(3,challannew);
	  ps.setString(4,challan[5]);
	  ps.setString(5,challannew1);
	  ps.setString(6,challan[15]);
	  ps.setString(7,challan[17]);
	  ps.setString(8,challan[18]);
	  ps.executeUpdate();
	 
       }catch(Exception e)
       {
    	   e.printStackTrace();
       }
	 
	 
	  

		  
	  
	 
	}

	  
		  
	  
	  }

	private static void elseif(boolean b) {
		// TODO Auto-generated method stub
		
	}
	  
}
	  
		
		

