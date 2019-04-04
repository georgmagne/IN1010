public class Aapning extends HvitRute{

  public Aapning(Labyrint lab, int rad, int kolonne){
    super(lab, rad, kolonne);
  }

  @Override
  public void gaa(Rute forrige){
    System.out.println("Jeg er en åpning: " + this);
    System.out.println("asdasdasdasdasdasdæsaød'aæsdæaspådæa'sådøæa'sådøaæ'sådøaæ'sådøaæs'ådøa'sæåøda'æsød'asød'asdø'asø'aåsdø'asød'asdø");
  }
}
