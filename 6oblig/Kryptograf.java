public class Kryptograf implements Runnable {

  private KryptMonitor hentFra;
  private DekryptMonitor giTil;
  private boolean running = true;

  public Kryptograf(KryptMonitor hentFra, DekryptMonitor giTil){
    this.hentFra = hentFra;
    this.giTil = giTil;
  }

  @Override
  public void run(){
    System.out.println("Starter i dekryptere: ");
    while (running){
      Melding skalDekryptes = hentFra.taUtMelding();
      if(skalDekryptes == null){
        running = false;
      } else{
        String kryptertMelding = skalDekryptes.hentKryptertInnhold();
        String dekryptertMelding = Kryptografi.dekrypter(kryptertMelding);

        skalDekryptes.dekrypt(dekryptertMelding);

        giTil.leggTilMelding(skalDekryptes);
      }
    }


  }
}
