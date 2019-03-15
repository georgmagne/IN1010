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

  public Resept skrivResept(Legemiddel middel, Pasient pasient, int reit) throws UlovligUtskrift { // Vanlig HvitResept.
    if ( middel instanceof PreparatA && !(this instanceof Spesialist)) {
        throw new UlovligUtskrift(this, middel);
    }
    Resept nyResept = new HvitResept(middel, this, pasient, reit);
    return nyResept;
  }

  public Resept skrivResept(Legemiddel middel, Pasient pasient) throws UlovligUtskrift { // Prevensjon resept, alltid 3 reit.
    if (middel instanceof PreparatA && !(this instanceof Spesialist)){
      throw new UlovligUtskrift(this, middel);
    }
    Resept nyResept = new Prevensjon(middel, this, pasient);
    return nyResept;
  }

  public Resept skrivBlaa(Legemiddel middel, Pasient pasient, int reit) throws UlovligUtskrift {
    if (middel instanceof PreparatA && !(this instanceof Spesialist)) {
      throw new UlovligUtskrift(this, middel);
    }
    Resept nyResept = new BlaaResept(middel, this, pasient, reit);
    return nyResept;
  }

  public Resept skrivMilitaer(Legemiddel middel, Pasient pasient, int reit) throws UlovligUtskrift {
    if (middel instanceof PreparatA && !(this instanceof Spesialist)) {
      throw new UlovligUtskrift(this, middel);
    }
    Resept nyResept = new MillitResept(middel, this, pasient, reit);
    return nyResept;
  }

  @Override
  public String toString() {
    return this.navn + " - Godkjennigspliktig.";
  }
}