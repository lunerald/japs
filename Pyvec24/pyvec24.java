
public class pyvec24
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
     private int u;
     private int o;
     private boolean dummy;
    
    /*
     Konstruktor für Objekte der Klasse pyvec24
     */
    public pyvec24()
    {
	System.out.println("Untere Grenze:");
        u = Integer.parseInt(System.console().readLine());
        System.out.println("Obere  Grenze:");
        o = Integer.parseInt(System.console().readLine());
	System.out.println("Vielfache erlaubt? J/n");
	String jn = System.console().readLine();

     	System.out.println("d -- c -- b -- a");
	for (int d=u; d<=o; d++) {
	for (int c=1; c<=d; c++) {
	for (int b=1; b<=c; b++) {
	for (int a=1; a<=b; a++) {
	
	if ( Math.pow(d,2) == Math.pow(c,2) + Math.pow(b,2) + Math.pow(a,2) ){
	
	dummy = true ;
	

	if ( jn.equals("n") && gcd(gcd(a,b),gcd(b,c)) != 1 ){
	dummy = false ;
	}
	
	if ( dummy ){
	System.out.println(d + "    " + c + "    " + b + "    " + a);
	}
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
pyvec24 d = new pyvec24();
}
}
