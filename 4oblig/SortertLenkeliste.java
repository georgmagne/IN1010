public class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T> {

  @Override
  public void leggTil(T x) {
    Node nyNode = new Node(x);
    if(forste == null && siste == null) {
      forste = nyNode;
      siste = nyNode;
    } else if(forste.data.compareTo(nyNode.data) >= 0) { // nyNode er mindre enn alle, skal derfor bli den første.
      nyNode.neste = forste;
      forste = nyNode;
    } else if (siste.data.compareTo(nyNode.data) <= 0) { // nyNode er størst.
      siste.neste = nyNode;
      siste = nyNode;
    } else { // nyNode har en verdi mellom forste og siste.
      Node peker = forste;

      for (int i = 1; i < this.stoerrelse(); i++){ // peker går gjennom alle nodene.
        if (peker.data.compareTo(nyNode.data) < 0 && peker.neste.data.compareTo(nyNode.data) > 0) { // nyNode skal etter peker, og før peker.neste.
          nyNode.neste = peker.neste;
          peker.neste = nyNode;
          break;
        }
        peker = peker.neste;
      }
    }
  }

  @Override
  public T fjern() { // Hadde vært fint med forrige peker i nodene.
    if (forste == null && siste == null){ //tom liste.
      throw new UgyldigListeIndeks(-1);
    }

    if (forste == siste){ //Kun ett element i listen.
      Node tmp = siste;
      forste = null;
      siste = null;
      return tmp.data;
    }

    Node peker = forste;
    while (peker.neste.neste != null){ // peker finner den nest siste noden.
      peker = peker.neste;
    }

    Node tmp = peker.neste; // den siste noden, som skal fjernes.
    siste = peker;
    peker.neste = null;
    return tmp.data;
  }

  @Override
  public void sett(int pos, T x){
    throw new UnsupportedOperationException();
  }

  @Override
  public void leggTil(int pos, T x){
    throw new UnsupportedOperationException();
  }
}
