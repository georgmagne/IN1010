public class Melding{
  public String dekryptertInnhold;
  private String kryptertInnhold;
  private int sekvensnummer;
  private int kanalId;
  public boolean dekryptert;

  public Melding(String innhold, int kanalId, int sekvensnummer){
    this.kryptertInnhold = innhold;
    this.kanalId = kanalId;
    this.sekvensnummer = sekvensnummer;
    this.dekryptert = false;
  }

  public void dekrypt(String nyttInnhold){
    this.dekryptertInnhold = nyttInnhold;
    this.dekryptert = true;
  }

  public String hentDekryptertInnhold(){
    return this.dekryptertInnhold;
  }

  public String hentKryptertInnhold(){
    return this.kryptertInnhold;
  }

  public int hentSekvensnummer(){
    return this.sekvensnummer;
  }

  public int hentId(){
    return this.kanalId;
  }

  @Override
  public String toString(){
    String string = "Ny Melding:\n fra kanal: " + this.kanalId + " Sekvnr: " + this.sekvensnummer + "\n Kryptert Innhold: " + this.kryptertInnhold + "\n";

    if (dekryptertInnhold != null){
      string += "Dekryptert innhold: " + this.dekryptertInnhold + "\n";
    } else {
      string = string + "Denne meldingen er ikke dekryptert enda.\n";
    }

    return string;
  }
}
