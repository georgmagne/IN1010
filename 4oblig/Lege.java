public class Lege implements Comparable<Lege>{

  protected String navn;
  protected int kontrollID;
  protected Lenkeliste<Resept> utskrevetResepter;

  public Lege(String navn) {
      this.navn = navn;
      this.kontrollID = 0; // Ikke godkjenningsfritak.
      this.utskrevetResepter = new Lenkeliste<Resept>() ;
  }

  public String hentNavn() {
    return this.navn;
  }

  public Resept skrivResept(Legemiddel middel, Pasient pasient, int reit) throws UlovligUtskrift { // Vanlig HvitResept.
    if ( middel instanceof PreparatA && !(this instanceof Spesialist)) {
        throw new UlovligUtskrift(this, middel);
    }
    Resept nyResept = new HvitResept(middel, this, pasient, reit);
    utskrevetResepter.leggTil(nyResept);
    return nyResept;
  }

  public Resept skrivResept(Legemiddel middel, Pasient pasient) throws UlovligUtskrift { // Prevensjon resept, alltid 3 reit.
    if (middel instanceof PreparatA && !(this instanceof Spesialist)){
      throw new UlovligUtskrift(this, middel);
    }
    Resept nyResept = new Prevensjon(middel, this, pasient);
    utskrevetResepter.leggTil(nyResept);
    return nyResept;
  }

  public Resept skrivBlaa(Legemiddel middel, Pasient pasient, int reit) throws UlovligUtskrift {
    if (middel instanceof PreparatA && !(this instanceof Spesialist)) {
      throw new UlovligUtskrift(this, middel);
    }
    Resept nyResept = new BlaaResept(middel, this, pasient, reit);
    utskrevetResepter.leggTil(nyResept);

    return nyResept;
  }

  public Resept skrivMilitaer(Legemiddel middel, Pasient pasient, int reit) throws UlovligUtskrift {
    if (middel instanceof PreparatA && !(this instanceof Spesialist)) {
      throw new UlovligUtskrift(this, middel);
    }
    Resept nyResept = new MillitResept(middel, this, pasient, reit);
    utskrevetResepter.leggTil(nyResept);
    return nyResept;
  }

  @Override
  public int compareTo(Lege lege){
    return this.navn.compareTo(lege.hentNavn());
  }

  @Override
  public String toString() {
    return this.navn + " - Godkjennigspliktig.";
  }

  public void hentResepter() {
    String utskrift = "";
    for (Resept elem: this.utskrevetResepter) {
      utskrift = utskrift + " " +elem.toString();
    }
    System.out.println(this.navn + " har skrivet disse reseptene: " + utskrift);
  }
}
