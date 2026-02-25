import java.awt.*;
import java.awt.event.*;

public class ZerFeb04 extends MeinFenster {
private Button knoli, knore;
private int x, dummy;
private boolean bibi=true;
MediaTracker mt = new MediaTracker(this);
Image[] bild=new Image[6];

public ZerFeb04(String titel, int w, int h){
  super(titel, w, h);
  x=0;
  dummy=0;
  setSize(w, h);
addWindowListener(new MeinFenSklav());
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
for(int i=1; i<=4; i+=1){
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
class SchlagMich implements ActionListener{
	public void actionPerformed (ActionEvent ae){
		String cmd =ae.getActionCommand();
		if (cmd.equals("k1")){
			 x-=10;
			 dummy=0;
		repaint();
		
         }
		if (cmd.equals("k2")){
	        x+=10;
	        dummy=2;
        repaint();
         }
}
}

public void paint( Graphics g ){

if (bibi){
g.drawImage(bild[dummy+1],150+x,80, this);
bibi=false;
} else {
g.drawImage(bild[dummy+2],150+x,80, this);
bibi=true;
}
}


public static void main( String[] args ) {
ZerFeb04 f = new ZerFeb04("Lauf, lauf!", 400, 200);
}
}