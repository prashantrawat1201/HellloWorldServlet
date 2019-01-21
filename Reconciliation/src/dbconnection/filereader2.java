//package myapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dbconnection.Jdbc;

public class filereader2 {
	private static Object string;
	private static String sql;

	public static void main(String args[]) throws IOException, SQLException {
		Jdbc jd=new Jdbc();
		final String COMMA_DELIMITER = ",";
		int i,j;
		 String sql="INSERT INTO CV1(VRDT , VRNO, DRCR, COD, AMOUNT ,DOC_COD , DES, ASCODE, CHNO, CC, AGRDT , DTR ,CHALDT) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	BufferedReader br=new BufferedReader(new FileReader("E:\\Reconciliation_Data\\lda_10_dec_csv/cv.csv"));
	
	
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
	  String[] Bank=line.split(COMMA_DELIMITER);
	  
	  
    
	   String[] a=Bank[2].split("-|\\/");
	   
//	   char[] strArray=a[0].toCharArray();
	  
	   
	  /* for(int i1 = 0; i1 < a[0].length(); i1++){
           if(Character.isWhitespace(a[0].charAt(i1))){
               a[0]=a[0].replaceAll("\\S+(?=[),])","");
           }
           
	   }*/ 
	
	//   System.out.println(a[0].trim());
	  
		  String Banknew="";
	  try {
		   Banknew=a[2]+"-"+a[0]+"-"+a[1];
	      System.out.println(Banknew.trim());
		  // StringBuffer stringBuffer=new StringBuffer();
	//  for(int j1=0;j1<strArray.length;j1++);
	  //if((strArray[j1]!="")&&(strArray[j1]!='\t'))
	  
	  
	  
	 
	  
	 // System.out.println(Banknew);
	  }catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  System.out.println(Bank[1]);
	   String[] b=Bank[13].split("-|\\/");
	   String Bank2="";
	  	  try {
	  		Bank2=b[2]+"-"+b[0]+"-"+b[1];
	  
	  System.out.println(Bank2.trim());
	  }catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  	  String[] c=Bank[31].split("/");
		   String Bank3="";
		  	  try {
		  		Bank3=c[2]+"-"+c[0]+"-"+c[1];
		  
		  System.out.println(Bank3.trim());
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  	String[] d=Bank[29].split("/");
			   String Bank4="";
			  	  try {
			  		Bank4=c[2]+"-"+c[0]+"-"+c[1];
			  
			  System.out.println(Bank4.trim());
			  }catch(Exception e)
			  {
				  e.printStackTrace();
			  }
	  	  
	  	  
	  
       try {
	 

	  
	  ps.setString(1,Banknew);
	  ps.setString(2,Bank[3]);
	  
	  ps.setString(3,Bank[4]);
	  ps.setString(4,Bank[5]);
	  ps.setString(5,Bank[6]);
	  ps.setString(6,Bank[7]);
	  ps.setString(7,Bank[8]);
	  ps.setString(8,Bank[9]);
	  ps.setString(9,Bank[10]);
	  ps.setString(10,Bank[11]);
	  ps.setString(11,Bank2);
	  ps.setString(12,Bank4);
	  ps.setString(13,Bank3);
	  ps.executeUpdate();
	 
       }catch(Exception e)
       {
    	   e.printStackTrace();
       }
	 
	 
	  

		  
	  
	 
	}

	  
		  
	  
	  }

	
	  
}
	  
		
		

