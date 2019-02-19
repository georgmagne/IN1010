import java.util.ArrayList;

public class TestPreparat {

  public static void main(String[] args) {
    PreparatA prepA = new PreparatA("Black tar heroin", 300, 5, 10);
    PreparatB prepB = new PreparatB("Valium", 150, 3, 4);
    PreparatC prepC = new PreparatC("Paracet", 40, 2);

    Legemiddel[] middelListe;
    middelListe = new Legemiddel[]{prepA, prepB, prepC};

    // System.out.println("Tester subklasse metoder:");
    // System.out.println("PrepA sin narkotiske styrke: " + prepA.hentNarkotiskStyrke());
    // System.out.println("PrepB sin vanedannende styrke: " + prepB.hentVanedannendeStyrke());


    for (Legemiddel elem: middelListe){
      System.out.println(elem.toString());
    }
  }

  public static void testAlle(Legemiddel preparat) {
    System.out.println("IDnr: " + preparat.hentId());
    System.out.println("Navn: " + preparat.hentNavn());
    System.out.println("Pris: " + preparat.hentPris());
    System.out.println("virkestoff mengde:" + preparat.hentVirkestoffMngd());
    System.out.println("........");
    //System.out.println(preparat.settNyPris());
  }

}
