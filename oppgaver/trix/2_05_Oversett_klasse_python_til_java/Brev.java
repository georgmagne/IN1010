import java.util.ArrayList;

public class Brev {
  String avsender;
  String mottaker;
  ArrayList<String> linjer;
  public void Brev(String giAvsender, String giMottaker) { // Konstruktør
    avsender = giAvsender;
    mottaker = giMottaker;
    linjer = new ArrayList<String>();
  }

  public void skrivLinje(String linje){
    linjer.add(linje);
  }

  public void lesBrev(){
    System.out.println("Hei, " + mottaker);
    System.out.println();
    for (String elem: linjer){
      System.out.println(elem);
    }
    System.out.println("");
    System.out.println("Hilsen fra, ");
    System.out.println(avsender);
  }

}
