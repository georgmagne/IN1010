public abstract class Rute {
  protected int rad, kolonne;
  protected Rute naboNord, naboSyd, naboVest, naboOst;
  protected Rute[] naboListe;
  protected Labyrint tilhorendeLab;
  protected char status;

  public abstract char tilTegn();
  public abstract void gaa(Rute forrige);

  public Rute(Labyrint lab, int rad, int kolonne){
    this.tilhorendeLab = lab;
    this.kolonne = kolonne;
    this.rad = rad;
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


  @Override
  public String toString(){
    String skriv = "Rute: ["+rad+";"+kolonne+"] Status: " + String.valueOf(status) ;
    return skriv;
  }
}
