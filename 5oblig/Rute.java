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
    this.naboNord = lab.hentRute(rad-1, kolonne);
    this.naboSyd = lab.hentRute(rad+1, kolonne);
    this.naboVest = lab.hentRute(rad, kolonne-1);
    this.naboOst = lab.hentRute(rad, kolonne+1);
    this.naboListe = new Rute[]{naboNord, naboSyd, naboVest, naboOst};
  }

  public Labyrint hentLab(){
    return tilhorendeLab;
  }

  @Override
  public String toString(){
    return String.valueOf(status);
  }
}
