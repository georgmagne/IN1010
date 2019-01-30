class Main{
  public static void main(String[] args) {
    Regneklynge abel = new Regneklynge(12); // Oppretter en Regneklynge kallt abel.

    for (int i = 0; i < 650; i++) { // Kjøres 650 ganger, og legger til en node hver gang.
      abel.settInnNode(new Node(64, 1)); // Node med 64GB og en Prosessor blir satt inn.
    }

    for (int i = 0; i < 16; i++) { // Kjøres 16 ganger og legger til node hver gang.
      abel.settInnNode(new Node(1024, 2)); // Node med 1024GB minne og to prosessorer blir satt inn.
    }

    System.out.println("Noder med minst 64GB: " + abel.totNoderMedNokMinne(64)); // Henter antall noder med 64GB eller mer minne.
    System.out.println("Noder med minst 32GB: " + abel.totNoderMedNokMinne(32)); // Henter antall noder med 32GB eller mer minne.
    System.out.println("Noder med minst 128GB: " + abel.totNoderMedNokMinne(128)); // Henter antall noder med 128GB eller mer minne-
    System.out.println("Antall prosessorer: " + abel.antTotProsessorer()); // Henter totale mengden prosessorer.
    System.out.println("Antall racks: " + abel.getAntRack()); // Henter totatle mengeden racks.

  }
}
