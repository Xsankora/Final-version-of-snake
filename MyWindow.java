import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
public class MyWindow {
	public static JLabel l = new JLabel();
	public static void main(String[] args) {
		JFrame f = new JFrame();
		JPanel p = new JPanel();		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setSize(SnakeGame.WHIDTH*SnakeGame.SCALE+7,SnakeGame.HEIGHT*SnakeGame.SCALE+30+SnakeGame.SCALE);
		f.setTitle("Ssssnake");
		f.setLocationRelativeTo(null);	
		f.add(new SnakeGame());
		JMenuBar menu = new JMenuBar();
		JMenu menu1 = new JMenu("Menu");
		JMenuItem mi1= new JMenuItem("Instructions");
		JMenuItem mi3= new JMenuItem("New Game ");
		JMenuItem mi2= new JMenuItem("Exit");
		menu1.add(mi1);
		menu1.add(mi3);
		menu1.add(mi2);
		mi2.addActionListener(new ActionListener(){  
		      public void actionPerformed(ActionEvent e){
			       System.exit(1);
			      }
			          });
		mi1.addActionListener(new ActionListener(){  
		      public void actionPerformed(ActionEvent e){
		    	  JFrame f1= new JFrame();
		    	  f1.setSize(260,180);
		    	  f1.setTitle("Instructions");
		    	  f1.setBackground(Color.WHITE);
		    	  f1.setVisible(true);	
		    	  JPanel jp= new JPanel();
		    	  DefaultListModel listModel = new DefaultListModel();
		    	  listModel.addElement(" Instructions of game ");
		    	  listModel.addElement("For starting game press 'SPACE' ");
		    	  listModel.addElement("If you want pause game press 'ESC' ");
		    	  listModel.addElement("For Hard mode press 'H' ");
		    	  listModel.addElement("For Slow mode press 'S' ");
		    	  listModel.addElement(" If you want to start new game press 'ENTER' ");
		    	  listModel.addElement(" Do not eat your tail ");
		    	  listModel.addElement(" You will play this game forever ");
		    	  JList listik = new JList(listModel);
		    	  f1.add(jp);
		    	  jp.add(listik);
		    	  
		    	  f1.setResizable(false);
			      }
			          });
		mi3.addActionListener(new ActionListener(){  
		      public void actionPerformed(ActionEvent e){
			       SnakeGame.state = SnakeGame.STATES.NEWGAME;
			      }
			          });
		menu.add(menu1);
		f.add(p,BorderLayout.SOUTH);			
		p.add(l);
		f.setJMenuBar(menu);
		f.setVisible(true);
	}
}
