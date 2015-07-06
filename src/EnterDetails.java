import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class EnterDetails extends JFrame {

	public EnterDetails() {
		// TODO Auto-generated constructor stub
		setDefaultCloseOperation(javax.swing.
				   WindowConstants.DISPOSE_ON_CLOSE);
				  setTitle("Enter Details");
				  setSize(400, 200);
				  Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
				  setBounds(dim.width/2-250,dim.height/2-250,500,500);
	getView();
	}

	private void getView() {
		// TODO Auto-generated method stub
		
	}
}
