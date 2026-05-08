var canvas = document.getElementById('AnimZM');
    canvas.addEventListener("mousedown", mauSi,false);
 
if(canvas.getContext){//if1
    	 var ctx = canvas.getContext('2d');
    	 var BildListe =new Array(11);
    	 var Bild=new Array(11);
    	 
    	 function biLa(){
    	  for (i=1; i<=8; i++){
    	   Bild[i]= new Image();
    	   Bild[i].src='zwe0'+i+'.png'
    	   Bild[i].onload = function(){}
    	  } 
    	 }
         biLa();
              
    	 
       function zeichne(){		  
        ctx.clearRect(0,0,canvas.width,canvas.height);      
        ctx.drawImage(Bild[k],zx,40);      
        ctx.drawImage(Bild[a],mx-20,my-80);
       }
}//endif1
zx=0;//x-Position Viech
k=3; //Bildnummer Viech
dx=0;//Schritt in x-Richtung
herz=false;
   
function renn(){
      zx+=dx;
      a=7;
      if (dx>0){//if2
    //vorwärts
     if (k!=4){k=4;}else{k=3;}
               }
     else if (dx<0){//if3
    //rückwärts
     if(k!=2){k=2;}else{k=1;}
                   }//endif3
     else{
    //fressen
    	 a=8;//Apfelbildnummer
     if(k!=6){k=6;}else{k=5;}
         }//endif2
      
     if (zx<mx-60){//if4
         dx=20;}
     else 
     if (zx>mx+15){dx=-20;} else {dx=0;}//endif4
  	   
      var ani =setTimeout(renn,400);
      zeichne();
}

function mauSi(event){
  	 mx = event.pageX;
  	 my = event.pageY;
  	 if(!herz){
  		 renn();
  		 herz=true;}
  	
}

     
   
   
