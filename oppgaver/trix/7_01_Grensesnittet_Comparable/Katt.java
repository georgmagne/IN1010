public class Katt {
  String navn;
  int alder;

  public Katt(Sting n, int a){
    this.navn = n;
    this.alder = a;
  }
  @Override
  public String toString() {
    return "Katten " + navn + " er " + alder + " gammel."
  }
}
