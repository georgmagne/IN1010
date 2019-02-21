public class TestResepter{

  public static void main(String[] args) {
    PreparatA prepA = new PreparatA("Black Tar Heroin", 300, 5, 10);
    PreparatB prepB = new PreparatB("Valium", 150, 3, 4);
    PreparatC prepC = new PreparatC("Paracet", 40, 2);

    Lege lege = new Lege();

    Resept hvit1 = new HvitResept(prepA, lege, 123, 1);
    Resept prev1 = new Prevensjon(prepB, lege, 1337, 1212);
    Resept prev2 = new Prevensjon(prepB, lege, 111);
    Resept prev3 = new Prevensjon(prepC, lege, 111);
    Resept millit1 = new MillitResept(prepB, lege, 333, 10);

    Resept[] reseptListe;
    reseptListe = new Resept[]{hvit1, prev1, prev2, prev3, millit1};

    for (Resept elem: reseptListe){
      System.out.println(elem);
      System.out.println();
    }
  }
}
