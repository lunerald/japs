var canvas = document.getElementById('AnimBenz');
    canvas.addEventListener("mousedown", mauSi,false);
    zeit=0;
    x=120;
    y=250;
    dummy=1;
    herz=false;  
	   
if(canvas.getContext){
    	 var ctx = canvas.getContext('2d');
    	 
       function biLa(){
    	   
    	   benzen01= new Image();
    	   benzen02= new Image();
    	   picomplex= new Image();
    	   sigmacomplex01= new Image();
    	   sigmacomplex02= new Image();
    	   sigmacomplex03= new Image();
    	   brombenzen01= new Image();
    	   brombenzen02= new Image();
    	   proton= new Image();
    	   brom2= new Image();
    	   brompolar= new Image();
    	   bromid= new Image();
    	   bromplus= new Image();
    	   febr3= new Image();
    	   febr4= new Image();
    	   hbr= new Image();
    	   
    	    benzen01.src='benzen01'+'.png'
    	   benzen02.src='benzen02'+'.png'
    	   picomplex.src='picomplex'+'.png'
    	   sigmacomplex01.src='sigmacomplex01'+'.png'
    	   sigmacomplex02.src='sigmacomplex02'+'.png'
    	   sigmacomplex03.src='sigmacomplex03'+'.png'
    	   brombenzen01.src='brombenzen01'+'.png'
    	   brombenzen02.src='brombenzen02'+'.png'
    	   proton.src='proton'+'.png'
    	   brom2.src='brom2'+'.png'
    	   brompolar.src='brompolar'+'.png'
    	   bromid.src='bromid'+'.png'
    	   bromplus.src='bromplus'+'.png'
    	   febr3.src='febr3'+'.png'
    	   febr4.src='febr4'+'.png'
           hbr.src='hbr'+'.png'
           
    	   benzen01.onload = function(){}
    	   benzen02.onload = function(){}
    	   picomplex.onload = function(){}
    	   sigmacomplex01.onload = function(){}
    	   sigmacomplex02.onload = function(){}
    	   sigmacomplex03.onload = function(){}
    	   brombenzen01.onload = function(){}
    	   brombenzen02.onload = function(){}
    	   proton.onload = function(){}
    	   brom2.onload = function(){}
    	   brompolar.onload = function(){}
    	   bromid.onload = function(){}
    	   bromplus.onload = function(){}
    	   febr3.onload = function(){}
    	   febr4.onload = function(){} 
    	   hbr.onload = function(){}
    	   
    	}
       biLa();
       zeichne();
}//endif
    	 
function zeichne(){	
      	ctx.clearRect(0,0,canvas.width,canvas.height); 
      	
        ctx.fillStyle="rgb(179,100,29)";
        ctx.fillRect(0,270,zeit*7.5,20);
        
      	
        
        
        
        if (zeit<16){
        ctx.drawImage(febr3,200,130); 
      	if (zeit<7){
      	ctx.drawImage(brom2,x,y); }
      	else if (zeit<12){
      	ctx.drawImage(brompolar,x,y-15); }
      	
      	if (dummy==1){
      	ctx.drawImage(benzen01,50,150);
      	dummy=2;
      	}else {
      	ctx.drawImage(benzen02,50,150);
      	dummy=1;
      	}
      	if(zeit >11 && zeit<16){
      	ctx.drawImage(bromplus,x+15,y); 
        ctx.drawImage(bromid,265-x,y); 
        }
        }else if(zeit<20){
        ctx.drawImage(picomplex,60,150); 
        ctx.drawImage(febr4,170,130); 
        }else if(zeit<26){
        ctx.drawImage(febr4,170,130); 
        if (dummy==1){
      	ctx.drawImage(sigmacomplex01,60,150);
      	dummy=2;
      	}else if(dummy==2){
      	ctx.drawImage(sigmacomplex02,60,150);
      	dummy=3;
      	}else if(dummy==3){
      	ctx.drawImage(sigmacomplex03,60,150);
      	dummy=1;
      	}
        }else if(zeit<=40){
        
        if (dummy==1){
      	ctx.drawImage(brombenzen01,50,160);
      	dummy=2;
      	}else {
      	ctx.drawImage(brombenzen02,50,160);
      	dummy=1;
      	}
      	if(zeit<30){
      	ctx.drawImage(febr4,170,130); 
        ctx.drawImage(proton,x+15,y-10);
      	}else{
      	ctx.drawImage(febr3,200,130); 
        ctx.drawImage(hbr,x,y-10);
      	}
      	}
      	ctx.font = "12px Arial";
      	ctx.fillText(String(zeit),20,20);  
      	//ctx.fillText(String(mx),60,20);  
        
}
     
function renn(){
	  zeit +=1;    
	  
	  if (zeit<10){y -=10;}
      if (zeit==12 || zeit==13){x -=10;}
      if(zeit>25 && zeit<30){x +=10;}
	  if(zeit>29 && zeit<35){y -=10;}
      if(zeit>40){ 
      zeit=40;}
      var ani =setTimeout(renn,1000);
      zeichne();
}
   
function mauSi(event){
     //reagiert auf Mausklick
  	 mx = event.pageX - event.target.getBoundingClientRect().left;
     if (mx<zeit*10){   
	  zeit = Math.floor(mx / 10); 
	  mx=300;
	  
	  if(zeit<7){
	  zeit=0;
	  x=120; 
	  y=250;}
	  else if(zeit<16){
	  zeit=7;
	  x=120;
	  y=180;}
	  
	  }
  	 if(!herz){
  		 renn();
  		 herz=true;}
  	
}

     
   
   
  
   
   
