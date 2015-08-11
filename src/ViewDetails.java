 
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
  
class ViewDetails extends JFrame
 {
   ViewDetails(String query)
  {
	   super.setLayout(new GridLayout(1,0));
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setTitle("View Details");
  setSize(500,500);
  setResizable(false);
  Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
  setBounds(dim.width/2-250,dim.height/2-250,500,500);
  if(query.equals("all"))
  getView();
  else
  getView(query);
  
   }

private void getView(String query) {
	// TODO Auto-generated method stub
	SqlAccess access=new SqlAccess();
	ArrayList<String> columnames=new ArrayList<String>();
	try {
	ResultSet result=access.getAnything(query);
		if(result!=null){
		ResultSetMetaData meta=(ResultSetMetaData) result.getMetaData();
		int count=meta.getColumnCount();
		Object[][] data=new Object[100][100];
		System.out.println(count);
		int i=1;
		while(i<=count){
		columnames.add(meta.getColumnName(i));
		System.out.println(meta.getColumnName(i));
		i++;
		}
		i=0;
		int j=0;
		while(result.next()){
			j=1;
			while(j<=count){
				data[i][j-1]=result.getString(j);
				j++;
			}
			i++;
		}
		JTable table=new JTable(data,columnames.toArray());
		add(new JScrollPane(table));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private void getView() {
	// TODO Auto-generated method stub
	String[] columNames={"Roll Number","Name","Total","Average"};
	
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
				  j=0;
				  while(j<4){
					  data[i][j]=result.getString("roll");
					  System.out.println(result.getString("roll"));
					  j++;
					  data[i][j]=result.getString("name");
					  j++;
					  System.out.println(result.getString("name"));
					  ResultSet total=access.getSum((String)data[i][j-2]);
					  while(total.next())
					  data[i][j]=total.getFloat("sum(marks)");
					  j++;
					  ResultSet avg=access.getAvg((String)data[i][j-3]);
					  while(avg.next())
					  data[i][j]=avg.getFloat("avg(marks)");
					  j++;
					  }
				  i++;
			  }
			  JTable table=new JTable(data,columNames);
			  table.setEnabled(false);
			  table.setCellSelectionEnabled(true);
			  add(new JScrollPane(table));
			  access.close();
		  }
		  }catch(Exception e){
			  
		  }
}
  }
