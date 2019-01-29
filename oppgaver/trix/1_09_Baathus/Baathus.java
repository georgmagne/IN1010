public class Baathus {
  private Baat[] baathus; // Baat definerer hva som skal være i arrayet, arrayet får navnet Baathus

  public Baathus(int antallPlasser) { // Metode som tar ett parameter, hvor mange plasser man vil ha i Baathuset.
    baathus = new Baat[antallPlasser]; // Lager et array som setter av 'antallPlasser' i minne til arrayet.
  }

  public void settInn(Baat enBaat) { // Metode som skal sette inn en baat i baathuset.
    boolean sattInn = false; // Boolsk variabel holder styr på om et objekt er satt inn eller ikke.
    int teller = 0; // Teller hvor mange objekter som er satt inn.

    while (teller < baathus.length && sattInn == false) { // Så lenge teller variabelen er mindre og sattInn er false
      if (baathus[teller] == null) { // Inntreffer hvis¸telleren går utenfor rangen til arrayet.
        baathus[teller] = enBaat;
        sattInn = true;
      } // Lukker if-en

      teller ++;
    } //Lukker while løkken

    if (sattInn != true) {
      System.out.println("Det er ikke plass til flere båter!");
    }
  }

  public void skrivBaater() {
    for (int i = 0; i < baathus.length; i++) {
      if (baathus[i] != null) {
        System.out.println(baathus[i].hentInfo());
      }
    }
  }
}
