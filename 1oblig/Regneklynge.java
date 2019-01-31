import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

class Regneklynge {

  ArrayList<Rack> rackListe = new ArrayList<Rack>();  // Bruker ArrayList fordi antall rack ikke er fastsatt, og potensielt uendelig.
  int maxNoderPerRack; // Initialisering av instansvariabel.


  public Regneklynge(String filnavn) throws Exception { // Kontruktør
    rackListe = new ArrayList<Rack>(); // Setter rackListe lik nytt ArrayList med Rack-objekter.

    Scanner fil = new Scanner(new File(filnavn));
    String sMaxNoderPerRack = fil.nextLine();
    maxNoderPerRack = Integer.parseInt(sMaxNoderPerRack); // Første linje i filen. Henviser til max antall noder i rack.
    rackListe.add(new Rack(maxNoderPerRack)); // Ett rack blir opprettet samtidig som regneklyngen.

    while (fil.hasNextInt()){ // Så lenge fil har en int til.

      String linjer = fil.nextLine();
      String[] biter = linjer.split(" ");

      String sLagAntNoder = biter[0];
      String sMinne = biter[1];
      String sProsessor = biter[2];

      int lagAntNoder = Integer.parseInt(sLagAntNoder);
      int minne = Integer.parseInt(sMinne);
      int prosessor = Integer.parseInt(sProsessor);


      for (int i = 0; i < lagAntNoder; i++) { // Kjøres lagAntNoder ganger, og legger til en node hver gang.
        settInnNode(new Node(minne, prosessor)); // Node med 64GB og en Prosessor blir satt inn.
      }
    }

  }

  public void lagRack(){
    rackListe.add(new Rack(maxNoderPerRack)); // Oppretter nytt tomt rack og legger det til rackListe.
  }

  public void settInnNode(Node node){ // Node opprettes og settes inn i passende rack i regneklyngen.
    if (!rackListe.get(rackListe.size()-1).erFull()) { // Hvis det siste racket ikke er fullt.
      rackListe.get(rackListe.size()-1).settInn(node); // Node blir satt inn i siste element i rackListe
    } else { // Hvis alle rack i rackListe er fulle.
      lagRack(); // Nytt rack blir opprettet
      rackListe.get(rackListe.size()-1).settInn(node); // Node blir satt inn i siste element i rackListe
      }
  }

  public int totNoderMedNokMinne(int nokMinne){ // Returnerer antall noder som har nok minne, sammenlignet med det gitte parameteret.
    int totNoderNokMinne = 0;

    for (int i = 0; i < rackListe.size(); i++){
      totNoderNokMinne += rackListe.get(i).noderMedNokMinne(nokMinne);
    }

    return totNoderNokMinne;
  }

  public int antTotProsessorer(){ // Returnerer antall prosessorer i regneklyngen.
    int totPros = 0; // Prosessor teller.

    for (int i = 0; i < rackListe.size(); i++){ // Itererer gjennom rackListe
      totPros += rackListe.get(i).antProsessorer(); // Legger til antall prosessorer til totPros.
    }

    return totPros;
  }

  public int getAntRack(){
    return rackListe.size(); // Antall rack i Regneklynge.
  }
}
