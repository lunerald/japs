
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class ZerApp03 extends Applet {
Button knoli, knore;
int x, dx, dummy, breit, hoch, b2;
boolean bibi=true;
boolean wart=true;
String titel; 
MediaTracker mt = new MediaTracker(this);
Image[] bild=new Image[7];
LosGehts los=new LosGehts();

public void init(){
	
//	breit=Integer.parseInt(getParameter("breit"));
//	hoch=Integer.parseInt(getParameter("hoch"));
//	titel=getParameter("titel");
	breit=500;
	hoch=100;
	setSize(breit, hoch);
	 b2=breit/2;
	 dx=0;
	  dummy=0;
ActionListener aktion = new SchlagMich();
setBackground(Color.WHITE);
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
for(int i=1; i<=6; i++){
bild[i]=getImage(getCodeBase(),"zwe0"+i+".png");
try{
   mt.addImage(bild[i],0);
   mt.waitForAll();
}catch (InterruptedException e){}
}
}
public class LosGehts extends Thread{

	public void run(){	
			while ( !wart && Math.abs(x+40)<b2-40){
			x+=dx;
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
g.drawImage(bild[5], b2+x,40, this);
}
else if(wart && !bibi){
g.drawImage(bild[6], b2+x,40, this);
}
else if (!wart && bibi){
g.drawImage(bild[dummy+1], b2+x,40, this);
}
else if (!wart && !bibi){
g.drawImage(bild[dummy+2], b2+x,40, this);
}
bibi=!bibi;
}
}
