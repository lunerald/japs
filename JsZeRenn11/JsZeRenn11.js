
   function losGehts(){
	   
      function zeichne(i,k){
        var canvas = document.getElementById('AnimZR');
        if(canvas.getContext){
        
        var ctx = canvas.getContext('2d');
        var bild3 = new Image();
        var bild4 = new Image();
        ctx.clearRect(0,0,canvas.width,canvas.height);
        if (k==3) {
        	 bild3.onload = function(){ 
        ctx.drawImage(bild3,i,50);
        	 }
        }
        if(k==4){
        	 bild4.onload = function(){ 
        ctx.drawImage(bild4,i,50);
        	 }
        }
  
        bild3.src='zwe03.png';
        bild4.src='zwe04.png';
        
                             }
    }
   i=0;
   k=3;
   function renn(){
    i+=10;
   if (i<450){
	   if (k==3){k=4;}else{k=3;}
    var ani =setTimeout(renn,400);
    zeichne(i,k);
             }
                  }
    renn();
    }

 