
/**
 * Beschreiben Sie hier die Klasse diart01.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class diart02
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
     private int z1;
     private int z2;
     private int z3;
     private int z4;
     private int z5;
     private int z6;
     private int z7;
     private int z8;
     private int z9;
     private int z10;
     private int z11;
     private int z12;
     private int z13;
     private int z14;
     private int z15;
     private int z16;
    /**
     * Konstruktor für Objekte der Klasse diart01
     */
    public diart02()
    {
        for (int a=0; a<8; a++) {
            for (int b=0; b<8; b++) {
                if (a != b ){
                for (int c=0; c<8; c++) {
                    if (a != c && b != c){
                    for (int d=0; d<8; d++) {
                        if(a != d && b != d && c != d ){
                        for (int e=0; e<8; e++) {  
                            if (a != e && b != e && c != e && d != e ){
                            for (int f=0; f<8; f++) {
                                if (a != f && b != f && c != f && d != f && e != f ){                                
                                    for (int g=0; g<8; g++) {
                                        if (a != g && b != g && c != g && d != g && e != g && f != g){
                                            for (int h=0; h<8; h++) {
                                                 if (a != h && b != h && c != h && d != h && e != h && f!= h && g != h){
    z1 = 512*a+64*b+8*c+b;
    z2 = 512*b+64*d+8*e+f;
    z3 = 512*g+64*h+8*a+h;
    z4 = 512*d+64*a+8*b+a;
    z5 = 512*g+64*d+8*c+h;
    z6 = f;
    z7 = h;
    z8 = 512*f+64*a+8*b+e;
    z9 = 512*h+64*c+8*h+g;
    z10 = 8*a+c;
    z11 = 512*d+64*a+8*f+c;
    z12 = 512*g+64*e+8*g+g;
    z13 = 512*h+64*d+8*g+e;
    z14 = 512*f+64*c+8*d+a;
    z15 = 512*h+64*f+8*h+b;
    z16 = 512*b+64*a+8*g+c;
  
    if ((z1- z2 + z3) == z4 && z5 / z6 * z7 == z8 && z9 + z10 -z11 == z12 && z13 - z14 + z15 == z16 && z1 + z5 - z9 == z13 && z2 / z6 + z10 == z14 && z3 / z7 + z11 == z15 && z4 + z8 - z12 == z16){
            System.out.println("A="+ a );
            System.out.println("B="+ b );
            System.out.println("C="+ c );
            System.out.println("D="+ d );
            System.out.println("E="+ e );
            System.out.println("F="+ f );
            System.out.println("G="+ g );
            System.out.println("H="+ h );
System.out.println("z1="+ z1 );
System.out.println("z2="+ z2 );
System.out.println("z3="+ z3 );
System.out.println("z4="+ z4 );
System.out.println("z5="+ z5 );
System.out.println("z6="+ z6 );
System.out.println("z7="+ z7 );
System.out.println("z8="+ z8 );
System.out.println("z9="+ z9 );
System.out.println("z10="+ z10 );
System.out.println("z11="+ z11 );
System.out.println("z12="+ z12 );
System.out.println("z13="+ z13 );
System.out.println("z14="+ z14 );
System.out.println("z15="+ z15 );
System.out.println("z16="+ z16 );
    }

}
}
}
}
}
}
}
}
}
}
}
}
}
}
}
}
public static void main(String[] args){
diart02 d = new diart02();
}
}
