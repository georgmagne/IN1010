import java.util.Iterator;

public class LenkelisteIterator implements Iterator<T> {

  protected Lenkeliste liste;
  protected int tall = 0;

  public LenkelisteIterator(Lenkteliste<T> liste){
    this.liste = liste;
  }

  @Override
  public boolean hasNext(){
    return tall < liste.stoerrelse();
  }

  @Override
  public T next(){
    if (hasNext()) {
      return liste.hent(tall++);
    }
      throw new NoSuchElementException();
  }

}
