import java.util.concurrent.CountDownLatch;

public class Kryptograf implements Runnable {

  private KryptMonitor hentFra;
  private DekryptMonitor giTil;
  private boolean running = true;
  private CountDownLatch latch;

  public Kryptograf(KryptMonitor hentFra, DekryptMonitor giTil, CountDownLatch latch){
    this.hentFra = hentFra;
    this.giTil = giTil;
    this.latch = latch;
  }

  @Override
  public void run(){
    System.out.println("Starter å dekryptere: ");
    while (running){
      Melding skalDekryptes = hentFra.taUtMelding();
      if(skalDekryptes == null){
        running = false;
        System.out.println("Avslutter" + this);

      } else {
        String kryptertMelding = skalDekryptes.hentKryptertInnhold();
        String dekryptertMelding = Kryptografi.dekrypter(kryptertMelding);

        skalDekryptes.dekrypt(dekryptertMelding);

        giTil.leggTilMelding(skalDekryptes);
        System.out.println("Dekryptert:" + skalDekryptes.hentId() + " " + skalDekryptes.hentSekvensnummer());
        // System.out.println(skalDekryptes);
      }
    }
    latch.countDown();

  }
}
