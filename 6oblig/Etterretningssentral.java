public class Etterretningssentral {

  public static void main(String[] args) {
    int antallTelegrafister = 3;

    Operasjonssentral ops = new Operasjonssentral(antallTelegrafister);
    Kanal[] kanaler = ops.hentKanalArray();
    System.out.println("Antall kanaler: " + kanaler.length);

    KryptMonitor kryptMonitor = new KryptMonitor();
    DekryptMonitor dekryptMonitor = new DekryptMonitor();

    for (int i = 0; i < antallTelegrafister; i++){
      Runnable lyttejobb = new Telegrafist(kanaler[i], kryptMonitor);
      new Thread(lyttejobb).start();
    }

  }
}
