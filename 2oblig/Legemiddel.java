abstract public class Legemiddel { // Superklasse, abstract fordi et legemiddel må ha flere egenskaper (PreparatA,B,C osv..)

  private String navn;
  private double pris;
  private double virkestoffMngd;

  private static int idTeller = 1;
  private int id;

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
