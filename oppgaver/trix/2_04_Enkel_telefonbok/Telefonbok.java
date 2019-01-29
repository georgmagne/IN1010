import java.util.HashMap;
import java.util.Scanner;


public class Telefonbok{
  public static void main(String[] args) {
    HashMap<String, String> telefonbok = new HashMap<>(); // Initialiserer en HashMap, med Nøkkel; String og Verdi; String.
    telefonbok.put("Arne", "22334455"); // Legger til Nøkkel; Arne og Verdi; 22334455
    telefonbok.put("Lisa", "98989898");
    telefonbok.put("Jonas", "97959759");
    telefonbok.put("Peder", "123456789");

    Scanner in = new Scanner(System.in); // Oppretter Scanner objekt, satt lik bruker input
    int input = 0;

    while (input != 1) {
      System.out.println("Meny:\n0: Soek etter person\n1: Avslutt");
      input = Integer.parseInt(in.nextLine()); // Gjør om input fra Scanner til integer og setter input lik denne.

      if (input == 0) { // Hvis input er 0.
        System.out.println("Hvem vil du ha nummeret til?"); // Ber bruker om hvilket navn de vil søke etter. Case sensitivt.
        String navn = in.nextLine(); // String varabelen blir satt lik denne nye inputen.

        if (telefonbok.containsKey(navn)) { // Hvis telefonbok har dette navnet.
          String tlf = telefonbok.get(navn); // String varabelen til, blir satt lik verdien til navnet som ble søkt og funnet.
          System.out.println("Navn: " + navn + "tlf: " + tlf);
        } else { // Hvis navnet ikke finnes i HashMappen
          System.out.println("Fant ikke " + navn + ".");
        }
      }
    }
    // Når bruker har avsluttet søkingen.
    System.out.println("Oversikt:");
    for (String navnekey : telefonbok.keySet()) { // Går gjennom hvert element i telefonboken og skrivet ut navnet + tlfnummer.
      System.out.println("Navn: " + navnekey + ", tlf: " + telefonbok.get(navnekey));
    }
  }
}
