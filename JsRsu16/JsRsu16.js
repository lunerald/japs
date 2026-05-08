  
var canvas = document.getElementById('AnimRsu');
	  zeit=0;
	  x=125;
	  y=200;
	  herz=false;
	   
if(canvas.getContext){
    	 var ctx = canvas.getContext('2d');
    	 
    	 function biLa(){
    	   
    	   brom2= new Image();
    	   bromspalt= new Image();
    	   bromyl= new Image();
    	   hbr= new Image();
    	   methan= new Image();
    	   methyl= new Image();
    	   methylbromid= new Image();
    	   
    	   brom2.src='brom2'+'.png'
    	   bromspalt.src='bromspalt'+'.png'
    	   bromyl.src='bromyl'+'.png'
    	   hbr.src='hbr'+'.png'
    	   methan.src='methan'+'.png'
    	   methyl.src='methyl'+'.png'
    	   methylbromid.src='methylbromid'+'.png'
    	   
    	   brom2.onload = function(){}
    	   bromspalt.onload = function(){}
    	   bromyl.onload = function(){}
    	   hbr.onload = function(){}
    	   methan.onload = function(){}
    	   methyl.onload = function(){}
    	   methylbromid.onload = function(){}
    	   
    	   
    	 }
         biLa();
         zeichne();
}//endif
    	 
function zeichne(){	
      	ctx.clearRect(0,0,canvas.width,canvas.height); 
      	
        ctx.fillStyle="rgb(179,100,29)";
        ctx.fillRect(((zeit*17) % 390 )-100,270,100,20);
        if (zeit==39){zeit=16;}
       	if (zeit<10){
      	ctx.font = "12px Arial";
      	ctx.rotate(90*Math.PI/180);
      	ctx.fillText('Licht',50+zeit*10,-135);
      	ctx.rotate(-90*Math.PI/180);
       	ctx.drawImage(brom2,110,130); 
       	            }
        else if(zeit<16){
        ctx.drawImage(bromyl,110,130);
        ctx.drawImage(bromyl,140+(zeit-10)*30,130);
  	                    }
  	    else if(zeit<19){
  	    ctx.drawImage(bromyl,110,130);
        ctx.drawImage(methan,(zeit-16)*30-40,110);
                        }
        else if(zeit<26){
  	    ctx.drawImage(methyl,40,110);
        ctx.drawImage(hbr,(zeit-19)*30+110,130);
        }
        else if (zeit<32){
        ctx.drawImage(methyl,40,110);
        ctx.drawImage(brom2,110,(zeit-26)*30-20);
        }
        else if (zeit<39){
        ctx.drawImage(bromyl,110,130);
        ctx.drawImage(methylbromid,40,(zeit-32)*30+110);
        }
        
}

function renn(){
       zeit +=dt;
	  
      var ani =setTimeout(renn,1000);
      zeichne();
}
    
    
    
document.getElementById('start').onclick = function(){
  	  
  	  zeit=0;
  	  dt=1;
  	  if (!herz){
  	  renn();
  	  herz=true;}	
}
document.getElementById('pause').onclick = function(){
  	if(dt==1){
  	  dt=0;}
  	  else{dt=1;}
}
   
   
  
   
   
