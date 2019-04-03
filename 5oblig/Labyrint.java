import java.io.File;
import java.util.Scanner;


public class Labyrint {
  protected Rute[][] toDim;
  protected int rader, kolonner;

  private Labyrint(int rader, int kolonner, Rute[][] arr){
    this.rader = rader;
    this.kolonner = kolonner;
    this.toDim = arr;
  }

  public Rute hentRute(int rad, int kolonne){
    System.out.println("["+rad+";"+kolonne+"]");

    if (rad < 0 || rad > this.rader-1){ // Utenfor toDim
      System.out.println("Skip rad");
      return null;
    }

    if (kolonne < 0 || kolonne > this.kolonner-1){ // Utenfor toDim
      System.out.println("Skip kolonne");
      return null;
    }

    return toDim[rad][kolonne];
  }

  private void leggTilRute(int rad, int kolonne, Rute nyRute){ // Legger til en Rute på gitt posisjon.
    if (rad < 0 || rad > this.rader-1 || kolonne < 0 || kolonne > this.kolonner-1){
      System.out.println("Utenfor arrayet.");
      return;
    }

    if (toDim[rad][kolonne] != null){
      System.out.println("Her er det allerede en Rute! ["+rad+";"+kolonne+"]");
      System.out.println("Ruten blir overskrevet.");
    }
    toDim[rad][kolonne] = nyRute;
  }

  public Rute[][] hentToDim(){
    return this.toDim;
  }

  public String toString(){
    String string = "";

    for (Rute[] rader: toDim){
      for (Rute elem: rader){
        string += elem.tilTegn();
      }
      string += "\n";
    }

    return string;
  }

  public void skrivUtLab(){
    String skriv = "";
    for (Rute[] rad: toDim){
      for (Rute kol: rad){
        skriv += kol;
      }
      skriv += "\n";
    }
    System.out.println("sasasasa");
    System.out.println(skriv);
  }

  static Labyrint lesFraFil(File fil) throws java.io.FileNotFoundException{
    Scanner leserFil = new Scanner(fil);

    int rader = Integer.valueOf(leserFil.next());
    int kolonner = Integer.valueOf(leserFil.next());
    Rute[][] nyRuteArrr = new Rute[rader][kolonner];

    Labyrint nyLab = new Labyrint(rader, kolonner, nyRuteArrr);

    Rute nyRute;

    int radPos = -1; // Variable for å holde styr raden Rutene skal legges til.
    int kolPos = 0;

    while (leserFil.hasNextLine()){
      String linje = leserFil.nextLine();
      String[] linjeArr = linje.split("");
      radPos += 1;
      kolPos = 0;

      for (String elem: linjeArr){
        if (elem.equals(".")){
          nyRute = new HvitRute(nyLab, radPos, kolPos);
          nyLab.leggTilRute(radPos, kolPos, nyRute);
        }

        if (elem.equals("#")){
          nyRute = new SortRute(nyLab, radPos, kolPos);
          nyLab.leggTilRute(radPos, kolPos, nyRute);
        }

        kolPos += 1;
      }
    }

    return nyLab;
  }
}
