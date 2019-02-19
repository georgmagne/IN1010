public class PreparatB extends Legemiddel{ // Vanedannende legemtiddel

  private double styrke;

  public PreparatB(String navn, double pris, double virkestoff, int styrke){
    super(navn, pris, virkestoff);
    this.styrke = styrke;
  }

  public double hentVanedannendeStyrke(){
    return styrke;
  }

  @Override
  public String toString(){
    return "Navn: " + this.navn + ", Pris: " + this.pris + ", Virkestoff mengde: " + super.virkestoffMngd + ", Styrke " + this.styrke;
  }
}
