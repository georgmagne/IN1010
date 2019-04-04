import java.io.File;

public class TestLabyrintOppsett {

  public static void main(String[] args) {
    Labyrint labyrint = null;

    try{
      File fil = new File("labyrinter/1.in");
      labyrint = labyrint.lesFraFil(fil);
    } catch (java.io.FileNotFoundException e) {
      e.getMessage();
    }

    System.out.println(labyrint);

    for (Rute[] rad: labyrint.hentToDim()){
      for (Rute rute: rad){
        Rute[] naboer = rute.hentNaboListe();
        System.out.println("Aktuell rute: [" + rute.rad + ";" + rute.kolonne+"]");
        System.out.println("Nord: " + naboer[0]);
        System.out.println("Syd: " + naboer[1]);
        System.out.println("Vest: " + naboer[2]);
        System.out.println("Ost: " + naboer[3]);
        System.out.println();
      }
    }

    System.out.println("Begynner å gå!");
    Rute sjekk = labyrint.hentRute(1, 1);
    sjekk.gaa(sjekk);
  }
}
