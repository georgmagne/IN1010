import java.util.Scanner; // Importerer scanner objekt

class HeiVerden { // Oppretter en klassse

  public static void main(String[] args) { // Main Metode
    System.out.print("Hei! Hva heter du?  "); // Printer til bruker
    Scanner sc = new Scanner(System.in); // Oppretter Scanner objekt, kallt med sc. Med System.in som parameter (instansvariabel?)
    String navn = sc.nextLine(); // Oppretter en stirng kallt navn, som settes lik linjen til sc.
    System.out.println("Hei, " + navn + "! Velkommen til IN1010!"); // Skriver ut til bruker.

  }
}
