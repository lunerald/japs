
	 var canvas = document.getElementById('AnimZB');
	 canvas.addEventListener("mousedown", mauSi,false);
	   //Ort Zwecke	   
	   zx=320;
	   zy=310;
	   //Ort Apfel
	   mx=300;
	   my=70;
	   //Bildparameter
	   k=3;
	   a=9;
	   //Schrittweite
	   dx=0;
	   ay=0;
	   //Ort Aufzug
	   sumay=70;
	   //Initialisierung
	   herz=false;  
	   
	 if(canvas.getContext){
    	 var ctx = canvas.getContext('2d');
    	 var Bild=new Array(12);
    	   	 
    	  for (i=1; i<=11; i++){
    	   Bild[i]= new Image();
    	   Bild[i].src='zwe0'+i+'.png'
    	   Bild[i].onload = function(){}
    	  } 
         zeichne();
	  }//endif
    	 
      function zeichne(){		  
        ctx.clearRect(0,0,canvas.width,canvas.height); 
        //Boden
        ctx.fillStyle="rgb(179,100,29)";
        ctx.fillRect(300,360,450,20);
        //Palmenstil
        ctx.fillStyle="rgb(179,100,29)";
        ctx.fillRect(390,90,15,290);
        //Sprungbrett
        ctx.fillStyle="rgb(255,0,255)";
        ctx.fillRect(250,150,500,10);
        //Aufzug
        ctx.strokeRect(550,sumay,150,80);
        ctx.fillStyle="rgb(0,0,0)";
        ctx.fillRect(550,sumay+80,150,10);
        //Zwecke
        ctx.drawImage(Bild[k],zx,zy);   
        //Apfel
        ctx.drawImage(Bild[a],mx-20,my-20);
        //Palmenwedel
        ctx.drawImage(Bild[11],250,30);
        //Wasser
        ctx.fillStyle="rgb(0,0,255)";
        ctx.fillRect(0,330,300,50);
        //Blub
        if(zy==290 && zx < 250){
      	ctx.font = "30px Arial";
      	ctx.fillText("BLUB",zx-20,330);  }
        
        }
     
   function renn(){
	  a=9;
	  //lauf nach rechts
      if (zx<mx-60 && Math.abs(zy-my+35)<40){dx=20;}
      else 
      //nach links
      if ( zx>mx+15 && Math.abs(zy-my+35)<40){dx=-20;}
      //stoppen
      else {dx=0;}
      //Aufzug
      //ab
      if (Math.abs(mx-630)<70 && Math.abs(my-sumay-50)<30 ){
      ay = 20;
      }
      //auf
      if (my<sumay && Math.abs(mx-630)<70 ){
      ay = -20;
      }
      //stoppen
      if(ay==20 && sumay==290){
      ay=0;
      }
      if(ay==-20 && sumay==70){
      ay=0;  
      }
      //Apfel mitnehmen
      if(my>sumay-20){
      my+=ay;}
      
      //Aufzugposition
      sumay+=ay;
      
      //Zwecke mitnehmen
      if(Math.abs(zx-625)<75 && ay < 0){
      zy+=ay;  
      }
      //ins Wasser fallen
      if(zx<210 && zy<310){
      fall =true;
      zy +=20;
      dx -=15; 
      }
      
      //nach oben begrenzen
      if(zy<90){zy=90}
      
      //x-Position Zwecke
      zx+=dx;
      
      if (dx>0){
     //Bildfolge Lauf nach rechts
     if (k!=4){k=4;}else{k=3;}}
     else if (dx<0){
     //Bildfolge Lauf nach links
     if(k!=2){k=2;}else{k=1;}}
     else 
     //stillstehen
    	 if (Math.abs(zy-my+35)<40 && ay!=20){
     //Bildfolge fressen
    	 a=10; 
     if(k!=6){k=6;}else{k=5;}}  
    	 else {
     //Bildfolge nicht fressen
         a=9;
     if(k!=8){k=8;}else{k=7;}} 
     
  	   
      var ani =setTimeout(renn,400);
      zeichne();
    }
   
     function mauSi(event){
     //reagiert auf Mausklick
     if (ay==0){
  	 mx = event.pageX - event.target.getBoundingClientRect().left;
  	 my = event.pageY - event.target.getBoundingClientRect().top;
     }
     
  	 if(!herz){
  		 renn();
  		 herz=true;}
  	
     }

