public class PreparatA extends Legemiddel{ // Narkotisk Legemiddel

  private double styrke;

  public PreparatA(String navn, double pris, double virkestoff, int styrke){
    super(navn, pris, virkestoff);
    this.styrke = styrke;
  }

  public double hentNarkotiskStyrke(){
    return styrke;
  }
}
