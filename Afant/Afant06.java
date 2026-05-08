


import java.awt.*;
import java.awt.event.*;

public class Afant06 extends MeinFenster {
private Button knoli, knore;
private int x, dx, dummy, bibi, brei2;
private boolean wart=true;
MediaTracker mt = new MediaTracker(this);
Image[] bild=new Image[11];
LosGehts los=new LosGehts();
public Afant06(String titel, int w, int h){
  super(titel, w, h);
  brei2=w/2;
  bibi=0;
  dx=0;
  dummy=0;
  setSize(w, h);
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
for(int i=1; i<=10; i+=1){
	bild[i]=getToolkit().getImage("arfant0"+i+".png");

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
			dummy=1;
		    
		    los.start();
		
         }
		if (cmd.equals("k2")){
			
	        dx=10;
	        dummy=5;
	      
	        los.start();
	       
         }
}
}

public void paint( Graphics g ){
if(wart && bibi!=1){
g.drawImage(bild[9],brei2+x,80, this);
bibi=1;
}
else if (wart && bibi==1){
g.drawImage(bild[10],brei2+x,80, this);
bibi=0;
}
if (!wart && bibi==0){
g.drawImage(bild[dummy],brei2+x,80, this);
} 
if (!wart && bibi==1){
g.drawImage(bild[dummy+1],brei2+x,80, this);
}
if (!wart && bibi==2){
g.drawImage(bild[dummy+2],brei2+x,80, this);
}
if (!wart && bibi==3){
g.drawImage(bild[dummy+3],brei2+x,80, this);
}
if(!wart){bibi+=1;}
if(bibi==4){bibi=0;}
}


public static void main( String[] args ) {
Afant06 f = new Afant06("Lauf, lauf!", 400, 200);
}
}
