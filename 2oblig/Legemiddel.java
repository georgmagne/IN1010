public Legemiddel {
  private int id;
  private String navn;
  private double pris;
  private double virkestoffMngd;
  public static int id = 0;

  public Legemiddel(String navn, double pris, double virkestoff) {
    this.navn = navn;
    this.pris = pris;
    virkestoffMngd = virkestoff;
    id += 1;
  }

  public int hentId() {
    return this.id;
  }

  public String hentNavn(){
    return this.navn;
  }

  public double hentPris(){
    return this.pris;
  }

  public double hentVirkestoffMngd() {
    return this.virkestoffMngd;
  }

  public void settNyPris(double nyPris) {
    this.pris = nyPris;
  }

}
