public class HvitRute extends Rute{

  public HvitRute(Labyrint lab, int rad, int kolonne){
    super(lab, rad, kolonne);
    super.status = '.';
  }

  @Override
  public void gaa(Rute forrige){
    System.out.println("Jeg er her: "+this);
    for (Rute nabo: naboListe){
      if (nabo == forrige){
        System.out.println("Jeg er: " + this);
        System.out.println("Der har jeg vært." + forrige);
      } else {
        System.out.println("Går fra: " + this);
        System.out.println("Går til: " + nabo);
        besokt.add(this);
        System.out.println();
        nabo.gaa(this);
      }
    }
  }

  public char tilTegn(){
    return super.status;
  }
}
