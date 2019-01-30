class Main{
  public static void main(String[] args) {
    Regneklynge abel = new Regneklynge();

    for (int i = 0; i < 650; i++) {
      abel.settInnNode(new Node(64, 1));
    }

    for (int i = 0; i < 16; i++) {
      abel.settInnNode(new Node(1024, 2));
    }

    System.out.println("Antall prosessorer: " + abel.antTotProsessorer());
    System.out.println("Noder med minst 64GB: " + abel.noderMedNokMinne(64));
    System.out.println("Noder med minst 32GB: " + abel.noderMedNokMinne(32));
    System.out.println("Noder med minst 128GB: " + abel.noderMedNokMinne(128));

    System.out.println("Antall racks: " + abel.getAntRack()); // Ok
  }
}
