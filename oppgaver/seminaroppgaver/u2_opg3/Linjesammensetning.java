import java.util.Scanner; // Importerer scanner classen
import java.io.File; // Importerer i/o fil.

class Linjesammensetning{ // Opretter en klasse; Linjesammensetning
  public static void main(String[] args) { // Main metode
    String setning = ""; // Oppretter string kallt setning
    Scanner fil = null; // Oppretter ett scanner objekt kalt fil, satt lik null

    try{ // Sjekker om dette går.
      fil = new Scanner(new File("ord.txt"));
    }catch(Exception e){ // Hvis det ikke går..
      System.exit(1); // Avslutter programmet
    } // Hvis det går
    while (fil.hasNextLine()){ // True så lenge fil har en linje til
      setning += fil.nextLine()+ " "; // Legger til linje fra fil, til stringen setning. Går til neste linje.
    }
    System.out.println(setning); // Skriver ut hele stringen setning.
  }

}
