

public class Quadratfunktion
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private double a, b, c ;
    private double scheitelX, scheitelY;
    private int anzahlNullstellen;
    private double[] nullstellen;

    /**
     * Konstruktor für Objekte der Klasse Quadratfunktion
     */
    public Quadratfunktion(double a, double b, double c)
    {
       koeffSetzen(a, b, c);
    }

   
    public double funktionswertBerechnen(double x)
    {
       return a*x*x + b*x + c;
    }
    public void koeffSetzen(double aNeu, double bNeu, double cNeu)
    {
    a = aNeu;
    b = bNeu;
    c = cNeu;
    scheitelBestimmen();
    nullstellenBerechnen();
    }
    public void anzahlNullstellenBestimmen(){
         double diskriminante = b*b - 4*a*c;
          if (diskriminante > 0 ){
            anzahlNullstellen = 2;
          }
          else if (diskriminante == 0){
            anzahlNullstellen = 1;
          }
          else {
            anzahlNullstellen = 0;
          }
         System.out.println("Anzahl Nullstellen:" + anzahlNullstellen);
    }
    public void scheitelBestimmen(){
        scheitelX = -b/(2*a);
        scheitelY = c - b*b / (4*a);
        System.out.println("Scheitel S(" + scheitelX + "|" + scheitelY + ")");
    }
    private void nullstellenBerechnen(){
        anzahlNullstellenBestimmen();
        nullstellen = new double[anzahlNullstellen];
        if (anzahlNullstellen == 2){
           nullstellen[0] = ( -b + Math.sqrt(b*b -4*a*c))/(2*a);
           nullstellen[1] = ( -b - Math.sqrt(b*b -4*a*c))/(2*a);
        }else {
        nullstellen[0] = -b /(2*a);
        }
        for (int i=0; i< anzahlNullstellen; i++){
          System.out.println("Nullstelle N" + (i+1) +"("+ nullstellen[i] + "|0)");
            
    }
}
}