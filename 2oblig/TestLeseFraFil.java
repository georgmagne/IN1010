public class TestLeseFraFil {
  public static void main(String[] args) {
    LeseFraFil test = new LeseFraFil("tekst.txt");

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


    System.out.println();
    for (String elem: test.legemidler) {
      System.out.println(elem);
    }

    System.out.println();
    for (String elem: test.leger) {
      System.out.println(elem);
    }

    System.out.println();
    for (String elem: test.resepter) {
      System.out.println(elem);
    }


  }
}
