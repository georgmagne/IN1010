import java.util.ArrayList;

class Regneklynge {

  public int maxNoderPerRack = 12; // Endre senere; lest fra fil.
  public ArrayList<Rack> rackListe = new ArrayList<Rack>();  // Bruker ArrayList fordi antall rack ikke er fastsatt, og potensielt uendelig.

  public Regneklynge(){ // Kontruktør
    rackListe = new ArrayList<Rack>(); // Setter rackListe lik nytt ArrayList med Rack-objekter.
    rackListe.add(new Rack(maxNoderPerRack)); // Ett rack blir opprettet samtidig som regneklyngen.
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
