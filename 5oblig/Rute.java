public abstract class Rute {
  protected int rad, kolonne;
  protected Rute naboNord, naboSyd, naboVest, naboOst;
  protected Rute[] naboListe;
  protected Labyrint tilhorendeLab;
  protected char status;

  public abstract char tilTegn();

  public Rute(Labyrint lab, int rad, int kolonne){
    this.tilhorendeLab = lab;
    this.kolonne = kolonne;
    this.rad = rad;
    // this.naboNord = lab.hentRute(rad-1, kolonne);
    // this.naboSyd = lab.hentRute(rad+1, kolonne);
    // this.naboVest = lab.hentRute(rad, kolonne-1);
    // this.naboOst = lab.hentRute(rad, kolonne+1);
    // this.naboListe = new Rute[]{naboNord, naboSyd, naboVest, naboOst};
  }

  public Labyrint hentLab(){
    return tilhorendeLab;
  }

  public void settNabo(){
    this.naboNord = tilhorendeLab.hentRute(rad-1, kolonne);
    this.naboSyd = tilhorendeLab.hentRute(rad+1, kolonne);
    this.naboVest = tilhorendeLab.hentRute(rad, kolonne-1);
    this.naboOst = tilhorendeLab.hentRute(rad, kolonne+1);
    this.naboListe = new Rute[]{naboNord, naboSyd, naboVest, naboOst};
  }
  public Rute[] hentNaboListe(){
    return naboListe;
  }

  public void gaa(){
    if (naboListe[0] == null || String.valueOf(naboListe[0].tilTegn()).equals("#")){
      System.out.println("Kan ikke gå nord.");
    } else {
      System.out.println("Kan gå nord.");
      naboListe[0].gaa();
    }

    if (naboListe[1] == null || String.valueOf(naboListe[1].tilTegn()).equals("#")){
      System.out.println("Kan ikke gå syd.");
    } else {
      System.out.println("Kan gå syd.");
      naboListe[1].gaa();
    }

    if (naboListe[2] == null || String.valueOf(naboListe[2].tilTegn()).equals("#")){
      System.out.println("Kan ikke gå vest.");
    } else {
      System.out.println("Kan gå vest.");
      naboListe[2].gaa();
    }

    if (naboListe[3] == null || String.valueOf(naboListe[3].tilTegn()).equals("#")){
      System.out.println("Kan ikke gå ost.");
    } else {
      System.out.println("Kan gå ost.");
      naboListe[3].gaa();
    }

  }

  @Override
  public String toString(){
    String skriv = "Rute: ["+rad+";"+kolonne+"] Status: " + String.valueOf(status) ;
    return skriv;
  }
}
