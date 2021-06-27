package db;
import java.sql.ResultSet;

public class SampleDAO {

	public static void main(String args[])
	{ResultSet x=null;
	GenericQuery ob=	new GenericQuery();
	 x=(ResultSet)(ob.selectAll("user_details"));

	
	try {
			
			  while(x.next()) {
				  System.out.println(x.getString(1)+ " "+x.getString(2)+" "+x.getString(3));
				   
			  }		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ob.close();
	
	
	}
}
