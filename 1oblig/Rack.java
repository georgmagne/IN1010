public class Rack {

  public Node[] nodeListe; // Velger array fremfor arraylist, trenger ikke dynamisk lengde fordi max noder er angitt.

  public Rack(int maxNoderPerRack){ // Konstruktør
    nodeListe = new Node[maxNoderPerRack];
    int maxNoder = maxNoderPerRack;
  }

  public void settInnNode(int giMinne, int giPros){
      for (int i=0; i < nodeListe.length; i++){ // Itererer gjennom nodeListe
          if (nodeListe[i] == null) {
            nodeListe[i] = new Node(giMinne, giPros);
            break; // Ut av for-løkka.
          }
      }
  }

  public boolean erFull(){
    for (int i=0; i < nodeListe.length; i++){
      if (nodeListe[i] == null){
        return false;
      }
    }
    return true;
  }
  public int noderMedNokMinne(int nokMinne){
    int antall = 0;

    for (int i=0; i < nodeListe.length; i++){
      if (nodeListe[i].nokMinne(nokMinne)){
        antall += 1;
      }
    }
    return antall;
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
