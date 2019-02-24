public class BlaaResept extends Resept {

  public BlaaResept(Legemiddel middel, Lege lege, int pasientID, int reit) {
    super(middel, lege, pasientID, reit);
  }

  @Override
  public String farge() {
    return "Blaa";
  }

  @Override
  public double prisAaBetale() {
    return 0.25*super.middel.hentPris(); // 25% av orginal pris.
  }

  @Override
  public String toString() {
    return "Farge: " + farge() + "\n" +
    super.toString() +
    "\nPris: " + super.middel.hentPris() +
    "\nRabatt: 75%" +
    "\nÅ Betale: " + prisAaBetale();
  }
}
