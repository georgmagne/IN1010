import java.util.ArrayList;
import java.util.HashMap;


public class TestLeseFraFil {
  public static void main(String[] args) {
    LeseFraFil test = new LeseFraFil("tekst.txt");
    ArrayList<Resept> resepter = new ArrayList<Resept>();
    HashMap<Integer, Legemiddel> midler = new HashMap<Integer, Legemiddel>();
    HashMap<String, Lege> legeSamling = new HashMap<String, Lege>();


    /** Fra fil:
    # Legemidler (navn, type, pris, antall/mengde, virkestoff [, styrke])
    navn = test.legemidler.get(0)
    type = test.legemidler.get(1)
    pris = test.legemidler.get(2)
    antall/mengde = test.legemidler.get(??) ?????
    virkestoff = test.legemidler.get(3)
    styrke = test.legemidler.get(4)

    # Leger (navn, kontrollID / 0 om legen ikke er spesialist)
    # Resepter (type, legemiddelNummer, legeNavn, persID, [reit])
    **/

    // Oppretter Legemiddel objekter.
    for (String elem: test.legemidler) {
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
        midler.put(nyttMiddel.id, nyttMiddel);
      }

      if (type.equals("b")) {
        styrke = Integer.parseInt(biter[4]);
        Legemiddel nyttMiddel = new PreparatB(navn, pris, virkestoff, styrke);
        midler.put(nyttMiddel.id, nyttMiddel);
        // System.out.println("styrke: " + styrke);
      }

      if (type.equals("c")){ // Hvis det ikke er preparatC (Altså A eller B)
        Legemiddel nyttMiddel = new PreparatC(navn, pris, virkestoff);
        midler.put(nyttMiddel.id, nyttMiddel);
      }
      System.out.println();
      // System.out.println(navn +" " + type +" "+ pris +" "+ virkestoff + " " );
      // System.out.println(".......");
    }
    System.out.println(midler.get(1));
    System.out.println(midler.get(2));
    System.out.println(midler.get(3));
    System.out.println(midler.get(4));

    // Oppretter Lege objekter.
    for (String elem: test.leger){
      String[] biter = elem.split(", ");
      String navn  = biter[0];
      int kontrollID = Integer.parseInt(biter[1]);
      // System.out.println(navn + kontrollID);

      if (biter[1].equals("0")){ // Ikke spesialist
        Lege nyLege = new Lege (navn);
        legeSamling.put(navn, nyLege);
      } else { // Spesialist
        Lege nyLege = new Spesialist(navn, kontrollID);
        legeSamling.put(navn, nyLege);
      }
    }

    System.out.println(legeSamling.get("Dr. Cox"));
    System.out.println(legeSamling.get("Dr. House"));

    // Oppretter resept objekter med riktig lege.
    for (String elem: test.resepter) {
      String[] biter = elem.split(", ");
      String type = biter[0];
      int legemiddelNummer = Integer.parseInt(biter[1]);
      String legeNavn = biter[2];
      int persID = Integer.parseInt(biter[3]);
      int reit;

      if (!type.equals("prevensjon")){ // Reit blir angitt.
        reit = Integer.parseInt(biter[4]);
        System.out.println(type+" " + legemiddelNummer +" "+ legeNavn +" " + persID + " "+ reit);

        // try {
        //   Resept nyResept = legeSamling.get(legeNavn).skrivResept(midler.get(legemiddelNummer), persID, reit);
        //   System.out.println("yoyoyoyo");
        //   System.out.println(nyResept);
        //   System.out.println("yoyoyo");
        // } catch (UlovligUtskrift uu) {
        //   System.out.println(uu.getMessage());
        // }

      } else {
        System.out.println(type+" " + legemiddelNummer +" "+ legeNavn +" " + persID);
      }
    }
  }
}
