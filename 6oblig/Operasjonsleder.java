import java.util.ArrayList;
import java.util.LinkedList;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.concurrent.CountDownLatch;

public class Operasjonsleder implements Runnable{

  DekryptMonitor hentFra;
  int antKanaler;
  LinkedList<Melding> meldinger;
  boolean running = true;
  CountDownLatch latchOpleder;
  ArrayList<ArrayList<Melding>> meldingSamling = new ArrayList<ArrayList<Melding>>();
  ArrayList<Melding[]> meldingSamlingSortert = new ArrayList<Melding[]>();


  public Operasjonsleder(DekryptMonitor hentFra, int antKanaler, CountDownLatch latchOpleder){
    this.hentFra = hentFra;
    this.antKanaler = antKanaler;
    this.meldinger = hentFra.hentMeldinger();
    this.latchOpleder = latchOpleder;

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

    // Oppretter 2d Arraylist/Array beholder til de sorterte meldingene.
    for (ArrayList<Melding> kanal: meldingSamling){
      int lengde = kanal.size();
      Melding[] nyttArray = new Melding[lengde];

      for (Melding melding: kanal){
        nyttArray[melding.hentSekvensnummer()-1] = melding;
      }
      meldingSamlingSortert.add(nyttArray);
    }

    // Skriver ut alle sorterte meldingene.
    // for (Melding[] kanal: meldingSamlingSortert){
    //   System.out.println("Ny kanal!");
    //   for (Melding melding: kanal){
    //     System.out.println(melding);
    //   }
    //   System.out.println("Ferdig med en kanal");
    // }

    // Oppretter filer til kanalene og legger de tilhørende meldingene til filen.
    for (Melding[] kanal: meldingSamlingSortert){
      String filnavn = "kanal" + kanal[0].hentId() + ".txt";
      System.out.println(filnavn);

      try {
        File fil = new File(filnavn);

        if (!fil.exists()){ // Lager filen, hvis den ikke finnes fra før.
          fil.createNewFile(); // Hvis den fins, blir den bare overskrevet senere.
        }

        PrintWriter writer = new PrintWriter(fil, "utf-8");

        for (int i = 0; i < kanal.length; i++){ // Går gjennom Melding[], som er beholderen for meldginer fra en gitt kanal.
          writer.println(kanal[i].hentDekryptertInnhold()); // legger det til filen.
          writer.println();
          writer.println();
        }

        writer.close(); // lukker filen.
      } catch (IOException e){
        e.printStackTrace();
      }
    }
    latchOpleder.countDown();
  }
}
