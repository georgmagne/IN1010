class Main{
  public static void main(String[] args) throws Exception {
    Regneklynge abel = new Regneklynge("regneklynge4.txt"); // Oppretter en Regneklynge kallt abel.

    System.out.println("Noder med minst 64GB: " + abel.totNoderMedNokMinne(64)); // Henter antall noder med 64GB eller mer minne.
    System.out.println("Noder med minst 32GB: " + abel.totNoderMedNokMinne(32)); // Henter antall noder med 32GB eller mer minne.
    System.out.println("Noder med minst 128GB: " + abel.totNoderMedNokMinne(128)); // Henter antall noder med 128GB eller mer minne-
    System.out.println("Antall prosessorer: " + abel.antTotProsessorer()); // Henter totale mengden prosessorer.
    System.out.println("Antall racks: " + abel.getAntRack()); // Henter totatle mengeden racks.

  }
}
