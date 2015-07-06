import java.awt.Container;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.SpringLayout.Constraints;


public class PasswordFrame extends JFrame implements ActionListener {
	JButton register,login;
	PasswordFrame(String option){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Password");
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		setSize(500,200);
		setResizable(false);
		setLocation((int)dim.getWidth()/2-250, (int)dim.getHeight()/2-100);
		if(option.equals("view")){
			Container panel=createViewPane();
			SpringUtilities.makeGrid(panel, 3, 2, 5, 5, 5, 5);
		}
		else if(option.equals("enter")){
			
		}
	}

	private Container createViewPane() {
		// TODO Auto-generated method stub
		Container panel=this.getContentPane();
		SpringLayout layout=new SpringLayout();
		panel.setLayout(layout);
		panel.setSize(500, 200);
		JLabel user=new JLabel("Roll Number");
		Constraints userConstraints=layout.getConstraints(user);
		userConstraints.setX(Spring.constant(200));
		userConstraints.setY(Spring.constant(200));
		panel.add(user);
		JTextField enterRoll=new JTextField("Enter login id",30);
		Constraints rollConstraints=layout.getConstraints(enterRoll);
		rollConstraints.setX(Spring.sum(Spring.constant(5), userConstraints.getConstraint(SpringLayout.EAST)));
		rollConstraints.setY(Spring.constant(200));
		enterRoll.setSize(80,80);
		panel.add(enterRoll);
		JLabel passLabel=new JLabel("Password");
		Constraints labelConstraints=layout.getConstraints(passLabel);
		labelConstraints.setX(Spring.constant(200));
		userConstraints.setY(Spring.sum(Spring.constant(5), userConstraints.getConstraint(SpringLayout.SOUTH)));
		panel.add(passLabel);
		JPasswordField passEnter=new JPasswordField(30);
		Constraints passConstraints=layout.getConstraints(passEnter);
		passConstraints.setX(Spring.sum(Spring.constant(5), labelConstraints.getConstraint(SpringLayout.EAST)));
		passConstraints.setY(Spring.constant(200));
		panel.add(passEnter);
		register=new JButton("Register");
		register.addActionListener(this);
		panel.add(register);
		login=new JButton("Login");
		login.addActionListener(this);
		panel.add(login);
		return panel;
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==register){
			System.out.println("register clicked");
		}
		else if(e.getSource()==login){
			System.out.println("login clicked");
		}
	}

}
