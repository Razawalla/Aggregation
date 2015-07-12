import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.SpringLayout.Constraints;


public class EnterDetails extends JFrame {

	public EnterDetails() {
		// TODO Auto-generated constructor stub
		setDefaultCloseOperation(javax.swing.
				   WindowConstants.DISPOSE_ON_CLOSE);
					setResizable(false);
				  setTitle("Enter Details");
				  Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
				  setBounds(dim.width/2-200,dim.height/2-75,400,150);
	getView();
	}

	private void getView() {
		// TODO Auto-generated method stub
		JPanel panel=new JPanel();
		panel.setSize(getWidth()/2, getHeight()/2);
		GridLayout layout=new GridLayout(5, 2);
		panel.setLayout(layout);
		panel.add(new JLabel("Roll Number"));
		JTextField roll=new JTextField(12);
		panel.add(roll);
		panel.add(new JLabel("Name"));
		JTextField name=new JTextField(30);
		panel.add(name);
		panel.add(new JLabel("Subject"));
		JTextField subject=new JTextField(30);
		panel.add(subject);
		panel.add(new JLabel("Marks"));
		JTextField marks=new JTextField(3);
		panel.add(marks);
		JButton submit=new JButton("Submit");
		panel.add(submit);
		add(panel);
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if((roll.getText()!=null)&&(name.getText()!=null)&&(subject.getText()!=null)&&(marks.getText()!=null)){
					SqlAccess access=new SqlAccess();
					try {
						access.insertData(roll.getText(), name.getText(), subject.getText(), marks.getText());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		}
			}
		});
		}
	
}
