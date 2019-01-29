public class Rack {

  public Node[] nodeListe; // Velger array fremfor arraylist, trenger ikke dynamisk lengde fordi max noder er angitt.

  public Rack(int maxNoderPerRack){ // Konstruktør
    nodeListe = new Node[maxNoderPerRack];
    int maxNoder = maxNoderPerRack;
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
    int antall = 0; // Teller for antall noder, som oppfyller kravene.

    for (int i=0; i < nodeListe.length; i++){ // Interer gjennom arrayet
      if (nodeListe[i].nokMinne(nokMinne)){  // Sjekker om noden har nok minne, sammenlign med parameteret.
        antall += 1; // Hvis ja
      }
    }
    return antall; // Etter at alle nodene  er sjekket.
  }

  /*  public boolean erTom(Node[] nodeListe){

}
*/
/*
public int antallNoder(){
int antall = 0;
for (int i=0; i < nodeListe.length; i++){

}
}
*/

}
