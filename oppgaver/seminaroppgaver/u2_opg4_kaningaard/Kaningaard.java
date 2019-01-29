class Kaningaard {
  private Kanin[] kaniner = new Kanin[100]; // Opretter et array med plass til Kanin objekter.
  // Velger array fordi antall plasser i Kaningaarden er fastsatt på forhånd.

  public boolean full() {
    for (int i = 0; i < kaniner.length; i++){ // Itererer gjennom arrayet kaniner.
      if (kaniner[i] == null){ // Hvis en plass i arrayet == null, altså ledig plass.
        return false;
      }
    }
    return true; // If testen slår ikke ut på noen indexer, altså; ingen ledige plasser.
  }
  public boolean tom() {
   for (int i = 0; i < kaniner.length; i++) { // Itererer gjennom arrayet kaniner.
     if (kaniner[i] != null){ // Hvis en plass i arrayet har peker på en kanin, altså; ikke tom.
      return false;
      }
   }
   return true;
  }

  public Kanin finnEn(String navn) {
    for (Kanin elem: kaniner) { // Plukker ut kaniner fra arrayet; kaniner og kaller dem elem
      if (navn == elem.hentNavn()){ // Hvis parameteret navn, er det samme som en kanin(elem) sitt navn.
        System.out.println("Kaninen " + navn + " er i kaningaarden!");
        return elem;
      }
    }
    System.out.println("Kaninen " + navn + " er ikke i kaningaarden!"); // Dette blir printet hvis
    return null; // Avslutter metoden.
  }

  public void settInn(Kanin kanin) {
    if (finnEn(kanin.hentNavn() != null)) { // Kaninen er i gaarden
        System.out.println("Den kaninen er allerede i gaarden.");
      } else if (full()){ // Hvis gaarden er full.
        System.out.println("Gaarden er full!");
      } else {
          boolean sattInn = false;
          int teller = 0;

          while (teller < kaniner.length && !sattinn){ // Så lenge telleren < lengden til arrayet og sattInn = false.
            if (kaniner[teller] == null){ // Hvis plassen i arrayet er ledig.
              kaniner[teller] = kanin; // Setter den ledig plassen lik kaninen fra parameteret.
              sattInn = true;
            }
            teller++; // Øker teller variabelen.
        }
      }
    }
  public void fjern(String navn) {
    boolean funnet = false;
    int teller = 0;

    while (teller < kaniner.length && !funnet){
      if (kaniner[teller] != null && kaniner[teller].hentNavn().equals(navn)){ // Hvis en index i arrayet kaniner er ikke-tom, og kaninen på denne indexen har samme navn som parameteret.
        kaniner[teller] = null;
        funnet = true;
      }
      teller++;
    }
    if (!funnet){
      System.out.println("Fant ikke kaninen " + navn + ".");
    }
  }

  public static void main(String[] args) {
    Kaningaard kg = new Kaningaard();
    kg.settInn(new Kanin("Kaare"));
    kg.settInn(new Kanin("Kaare"));
    kg.fjern("Kaare");
    kg.fjern("Kaare");
  }
}
