public class Integrasjonstest {
  public static void main(String[] args) {

    Lege lege1 = new Lege("Dr. Mengele");
    Spesialist spes1 = new Spesialist("Dr. House", 12313);
    Lege[] legeListe = new Lege[]{lege1, spes1};

    Legemiddel prepA = new PreparatA("Black Tar Heroin", 12, 12, 1);
    Legemiddel prepB = new PreparatB("Valium", 20, 5, 10);
    Legemiddel prepC = new PreparatC("Paracet", 123, 13);
    Legemiddel[] legemiddelListe = new Legemiddel[]{prepA, prepB, prepC};

    System.out.println("*Lager Resepter: ");
    Resept nyResept1 = reseptTryCatch(spes1, prepA, 123, 34);
    Resept nyResept2 = reseptTryCatch(lege1, prepB, 123, 123);
    Resept ugyldigLege = reseptTryCatch(lege1, prepA, 1233, 123); // Prøver å lage en resept for narkotisk, med lege, ikke spesialist.
    Resept prev1 = reseptTryCatch(lege1, prepC, 12333);
    Resept[] reseptListe = new Resept[]{nyResept1, nyResept2, prev1, ugyldigLege};

    System.out.println();
    //Skriver ut Legemidlene.
    System.out.println("*LEGEMIDLER: ");
    for (Legemiddel elem: legemiddelListe){
      System.out.println(elem);
    }
    System.out.println("-----------------");
    System.out.println();


    //Skriver ut legene
    System.out.println("*LEGER:");
    for (Lege elem: legeListe){
      System.out.println(elem);
    }
    System.out.println("-----------------");
    System.out.println();


    // Skriver ut reseptene.
    System.out.println("*RESEPTER: ");
    for (Resept elem: reseptListe){
      System.out.println(elem);
      System.out.println();
    }
  }

  public static Resept reseptTryCatch (Lege lege, Legemiddel prep, int pasientID, int reit){
    try {
      Resept resept;
      resept = lege.skrivResept(prep, 123, 4);
      System.out.println("Skriver resept for " + prep.hentNavn() + ".");
      return resept;
    } catch (UlovligUtskrift uu) {
      System.out.println("Kunne ikke skrive resept for: " + prep.hentNavn() );
      System.out.println(uu.getMessage());
      return null;
    }
  }

  // Overloading for prevensjon resept.
  public static Resept reseptTryCatch (Lege lege, Legemiddel prep, int pasientID){
    try {
      System.out.println("Skriver prevensjon resept for " + prep.hentNavn());
      Resept resept;
      resept = lege.skrivResept(prep, 12333);
      return resept;
    } catch (UlovligUtskrift uu) {
      System.out.println(uu.getMessage());
      return null;
    }

  }
}
