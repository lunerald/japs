
function losGehts(){ 
	var canvas = document.getElementById('AnimSte');
 	if(canvas.getContext){
    	var ctx = canvas.getContext('2d');
	}
	rouge=0;
	vert=0;
	bleu=0;
	dx=10;
	x=-10;
	ang = 0;
	vivi=0;
    vu = 0;
	af = 0;
	egal=4;
	mix=400;
	miy=250;
	sym = 4 * Math.PI/5;

	pus = new Array();
	eck = new Array();

	function poly(){
		for(var n = 0; n <= egal; n++){ 
		eck[n]=new Array();
		pus[n]=new Array();
		}
		//generiere Stern
	
        	pus[0][0]=0;
		pus[0][1]=-150;
		for (var m=1; m <= egal; m++){
		wau = m * sym;
		pus[m]=dreh(pus[0],wau);
		}
		}
poly();

	function zeichne(){

		// Hintergrund
	        ctx.fillStyle='rgb(127,127,127)';
	        ctx.fillRect(0,0,800,500);

		// Polygon in der Mitte
		ctx.fillStyle='rgb('+rouge+','+vert+','+bleu+')';
		ctx.beginPath();
		
		for (var ka=0; ka <= egal; ka++){
		ctx.lineTo(eck[ka][0] + mix, eck[ka][1] + miy);
		ctx.lineTo(eck[ka][0] + mix, eck[ka][1] + miy);
		}
		ctx.closePath();
		ctx.fill();

		for (var i=0; i<=80; i++){
		x +=dx;
 		
		//Gitter-Linien
		ctx.fillStyle='rgb(0,127,255)';
		ctx.fillRect(x,0,2,500);

		//Gitter-Parabel
		yp = 0.0004*Math.pow(x,2) + 100 + 0.2 * x;
		ctx.fillStyle='rgb(0,255,0)';
		ctx.beginPath();
		ctx.moveTo(x+2, yp);
		ctx.lineTo(x+3, yp);
		ctx.lineTo(x+4,500);
		ctx.lineTo(x+2,500);
		ctx.closePath();
		ctx.fill();

		//Gitter-Dreieck
		yd1 = -0.4 * x + 400;
		yd2 = -2*x + 900;
		if (yd2 < yd1 ){
		ctx.fillStyle='rgb(255,0,0)';
		ctx.beginPath();
		ctx.moveTo(x+2, yd2);
		ctx.lineTo(x+4, yd2);
		ctx.lineTo(x+4, yd1);
		ctx.lineTo(x+3, yd1);
		ctx.closePath();
		ctx.fill();
		}
		
		}

		}

     function dreh(punk, wink){
	return{ 0:Math.cos(wink) * punk[0] - Math.sin(wink) * punk[1],
	        1:Math.sin(wink) * punk[0] + Math.cos(wink) * punk[1]};
	}
     
     function affi(punk,k){
        return{ 0:punk[0],
		1:punk[1]*k};
	}
     function renn(){

	for (var j=0; j<=egal; j++){
	eck[j]=affi(dreh(pus[j],ang),Math.cos(vivi));
	}
	vivi= vivi + Math.PI / 1500 *af
	ang = ang + Math.PI / 600 * vu;
        x=-10;
	y=0;
        var ani =setTimeout(renn,20);
	zeichne();
	}

     document.getElementById('dre').onclick = function(){
    	if (vu == 0){vu =1;}
	else{vu =0;}
        }
     document.getElementById('aff').onclick = function(){
    	if (af == 0){af =1;}
	else{af =0;}
        }
     document.getElementById('5stern').onclick = function(){
    	egal=4;
	sym =4 * Math.PI/5;
	poly();
        }
     document.getElementById('quadrat').onclick = function(){
    	egal=3;
	sym = Math.PI/2;
        poly();
        }
     document.getElementById('dreieck').onclick = function(){
    	egal=2;
	sym = 2* Math.PI/3;
        poly();
        }
     document.getElementById('7stern').onclick = function(){
    	egal=6;
	sym =6 * Math.PI/7;
	poly();
        }
     document.getElementById('rot').oninput = function(){
	rouge=parseInt(rot.value);
	}
     document.getElementById('gruen').oninput = function(){
	vert=parseInt(gruen.value);
	}
     document.getElementById('blau').oninput = function(){
	bleu=parseInt(blau.value);
	}
renn();
}
