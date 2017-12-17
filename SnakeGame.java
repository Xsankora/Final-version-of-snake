
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakeGame extends JPanel implements ActionListener {
	public static final int SCALE = 30;
	public static final int WHIDTH = 20;
	public static final int HEIGHT = 20;
	public static int SPEED =5;
	public static int score ;
	public static enum STATES{NEWGAME,PLAY,PAUSE,PLAYHARD}
	public static STATES state =STATES.PLAY;
	Apple a = new Apple((int)(Math.random()*WHIDTH),(int)(Math.random()*HEIGHT));
	Snake s= new Snake(10,10,9,10);
	Timer t = new Timer(1000/SPEED, this);	
	Timer t1 = new Timer(1000/15, this);
    public SnakeGame() {
    	t.start();
		addKeyListener(new KeyBoard());
		setFocusable(true);
	}	
	public void paint(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, WHIDTH*SCALE, HEIGHT*SCALE);
		g.setColor(Color.black);
		for(int x=0;x<=WHIDTH*SCALE;x+=SCALE) {
		g.drawLine(x, 0, x, HEIGHT*SCALE);	
		}
		for(int y=0;y<=HEIGHT*SCALE;y+=SCALE) {
			g.drawLine(0,y,WHIDTH*SCALE,y);
		}
		for(int i=0;i<s.length;i++) {
			g.setColor(Color.white);
			g.fillRect(s.sX[i]*SCALE+1, s.sY[i]*SCALE+1, SCALE-1,SCALE-1);
		}
		if (s.sX[0]  < 0) s.sX[0] = WHIDTH - 1;
		if (s.sX[0] > WHIDTH - 1) s.sX[0] = 0;
		if (s.sY[0]  < 0) s.sY[0] = HEIGHT - 1;
		if (s.sY[0] > HEIGHT - 1) s.sY[0] = 0;
		g.setColor(Color.RED);
		g.fillOval(a.posX*SCALE+1, a.posY*SCALE+1, SCALE-1,SCALE-1);
	}
public void actionPerformed(ActionEvent e) {
	if(state.equals(STATES.PLAY)) {	
	s.move();
	if((s.sX[0]==a.posX)&(s.sY[0]==a.posY)) {
		a.setRandomPosition();		
		s.length++;
		score++;
		MyWindow.l.setText(" Your score " + score);
	}
	for(int i=1;i<s.length;i++) {
	if((s.sX[i]==a.posX)&(s.sY[i]==a.posY)) {
		a.setRandomPosition();
	}
	}
	if(s.length == 60) { 
		SnakeGame.state = SnakeGame.STATES.PAUSE;
		JFrame win = new JFrame();
		win.setSize(300,150);
		win.setVisible(true);
		win.setLocationRelativeTo(null);	
	    JLabel l = new JLabel(" You win, close this window and start new game " );
	    win.add(l,BorderLayout.CENTER);	
	}
	t1.stop();
	t.start();
	repaint();	
	}	
	if(state.equals(STATES.PLAYHARD)) {	
		s.move();
		if((s.sX[0]==a.posX)&(s.sY[0]==a.posY)) {
			a.setRandomPosition();
			s.length++;
			score++;
			MyWindow.l.setText(" Your score " + score);
		}
		for(int i=1;i<s.length;i++) {
		if((s.sX[i]==a.posX)&(s.sY[i]==a.posY)) {
			a.setRandomPosition();
		}
		}
		
		t1.start();
		repaint();
		}	
	if(state.equals(STATES.NEWGAME)) {	
		JFrame lose = new JFrame();
		lose.setSize(150,150);
		lose.setVisible(true);
		lose.setLocationRelativeTo(null);	
	    JLabel l = new JLabel("You finished with score " + score);
	    lose.add(l,BorderLayout.CENTER);
		s.length=2;
		score=0;		
		state = STATES.PLAY;
}
}
private class KeyBoard extends KeyAdapter{
    public void keyPressed(KeyEvent e){
        s.keyPressed(e);
    }
}
}
