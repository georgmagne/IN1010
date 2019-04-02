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
    if (rad < 0 || rad > this.rader){ // Utenfor toDim
      return null;
    }

    if (kolonne < 0 || kolonne > this.kolonner){ // Utenfor toDim
      return null;
    }

    return toDim[rad][kolonne];
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

  static Labyrint lesFraFil(File fil){
    while (fil.hasNextLine())
    return lab;
  }
}
