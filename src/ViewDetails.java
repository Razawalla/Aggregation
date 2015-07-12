 
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.sql.ResultSet;
  
class ViewDetails extends JFrame
 {
   ViewDetails()
  {
	   super.setLayout(new GridLayout(1,0));
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setTitle("View Details");
  setSize(500,500);
  Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
  setBounds(dim.width/2-250,dim.height/2-250,500,500);
  getView();
  
   }

private void getView() {
	// TODO Auto-generated method stub
	String[] columNames={"Roll Number","Name","Subject","Total"};
	
	SqlAccess access=new SqlAccess();
	  try{
		  ResultSet result=access.readDatabase();
		  
		  if(result==null){
			  System.out.println("result is null");
			  add(new JLabel("something is wrong"));
		  }
		  else{
			  System.out.println("Came to else part");
			  Object[][] data=new Object[15][15];
			  int i=0,j=0;
			  while(result.next()){
				  while(j<4){
					  data[i][j]=result.getString("roll");
					  System.out.println(result.getString("roll"));
					  j++;
					  data[i][j]=result.getString("name");
					  j++;
					  System.out.println(result.getString("name"));
					  data[i][j]=result.getInt("subject");
					  j++;
					  System.out.println(result.getString("subject"));
					  data[i][j]=result.getString("marks");
					  j++;
					  System.out.println(result.getString("marks"));
				  }
				  i++;
			  }
			  JTable table=new JTable(data,columNames);
			  table.setEnabled(false);
			  table.setCellSelectionEnabled(true);
			  add(new JScrollPane(table));
			  System.out.println(result.getString("roll"));
			  access.close();
		  }
		  }catch(Exception e){
			  
		  }
}
  }
