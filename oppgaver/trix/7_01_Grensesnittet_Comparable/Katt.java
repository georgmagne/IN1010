public class Katt implements Comparable<Katt> {
  private String navn;
  private int alder;

  public Katt(String navn, int alder) {
    this.navn = navn;
    this.alder = alder;
  }

  public int compareTo (Katt annen){
    if (this.alder < annen.alder) {
      return -1;
    } else if (this.alder > annen.alder){
      return 1;
    } else {
      return 0;

    }
  }

  public String toString(){
    return "Katten " + navn + " er " + alder + " år";
  }
}
