import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Snake   {
 public int direction =0;
 public static int length =2;
 public int sX[]= new int[60];
 public int sY[] = new int[60];
 public Snake(int x0, int x1, int y0,int y1) {
	 sX[0] =x0;
	 sY[1] =y0;
	 sX[0] =x1;
	 sY[1] =y1;
 }
public void move() {
	for(int d=length-1;d>0;d--) {
		sX[d]= sX[d-1];
		sY[d] = sY[d-1];
		}
	if(direction ==0) sX[0]++;
	if(direction ==1) sY[0]++;
	if(direction ==2) sX[0]--;
	if(direction ==3) sY[0]--;
	for(int i=length-1;i>0;i--) {
		if((sX[0]==sX[i]) & (sY[0]==sY[i])) { length=i-2;
		SnakeGame.score =length;
		MyWindow.l.setText(" Your score " + SnakeGame.score);
	}
	}
	if(length<2) {length=2;} 	
}
public void keyPressed(KeyEvent keyEvent){
    int key = keyEvent.getKeyCode();
    if((key == keyEvent.VK_RIGHT) & direction !=2 )direction = 0;
    if((key == keyEvent.VK_DOWN)& direction !=3 )direction = 1;
    if((key == keyEvent.VK_LEFT)& direction !=0 )direction = 2;
    if((key == keyEvent.VK_UP)& direction !=1 )direction = 3;
    if (key == KeyEvent.VK_ESCAPE) {
    	if(SnakeGame.state == SnakeGame.STATES.PLAY) {
          SnakeGame.state = SnakeGame.STATES.PAUSE;
    	}
    	if(SnakeGame.state == SnakeGame.STATES.PLAYHARD) {
            SnakeGame.state = SnakeGame.STATES.PAUSE;
      	}
    }
    if(key == keyEvent.VK_SPACE) {
    	if(SnakeGame.state == SnakeGame.STATES.PAUSE) {
    		SnakeGame.state = SnakeGame.STATES.PLAY;
    	}
    	if(SnakeGame.state == SnakeGame.STATES.PAUSE) {
    		SnakeGame.state = SnakeGame.STATES.PLAYHARD;
    	}
    }
    if(key == keyEvent.VK_H) {
    if(SnakeGame.state == SnakeGame.STATES.PLAY) {
        SnakeGame.state = SnakeGame.STATES.PLAYHARD;    
  	} 
    }
    if(key == keyEvent.VK_S) {
    if(SnakeGame.state == SnakeGame.STATES.PLAYHARD) {
        SnakeGame.state = SnakeGame.STATES.PLAY;
  	}
    }
    
    if (key == KeyEvent.VK_ENTER) {
    	if(SnakeGame.state == SnakeGame.STATES.PLAYHARD) {
            SnakeGame.state = SnakeGame.STATES.NEWGAME;
      	} 
    	if(SnakeGame.state == SnakeGame.STATES.PLAY) {
            SnakeGame.state = SnakeGame.STATES.NEWGAME;
      	}   	
    }
    }

}