import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;


public class Labyrint {
  protected Rute[][] toDim;
  protected int rader, kolonner;

  private Labyrint(int rader, int kolonner, Rute[][] arr){
    this.rader = rader;
    this.kolonner = kolonner;
    this.toDim = arr;
  }

  static Labyrint lesFraFil(File fil) throws java.io.FileNotFoundException{
    Scanner leserFil = new Scanner(fil);

    String forste = leserFil.nextLine();
    String[] forsteArr = forste.split(" ");

    int rader = Integer.valueOf(forsteArr[0]);
    int kolonner = Integer.valueOf(forsteArr[1]);
    Rute[][] nyRuteArr = new Rute[rader][kolonner];

    Labyrint nyLab = new Labyrint(rader, kolonner, nyRuteArr);

    Rute nyRute;
    int radPos = 0;
    while (leserFil.hasNextLine()){
      int kolPos = 0;

      String linje = leserFil.nextLine();
      String[] linjeArr = linje.split("");

      Rute[] nyRad = new Rute[kolonner];

      for (String elem: linjeArr){
        if (elem.equals(".")){
          if (radPos == 0 || radPos == rader-1 || kolPos == 0 || kolPos == kolonner-1){ // Rute i kanten.
            nyRute = new Aapning(nyLab, radPos, kolPos);
          } else {
            nyRute = new HvitRute(nyLab, radPos, kolPos);
          }

        } else if (elem.equals("#")){
          nyRute = new SortRute(nyLab, radPos, kolPos);
        }
        else {
          System.out.println("Det har skjedd noe feil.");
          break;
        }

        nyRad[kolPos++] = nyRute;
      }
      nyRuteArr[radPos++] = nyRad;
    }

    // Går gjennom rutene og setter naboene.
    for (Rute[] rad: nyLab.hentToDim()){
      for (Rute elem: rad){
        elem.settNabo();
      }
    }

    return nyLab;
  }

  public Rute hentRute(int rad, int kolonne){
    if (rad < 0 || rad > this.rader-1){ // Utenfor toDim
      return null;
    }

    if (kolonne < 0 || kolonne > this.kolonner-1){ // Utenfor toDim
      return null;
    }
    return toDim[rad][kolonne];
  }

  public Rute[][] hentToDim(){
    return this.toDim;
  }

  // Indekserer rutene (rad, kolonne), ikke (kolonne, rad) som spesifisert noen steder i oppgaveteksten.
  // Velger derfor å holde meg til dette i signaturen til denne metoden også.
  public Liste<String> finnUtveiFra(int rad, int kol){
    Rute skalSjekke = this.hentRute(rad, kol);
    skalSjekke.finnUtvei();
    Liste<String> utveiListe = new SortertLenkeliste<>();

    utveiListe.leggTil("Antall utveier: " + String.valueOf(skalSjekke.hentAntUtveier())); // Første element i lenkelisten sier hvor mange utveier det er.
    //Lager String-er av Rute objektene ruteneIngenDups, som holder rede på alle utveiene.
    for (ArrayList<Rute> enUtveiListe: skalSjekke.hentUtveier()){
      String enUtvei = "";
      int antallSteg = 0;
      for (Rute rute: enUtveiListe){
        enUtvei = enUtvei + "[" + String.valueOf(rute.hentRad()) + ";" + String.valueOf(rute.hentKol()) + "] --> ";
        antallSteg ++;
      }
      enUtvei = "Denne utveien har " + String.valueOf(antallSteg) + " antall steg " + enUtvei + "Ute!";
      utveiListe.leggTil(enUtvei);
    }
    return utveiListe;

  }


  @Override
  public String toString(){
    String skriv = "";

    for (Rute[] rader: toDim){
      for (Rute elem: rader){
        skriv = skriv + String.valueOf(elem.tilTegn());
      }
      skriv = skriv +"\n";
    }
    skriv = skriv + "Storrelse: ["+this.rader+";"+this.kolonner+"]\n";
    return skriv;
  }
}
