 
import javax.swing.*;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
  
class ViewDetails extends JFrame
 {
   ViewDetails()
  {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setTitle("View Details");
  setSize(500,500);
  Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
  setBounds(dim.width/2-250,dim.height/2-250,500,500);
  getView();
  
   }

private void getView() {
	// TODO Auto-generated method stub
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
