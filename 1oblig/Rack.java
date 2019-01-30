public class Rack {

  public Node[] nodeListe; // Velger array fremfor arraylist, trenger ikke dynamisk lengde fordi max noder er angitt.

  public Rack(int maxNoderPerRack){ // Konstruktør
    nodeListe = new Node[maxNoderPerRack]; // Setter lengden til nodeListe lik maxNoderPerRack.
  }

  public void settInn(Node node){
    for (int i=0; i < nodeListe.length; i++){ // Itererer gjennom nodeListe
      if (nodeListe[i] == null) { // Hvis plassen i arrayet er ledig.
        nodeListe[i] = node; // Setter inn ny node på den første ledige plassen i racket.
        break; // Ut av for-løkka.
      }
    }
  }

  public boolean erFull(){
    for (int i=0; i < nodeListe.length; i++){ // Itererer gjennom arrayet med noder
      if (nodeListe[i] == null){ // Hvis plassen er ledig.
        return false; // Racket er ikke fullt
      }
    }
    return true; // Racket er fullt.
  }

  public int noderMedNokMinne(int nokMinne){
    int antall = 0;
    for (int i = 0 ; i < nodeListe.length; i++){
      if (nodeListe[i] == null){
        return antall;
      }
      if (nodeListe[i].nokMinne(nokMinne)){
        antall += 1;
      }
    }
    return antall;
  }

  public int antProsessorer(){
    int antPros = 0;
    for (int i = 0; i < nodeListe.length; i++){
      if(nodeListe[i] == null){
        return antPros;
      }
      antPros += nodeListe[i].getPros();
    }
    return antPros;
  }
}
