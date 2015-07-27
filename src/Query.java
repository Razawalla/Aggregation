import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class Query extends JFrame {
public Query() {
	// TODO Auto-generated constructor stub
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	setBounds((int)d.getWidth()/2-250,(int) d.getHeight()/2-150, 500, 300);
	JTextField query=new JTextField();
	getContentPane().setLayout(null);
	query.setBounds(50, 5, 400, 50);
	JButton execute,viewAll;
	execute=new JButton("Execute");
	execute.setBounds(50, 100, 100, 50);
	viewAll=new JButton("View All");
	viewAll.setBounds(350, 100, 100, 50);
	add(execute);
	add(viewAll);
	add(query);
	execute.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ViewDetails details=new ViewDetails(query.getText());
			details.setVisible(true);
			setVisible(false);
		}
	});
	viewAll.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ViewDetails details=new ViewDetails("all");
			details.setVisible(true);
			setVisible(false);
		}
	});
}
}
