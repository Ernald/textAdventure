import java.awt.*;
import javax.swing.*;


public class MoveBall {

	int x=0;
	int y=100;
	
	public static void main(String[] args) {
		MoveBall ok=new MoveBall();
        ok.go();
	}
	public void go() {
		JFrame frame=new JFrame();
		MyDrawPanel drawpanel=new MyDrawPanel();
		
		frame.getContentPane().add(drawpanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 450);
		frame.setTitle("Move Ball");
		frame.setVisible(true);
		
		for(int i=0;i<100;i++) {
			x=x+3;
			y=0;

			drawpanel.repaint();
			try { Thread.sleep(80);
			}catch(Exception ex) {}
		}

}
	class MyDrawPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
	    	g.setColor(Color.BLUE);
	    	g.fillOval(x, y, 50, 50);
	    	 
	     }
	}

}
