import java.util.Scanner;
import java.io.File;

class Gruppeoppmoete {
  private String[]  navn = new String[17];
  private boolean[] oppmoete = new boolean[17];
  private int totalStudenter = 0;

  public void lesInnFil(String filnavn) throws Exception{
    Scanner innFil = new Scanner (new File(filnavn));

    while (innFil.hasNextLine() && totalStudenter < navn.length){
      navn[totalStudenter] = innFil.nextLine();
      totalStudenter++;
    }
  }

  public void registrerOppmoete(String studentnavn) {
    for (int i=0; i < totalStudenter; i++){ // Løkke for å iterere gjennom navn array
      if (studentnavn.equals(navn[i])){ // Sjekker om argumentet studentnavn er i listen navn.
        oppmoete[i] = true; // Setter plassen i oppmoete som tilsavrer den aktuelle studenen til true.
      }
    }
  }

  public  void skrivUtAlleOppmoette() {
    for (int i = 0; i < totalStudenter; i++) { // Løkke for å iterere gjennom navn array.
      if (oppmoete[i]) {
        System.out.println(navn[i] + "har moett.");
      } else {
        System.out.println(navn[i] + "har ikke moett.");
      }
    }
  }
}
