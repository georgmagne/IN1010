class Lenkeliste<T> implements Liste<T> {
  class Node { // Hjelpe klasse.
    Node neste = null;
    T data;

    Node(T x) {
      data = x;
    }
  }

  protected Node forste = null;
  protected Node siste = null;


  public int stoerrelse() {
    Node peker = forste;
    int ant = 0;

    while (peker != null) {
      ant++;
      peker = peker.neste;
    }
    return ant;
  }

  public void leggTil(int pos, T x) {
    Node peker = forste;

    if (peker == null) { // listen er tom.
      forste = new Node(x);
      siste = forste;

    } else if (pos == 0){ // Node skal settes inn først
      Node gammelNeste = forste;
      Node nyNode = new Node(x);
      forste = nyNode;
      nyNode.neste = gammelNeste;

    } else if(pos +1== this.stoerrelse() ){ // Node skal settes inn bakerst.
      leggTil(x);
    } else {
        for (int i = 1; i < pos; i++) { // Finner fram til pekeren som er den "forrige" til den som skal settes inn.
          peker = peker.neste;
        }

        Node gammelNeste = peker.neste;
        Node nyNode = new Node(x);
        nyNode.neste = gammelNeste;
        peker.neste = nyNode;
      }
  }

  public void leggTil(T x) { // Kø: nye noder skal bakerst i listen.
    Node nyNode = new Node(x);
    if (forste == null && siste == null) { // Listen er tom.
      forste = nyNode;
      siste = nyNode;
    } else { // listen er ikke tom, nye noder skal sist.
      Node gammelSiste = siste;
      siste = nyNode;
      gammelSiste.neste = siste;
    }
    Node peker = forste;
    for (int i = 0; i < this.stoerrelse(); i++) {
      peker = peker.neste;
    }
  }

  public void sett(int pos, T x) {
    Node peker = forste;

    for (int i = 0; i < pos; i++) {
      peker = peker.neste;
    }
    peker.data = x;
  }

  public T hent(int pos) {
    Node peker = forste;

    if (pos == 0){ // Den som skal hentes er den første.
      return forste.data;

    } else if (pos == this.stoerrelse()){ // Hvis den som skal hentes er den siste.
      return siste.data;

    } else {
        for (int i = 0; i < pos; i++){
          peker = peker.neste;
        }
      return peker.data; // **Spør om NPE, mulig å kjøre program videre etter exception?. (peker.data NPE)
      }
  }

  public T fjern(int pos) {
    Node peker = forste;

    if (forste == siste){ // kun ett objekt i listen.
      forste = null;
      siste = null;
      return peker.data;
    }

    for (int i = 1; i < pos; i++) { // Flytter pekeren er "forrige" til den som skal fjernes.
      peker = peker.neste;
    }

    // peker er nå den "forrige" til den som skal fjernes.
    Node tmp = peker.neste; // Den aktuelle noden som skal fjernes.
    peker.neste = tmp.neste;

    if (peker.neste == null){ // Hvis det var den siste som ble fjernet.
      siste = peker; // Må @siste oppdateres.
    }
    return tmp.data;
  }

  public T fjern() throws UgyldigListeIndeks{ // Tvinger de som kaller metoden til å bruke try-catch, noe TestLenkeliste gjør..
    Node tmp = forste;
    forste = forste.neste;
    return tmp.data;
  }
}
