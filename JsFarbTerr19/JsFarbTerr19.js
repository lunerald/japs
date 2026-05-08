
function losGehts(){ 
	var canvas = document.getElementById('AnimFaT');
	dx=0;
	dy=0;	
	x=-24;
	y=0;
	re=0;
	li=-1;
    ob=0;
	un=0;
	 if(canvas.getContext){
    	 var ctx = canvas.getContext('2d');
	     ctx.fillStyle='rgb(127,127,127)';
	     ctx.fillRect(0,0,hori,hori);
	 }

	
	
	function zeichne(){
		
		rot   = Math.floor(Math.random()*255);
		gruen = Math.floor(Math.random()*255);
		blau  = Math.floor(Math.random()*255);

		ctx.fillStyle='rgb('+rot+','+gruen+','+blau+')';
		ctx.fillRect(x,y,16,16);
		}


 	function renn(){

	if (re != (hori+8)/48){
  	if (x < hori-16-re*24 && y == ob*24){ 
	if (x == hori-16-(re+1)*24){li+=1;}
	dx = 24;
	dy = 0;
	}
    if (x == hori-16-re*24 && y < hori-16-un*24 ){
	if (y == hori-16-(un+1)*24){ob+=1;}
	dx = 0;
	dy = 24;
	}
	if (x > li*24 && y== hori-16-un*24 ){
	if (x == (li+1)*24){re+=1;}
	dx = -24;
	dy = 0;
	}
	if (x == li*24 && y > ob*24 ){
	if (y == (ob+1)*24){un+=1;}
	dx = 0;
	dy = -24;
	}
	x += dx;
	y += dy;
        
 	var ani =setTimeout(renn,zeis);
        zeichne();
        }
	}
renn();
}
