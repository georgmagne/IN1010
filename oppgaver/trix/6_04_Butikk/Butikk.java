public class Butikk  {
  private Person foerste;

  public void settInn(Person p) {
    if (this.foerste == null) {
      this.foerste = p;
    } else {
      Person midlertidig = foerste;
      while (midlertidig.hentNeste() != null){
        midlertidig = midlertidig.hentNeste();
      }
      midlertidig.settNeste(p);
    }
  }

  public void entreButikk(Person p) {

  }

  public void gaaTilKassen() {
    while (foerste != null) {
      System.out.println("Behandler kunde: " + foerste);
      foerste = foerste.hentNeste();
    }
    System.out.println("Ingen fler kunder.");
  }
}
