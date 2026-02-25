
	 var canvas1 = document.getElementById('AnimMeso');
	  zeit1=0;
        dt=1; 
	   
	 if(canvas1.getContext){
    	 var ctx1 = canvas1.getContext('2d');
    	 
    	 function biLa1(){
    	   
    	  
    	   anilin01= new Image();
    	   anilin02= new Image();
    	   anilin03= new Image();
    	   anilin04= new Image();
    	   anilin05= new Image();
    	   
    	   benzaldehyd01= new Image();
    	   benzaldehyd02= new Image();
    	   benzaldehyd03= new Image();
    	   benzaldehyd04= new Image();
    	   benzaldehyd05= new Image();
    	   
    	   brombenzen01= new Image();
    	   brombenzen02= new Image();
    	   brombenzen03= new Image();
    	   brombenzen04= new Image();
    	   brombenzen05= new Image();
    	   
    	   nitrobenzen01= new Image();
    	   nitrobenzen02= new Image();
    	   nitrobenzen03= new Image();
    	   nitrobenzen04= new Image();
    	   nitrobenzen05= new Image();
    	   
    	   phenol01= new Image();
    	   phenol02= new Image();
    	   phenol03= new Image();
    	   phenol04= new Image();
    	   phenol05= new Image();
    	   
    	   phenolat01= new Image();
    	   phenolat02= new Image();
    	   phenolat03= new Image();
    	   phenolat04= new Image();
    	   phenolat05= new Image();
    	  
    	   anilin01.src='anilin01'+'.png'
    	   anilin02.src='anilin02'+'.png'
    	   anilin03.src='anilin03'+'.png'
    	   anilin04.src='anilin04'+'.png'
    	   anilin05.src='anilin05'+'.png'
    	   
    	   benzaldehyd01.src='benzaldehyd01'+'.png'
    	   benzaldehyd02.src='benzaldehyd02'+'.png'
    	   benzaldehyd03.src='benzaldehyd03'+'.png'
    	   benzaldehyd04.src='benzaldehyd04'+'.png'
    	   benzaldehyd05.src='benzaldehyd05'+'.png'
    	   
    	   brombenzen01.src='brombenzen01'+'.png'
    	   brombenzen02.src='brombenzen02'+'.png'
    	   brombenzen03.src='brombenzen03'+'.png'
    	   brombenzen04.src='brombenzen04'+'.png'
    	   brombenzen05.src='brombenzen05'+'.png'
    	   
    	   nitrobenzen01.src='nitrobenzen01'+'.png'
    	   nitrobenzen02.src='nitrobenzen02'+'.png'
    	   nitrobenzen03.src='nitrobenzen03'+'.png'
    	   nitrobenzen04.src='nitrobenzen04'+'.png'
    	   nitrobenzen05.src='nitrobenzen05'+'.png'
    	   
    	   phenol01.src='phenol01'+'.png'
    	   phenol02.src='phenol02'+'.png'
    	   phenol03.src='phenol03'+'.png'
    	   phenol04.src='phenol04'+'.png'
    	   phenol05.src='phenol05'+'.png'
    	   
    	   phenolat01.src='phenolat01'+'.png'
    	   phenolat02.src='phenolat02'+'.png'
    	   phenolat03.src='phenolat03'+'.png'
    	   phenolat04.src='phenolat04'+'.png'
    	   phenolat05.src='phenolat05'+'.png'
    	  
    	   anilin01.onload = function(){}
    	   anilin02.onload = function(){}
    	   anilin03.onload = function(){}
    	   anilin04.onload = function(){}
    	   anilin05.onload = function(){}
    	   
    	   benzaldehyd01.onload = function(){}
    	   benzaldehyd02.onload = function(){}
    	   benzaldehyd03.onload = function(){}
    	   benzaldehyd04.onload = function(){}
    	   benzaldehyd05.onload = function(){}
    	   
    	   brombenzen01.onload = function(){}
    	   brombenzen02.onload = function(){}
    	   brombenzen03.onload = function(){}
    	   brombenzen04.onload = function(){}
    	   brombenzen05.onload = function(){}
    	   
    	   nitrobenzen01.onload = function(){}
    	   nitrobenzen02.onload = function(){}
    	   nitrobenzen03.onload = function(){}
    	   nitrobenzen04.onload = function(){}
    	   nitrobenzen05.onload = function(){}
    	   
    	   phenol01.onload = function(){}
    	   phenol02.onload = function(){}
    	   phenol03.onload = function(){}
    	   phenol04.onload = function(){}
    	   phenol05.onload = function(){}
    	   
    	   phenolat01.onload = function(){}
    	   phenolat02.onload = function(){}
    	   phenolat03.onload = function(){}
    	   phenolat04.onload = function(){}
    	   phenolat05.onload = function(){}
    	  
    	 }
         biLa1();
         zeichne1();
	  }//endif
    	 
      function zeichne1(){	
      	ctx1.clearRect(0,0,canvas1.width,canvas1.height); 
      	
        ctx1.fillStyle="rgb(179,100,29)";
        
        if (name=="Anilin"){
        switch (zeit1){
        case (1): ctx1.drawImage(anilin01,100,100); 
        break;
        case (2): ctx1.drawImage(anilin02,100,100); 
        break;
        case (3): ctx1.drawImage(anilin04,100,100); 
        break;
        case (4): ctx1.drawImage(anilin03,100,100); 
        break;
        case (5): ctx1.drawImage(anilin05,100,100); 
        break;
      	}
      	}
      	
      	 if (name=="Benzaldehyd"){
        switch (zeit1){
        case (1): ctx1.drawImage(benzaldehyd01,100,100); 
        break;
        case (2): ctx1.drawImage(benzaldehyd02,100,100); 
        break;
        case (3): ctx1.drawImage(benzaldehyd04,100,85); 
        break;
        case (4): ctx1.drawImage(benzaldehyd03,100,85); 
        break;
        case (5): ctx1.drawImage(benzaldehyd05,100,85); 
        break;
      	}
      	}
      	
      	 if (name=="Brombenzen"){
        switch (zeit1){
        case (1): ctx1.drawImage(brombenzen01,100,100); 
        break;
        case (2): ctx1.drawImage(brombenzen02,100,100); 
        break;
        case (3): ctx1.drawImage(brombenzen04,100,80); 
        break;
        case (4): ctx1.drawImage(brombenzen03,100,80); 
        break;
        case (5): ctx1.drawImage(brombenzen05,100,80); 
        break;
      	}
      	}
      	
      	 if (name=="Nitrobenzen"){
        switch (zeit1){
        case (1): ctx1.drawImage(nitrobenzen01,100,100); 
        break;
        case (2): ctx1.drawImage(nitrobenzen02,100,100); 
        break;
        case (3): ctx1.drawImage(nitrobenzen04,100,85); 
        break;
        case (4): ctx1.drawImage(nitrobenzen05,100,85); 
        break;
        case (5): ctx1.drawImage(nitrobenzen03,100,85); 
        break;
      	}
      	}
      	
      	 if (name=="Phenol"){
        switch (zeit1){
        case (1): ctx1.drawImage(phenol01,100,100); 
        break;
        case (2): ctx1.drawImage(phenol02,100,100); 
        break;
        case (3): ctx1.drawImage(phenol04,100,85); 
        break;
        case (4): ctx1.drawImage(phenol03,100,85); 
        break;
        case (5): ctx1.drawImage(phenol05,100,85); 
        break;
      	}
      	}
      	
      	 if (name=="Phenolat"){
        switch (zeit1){
        case (1): ctx1.drawImage(phenolat01,100,85); 
        break;
        case (2): ctx1.drawImage(phenolat02,100,85); 
        break;
        case (3): ctx1.drawImage(phenolat04,100,100); 
        break;
        case (4): ctx1.drawImage(phenolat03,100,100); 
        break;
        case (5): ctx1.drawImage(phenolat05,100,100); 
        break;
      	}
      	}
      	ctx1.font = "12px Arial";
      	ctx1.fillText(name,20,20); 
        
        }
     
   function renn1(){
	  zeit1 +=dt; 
	  
	  if(zeit1==6){
	  zeit1=1;
	  }
	  
      var ani =setTimeout(renn1,1000);
      zeichne1();
    }
   
 
 document.getElementById('anilin').onclick = function(){
 name ="Anilin";
 }
 document.getElementById('brombenzen').onclick = function(){
 name ="Brombenzen";
 }
 document.getElementById('benzaldehyd').onclick = function(){
 name ="Benzaldehyd";
 }
 document.getElementById('phenol').onclick = function(){
 name ="Phenol";
 }
 document.getElementById('phenolat').onclick = function(){
 name ="Phenolat";
 }
 document.getElementById('nitrobenzen').onclick = function(){
 name ="Nitrobenzen";
 }
 document.getElementById('stopp').onclick = function(){
 if (dt==1){dt=0;}
 else{dt=1;}
 }

     
   
   
  
   
   
