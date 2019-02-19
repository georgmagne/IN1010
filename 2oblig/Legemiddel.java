abstract public class Legemiddel { // Superklasse, abstract fordi et legemiddel må ha flere egenskaper (PreparatA,B,C osv..)

  protected String navn;
  protected double pris;
  protected double virkestoffMngd;

  protected static int idTeller = 1;
  protected int id;

  public Legemiddel(String navn, double pris, double virkestoff) {
    this.navn = navn;
    this.pris = pris;
    virkestoffMngd = virkestoff;
    id = idTeller++;
  }

  public int hentId() {
    return id;
  }

  public String hentNavn(){
    return navn;
  }

  public double hentPris(){
    return pris;
  }

  public double hentVirkestoffMngd() {
    return virkestoffMngd;
  }

  public void settNyPris(double nyPris) {
    this.pris = nyPris;
  }

}
