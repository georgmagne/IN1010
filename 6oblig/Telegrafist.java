import java.util.concurrent.CountDownLatch;

public class Telegrafist implements Runnable{

  private Kanal kanal;
  private int kanalId;
  private int antMottattMelding;
  private KryptMonitor rapportererTil;
  private boolean running = true;
  private CountDownLatch latchTelegraf;

  public Telegrafist(Kanal kanal, KryptMonitor sjef, CountDownLatch latchTelegraf){
    this.kanal = kanal;
    this.kanalId = kanal.hentId();
    this.rapportererTil = sjef;
    this.antMottattMelding = 0;
    this.latchTelegraf = latchTelegraf;
  }

  @Override
  public void run(){
    System.out.println("Starter å lytte på: " + this.kanalId);

    while (running) {
      String nyMeldingInnhold = this.kanal.lytt();

      if (nyMeldingInnhold == null){ // Tomt for meldinger.
        running = false;

      } else { // Mottatt ny melding.
        antMottattMelding++;
        Melding nyMelding = new Melding(nyMeldingInnhold, this.kanalId, antMottattMelding);
        rapportererTil.leggTilMelding(nyMelding);
      }
    }

    latchTelegraf.countDown();
    System.out.println("Ferdig med å lytte. Avslutter avlytting på kanal: " + this.kanalId);
  }
}
