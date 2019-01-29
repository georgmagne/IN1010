public class Bil3 {
  String bilNummer;

  public Bil3(String giNummer) {
    bilNummer = giNummer;

  }
  public void skrivBil() {
    System.out.println("Jeg er en bil! Nummeret mitt er: " + bilNummer);
  }

  public String getNummer() {
    return bilNummer;
  }
}
