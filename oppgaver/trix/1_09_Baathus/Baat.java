class Baat {

  private static int antProd = 0; // Static nummer, for alle baater.
  private int prodnr; // variabel for unikt nummer til hver av baatene
  private String merke; // Navn, definert ved en sting
  }

  public Baat(String mrk) {
    prodnr = antProd; // Baat får nummer ettersom hvor mange som har blitt produsert.
    antProd++; // antProd variabel blir økt med 1. Etter at en ny baat har blir laget.
    merke = mrk; // merke er definert av parameter.
  }

  public String hentInfo() { // Metode som returnerer info om baaten + litt string.
    return "Produksjonsnummer: " + prodnr + ", merke: " + merke;
  }
}
