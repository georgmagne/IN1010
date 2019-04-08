import java.util.ArrayList;

public class Aapning extends HvitRute{

  public Aapning(Labyrint lab, int rad, int kolonne){
    super(lab, rad, kolonne);
  }

  @Override
  public void gaa(Rute forrige){
    System.out.println("Jeg er en åpning: " + this);
    System.out.println("Dette er en åpning!!\n");
    utveier ++;
    besokt.add(this);
    rutene.add(besokt);
    besokt = new ArrayList<Rute>(); // Resetter besokt ArrayListen slik at
  }
}
