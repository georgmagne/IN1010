import java.util.ArrayList;

class Regneklynge {

    public int maxNoderPerRack = 12; // Endre senere; lest fra fil.
    public int giMinne = 32; // Endre; lese fra fil
    public int giPros = 1;
    public ArrayList<Rack> rackListe = new ArrayList<Rack>();  // Bruker ArrayList fordi antall rack ikke er fastsatt, og potensielt uendelig.
    public Node node = new Node(giMinne, giPros); // Må endres; kun for test.
    /* metoder til arraylist
    add()
      rackListe.add(new Rack(asdasdasd,asdasdasd))
    get()
    remove()
    size()
    */
    public Regneklynge(){ // Kontruktør
      rackListe = new ArrayList<Rack>(); // Setter rackListe lik nytt ArrayList med Rack-objekter.
      rackListe.add(new Rack(maxNoderPerRack)); // Ett rack blir opprettet samtidig som regneklyngen.
    }

    public void lagRack(){
      rackListe.add(new Rack(maxNoderPerRack)); // Oppretter nytt tomt rack og legger det til rackListe.
    }

    public void settInnNode(){ // Node opprettes og settes inn i passende rack i regneklyngen.
      if (!rackListe.get(rackListe.size()-1).erFull()) { // Hvis det siste racket ikke er fullt.
        rackListe.get(rackListe.size()-1).settInn(node); // Node blir satt inn i siste element i rackListe
      } else { // Hvis alle rack i rackListe er fulle.
        lagRack(); // Nytt rack blir opprettet
        rackListe.get(rackListe.size()-1).settInn(node); // Node blir satt inn i siste element i rackListe
      }
    }

    public int noderMedNokMinne(int nokMinne){ // Returnerer antall noder som har nok minne, sammenlignet med det gitte parameteret.
      int totNoderNokMinne = 0;
      for (Rack elem: rackListe){
        totNoderNokMinne += elem.noderMedNokMinne(nokMinne);
      }

    }

    public int antProsessorer(){ // Returnerer antall prosessorer i regneklyngen.
      int totPros = 0; // Prosessor teller.
      for (Rack elem: rackListe){ // Hvert rack i rackListe.
        for (Node n: elem){ // Hver node i rack.
          totPros += n.getPros(); // Legger til Noden sitt antall prosessorer.
        }
      }
  }

    public int getAntRack(){
      return rackliste.size(); // Antall rack i Regneklynge.
    }
}
