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

  public Resept skrivResept(Legemiddel middel, int pasientID, int reit) throws UlovligUtskrift { // Vanlig HvitResept.
    if ( middel instanceof PreparatA && !(this instanceof Spesialist)) {
        throw new UlovligUtskrift(this, middel);
    }
    Resept nyResept = new HvitResept(middel, this, pasientID, reit);
    return nyResept;
  }

  public Resept skrivResept(Legemiddel middel, int pasientID) throws UlovligUtskrift { // Prevensjon resept, alltid 3 reit.
    if (middel instanceof PreparatA && !(this instanceof Spesialist)){
      throw new UlovligUtskrift(this, middel);
    }
    Resept nyResept = new Prevensjon(middel, this, pasientID);
    return nyResept;
  }

  public Resept skrivBlaa(Legemiddel middel, int pasientID, int reit) throws UlovligUtskrift {
    if (middel instanceof PreparatA && !(this instanceof Spesialist)) {
      throw new UlovligUtskrift(this, middel);
    }
    Resept nyResept = new BlaaResept(middel, this, pasientID, reit);
    return nyResept;
  }

  public Resept skrivMilitaer(Legemiddel middel, int pasientID, int reit) throws UlovligUtskrift {
    if (middel instanceof PreparatA && !(this instanceof Spesialist)) {
      throw new UlovligUtskrift(this, middel);
    }
    Resept nyResept = new MillitResept(middel, this, pasientID, reit);
    return nyResept;
  }

  @Override
  public String toString() {
    return this.navn + " - Godkjennigspliktig.";
  }
}
