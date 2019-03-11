public class Stabel<T> extends Lenkeliste<T>{

  public void leggPaa(T x) {
    Node nyNode = new Node(x);

    if (forste == null && siste == null){ // listen er tom
      forste = nyNode;
      siste = nyNode;
      // .neste == null
    } else {
      siste.neste = nyNode;
      siste = nyNode;
    }


  }

  public T taAv() {
    if (this.stoerrelse() < 1){ //Listen er tom.
      throw new UgyldigListeIndeks(-1);
    }
    
    Node tmp;
    if (this.stoerrelse() == 1){
      tmp = forste;

      siste = null;
      forste = null;
      return tmp.data;
    }

    tmp = siste;
    Node peker = forste;

    while (peker.neste.neste != null){
      peker = peker.neste;
    }
    siste = peker;
    siste.neste = null;
    return tmp.data;
  }
}
