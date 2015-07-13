import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			 result=statement.executeQuery("select * from marks.student group by roll");
			 
			return result;
		
		
	}
	
	public void insertData(String roll,String name,String subject,String marks )throws Exception{
		Crypt crypt=new Crypt(Integer.parseInt(marks));
		statement=connect.createStatement();
		result=statement.executeQuery("select hash from marks.roll_to_hash where roll="+roll+" limit 1");
		if(result.absolute(1)){
			//connect.close();
		}
		else{
			String insert="insert into roll_to_hash(roll,hash)"+"values(?,?)";
			PreparedStatement p=(PreparedStatement)connect.prepareStatement(insert);
			p.setInt(1, Integer.parseInt(roll));
			p.setInt(2, roll.hashCode());
			p.executeUpdate();
		}
		String sql="insert into student (roll,name,subject,marks)"+"values(?,?,?,?)";
		PreparedStatement preparedStatement=(PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setInt(1, Integer.parseInt(roll));
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, subject);
		preparedStatement.setBytes(4, Crypt.encrypt(Crypt.raw, marks.getBytes()));
		preparedStatement.executeUpdate();
		sql="insert into hashmap(roll_hash,subject,marks)"+"values(?,?,?)";
		preparedStatement=(PreparedStatement)connect.prepareStatement(sql);
		preparedStatement.setInt(1,roll.hashCode());
		preparedStatement.setString(2, subject);
		preparedStatement.setInt(3, Integer.parseInt(marks));
		preparedStatement.executeUpdate();
	}
	
	public ResultSet getAvg(String roll){
		try {
			String query="select avg(marks) from marks.hashmap where roll_hash=(select hash from marks.roll_to_hash where roll=?)";
			PreparedStatement prep=(PreparedStatement)connect.prepareStatement(query);
			prep.setInt(1, Integer.parseInt(roll));
			ResultSet res=prep.executeQuery();
			
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
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
