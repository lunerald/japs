var canvas = document.getElementById('AnimBro');
	 canvas.addEventListener("mousedown", mauSi,false);
	  zeit=0;
	  x=125;
	  y=200;
	  
	   herz=false;  
	   
if(canvas.getContext){
    	 var ctx = canvas.getContext('2d');
    	 
    	 function biLa(){
    	   
    	   brom01= new Image();
    	   bromid= new Image();
    	   brompolar= new Image();
    	   c2h4= new Image();
    	   c2h4brplus01= new Image();
    	   c2h4brplus02= new Image();
    	   dibrc2h4= new Image();
    	   
    	   brom01.src='brom01'+'.png'
    	   bromid.src='bromid'+'.png'
    	   brompolar.src='brompolar'+'.png'
    	   c2h4.src='c2h4'+'.png'
    	   c2h4brplus01.src='c2h4brplus01'+'.png'
    	   c2h4brplus02.src='c2h4brplus02'+'.png'
    	   dibrc2h4.src='dibrc2h4'+'.png'
    	   
    	   brom01.onload = function(){}
    	   bromid.onload = function(){}
    	   brompolar.onload = function(){}
    	   c2h4.onload = function(){}
    	   c2h4brplus01.onload = function(){}
    	   c2h4brplus02.onload = function(){}
    	   dibrc2h4.onload = function(){}
    	   
    	   
    	 }
         biLa();
         zeichne();
}//endif
    	 
function zeichne(){	
      	ctx.clearRect(0,0,canvas.width,canvas.height); 
      	
        ctx.fillStyle="rgb(179,100,29)";
        ctx.fillRect(0,270,zeit*10,20);
        
      	if (zeit<12){
      		
      	if (zeit<6){
      	ctx.drawImage(brom01,x,y); }
      	else {
      	ctx.drawImage(brompolar,x,y); }
      	
      	ctx.drawImage(c2h4,100,100);
      	}
      	else if (zeit<16){
      	ctx.drawImage(c2h4brplus01,100,100);
      	ctx.drawImage(bromid,x,y+30); }
        else if (zeit<23){
        ctx.drawImage(c2h4brplus02,100,100);
      	ctx.drawImage(bromid,x,y+30); }
      	else{
      	 ctx.drawImage(dibrc2h4,100,100);}
        
      	ctx.font = "12px Arial";
      	ctx.fillText(String(zeit),20,20);  
      	//ctx.fillText(String(mx),60,20);  
        
}
     
function renn(){
	  zeit +=1;    
	  
	  if (zeit<8){y -=10;}
      
      if (Math.abs(zeit-17)<=1){
      x +=10;}
      
      if (zeit==20 || zeit==21){
      y-=10;}
      if(zeit>29){ 
      zeit=29;}
      var ani =setTimeout(renn,1000);
      zeichne();
}
   
function mauSi(event){
     //reagiert auf Mausklick
  	 mx = event.pageX - event.target.getBoundingClientRect().left;
     if (mx<zeit*10){   
	  zeit = Math.floor(mx / 10); 
	  mx=300;
	  
	  if(zeit<8){
	  zeit=0;
	  x=125; 
	  y=200;}
	  else if(zeit<16){
	  zeit=8;
	  x=125;
	  y=130;}
	  
	  }
  	 if(!herz){
  		 renn();
  		 herz=true;}
  	
}

     
   
   
  
   
   
