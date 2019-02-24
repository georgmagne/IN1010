public class Lege {

  protected String navn;
  protected int kontrollID;

  public Lege(String navn) {
      this.navn = navn;
      this.kontrollID = 0; // Ikke godkjenningsfritak.
  }

  public String hentNavn() {
    return this.navn;
  }

  public HvitResept skrivResept(Legemiddel middel, int pasientID, int reit) throws UlovligUtskrift { // Vanlig HvitResept.
    if ( middel instanceof PreparatA && !(this instanceof Spesialist) ) {
        throw new UlovligUtskrift(this, middel);
    }
    HvitResept nyResept = new HvitResept(middel, this, pasientID, reit);
    return nyResept;
  }

  public HvitResept skrivResept(Legemiddel middel, int pasientID) throws UlovligUtskrift { // Prevensjon resept, alltid 3 reit.
    if (middel instanceof PreparatA && this.kontrollID == 0){
      throw new UlovligUtskrift(this, middel);
    }
    HvitResept nyResept = new Prevensjon(middel, this, pasientID);
    return nyResept;
  }

  @Override
  public String toString() {
    return this.navn + " - Godkjennigspliktig.";
  }
}
