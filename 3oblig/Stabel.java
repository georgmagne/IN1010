public class Stabel<T> extends Lenkeliste<T>{

  public void leggPaa(T x) {

    Node nyNode = new Node(x);
    nyNode.neste = forste;
    forste = nyNode;
  }

  public T taAv() {
    Node tmp = forste;
    forste = tmp.neste;
    return tmp.data;

  }
}
