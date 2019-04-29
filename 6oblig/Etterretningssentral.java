import java.util.LinkedList;

public class Etterretningssentral {

  public static void main(String[] args) {
    int antallTelegrafister = 3;
    int antallKryptografer = 20;

    int antDekryptMelding = 0;
    int antKryptMelding = 0;
    int antMeldinger = 0;

    Operasjonssentral ops = new Operasjonssentral(antallTelegrafister);
    Kanal[] kanaler = ops.hentKanalArray();
    System.out.println("Antall kanaler: " + kanaler.length);

    KryptMonitor kryptMonitor = new KryptMonitor();
    DekryptMonitor dekryptMonitor = new DekryptMonitor();

    for (int i = 0; i < antallTelegrafister; i++){ // Lytter til alle kanalene.
      Runnable lyttejobb = new Telegrafist(kanaler[i], kryptMonitor);
      new Thread(lyttejobb).start();
    }

    // for (int i = 0; i < antallKryptografer; i++){ // Oppretter kryptografer.
    //   Runnable dekryptering = new Kryptograf(kryptMonitor, dekryptMonitor);
    //   new Thread(dekryptering).start();
    // }

    // try{
    //   System.out.println("Main sover i 7.5sek");
    //   Thread.sleep(7500);
    // } catch (InterruptedException e){
    //   System.out.println("fak");
    // }
    // LinkedList<Melding> meldinger = kryptMonitor.hentMeldinger();

    // int antKryptMelding = 0;
    // for (Melding elem: kryptMonitor.hentMeldinger()){
    //   System.out.println(elem);
    //   antKryptMelding++;
    // }
    // System.out.println("Ferdig med å skrive kryptertMeldinger\n");
    // System.out.println("tot: " + antKryptMelding);
    // kryptMonitor.ferdigMedLytting = true;

    for (int i = 0; i < antallKryptografer; i++){ // Oppretter kryptografer.
      Runnable dekryptering = new Kryptograf(kryptMonitor, dekryptMonitor);
      new Thread(dekryptering).start();
    }

    // LinkedList<Melding> dekrypterteMeldinger = dekryptMonitor.hentMeldinger();

    try{
      System.out.println("Main sover i 20sek");
      Thread.sleep(20000);
    } catch (InterruptedException e){
      System.out.println("fak");
    }
    dekryptMonitor.ferdigMedDekrypt = true;

    // int antDekryptMelding = 0;
    for (Melding elem: dekryptMonitor.hentMeldinger()){
      System.out.println(elem);
      if (elem.dekryptert){
        antDekryptMelding++;
      }
      antMeldinger++;

    }
    System.out.println("Skrevet ut meldingene");
    System.out.println("Det er : " + antMeldinger + "stk kryptertMeldinger");
    System.out.println("Det er: " + antDekryptMelding + "stk dekryptmeldinger.") ;

    Runnable opleder = new Operasjonsleder(dekryptMonitor, antallTelegrafister);
    new Thread(opleder).start();
    // System.exit(0);
  }
}
