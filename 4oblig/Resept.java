abstract public class Resept { // Skal ikke kunnes opprettes dirkete.

  protected static int idTeller = 1;
  protected int id;

  protected Legemiddel middel;
  protected Lege utskrivendeLege;
  protected Pasient pasient;
  protected int reit;


  public Resept(Legemiddel middel, Lege lege, Pasient pasient, int reit) {
    this.id = idTeller++;
    this.middel = middel;
    this.utskrivendeLege = lege;
    this.pasient = pasient;
    this.reit = reit;
  }

  public int hentID(){
    return this.id;
  }

  public Legemiddel hentLegemiddel(){
    return this.middel;
  }

  public Lege hentLege(){
    return this.utskrivendeLege;
  }

  public Pasient hentPasient(){
    return this.pasient;
  }

  public int hentReit(){
    return this.reit;
  }

  public boolean bruk(){
    if (this.reit == 0){
      return false;
    } else {
      this.reit -= 1; // "Bruker" en stack av resepten.
      return true;
    }
  }

  abstract public String farge();
  abstract public double prisAaBetale();

  @Override
  public String toString(){
    return "Tilhører pasient: " + this.pasient + "\nLegemiddel: " + this.middel +
    "\nUtsted av: " + this.utskrivendeLege + "\nAntall uthentinger igjen: " +
    this.reit + "\nReseptID: " + this.id;
  }
}
