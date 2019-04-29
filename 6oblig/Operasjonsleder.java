import java.util.ArrayList;
import java.util.LinkedList;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Operasjonsleder implements Runnable{

  DekryptMonitor hentFra;
  int antKanaler;
  LinkedList<Melding> meldinger;
  boolean running = true;
  ArrayList<ArrayList<Melding>> meldingSamling = new ArrayList<ArrayList<Melding>>();
  // ArrayList<ArrayList<Melding>> meldingSamlingSortert = new ArrayList<ArrayList<Melding>>();
  ArrayList<Melding[]> meldingSamlingSortert = new ArrayList<Melding[]>();


  public Operasjonsleder(DekryptMonitor hentFra, int antKanaler){
    this.hentFra = hentFra;
    this.antKanaler = antKanaler;
    this.meldinger = hentFra.hentMeldinger();

    for (int i = 0; i < antKanaler; i++){
      ArrayList<Melding> nyListe = new ArrayList<>();
      meldingSamling.add(nyListe);
    }
  }

  @Override
  public void run(){
    while (running){
      Melding aktuellMelding = hentFra.taUtMelding();
      if(aktuellMelding == null){
        running = false;
        System.out.println("Avslutter: " + this);
      } else {
        int i = aktuellMelding.hentId();
        meldingSamling.get(i-1).add(aktuellMelding);
      }
    }

    // Melding[] nyttArray;

    for (ArrayList<Melding> kanal: meldingSamling){
      int lengde = kanal.size();
      Melding[] nyttArray = new Melding[lengde];

      for (Melding melding: kanal){
        nyttArray[melding.hentSekvensnummer()-1] = melding;
      }
      meldingSamlingSortert.add(nyttArray);
    }

    for (Melding[] kanal: meldingSamlingSortert){
      System.out.println("Ny kanal!");
      for (Melding melding: kanal){
        System.out.println(melding);
      }
      System.out.println("Ferdig med en kanal");
    }


    for (Melding[] kanal: meldingSamlingSortert){
      String filnavn = "kanal" + kanal[0].hentId() + ".txt";
      System.out.println(filnavn);

      try {
        File fil = new File(filnavn);

        if (!fil.exists()){
          fil.createNewFile();
        }

        PrintWriter writer = new PrintWriter(fil, "utf-8");

        for (int i = 0; i < kanal.length; i++){
          writer.println(kanal[i].hentDekryptertInnhold());
          writer.println();
          writer.println();
        }

        writer.close();
      } catch (IOException e){
        e.printStackTrace();
      }
    }

    System.exit(0);
  }
}
