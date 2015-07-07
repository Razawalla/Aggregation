import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.SpringLayout.Constraints;


public class Register extends JFrame {
	Register(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int)dim.getWidth()/2-200,(int)dim.getHeight()/2-200);
		createForm();
	}

	private void createForm() {
		// TODO Auto-generated method stub
		Container panel=this.getContentPane();
		SpringLayout layout=new SpringLayout();
		panel.setLayout(layout);
		JLabel name=new JLabel("Name");
		Constraints nameCons=layout.getConstraints(name);
		nameCons.setX(Spring.constant(20));
		nameCons.setY(Spring.constant(30));
		panel.add(name);
		JTextField nameField=new JTextField();
		panel.add(nameField);
		JLabel designation=new JLabel("Designation");
		panel.add(designation);
		JComboBox<String> combo=new JComboBox<String>(new String[]{"Student","Faculty"});
		combo.setSelectedIndex(0);
		panel.add(combo);
		combo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String des=(String)combo.getSelectedItem();
				if(des.equals("Student")){
					JLabel roll=new JLabel("Roll number");
					panel.add(roll);
					JTextField rollEnter=new JTextField();
					panel.add(rollEnter);
				}
			}
		});
		
	}
}
