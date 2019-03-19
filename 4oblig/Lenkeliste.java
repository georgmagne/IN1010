import java.util.Iterator;
import java.util.NoSuchElementException;

class Lenkeliste<T> implements Liste<T>, Iterable<T> {
  class Node { // Hjelpe klasse.
    Node neste = null;
    T data;

    Node(T x) {
      data = x;
    }
  }

  protected Node forste = null;
  protected Node siste = null;

  class LenkelisteIterator implements Iterator<T> {

    private Lenkeliste liste;
    private int tall = 0;

    public LenkelisteIterator(Lenkeliste<T> liste){
      this.liste = liste;
    }

    @Override
    public boolean hasNext(){
      return tall < liste.stoerrelse();
    }

    @Override
    public T next(){
      if (hasNext()) {
        return (T)liste.hent(tall++);
      }
        throw new NoSuchElementException();
    // return liste.hent(tall++);
    // return (T) liste.hent(tall++);
    // return null;
    }
  }

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
    if (pos > this.stoerrelse()){
      throw new UgyldigListeIndeks(-1);
    }
    if (pos < 0){
      throw new UgyldigListeIndeks(-1);
    }
    Node peker = forste;

    if (forste == null && siste == null) { // listen er tom.
      forste = new Node(x);
      siste = forste;

    } else if (pos == 0){ // Node skal settes inn først
      Node gammelNeste = forste;
      Node nyNode = new Node(x);
      forste = nyNode;
      nyNode.neste = gammelNeste;

    } else if(pos +1== this.stoerrelse()){ // Node skal settes inn bakerst.
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
  }

  public void sett(int pos, T x) {
    if(forste == null && siste == null) {
      throw new UgyldigListeIndeks(-1);
    }
    if (pos >= this.stoerrelse()){
      throw new UgyldigListeIndeks(pos);
    }
    if (pos < 0){
      throw new UgyldigListeIndeks(-1);
    }

    Node peker = forste;

    for (int i = 0; i < pos; i++) {
      peker = peker.neste;
    }
    peker.data = x;
  }

  public T hent(int pos) {
    if(forste == null && siste == null) {
      throw new UgyldigListeIndeks(-1);
    }
    if (pos >= this.stoerrelse()){
      throw new UgyldigListeIndeks(pos);
    }
    if (pos < 0){
      throw new UgyldigListeIndeks(-1);
    }

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

  //Hent fra Daniel
  // public T hent(int pos) throws UgyldigListeIndeks {
  //   if (pos > 0 && pos < stoerrelse() ){
  //     Node p = start;
  //     for (int i = 0; i < pos; i++){
  //       p = p.neste;
  //     }
  //     return p.data;
  //   } else if (pos == 0) {
  //     if(stoerrelse() != 0){
  //       return start.data;
  //     }
  //   }
  //   throw new UgyldigListeIndeks(pos);
  // }

  public T fjern(int pos) {
    if (forste == null && siste == null) {
      throw new UgyldigListeIndeks(-1);
    }
    if (pos >= this.stoerrelse()){
      throw new UgyldigListeIndeks(pos);
    }
    if (pos < 0){
      throw new UgyldigListeIndeks(-1);
    }

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
    if (forste == null && siste == null){ //tom liste.
      throw new UgyldigListeIndeks(-1);
    }

    Node tmp = forste;
    forste = forste.neste;
    return tmp.data;
  }

  public Iterator<T> iterator(){
    return new LenkelisteIterator(this);
  }

}
