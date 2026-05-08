
function losGehts(){ 
	var canvas = document.getElementById('StaPli');


	dx=10;
	dy=10;	
	x=-10;
	y=0;
	ang = 0;
        vu = 0;

	mix=250;
	miy=400;

	nix=280;
	niy=370;
	
	pus = new Array();
        for (var j=0; j<=11; j++){
	pus[j]=new Array();
	}
        pus[0][0]=-50;
	pus[0][1]=-200;
	
	pus[1][0]=50;
	pus[1][1]=-200;
	
	pus[2][0]=50;
	pus[2][1]=-100;
	
	pus[3][0]=150;
	pus[3][1]=-100;

	pus[4][0]=150;
	pus[4][1]=0;

	pus[5][0]=50;
	pus[5][1]=0;

	pus[6][0]=50;
	pus[6][1]=200;

	pus[7][0]=-50;
	pus[7][1]=200;

	pus[8][0]=-50;
	pus[8][1]=0;

	pus[9][0]=-150;
	pus[9][1]=0;

	pus[10][0]=-150;
	pus[10][1]=-100;

	pus[11][0]=-50;
	pus[11][1]=-100;

	
	 if(canvas.getContext){
    	 var ctx = canvas.getContext('2d');  
	 }
 
	function zeichne(){
	        ctx.fillStyle='rgb(127,127,127)';
	        ctx.fillRect(0,0,500,800);
		
		ctx.fillStyle='rgb(0,0,127)';
		ctx.beginPath();
		for (var k=0; k<=11; k++){
		ctx.lineTo(pus[k][0] + nix, pus[k][1] + niy);
		}
		ctx.closePath();
		ctx.fill();

		ctx.fillStyle='rgb(162,0,162)';
		ctx.beginPath();
		for (var n=0; n<=11; n++){
		ctx.lineTo(pus[n][0] + mix, pus[n][1] + miy);
		}
		ctx.closePath();
		ctx.fill();




		for (var i=0; i<=50; i++){
		x +=dx;
 		y +=dy;
		

		ctx.fillStyle='rgb(255,0,0)';
		ctx.fillRect(x,0,2,400-y);
		ctx.fillStyle='rgb(255,127,0)';
		ctx.fillRect(x+2,0,2,800);

		ctx.fillStyle='rgb(0,0,0)';
		ctx.font = "30px Arial";
      		ctx.fillText("Für Lars",100,100);
		ctx.fillText("Zur Konfirmation",100,700);

		ctx.fillStyle='rgb(255,255,0)';
		ctx.beginPath();
		ctx.lineTo(x+4, 800-y);
		ctx.lineTo(x+6,800);
		ctx.lineTo(x+4,800);
		ctx.closePath();
		ctx.fill();
		
		}

		}
	
zeichne();
}
