
import java.awt.*;
import java.awt.event.*;
public class ZeMau07 extends MeinFenster {
private int x, dx, dummy,brei2, mx, my;
private boolean bibi=true;
private boolean wart=true;
MediaTracker mt = new MediaTracker(this);
Image[] bild=new Image[9];
LosGehts los=new LosGehts();

public ZeMau07(String titel, int w, int h){
  super(titel, w, h);
  x=0;
  dx=0;
  dummy=0;
  setSize(w, h);
  brei2=w/2;
  mx=brei2-15;
  my=100;
addWindowListener(new MeinFenSklav());
addComponentListener(new FenBrei());
addMouseListener(new Mausi());
setVisible(true);

for(int i=1; i<=8; i+=1){
	bild[i]=getToolkit().getImage("zwe0"+i+".png");

	mt.addImage(bild[i],0);}
	try{
		mt.waitForAll();
	}catch (InterruptedException e){}

}

class MeinFenSklav extends WindowAdapter{

public void windowClosing(WindowEvent we) {
System.exit(0);
}
}
class FenBrei extends ComponentAdapter{
	
public void componentResized(ComponentEvent e){
	Component c = e.getComponent();
brei2=c.getSize().width/2;
System.out.println(brei2);
}
}
class Mausi extends MouseAdapter{
	
public void mousePressed(MouseEvent e){
	mx = e.getX();
	my = e.getY();
if (Math.abs(brei2+x-mx)<40){
	wart=true;

}
else if(mx < brei2+x){
	dx=-10;
	dummy=0;
	wart=false;
 }
else if(mx> brei2+x){
	dx=10;
	dummy=2;
	wart=false;
 }
los.start();
}
}

public class LosGehts implements Runnable{

	public void run(){	
			while (!wart && Math.abs(x+brei2-mx+25)>25){
			x+=dx;
			//System.out.println(x);
			repaint();
		try{
	       Thread.sleep(400);
	       }
			catch (InterruptedException ie){
			//return;
			}
	}x-=dx;
	wart=true;
    while (wart){
	repaint();
	     try{
	       Thread.sleep(1000);
	       }
			catch (InterruptedException ie){
				return;
			}
	}
	}
	
public void start(){
new Thread(this).start();
}
}

public void paint( Graphics g ){
if(wart && bibi){
g.drawImage(bild[5],brei2+x,my-30, this);
bibi=false;
}
else if (wart && !bibi){
g.drawImage(bild[6],brei2+x,my-30, this);
bibi=true;
}
if (!wart && bibi){
g.drawImage(bild[dummy+1],brei2+x,my-30, this);
bibi=false;
} else if (!wart && !bibi){
g.drawImage(bild[dummy+2],brei2+x,my-30, this);
bibi=true;
}
if (wart){
g.drawImage(bild[8],mx-15,my-15, this);
}
if (!wart){
g.drawImage(bild[7],mx-15,my-15, this);
}
}


public static void main( String[] args ) {
ZeMau07 f = new ZeMau07("Lauf, lauf!", 400, 200);
}
}

