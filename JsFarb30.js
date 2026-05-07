

var canvas = document.getElementById('Farbquadrat');
 if(canvas.getContext){
    var ctx = canvas.getContext('2d');
 }
rouge=0;
vert=0;
bleu=0;

function zeichne(){

	        ctx.fillStyle='rgb('+rouge+','+vert+','+bleu+')';
	        ctx.fillRect(0,0,256,256);

 let r = document.getElementById("rot").value;
 let g = document.getElementById("gruen").value;
 let b = document.getElementById("blau").value;

let hex = "#"
 + Number(r).toString(16).padStart(2,"0")
 + Number(g).toString(16).padStart(2,"0")
 + Number(b).toString(16).padStart(2,"0");
 

hex = hex.toUpperCase();

document.getElementById("hexcode").innerHTML = hex;
}
document.getElementById('rot').oninput = function(){
	rouge=parseInt(rot.value);
    zeichne();
}
document.getElementById('gruen').oninput = function(){
	vert=parseInt(gruen.value);
    zeichne();
}
document.getElementById('blau').oninput = function(){
	bleu=parseInt(blau.value);
    zeichne();
}

