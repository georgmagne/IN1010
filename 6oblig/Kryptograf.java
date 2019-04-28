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
    System.out.println("Starter å dekryptere: ");
    while (running){
      Melding skalDekryptes = hentFra.taUtMelding();
      if(skalDekryptes == null){
        running = false;
        System.out.println("Avslutter" + this);
      } else{
        System.out.println("Jeg er her!!!!!");
        String kryptertMelding = skalDekryptes.hentKryptertInnhold();
        String dekryptertMelding = Kryptografi.dekrypter(kryptertMelding);

        skalDekryptes.dekrypt(dekryptertMelding);

        giTil.leggTilMelding(skalDekryptes);
        System.out.println("Dekryptert:");
        System.out.println(skalDekryptes);
      }
    }


  }
}
