public class Spesialist extends Lege implements Godkjenningsfritak {

  int kontrollID;

  public Spesialist(String navn, int kontrollID) {
    super(navn);
    this.kontrollID = kontrollID;
  }

  public int hentKontrollID(){
    return this.kontrollID;
  }

  @Override
  public String toString(){
    return super.navn + " - Godkjenningsfritak ID: " + this.kontrollID;
  }
}
