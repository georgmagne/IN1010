import java.io.*;
import java.util.*;
// import java.util.ArrayList;


public class LeseFraFil{
  // Arrays med string fra fil.
  protected ArrayList<String> linjer = new ArrayList<String>();
  protected ArrayList<String> legemidler = new ArrayList<String>();
  protected ArrayList<String> leger = new ArrayList<String>();
  protected ArrayList<String> resepter = new ArrayList<String>();

  // Array og Hashmaps med opprett
  protected ArrayList<Resept> resepterSamling = new ArrayList<Resept>();
  protected HashMap<Integer, Legemiddel> middelSamling = new HashMap<Integer, Legemiddel>();
  protected HashMap<String, Lege> legeSamling = new HashMap<String, Lege>();

  // Kontruktør
  public LeseFraFil (String filnavn) {
    File filen = new File(filnavn);
    Scanner fil = null;

    try {
      fil = new Scanner(filen);
    } catch (FileNotFoundException e) {
      System.out.println("Finner ikke filen: " + filnavn);
    }

    // Henter ut og sorterer infoen fra filen til arrayene.
    while (fil.hasNextLine()) {
      linjer.add(fil.nextLine());
    }

    for (int i = 0; i < linjer.size(); i++){
      if (linjer.get(i).indexOf("#") != -1){
        String infoLinje = linjer.get(i);
        String[] infoBiter = infoLinje.split(" ");
        String navn = infoBiter[1].toLowerCase();

        if (navn.equals("legemidler")){
          System.out.println("Fant legemidlene");
          legemidler.add(linjer.get(i+1)); // Hardkodet!
          legemidler.add(linjer.get(i+2));
          legemidler.add(linjer.get(i+3));
          legemidler.add(linjer.get(i+4));
        }

        if (navn.equals("leger")){
          System.out.println("Fant legene");
          leger.add(linjer.get(i+1)); // Hardkodet!
          leger.add(linjer.get(i+2));
          leger.add(linjer.get(i+3));
          leger.add(linjer.get(i+4));
        }

        if (navn.equals("resepter")){
          System.out.println("Fant reseptene");
          resepter.add(linjer.get(i+1)); // Hardkodet!
          resepter.add(linjer.get(i+2));
          resepter.add(linjer.get(i+3));
          resepter.add(linjer.get(i+4));
        }
      }
    }

    // Oppretter Legemidler, Leger og Resepter.

    //Oppretter Legemiddel objekter og legger til middelSamling.
    for (String elem: legemidler) {
      String[] biter;
      biter = elem.split(", ");

      String navn = biter[0];
      String type = biter[1];
      double pris = Double.parseDouble(biter[2]);
      double virkestoff = Double.parseDouble(biter[3]);
      int styrke;

      if (type.equals("a")){
        styrke = Integer.parseInt(biter[4]);
        Legemiddel nyttMiddel = new PreparatA(navn, pris, virkestoff, styrke);
        middelSamling.put(nyttMiddel.id, nyttMiddel);
      }

      if (type.equals("b")) {
        styrke = Integer.parseInt(biter[4]);
        Legemiddel nyttMiddel = new PreparatB(navn, pris, virkestoff, styrke);
        middelSamling.put(nyttMiddel.id, nyttMiddel);
      }

      if (type.equals("c")){
        Legemiddel nyttMiddel = new PreparatC(navn, pris, virkestoff);
        middelSamling.put(nyttMiddel.id, nyttMiddel);
      }
    }

    // Oppretter Lege objekter og legger til
    for (String elem: leger){
      String[] biter = elem.split(", ");
      String navn  = biter[0];
      int kontrollID = Integer.parseInt(biter[1]);
      if (biter[1].equals("0")){ // Ikke spesialist
        Lege nyLege = new Lege (navn);
        legeSamling.put(navn, nyLege);
      } else { // Spesialist
        Spesialist nyLege = new Spesialist(navn, kontrollID);
        legeSamling.put(navn, nyLege);
      }
    }

    // Oppretter Resept objekter med riktig lege, legger til legeSamling.
    for (String elem: resepter) {
      String[] biter = elem.split(", ");
      String type = biter[0];
      int legemiddelNummer = Integer.parseInt(biter[1]);
      String legeNavn = biter[2];
      int persID = Integer.parseInt(biter[3]);
      int reit;

      if (type.equals("prevensjon")){ // Reit blir ikke angitt.
        Resept nyResept = reseptTryCatch(legeSamling.get(legeNavn), middelSamling.get(legemiddelNummer), persID);
        resepterSamling.add(nyResept);
      }

      if (type.equals("blaa")) { // Hvis blaa resept
        reit = Integer.parseInt(biter[4]);
        Resept nyResept = blaaTryCatch(legeSamling.get(legeNavn), middelSamling.get(legemiddelNummer), persID, reit);
        resepterSamling.add(nyResept);
      }

      if (type.equals("hvit")) { // Hvis HvitResept.
        reit = Integer.parseInt(biter[4]);
        Resept nyResept = reseptTryCatch(legeSamling.get(legeNavn), middelSamling.get(legemiddelNummer), persID, reit);
        resepterSamling.add(nyResept);
      }

      if (type.equals("militaer")){ // Hvit millitaer resept.
        reit = Integer.parseInt(biter[4]);
        Resept nyResept = millitTryCatch(legeSamling.get(legeNavn), middelSamling.get(legemiddelNummer), persID, reit);
        resepterSamling.add(nyResept);
      }
    }

    // Fjerner alle null indexer, forårsaket av godkjennigspliktig lege forsøk på å skrive ut narkotisk stoff.
    for (int i = 0; i < resepterSamling.size(); i++ ){
      if(resepterSamling.get(i) == null){
        resepterSamling.remove(i);
      }
    }
  }

  // Metode for å opprette Resept.
  public Resept reseptTryCatch (Lege lege, Legemiddel prep, int pasientID, int reit) {
    try {
      System.out.println("Skriver resept for: " + prep.hentNavn() + ".");
      return lege.skrivResept(prep, pasientID, reit);
    } catch (UlovligUtskrift uu) {
      System.out.println(uu.getMessage());
      return null;
    }
  }

  // Overloading for prevensjon resept.
  public Resept reseptTryCatch (Lege lege, Legemiddel prep, int pasientID){
    try {
      // System.out.println("Skriver prevensjon resept for " + prep.hentNavn());
      return lege.skrivResept(prep, pasientID);
    } catch (UlovligUtskrift uu) {
      System.out.println(uu.getMessage());
      return null;
    }
  }

  // Metode for å opprette blaa resept.
  public Resept blaaTryCatch (Lege lege, Legemiddel prep, int pasientID, int reit) {
    try {
      System.out.println("Skriver blaa resept for " + prep.hentNavn());
      return lege.skrivBlaa(prep, pasientID, reit);
    } catch (UlovligUtskrift uu) {
      System.out.println(uu.getMessage());
      return null;
    }
  }

  public Resept millitTryCatch (Lege lege, Legemiddel prep, int pasientID, int reit) {
    try {
      System.out.println("Skriver millitaer resept for " + prep.hentNavn());
      return lege.skrivMilitaer(prep, pasientID, reit);
    } catch (UlovligUtskrift uu) {
      System.out.println(uu.getMessage());
      return null;
    }
  }


}
