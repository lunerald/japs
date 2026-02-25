
	 var canvas2 = document.getElementById('AnimAzo');
	  zeit2=0;
	   dt2=0;
	   
	 if(canvas2.getContext){
    	 var ctx2 = canvas2.getContext('2d');
    	 
    	 function biLa2(){
    	   
    	   azo01= new Image();
    	   azo02= new Image();
    	   azo03= new Image();
    	   azo04= new Image();
    	   azo05= new Image();
    	   azo06= new Image();
    	   azo07= new Image();
    	   azo08= new Image();
    	   azo09= new Image();
    	   azo10= new Image();
    	   azo11= new Image();
    	   azo12= new Image();
    	  
    	   azo01.src='azo01'+'.png'
    	   azo02.src='azo02'+'.png'
    	   azo03.src='azo03'+'.png'
    	   azo04.src='azo04'+'.png'
    	   azo05.src='azo05'+'.png'
    	   azo06.src='azo06'+'.png'
    	   azo07.src='azo07'+'.png'
    	   azo08.src='azo08'+'.png'
    	   azo09.src='azo09'+'.png'
    	   azo10.src='azo10'+'.png'
    	   azo11.src='azo11'+'.png'
    	   azo12.src='azo12'+'.png'

    	  
    	   azo01.onload = function(){}
    	   azo02.onload = function(){}
    	   azo03.onload = function(){}
    	   azo04.onload = function(){}
    	   azo05.onload = function(){}
    	   azo06.onload = function(){}
    	   azo07.onload = function(){}
    	   azo08.onload = function(){}
    	   azo09.onload = function(){}
    	   azo10.onload = function(){}
    	   azo11.onload = function(){}
    	   azo12.onload = function(){}
    	  

    	  
    	 }
         biLa2();
         zeichne2();
	  }//endif
    	 
      function zeichne2(){	
      	ctx2.clearRect(0,0,canvas2.width,canvas2.height); 
      	
        
        switch (zeit2){
        case (1): ctx2.drawImage(azo01,20,20); 
        break;
        case (2): ctx2.drawImage(azo02,20,20); 
        break;
        case (3): ctx2.drawImage(azo03,20,20); 
        break;
        case (4): ctx2.drawImage(azo04,20,20); 
        break;
        case (5): ctx2.drawImage(azo05,20,20); 
        break;
        case (6): ctx2.drawImage(azo06,20,20); 
        break;
        case (7): ctx2.drawImage(azo07,20,20); 
        break;
        case (8): ctx2.drawImage(azo08,20,20); 
        break;
        case (9): ctx2.drawImage(azo09,20,20); 
        break;
        case (10): ctx2.drawImage(azo10,20,20); 
        break;
         case (11): ctx2.drawImage(azo11,20,20); 
        break;
        case (12): ctx2.drawImage(azo12,20,20); 
        break;
        
      	}
   
        }
     
   function renn2(){
	  zeit2 +=dt2; 
	  
	  if(zeit2==13){
	  zeit2=1;
	  }
	  if(zeit2==0){
	  zeit2=12;
	  }
	  
      var ani2 =setTimeout(renn2,1000);
      zeichne2();
    }
 document.getElementById('vor').onclick = function(){
 dt2=1;
 }
  document.getElementById('stopp2').onclick = function(){
 dt2=0;
 }
 document.getElementById('zurueck').onclick = function(){
 dt2=-1;
 }

     
   
   
  
   
   
