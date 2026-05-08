
/* Dieses Programm löst diophantische Gleichungen der Form 
   
   ax + by = c */

public class diophant25
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
     private int a;
     private int b;
     private int c;
    
    /*
     Konstruktor für Objekte der Klasse diophant25
     */
    public diophant25()
    {
	System.out.println("Zahl 1:");
        a = Integer.parseInt(System.console().readLine());
        System.out.println("Zahl 2:");
        b = Integer.parseInt(System.console().readLine());
	System.out.println("Ergebnis:");
        c = Integer.parseInt(System.console().readLine());
	
	int r  = a ;
	int rr = b ;
	int x  = 1 ;
	int xx = 0 ;
 	int y  = 0 ;
 	int yy = 1 ;
	
	while ( rr != 0 ){
		int q  = r / rr ;
		int rn = rr ;
		    rr = r % rr ;
		     r = rn ;
		int xn = xx ;
		    xx = x - q * xx ;
		    x  = xn ;
		int yn = yy ;
		    yy = y - q * yy ;
		    y  = yn ;
}
	if ( c == r ) {

		System.out.println("ggT:" + r + "   x=" + x + "   y=" + y);

	}else if ( c % r == 0 ){
		
		x = x * c / r ;
		y = y * c / r ;

		System.out.println("x=" + x + "   y=" + y);

		int k1 = - x / b ;
		int k2 = y / a ;

	for (int k = k1+1; k<=k2; k++){

		int xk = x + k * b / r ;
		int yk = y - k * a / r ;

		System.out.println("x=" + xk + "   y=" + yk);
}
}else { 

		System.out.println("keine Loesung");

		
}
}

public static void main(String[] args){
diophant25 d = new diophant25();
}
}
