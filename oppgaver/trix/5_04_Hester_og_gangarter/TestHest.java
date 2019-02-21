class TestHest {
  public static void main(String[] args) {
    EngelskFullblodshest willy = new EngelskFullblodshest("William", 11);

    PasoFino rod = new PasoFino("Rod", 5);
    Islandshest vidja = new Islandshest("Vidja", 12);

    willy.skritt();
    willy.trav();
    willy.galopp();

    rod.skritt();
    rod.toelt();

    vidja.trav();
    vidja.toelt();
    vidja.pass();
  }
}
