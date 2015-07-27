import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class AggregateMain implements ActionListener {
	
	JPanel cards;
	JFrame main;
	JButton view,enter;
	
	public AggregateMain() {
		// TODO Auto-generated constructor stub
		main=new JFrame("SQL Aggregation");
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		main.setBounds(dim.width/2-250, dim.height/2-250, 500, 500);
		main.setResizable(false);
		view=new JButton("View");
		enter=new JButton("Enter");
		Container container=main.getContentPane();
		container.setSize(500,500);
		container.setLayout(new FlowLayout());
		view.setPreferredSize(new Dimension(80,30));
		enter.setPreferredSize(new Dimension(80, 30));
		container.add(view);
		container.add(enter);
		view.addActionListener(this);
		enter.addActionListener(this);
		main.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new AggregateMain();
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==view){
		//PasswordFrame pf=new PasswordFrame("view");	
		//ViewDetails details=new ViewDetails();
		//details.setVisible(true);
		//pf.setVisible(true);
			Query q=new Query();
			q.setVisible(true);
		}
		else if(e.getSource()==enter){
			EnterDetails details=new EnterDetails();
			details.setVisible(true);
		}
		main.setVisible(false);
	}

}
