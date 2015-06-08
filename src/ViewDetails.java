 
import javax.swing.*;
import java.sql.ResultSet;
  
class ViewDetails extends JFrame
 {
   ViewDetails()
  {
  setDefaultCloseOperation(javax.swing.
   WindowConstants.DISPOSE_ON_CLOSE);
  setTitle("Welcome");
  setSize(400, 200);
  SqlAccess access=new SqlAccess();
  try{
	  ResultSet result=access.readDatabase();
	  String resultString=null;
	  
	  if(result==null){
		  System.out.println("result is null");
		  add(new JLabel("something is wrong"));
	  }
	  else{
		  while(result.next()){
			  resultString=result.getString("roll")+" "+result.getString("name")+" "+result.getString("subject")+" "+result.getString("marks")+" "+result.getString("status");
		  }
		  add(new JLabel(resultString));
		  access.close();
	  }
	  }catch(Exception e){
		  
	  }
   }
  }
