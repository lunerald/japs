
public class pytrip23
{
    // Instanzvariablen 
     private int u;
     private int o;
     private boolean dummy;
    
    /*
      Konstruktor für Objekte der Klasse pytrip23
     */
    public pytrip23()
    {
	System.out.println("Untere Grenze:");
        u = Integer.parseInt(System.console().readLine());
        System.out.println("Obere  Grenze:");
        o = Integer.parseInt(System.console().readLine());
	System.out.println("Vielfache erlaubt? J/n");
	String jn = System.console().readLine();

     	System.out.println("c -- b -- a");
	for (int c=u; c<=o; c++) {
	for (int b=1; b<c; b++) {
	for (int a=1; a<b; a++) {
	
	if ( Math.pow(c,2) == Math.pow(b,2) + Math.pow(a,2) ){
	
	dummy = true ;

	if ( jn.equals("n") && gcd(a,b) != 1 ){
	dummy = false ;
	}
	
	if ( dummy ){
	System.out.println(c + "  " + b + "  " + a);
	}
	}
	}
	}
	}
}

	public int gcd(int eins, int zwei){
	int r  = eins;
	int rr = zwei;
	

	while ( rr != 0 ){

		int rn = rr ;
		    rr = r % rr ;
		     r = rn ;
	
}
	return r;
}
public static void main(String[] args){
pytrip23 d = new pytrip23();
}
}
