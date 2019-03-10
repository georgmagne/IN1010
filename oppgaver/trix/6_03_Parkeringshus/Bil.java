public class Bil {
  private int regnr, antPas;

  public Bil(int regnr, int antPas) {
    this.regnr = regnr;
    this.antPas = antPas;
  }

  public int hentRegnr () {
    return regnr;
  }

  public int hentAntPas () {
    return antPas;
  }
  
}
