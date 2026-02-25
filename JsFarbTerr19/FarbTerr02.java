
import java.awt.*;

import java.util.Random;


public class FarbTerr02 extends Frame{
	public FarbTerr02(String titel){
		 
		setTitle(titel);
		  
		setSize(500, 300);
		  
		setBackground(Color.lightGray);
		  
		setForeground(Color.red);
		  
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		 
		setLocation((d.width-getSize().width)/2, (d.height-getSize().height)/2);

		setVisible(true);

		}

		public static void wartemal(long millis){

		try {

		Thread.sleep(millis);

		} 
		catch (InterruptedException e){}

		}

		public void paint( Graphics g ){

		Random r = new Random();

		for (int y=30; y<getHeight()-10; y += 15)

		for (int x=12; x<getWidth()-10; x += 15) {

		g.setColor(new Color(r.nextInt(256),
		r.nextInt(256),
		r.nextInt(256)));

		g.fillRect(x, y, 10, 10);

		g.setColor(Color.BLACK);

		g.drawRect(x - 1, y - 1, 10, 10);

		wartemal(500);

		}

		}


	public static void main(String[] args) {
		FarbTerr02 f = new FarbTerr02("Bunte Quadrate");

	}

}
