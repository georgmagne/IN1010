public class Pasient {
  protected static int idTeller = 1;
  protected int id;

  protected String navn, persnr;
  protected Stabel<Resept> resepter;

  public Pasient(String navn, String persnr) {
    this.id = idTeller++;
    this.navn = navn;
    this.persnr = persnr;
    this.resepter = new Stabel<Resept>();
  }

  public String hentNavn(){
    return this.navn;
  }

  public void leggTilResept(Resept nyResept) {
    resepter.leggTil(nyResept); // Har ikke behov for å legg til på spesifikk posisjon.
  }

  public String resepterToString() { // "Organiserer" reseptene til én string.
    String returString = "";
    for (int i = 0; i < resepter.stoerrelse(); i++){
      returString = returString + "\n" + resepter.hent(i).toString();
    }
    return returString;
  }

  public void skrivResepter(){ // Skriver ut den resptene.
    System.out.print(resepterToString());
  }

  public String toString(){
    return this.navn + " (persnr: " + this.persnr + ")";
  }

  public Stabel<Resept> hentReseptListe(){
    return resepter;
  }

  public int tellNarkoResept(){
    int totNarko = 0;
    for (Resept elem: resepter){
      if (elem.hentLegemiddel() instanceof PreparatA){
        totNarko++;
      }
    }
    return totNarko;
  }
}
