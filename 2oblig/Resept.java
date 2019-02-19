abstract public class Resept {

  protected static int idTeller = 1;
  protected int id;

  protected Legemiddel middel;
  protected Lege utstedtAvLege;
  protected int tilhorerPasient;
  protected int reit;


  public Resept(Legemiddel middel, Lege lege, int pasient) {
    id = idTeller++;
    this.middel = middel;
    this.utstedtAvLege = lege;
    this.tilhorerPasient = pasient;
    this.reit = 1; // Antar at alle resepter kan brukes 1 gang, hvis ikke annet blir spesifisert.

  }
}
