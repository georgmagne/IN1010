public class Melding{
  private String dekryptertInnhold;
  private String kryptertInnhold;
  private int sekvensnummer;
  private int kanalId;

  public Melding(String innhold, int kanalId, int sekvensnummer){
    this.kryptertInnhold = innhold;
    this.kanalId = kanalId;
    this.sekvensnummer = sekvensnummer;
  }

  public void dekrypt(String nyttInnhold){
    this.kryptertInnhold = nyttInnhold;
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
}
