import java.util.*;
import java.io.*;

public class Legesystem{
  // Opprett lister som lagrer objektene i legesystemet
  public static HashMap<String, Pasient> pasientSamling = new HashMap<String, Pasient>(); // Nødvendig??

  public static Lenkeliste<Lege> legeListe = new Lenkeliste<>();
  public static Lenkeliste<Pasient> pasientListe = new Lenkeliste<>();
  public static Lenkeliste<Legemiddel> legemiddelListe = new Lenkeliste<>();

  public static void main(String[] args){

  }

  public Legemiddel finnLegemiddel(int legemiddelNr){
    for (Node elem: legemiddelListe) {
      if (elem.data.hentId() == legemiddelNr) {
        return elem.data;
      }
    }
      System.out.println("Fant ikke det legemiddelet.");
  }

  public Lege finnLege(String navn){

  }

  public Pasient finnPasient(int PasientID){

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
          String[] innlestListe = innlest.split(", "); // Lagde selv.. Se neste blokk.

          String navn = innlestListe[0] + innlestListe[1];
          String persNr = innlestListe[2];

          Pasient nyPasient = new Pasient(navn, persNr); // Oppretter pasient objekt.
          pasientSamling.put(navn, nyPasient); // Legger det nye pasient objektet til HashMappen, men navn som nøkkel.

          if(innlest.charAt(0) == '#'){     //Om vi er ferdig med å legge til pasienter, bryt whileløkken,
            break;                          //slik at vi fortsetter til koden for å legge til legemiddler
          }
            //
            //MERK:  Her må du legge til pasienten i en lenkeliste
            //
          pasientListe.leggTil(nyPasient);
        }

      } else if(info[1].compareTo("Legemidler") == 0){ //Legger inn Legemidlene
        while(scanner.hasNextLine()){
          innlest = scanner.nextLine();
          // String[] innlestListe = innlest.split(", ");

          //Om vi er ferdig med å legge til legemidler, bryt whileløkken,
          //slik at vi fortsetter til koden for å legge til leger
          if(innlest.charAt(0) == '#'){
            break;
          }

          String[] legemiddel = innlest.split(", "); // lagde ikke selv..

          String navn = legemiddel[0]; // Kan droppe variablene og bruke referansene i arrayet direkte.
          String type = legemiddel[1];
          double pris = Double.valueOf(legemiddel[2]);
          double virkestoff = Double.valueOf(legemiddel[3]);
          int styrke = Integer.valueOf(legemiddel[4]);

          if(legemiddel[1].compareTo("a") == 0){
            Legemiddel nyttMiddel = new PreparatA(navn, pris, virkestoff, styrke);
            legemiddelListe.leggTil(nyttMiddel);
              //
              //MERK:  Her må du legge til et PreparatA i en lenkeliste
              //
          }else if(legemiddel[1].compareTo("b") == 0){
            Legemiddel nyttMiddel = new PreparatB(navn, pris, virkestoff, styrke);
            legemiddelListe.leggTil(nyttMiddel);
              //
              //MERK:  Her må du legge til et PreparatB i en lenkeliste
              //
          }else if (legemiddel[1].compareTo("c") == 0){
            Legemiddel nyttMiddel = new PreparatC(navn, pris, virkestoff);
            legemiddelListe.leggTil(nyttMiddel);
              //
              //MERK:  Her må du legge til et PreparatC i en lenkeliste
              //
          }
        }
      }

      //Legger inn leger
      else if(info[1].compareTo("Leger") == 0){
        while(scanner.hasNextLine()){
          innlest = scanner.nextLine();

            //Om vi er ferdig med å legge til leger, bryt whileløkken,
            //slik at vi fortsetter til koden for å legge til resepter
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
          int pasientID = Integer.valueOf(info[3]);
          int reit = Integer.valueOf(info[4]);

          Legemiddel middel;
          Lege skalSkrive;
          Pasient skalFaa;


          //
          // Her må du finne legen, legemiddelet, og pasienten som ligger
          // i lenkelistene utifra informasjonen.
          //
          // Dette burde skilles ut i hjelpemetoder leter gjennom listene
          // og returnerer riktig objekt, ut ifra informasjonen som ble lest inn
          //
          // Opprett et reseptobjekt med skrivResept funksjonen i legen,
          // og legg det til i en lenkeliste
          //
          // Dersom legeobjektene dine oppretter PResepter, kan du ignorere reit
          //
          //
        }
      }
    }
  }
}
