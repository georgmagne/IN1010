import java.io.File;

public class TestLabyrintOppsett {

  public static void main(String[] args) {
    Labyrint labyrint = null;

    try{
      File fil = new File("labyrinter/4.in");
      labyrint = labyrint.lesFraFil(fil);
    } catch (java.io.FileNotFoundException e) {
      e.getMessage();
    }

    System.out.println(labyrint);
    System.out.println("Aller koordinater er på formen:");
    System.out.println("[RAD;KOLONNE]");

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

    // System.out.println("Begynner å gå!");
    // Rute sjekk = labyrint.hentRute(0, 9);
    // sjekk.gaa(sjekk);
    // sjekk.finnUtvei();

    Liste<String> utvei = labyrint.finnUtveiFra(22,7);
    // System.out.println(utvei);
    // System.out.println(utvei.hent(0));
    // System.out.println(utvei.hent(1));
    System.out.println("\nUtvei fra: " + labyrint.hentRute(22,7));
    for (String vei: utvei){
      System.out.println(vei);
    }

    // utvei = labyrint.finnUtveiFra(3,1);

    // System.out.println("\nUtvei fra: " + labyrint.hentRute(3,1));
    // for (String vei: utvei){
    //   System.out.println(vei);
    // }
    //
    //
    // utvei = labyrint.finnUtveiFra(3,3);
    //
    // System.out.println("\nUtvei fra: " + labyrint.hentRute(3,3));
    // for (String vei: utvei){
    //   System.out.println(vei);
    // }
    //
    // utvei = labyrint.finnUtveiFra(3,4);
    //
    // System.out.println("\nUtvei fra: " + labyrint.hentRute(3,4));
    // for (String vei: utvei){
    //   System.out.println(vei);
    // }
    //
    //
    // utvei = labyrint.finnUtveiFra(0,1);
    //
    // System.out.println("\nUtvei fra: " + labyrint.hentRute(0,1));
    // for (String vei: utvei){
    //   System.out.println(vei);
    // }

  }
}
