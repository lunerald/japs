
        rou = new Array(0,255);
	ver = new Array(127,127);
	ble = new Array(255,0);

	an = 0;
	vi = 0;
        vu = 0;
	af = 0;
	

	hixy = new Array(-240,0);

    eck = new Array();
    xy  = new Array();
    zahl= new Array();
    h1  = new Array();
    h2  = new Array();

function haupt_menu(){
    for (var i=0; i < 5; i++){
        temp_option = new Option(i+5);
        document.menu.haupt_menu.options[i] = temp_option;
    }
}

function sub_menu(sub){

    for (var h=0; h <= Math.floor(sub/2)+1; h++){
        temp_option = new Option(h);
        document.menu.sub_menu.options[h] = temp_option;
        }
}

function rebuild_menu(menindex){
// leeren
    document.menu.sub_menu.length = 0;

// neu schreiben 
    sub_menu(menindex);
}

function wert(ec,or){
        ord = parseInt(or);
        ez  = parseInt(ec);

        for(q =0; q<=zahl.length; q++){
          delete zahl[q],h1[q],h2[q];
        }
        
        e4 = ez * 4;
       
        hiw = Math.PI / ez;
       
    
        for (var j=0; j< e4; j++){
        h1[j]= j; 
        }

        if(or > 0){
            for (var f=1; f <= Math.pow(2,ord) ; f++){

                    //im Uhrzeigersinn
                for (var c1 = f; c1 < e4-1; c1++){
                  
                     h2[c1]   = h1[c1+1];
                }

                     h2[e4-1] = h1[f];
                    
                for (var c2 = 0;  c2 < f; c2++){

                     h2[c2] = h1[c2];

                }
                // Arrays abgleichen 
                for (var z=0; z< e4; z++){
                    h1[z]=h2[z];
                }
            }
        }

        zahl = h1 ;
               

        eck[0] = dreh(hixy, hiw * (ord + 1));
      
        eck[1] = affi(eck[0],0);
       
        eck[2] = streck(eck[1],0.9);
        
        eck[3] = streck(eck[0],0.9);
           
}

function koordi(){
		for (var n1 = 0 ; n1 < e4; n1++){
             xy[n1]=new Array();

           j1 = Math.floor(n1 / 4);//rotation
           j2 = Math.floor(n1 / 2) % 2;// zentrische Streckung x- Richtung
           j3 = n1 % 2;// Affinität y- Richtung
       
                 for (var t4 = 0; t4 < 4; t4++){// Ecken Trapeze
                           xy[n1][t4]=new Array();

                            if ( j2 == 1 && t4 > 1){ 
                               ka =0.5;
                               }else{
                               ka = j2;
                            }
                            if ( j2 == 1  && j3 == 1 && (t4 == 0 || t4 ==3)){
                               es = -0.5;
                               }else{
                               es = Math.pow(-1,j3);
                            }
                                     
          xy[n1][t4] = affi(dreh(affi(streck(eck[t4],Math.pow(0.9,ka)),es),2 * hiw * j1 + vi),Math.cos(an));
      
		          }
		            
        }   
           
zeichne();
}
       
function zeichne(){
        var element = document.getElementById('Sterngen');
 	    if(element.getContext){
              var context = element.getContext('2d');
            }

        context.clearRect(0,0,480,480);
		
		for (var m1=0; m1 < e4; m1++){
           
           r1 = zahl[m1];            
           i1 = Math.floor(r1 / 2) % 2;

           context.fillStyle='rgb('+rou[i1]+','+ver[i1]+','+ble[i1]+')';
           context.beginPath();
              
           for (var t3 = 0; t3 < 4; t3++){

		       context.lineTo(xy[r1][t3][0]+240,xy[r1][t3][1]+240);
		   }
		   context.closePath();
           context.fill();
                   
         }
}
	

function streck(punk, ks){
        return{ 0:punk[0] * ks ,
		        1:punk[1] * ks};
}

function dreh(punk, wink){
	return{ 0:Math.cos(wink) * punk[0] - Math.sin(wink) * punk[1],
	        1:Math.sin(wink) * punk[0] + Math.cos(wink) * punk[1]};
}
     
function affi(punk, aa){
        return{ 0:punk[0] ,
		        1:punk[1] * aa};
}
    
function renn(){

	an = an + Math.PI / 1500 *af;
	vi = vi + Math.PI / 600 * vu;
   
    var ani =setTimeout(renn,20);

	koordi();
}


document.getElementById('dre').onclick = function(){
    	if (vu == 0){vu =1;}
	else{vu =0;}
}
    
document.getElementById('aff').onclick = function(){
    	if (af == 0){af =1;}
	else{af =0;}
}
  
document.getElementById('rota').oninput = function(){
	rou[0]=parseInt(rota.value);
}
     
document.getElementById('gruena').oninput = function(){
	ver[0]=parseInt(gruena.value);
}
     
document.getElementById('blaua').oninput = function(){
	ble[0]=parseInt(blaua.value);
}
    
document.getElementById('roti').oninput = function(){
	rou[1]=parseInt(roti.value);
}
     
document.getElementById('grueni').oninput = function(){
	ver[1]=parseInt(grueni.value);
}
     
document.getElementById('blaui').oninput = function(){
	ble[1]=parseInt(blaui.value);
}


