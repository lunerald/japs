
import java.awt.*;
import java.awt.event.*;
public class ZeTrea05 extends MeinFenster {
private Button knoli, knore;
private int x, dx, dummy,brei2;
private boolean bibi=true;
private boolean wart=true;
MediaTracker mt = new MediaTracker(this);
Image[] bild=new Image[7];
LosGehts los=new LosGehts();
public ZeTrea05(String titel, int w, int h){
  super(titel, w, h);
  dx=0;
  dummy=0;
  setSize(w, h);
  brei2=w/2;
addWindowListener(new MeinFenSklav());
addComponentListener(new FenBrei());
ActionListener aktion = new SchlagMich();
setLayout(new FlowLayout());
knoli = new Button("links");
add(knoli);
knoli.addActionListener(aktion);
knoli.setActionCommand("k1");
knore = new Button("rechts");
add(knore);
knore.addActionListener(aktion);
knore.setActionCommand("k2");
setVisible(true);

for(int i=1; i<=6; i+=1){
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

public class LosGehts extends Thread{

	public void run(){	
			while ( !wart && Math.abs(x+40)<brei2-40){
			x+=dx;
			//System.out.println(x);
			repaint();
		try{
	       sleep(400);
	       }
			catch (InterruptedException ie){
			return;
			}
	}x-=dx;
	wart=true;
    while (wart){
	repaint();
	     try{
	       sleep(1000);
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
class SchlagMich implements ActionListener{
	public void actionPerformed (ActionEvent ae){
		String cmd =ae.getActionCommand();
		wart=false;
		if (cmd.equals("k1")){
			
			dx=-10;
			dummy=0;
		
		    los.start();
		
         }
		if (cmd.equals("k2")){
			
	        dx=10;
	        dummy=2;
	      
	        los.start();
	       
         }
}
}

public void paint( Graphics g ){
if(wart && bibi){
g.drawImage(bild[5],brei2+x,80, this);
bibi=false;
}
else if (wart && !bibi){
g.drawImage(bild[6],brei2+x,80, this);
bibi=true;
}
if (!wart && bibi){
g.drawImage(bild[dummy+1],brei2+x,80, this);
bibi=false;
} else if (!wart && !bibi){
g.drawImage(bild[dummy+2],brei2+x,80, this);
bibi=true;
}
}


public static void main( String[] args ) {
ZeTrea05 f = new ZeTrea05("Lauf, lauf!", 400, 200);
}
}

