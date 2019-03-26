import java.util.*;
import java.io.*;

public class Legesystem{
  // Opprett lister som lagrer objektene i legesystemet

  private static SortertLenkeliste<Lege> legeListe = new SortertLenkeliste<>();
  private static Lenkeliste<Pasient> pasientListe = new Lenkeliste<>();
  private static Lenkeliste<Legemiddel> legemiddelListe = new Lenkeliste<>();
  private static Lenkeliste<Resept> reseptListe = new Lenkeliste<>();

  public static int totNarko = 0;
  public static int totVane = 0;

  private static boolean running = true;
  private static Scanner input = new Scanner(System.in);


  public static void main(String[] args){

    // Scanner input = new Scanner(System.in);

    File fil = new File("innlesing.txt");
    lesFraFil(fil);

    while (running) {
      System.out.println("\n\n===========================");
      System.out.println("Velg hva du vil gjøre fra menyen:");
      System.out.println("1: Skrive ut all informasjon.");
      System.out.println("2: Legg til nye elementer.");
      System.out.println("3: Bruke en resept.");
      System.out.println("4: Skriv ut statistikk.");
      System.out.println("5: Skriv data til fil.");
      System.out.println("q: Avslutte programmet.");

      String fraBruker = input.nextLine();

      switch(fraBruker){
        case "q":
          System.out.println("Avslutter programmet");
          running = false;
        break;

        case "1":
          System.out.println();
          skrivInfo();
          break;
        case "2":
          leggTilElement();
          break;
        case "3":
          brukResept();
          break;
        case "4":
          lagStatistikk();
          System.out.println("\nTotalt utskrevende Narkotiske: " + totNarko);
          System.out.println("Totalt utskrevende Vanedannende: " + totVane);
          System.out.println();
          statNarkoMisbruk();
          break;
        case "5":
          System.out.println("\n===================\nMulighet for å skrive til fil er ikke implementert.");
          break;

        default:
          System.out.println("Ugyldig input. Prøv på nytt.");
      }
    }
  }

  public static void lagStatistikk() {
    totNarko = 0;
    totVane = 0;
    for (Lege elem: legeListe){
      totNarko = totNarko + elem.hentSkrevetNarko();
      totVane = totVane + elem.hentSkrevetVane();
    }
  }

  public static void statNarkoMisbruk(){
    for (Lege elem: legeListe){
      if(elem.hentSkrevetNarko() > 0 ){
      System.out.println(elem.hentNavn() + " har skrevet: " + elem.hentSkrevetNarko() + " resepter for narkotisk legemiddel.");
      }
    }

    System.out.println();
    for (Pasient elem: pasientListe){
      if (elem.tellNarkoResept() > 0){
        System.out.println(elem + " har " + elem.tellNarkoResept() + " narkotiske resepter.");
      }
      // for (Resept reseptElem: elem.hentReseptListe()){
      //   if (reseptElem.hentLegemiddel() instanceof PreparatA){
      //     System.out.println(elem + " har "+ i + " narkotisk resept");
      //     System.out.println();
      //   }
      // }
    }
  }

  public static void leggTilElement(){
    System.out.println("Velg hva du skal legge til:");
    System.out.println("1: Pasient");
    System.out.println("2: Lege eller Spesialist");
    System.out.println("3: Resept");
    System.out.println("4: Legemiddel");

    Scanner inn = new Scanner(System.in);
    String input = inn.nextLine();

    switch(input){
      case ("1"): // Pasient
        System.out.println("Legger til pasient");
        System.out.println("Oppgi navnet til pasienten: ");
        String navn = inn.nextLine();
        System.out.println("Oppgi fødselsnr til pasienten: ");
        String persnr = inn.nextLine();
        leggTilPasient(navn, persnr);
        break;

      case ("2"): // Lege / Spesialist
        System.out.println("1: Lege");
        System.out.println("2: Spesialist");
        input = inn.nextLine();

        if (input.equals("1")) { // Lege
          System.out.println("Oppgi Legens navn:");
          navn = inn.nextLine();
          leggTilLege(navn);
          break;
        }

        else if (input.equals("2")){ // Spesialist
            System.out.println("Oppgi Spesialistens navn: ");
            navn = inn.nextLine();
            System.out.println("Oppgi KontrollID:");
            try{
            int kontrollID = Integer.valueOf(inn.nextLine());
            leggTilSpesialist(navn, kontrollID);
          } catch (NumberFormatException e){
            System.out.println("KontrollID må være et tall! Prøv på nytt.");
          }

        } else {
          System.out.println("Ugyldig input, prøv på nytt.");
        }
        break;

      case ("3"): // Resept

        // Veglger legemiddel.
        System.out.println("Velg legemiddel");
        for (Legemiddel elem: legemiddelListe){
          System.out.println(elem.id + ": " + elem.hentNavn());
        }

        System.out.println("Oppgi navnet:");
        int aktueltMiddelID;
        try {
          aktueltMiddelID = Integer.valueOf(inn.nextLine());
        } catch (NumberFormatException e) {
          System.out.println("Du må oppgi et tall!");
          break;
        }

        //Velger lege.
        System.out.println("Hvilken lege skal skrive ut?");
        System.out.println("Velg mellom disse:");

        for (Lege elem: legeListe){
          System.out.println(elem.hentNavn());
        }
        System.out.println("\nSkriv navnet på legen som skal skrive.");
        String aktuellLegeNavn  = inn.nextLine();

        // Velg pasient
        System.out.println("Hvilken pasient skal ha resepten?");
        for (Pasient elem: pasientListe){
          System.out.println(elem.id + ": " + elem.hentNavn());
        }
        System.out.println("Oppgi pasientID:");
        int aktuellPasientId;
        try{
          aktuellPasientId = Integer.valueOf(inn.nextLine());
        } catch (NumberFormatException e) {
          System.out.println("Du må oppgi et tall!");
          break;
        }

        // Velg antall reit.
        System.out.println("Oppgi antal reit:");
        int antReit;
        try{
        antReit = Integer.valueOf(inn.nextLine());
        } catch (NumberFormatException e){
          System.out.println("Du må oppgi et tall. Prøv på nytt.");
          break;
        }

        leggTilResept(aktueltMiddelID, aktuellLegeNavn, aktuellPasientId, antReit);
        break;

      case ("4"): // Legemiddel
        System.out.println("Legger til legemiddel...");

        System.out.println("Oppgi navn på middel:");
        String middelNavn = inn.nextLine();

        System.out.println("Oppgi prisen:");
        double middelPris = Double.valueOf(inn.nextLine());

        System.out.println("Oppgi virkestoff mengde:");
        double middelVirkestoff = Double.valueOf(inn.nextLine());

        System.out.println("Velg legemiddeltype:");
        System.out.println("1: Narkotisk");
        System.out.println("2: Vanedannende");
        System.out.println("3: Vanlig");

        String valg = inn.nextLine();
        Legemiddel nyttMiddel = null;
        int styrke;

        if (valg.equals("1")){
          System.out.println("Oppgi styrke:");
          styrke = Integer.valueOf(inn.nextLine());
          leggTilNarkoLegemiddel(middelNavn, middelPris, middelVirkestoff, styrke);
        }

        if (valg.equals("2")){
          System.out.println("Oppgi styrke:");
          styrke = Integer.valueOf(inn.nextLine());
          leggTilVaneLegemiddel(middelNavn, middelPris, middelVirkestoff, styrke);
        }

        if (valg.equals("3")){
          leggTilLegemiddel(middelNavn, middelPris, middelVirkestoff);

        } else {
          System.out.println("Du må skrive et tall mellom 1-3. Prøv på nytt.");
        }

        break;


    }
  }

  public static void brukResept(){
    Scanner inn = new Scanner(System.in);
    System.out.println("Velg pasient:");
    for (Pasient elem: pasientListe){
      System.out.println(elem.id + ": " + elem);

    }
    int valgtPasient = Integer.valueOf(inn.nextLine());

    // Finner pasient --- Kan bruke finnPasient metode ;(
    Pasient aktuellPasient = null;
    for (Pasient elem: pasientListe){
      if(elem.id == valgtPasient){
        aktuellPasient = elem;
        System.out.println("\nDu valgte " + aktuellPasient);
        break;
      }
    }
    if(aktuellPasient == null){
      System.out.println("Fant ikke den pasienten. Prøv på nytt.");
      return;
    }

    if(aktuellPasient.hentReseptListe().stoerrelse() == 0){ // Pasienten har ingen resepter.
      System.out.println("Den pasienten har ingen resepter.");
      return;
    }

    System.out.println("Velg resept.");
    for (Resept elem: aktuellPasient.hentReseptListe()){
      System.out.println(elem.hentID() +": "+ elem.hentLegemiddel().hentNavn() + " - Uthentinger igjen: " + elem.hentReit());
    }

    int valg = Integer.valueOf(inn.nextLine());
    Resept aktuellResept = null;


    for (Resept elem: aktuellPasient.hentReseptListe()){
      if (valg == elem.hentID()){
        aktuellResept = elem;
        System.out.println("Du har valgt: ");
        System.out.println(elem);

        System.out.println("");
      } else {
        System.out.println("Fant ikke den resepten.");
      }
    }

    if (aktuellResept.bruk()){
      System.out.println("Bruker en reit.");
      System.out.println(aktuellResept.hentReit() +" reit igjen.");
    } else {
      System.out.println("Reseten har ikke mer reit.\nVelg en annen.");
      brukResept();
    }



  }

  // public static void skrivStatistikk(){
  //
  // }

  public static void leggTilPasient(String navn, String persnr){
    Pasient nyPasient = new Pasient(navn, persnr);
    pasientListe.leggTil(nyPasient);
    System.out.println("La til " + nyPasient + " i systemet.");
  }

  public static void leggTilLege(String navn){
    Lege nyLege = new Lege(navn);
    legeListe.leggTil(nyLege);
    System.out.println("La til " + nyLege + "i systemet.");
  }

  public static void leggTilSpesialist(String navn, int kontrollID){
    Lege nyLege = new Spesialist(navn, kontrollID);
    legeListe.leggTil(nyLege);
    System.out.println("La til " + nyLege + " i systemet.");
  }

  public static void leggTilNarkoLegemiddel(String navn, double pris, double virkestoff, int styrke){
    Legemiddel nyttMiddel = new PreparatA(navn, pris, virkestoff, styrke);
    legemiddelListe.leggTil(nyttMiddel);
    totNarko ++;
    System.out.println("La til" + nyttMiddel);
  }

  public static void leggTilVaneLegemiddel(String navn, double pris, double virkestoff, int styrke){
    Legemiddel nyttMiddel = new PreparatB(navn, pris, virkestoff, styrke);
    legemiddelListe.leggTil(nyttMiddel);
    totVane ++;
    System.out.println("La til" + nyttMiddel);
  }

  public static void leggTilLegemiddel(String navn, double pris, double virkestoff){
    Legemiddel nyttMiddel = new PreparatC(navn, pris, virkestoff);
    legemiddelListe.leggTil(nyttMiddel);
    System.out.println("La til" + nyttMiddel);
  }

  public static void leggTilResept(int middelID, String legeNavn, int pasientID, int reit){
    Legemiddel aktueltMiddel = finnLegemiddel(middelID);
    Lege aktuellLege = finnLege(legeNavn);
    Pasient aktuellPasient = finnPasient(pasientID);
    System.out.println(aktuellLege);
    System.out.println(aktuellPasient);
    System.out.println(aktueltMiddel);

    if(aktueltMiddel != null && aktuellLege != null && aktuellPasient != null){
      Resept nyResept = null;
      try {
        nyResept = aktuellLege.skrivResept(aktueltMiddel, aktuellPasient, reit);
        reseptListe.leggTil(nyResept);
      } catch (UlovligUtskrift e){
        e.getMessage();
        }
      } else {
        System.out.println("Noe gikk galt ved skriving av resept. Prøv igjen.");
    }
  }


  public static void skrivInfo(){
    System.out.println("\n----------------\nSkriver alle pasienter\n----------------\n");
    for (Pasient elem: pasientListe){
      System.out.println(elem);
    }

    System.out.println("\n----------------\nSkriver alle leger og resepter.\n----------------\n");
    for (Lege elem: legeListe){
      System.out.println(elem);
      elem.hentResepter();
      System.out.println("\n----------------\n");
    }

    System.out.println("\n----------------\nSkriver alle legemidler.\n----------------\n");
    for (Legemiddel elem: legemiddelListe){
      System.out.println(elem);
    }
  }


  public static Legemiddel finnLegemiddel(int legemiddelNr){
    for (Legemiddel elem: legemiddelListe){
      if (elem.hentId() == legemiddelNr) {
        return elem;
      }
    }
    System.out.println("Fant ikke det legemiddelet.");
    return null;
  }

  public static Lege finnLege(String navn){
    for (Lege elem: legeListe){
      if(elem.hentNavn().equals(navn)){
        return elem;
      }
    }
    System.out.println("Fant ikke den legen");
    return null;
  }

  public static Pasient finnPasient(int pasientID){
    for (Pasient elem: pasientListe){
      if (elem.id == pasientID){
        return elem;
      }
    }
    System.out.println("Fant ikke den pasienten");
    return null;
  }

  private static void lesFraFil(File fil){
    Scanner scanner = null;
    try{
      scanner = new Scanner(fil);
    }catch(FileNotFoundException e){
      System.out.println("Fant ikke filen, starter opp som et tomt Legesystem");
      return;
    }


    String innlest = scanner.nextLine();

    while(scanner.hasNextLine()){
      String[] info = innlest.split(" ");
            // Legger til alle pasientene i filen
      if(info[1].compareTo("Pasienter") == 0){
        while(scanner.hasNextLine()) {
          innlest = scanner.nextLine();

          if(innlest.charAt(0) == '#'){
            break;
          }

          String[] innlestListe = innlest.split(", "); // Lagde selv.. Se neste blokk.

          String navn = innlestListe[0];
          String persNr = innlestListe[1];
          Pasient nyPasient = new Pasient(navn, persNr); // Oppretter pasient objekt.

          pasientListe.leggTil(nyPasient);
        }

      } else if(info[1].compareTo("Legemidler") == 0){ //Legger inn Legemidlene
        while(scanner.hasNextLine()){
          innlest = scanner.nextLine();

          if(innlest.charAt(0) == '#'){
            break;
          }

          String[] legemiddel = innlest.split(", "); // lagde ikke selv..

          String navn = legemiddel[0]; // Kan droppe variablene og bruke referansene i arrayet direkte.
          String type = legemiddel[1];
          double pris = Double.valueOf(legemiddel[2]);
          double virkestoff = Double.valueOf(legemiddel[3]);

          if(legemiddel[1].compareTo("a") == 0){
            int styrke = Integer.valueOf(legemiddel[4]);
            Legemiddel nyttMiddel = new PreparatA(navn, pris, virkestoff, styrke);
            legemiddelListe.leggTil(nyttMiddel);

          }else if(legemiddel[1].compareTo("b") == 0){
            int styrke = Integer.valueOf(legemiddel[4]);
            Legemiddel nyttMiddel = new PreparatB(navn, pris, virkestoff, styrke);
            legemiddelListe.leggTil(nyttMiddel);

          }else if (legemiddel[1].compareTo("c") == 0){
            Legemiddel nyttMiddel = new PreparatC(navn, pris, virkestoff);
            legemiddelListe.leggTil(nyttMiddel);
          }
        }
      }

      //Legger inn leger
      else if(info[1].compareTo("Leger") == 0){
        while(scanner.hasNextLine()){
          innlest = scanner.nextLine();

          if(innlest.charAt(0) == '#'){
            break;
          }
          String[] legeInfo = innlest.split(", ");

          String navn = legeInfo[0];
          int kontrollID = Integer.valueOf(legeInfo[1]);
          Lege nyLege;

          if (kontrollID != 0){
            nyLege = new Spesialist(navn, kontrollID);
          } else {
            nyLege = new Lege(navn);
          }

          legeListe.leggTil(nyLege);
        }

      }else if(info[1].compareTo("Resepter") == 0){ //Legger inn Resepter
        while(scanner.hasNextLine()){
          innlest = scanner.nextLine();
          info = innlest.split(", ");

          int legemiddelNr = Integer.valueOf(info[0]);
          String legeNavn = info[1];
          int pasientID = Integer.valueOf(info[2]);
          int reit = Integer.valueOf(info[3]);

          Legemiddel middel = finnLegemiddel(legemiddelNr);
          Lege legeSkalSkrive = finnLege(legeNavn);
          Pasient skalFaa = finnPasient(pasientID);
          try{
          Resept nyResept = legeSkalSkrive.skrivResept(middel, skalFaa, reit); // Oppretter HvitResept.
          } catch (UlovligUtskrift uu) {
          System.out.println(uu.getMessage());
          }
        }
      }
    }
  }
}
