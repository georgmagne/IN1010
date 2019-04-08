import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.*;

public abstract class Rute {
  protected int rad, kolonne;
  protected Rute naboNord, naboSyd, naboVest, naboOst;
  protected Rute[] naboListe;
  protected Labyrint tilhorendeLab;
  protected char status;

  public abstract char tilTegn();
  public abstract void gaa(Rute forrige);

  public static ArrayList<Rute> besokt = new ArrayList<Rute>(); // Holder rede på alle besokte ruter, etter at en aapning har blitt besokt.
  public static ArrayList<ArrayList<Rute>> rutene = new ArrayList<ArrayList<Rute>>(); // Holder rede på hver enkelt utveurute, men med duplikatRuter. En liste er en utvei.
  public static ArrayList<ArrayList<Rute>> ruteneIngenDups = new ArrayList<ArrayList<Rute>>(); // Holder rede på utveirute, uten duplikatRuter. En liste er en utvei.
  public static int utveier = 0; // Teller for antall utveier.

  public Rute(Labyrint lab, int rad, int kolonne){
    this.tilhorendeLab = lab;
    this.kolonne = kolonne;
    this.rad = rad;
  }

  public Labyrint hentLab(){
    return tilhorendeLab;
  }

  public int hentRad(){
    return this.rad;
  }

  public int hentKol(){
    return this.kolonne;
  }

  public int hentAntUtveier(){
    return this.utveier;
  }

  public ArrayList<ArrayList<Rute>> hentUtveier(){
    return ruteneIngenDups;
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

  private void reset(){
    besokt = new ArrayList<Rute>(); // Holder rede på alle besokte ruter, etter at en aapning har blitt besokt.
    rutene = new ArrayList<ArrayList<Rute>>(); // Holder rede på hver enkelt utveurute, men med duplikatRuter. En liste er en utvei.
    ruteneIngenDups = new ArrayList<ArrayList<Rute>>(); // Holder rede på utveirute, uten duplikatRuter. En liste er en utvei.
    utveier = 0; // Teller for antall utveier.

  }

  public void finnUtvei(){
    // // besokt = new ArrayList<Rute>();
    // utveier = 0;
    // rutene = new ArrayList<ArrayList<Rute>>();
    // ruteneIngenDups = new ArrayList<ArrayList<Rute>>();
    reset();
    this.gaa(this);

    // Fjerner duplikatruter og lager en ny ArrayList
    for (ArrayList<Rute> elem: rutene){
      LinkedHashSet<Rute> hashSet = new LinkedHashSet<>(elem);
      ArrayList<Rute> ingenDups = new ArrayList<>(hashSet);
      ruteneIngenDups.add(ingenDups);
    }

    // Try catch, hvis det ikke var noen utvei fra den gitte Ruten, er ruteneIngenDups ikke definert.
    try{
      Rute start = ruteneIngenDups.get(0).get(0);
      // Fjerner "grums" fra rekusjonen, på vei tilbake fra Åpning.
      // Måtte burke iterator for å unngå concurrent error.
      for (ArrayList<Rute> elem: ruteneIngenDups){
        Iterator<Rute> it = elem.iterator();
        while (it.hasNext()) {
          if (it.next() != start){
            it.remove();
          } else {
            break;
          }
        }
      }
    }
    catch (IndexOutOfBoundsException e){
      System.out.println("Ingen utvei");
    }

    System.out.println("\n###################\nSkriver ut rutene.");
    for (ArrayList<Rute> elem: ruteneIngenDups){
      System.out.println("\nDette er en rute: ");

      for (Rute rute: elem){
        System.out.println(rute);
      }
    }
  }

  @Override
  public String toString(){
    String skriv = "Rute: ["+rad+";"+kolonne+"] Status: " + String.valueOf(status) ;
    return skriv;
  }
}
