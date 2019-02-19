public class PreparatC extends Legemiddel{ // Vanedannende legemtiddel

  public PreparatC(String navn, double pris, double virkestoff){
    super(navn, pris, virkestoff); // PreparatC har kun de samme egenskaper som Legemiddel.
  }

  @Override
  public String toString(){
    return "Navn: " + this.navn + ". Pris: " + this.pris + ". Virkestoff mengde: " + super.virkestoffMngd;
  }
}
