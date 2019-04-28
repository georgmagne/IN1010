import java.util.LinkedList;

public class Etterretningssentral {

  public static void main(String[] args) {
    int antallTelegrafister = 3;
    int antallKryptografer = 20;

    Operasjonssentral ops = new Operasjonssentral(antallTelegrafister);
    Kanal[] kanaler = ops.hentKanalArray();
    System.out.println("Antall kanaler: " + kanaler.length);

    KryptMonitor kryptMonitor = new KryptMonitor();
    DekryptMonitor dekryptMonitor = new DekryptMonitor();

    for (int i = 0; i < antallTelegrafister; i++){ // Lytter til alle kanalene.
      Runnable lyttejobb = new Telegrafist(kanaler[i], kryptMonitor);
      new Thread(lyttejobb).start();
    }

    try{
      System.out.println("Main sover i 10sek");
      Thread.sleep(10000);
    } catch (InterruptedException e){
      System.out.println("fak");
    }
    // LinkedList<Melding> meldinger = kryptMonitor.hentMeldinger();

    for (Melding elem: kryptMonitor.hentMeldinger()){
      System.out.println(elem);
    }

    for (int i = 0; i < antallKryptografer; i++){ // Oppretter kryptografer.
      Runnable dekryptering = new Kryptograf(kryptMonitor, dekryptMonitor);
      new Thread(dekryptering).start();
    }

    LinkedList<Melding> dekrypterteMeldinger = dekryptMonitor.hentMeldinger();

    try{
      System.out.println("Main sover i 20sek");
      Thread.sleep(20000);
    } catch (InterruptedException e){
      System.out.println("fak");
    }

    for (Melding elem: dekrypterteMeldinger){
      System.out.println(elem);
    }
  }
}
