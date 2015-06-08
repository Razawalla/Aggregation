import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class SqlAccess {
	private Connection connect=null;
	private Statement statement=null;
	private ResultSet result=null;
	
	public ResultSet readDatabase()throws Exception{
		try{
			System.out.println("came to readDatabase");
			Class.forName("com.mysql.jdbc.Driver");
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/marks?","root","5686");
			if(connect!=null)
				System.out.println("party");
			statement=connect.createStatement();
			 result=statement.executeQuery("select * from marks.student");
			 System.out.println(result.getMetaData().getTableName(1));
			 for(int i=1;i<=result.getMetaData().getColumnCount();i++){
					System.out.println(result.getMetaData().getColumnName(i));
				}
				return result;
		}catch(Exception e){
			System.out.println("got exception"+e);
			throw e;
		}
		
	}

	public void close() {
		// TODO Auto-generated method stub
		try{
		if(result!=null)
			result.close();
		if(statement!=null)
			statement.close();
		if(connect!=null)
			connect.close();
		}catch(Exception e){
			
		}
	}

}
