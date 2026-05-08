

import java.awt.*;
import java.awt.event.*;
public class ZeBlub08 extends MeinFenster {
private int x, dx, y, dy, dummy, mx, my,ay, sumay;
private boolean bibi=true;
private boolean wart=true;
private boolean hung=true;
private boolean drin=false;
MediaTracker mt = new MediaTracker(this);
Image[] bild=new Image[12];
LosGehts los=new LosGehts();

public ZeBlub08(String titel, int w, int h){
  super(titel, w, h);
  ay=0;
  sumay=0;
  y=350;
  dy=0;
  x=350;
  dx=0;
  dummy=2;
  setSize(w, h);
  mx=300;
  my=70;
addWindowListener(new MeinFenSklav());
addMouseListener(new Mausi());
setVisible(true);

for(int i=1; i<=11; i+=1){
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

class Mausi extends MouseAdapter{
	
public void mousePressed(MouseEvent e){
if (ay==0){	
	mx = e.getX();
	my = e.getY();
  if (Math.abs(my-y+10)>40){
		hung = true;
		wart = true;
		}else{
	hung =false;
  }
  if (Math.abs(x-mx)<40){
	wart=true;
  }
  else if(mx < x && !hung){
	dx=-10;
	dummy=0;
	wart=false;
  }
  else if(mx> x && !hung){
	dx=10;
	dummy=2;
	wart=false;
  }
  ay=0;
  if (!wart){hung=true;}

  if (Math.abs(mx-620)<50 && Math.abs(my+sumay-110)<30 && !drin){
	ay=20;
  }
  if (drin && my< sumay+60 && mx>550 ){
	ay=-20;
  }

  los.start();
}//endif(ay==0)
}
}


public class LosGehts implements Runnable{

	public void run(){	
		
			while (!wart && Math.abs(x-mx+25)>25){
			x+=dx;
			if(y==140 && x<180 ){
				dy=20;
			}
			repaint();
		try{
	       Thread.sleep(400);
	       }
			catch (InterruptedException ie){
			}
	
    }
     if (Math.abs(my-y+10)<40){
				hung=false;
				}
     x-=dx;
	wart=true;
    while (wart){
    sumay+=ay;
    if (!drin && ay>0 || (drin && my >sumay+60)){
     my+=ay;}
	repaint();
	     try{
	       if (dy>0){Thread.sleep(400);}
	       else{
	       Thread.sleep(1000);
	           }
	       }
			catch (InterruptedException e){
			}
	}
	}
	
public void start(){
new Thread(this).start();
}
}

public void paint( Graphics g ){
y+=dy;
//Palmenstil
g.setColor(new Color(179,100,29));
g.fillRect(390,90,15,290);
g.setColor(Color.MAGENTA);
g.fillRect(250,150,300,10);
if (sumay>210 || sumay<20){ay=0;}
if ((y-sumay)<=150 && x>535){
	drin=true;
 }else{
	drin=false;}
g.setColor(Color.BLACK);
g.fillRect(550,sumay+150,150,10);
g.drawRect(550,sumay+70,150,80);
if (!wart && bibi){
g.drawImage(bild[dummy+1],x,y-40, this);
} else if (!wart && !bibi){
g.drawImage(bild[dummy+2],x,y-40, this);
}
if(wart && bibi && !hung){
g.drawImage(bild[5],x,y-50, this);
}
else if (wart && !bibi && !hung){
g.drawImage(bild[6],x,y-50, this);
}
if(ay>=0)
    {
  if(wart && bibi && hung){
  g.drawImage(bild[7],x,y-50, this);
  }
  else if (wart && !bibi && hung){
  g.drawImage(bild[8],x,y-50, this);
  }
  
}
else if (ay<0){
	y=sumay+120;
	if (bibi){
	g.drawImage(bild[7],x,y-30, this);
	}else{
    g.drawImage(bild[8],x,y-30, this);
	}
}//Apfel
if (wart && !hung){
	  g.drawImage(bild[9],mx-15,my-15, this);
	  }
	  else{
	  g.drawImage(bild[10],mx-15,my-15, this);
	  }
bibi=!bibi;
//Palmwedel
g.drawImage(bild[11],250,30,this);
//Wasser
g.setColor(Color.BLUE);
g.fillRect(0,330,300,50);
if(y>=350 && dy==20){
	y=350;
	dy=0;
	drin=false;
g.setFont(new Font(null,Font.BOLD,30));
g.drawString("BLUB",x-20,330);}
}


public static void main( String[] args ) {
ZeBlub08 f = new ZeBlub08("Plansch!", 750, 400);
}
}


