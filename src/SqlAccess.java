import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;


public class SqlAccess {
	private Connection connect=null;
	private Statement statement=null;
	private ResultSet result=null;
	
	public SqlAccess() {
		// TODO Auto-generated constructor stub
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/marks?","root","5686");
		}catch(Exception e){
			System.out.println("got exception"+e);
			}
	}
	
	public ResultSet readDatabase()throws Exception{
		System.out.println("came to readDatabase");
			statement=connect.createStatement();
			 result=statement.executeQuery("select * from marks.student");
			 System.out.println(result.getMetaData().getTableName(1));
			 for(int i=1;i<=result.getMetaData().getColumnCount();i++){
					System.out.println(result.getMetaData().getColumnName(i));
				}
				return result;
		
		
	}
	
	public void insertData(String roll,String name,String subject,String marks )throws Exception{
		String sql="insert into student (roll,name,subject,marks)"+"values(?,?,?,?)";
		PreparedStatement preparedStatement=(PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setInt(1, Integer.parseInt(roll));
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, subject);
		preparedStatement.setInt(4, Integer.parseInt(marks));
		preparedStatement.executeUpdate();
		
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
