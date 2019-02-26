import java.util.Map;

public class IntegrasjonstestFraFil {
  public static void main(String[] args) {
    LeseFraFil lagResepter = new LeseFraFil("tekst.txt");

    System.out.println("\nSkriver ut alle legemidler: ");
    for (Map.Entry<Integer, Legemiddel>  elem: lagResepter.middelSamling.entrySet()){
      System.out.println("ID: " + elem.getKey() + " - " + elem.getValue());
    }

    System.out.println("\nSkriver ut alle Leger: ");
    for (Map.Entry<String, Lege> elem: lagResepter.legeSamling.entrySet()){
      System.out.println(elem.getValue());
    }

    System.out.println("\nSkriver ut alle gyldige resepter: ");
    for (Resept elem: lagResepter.resepterSamling){
      System.out.println("----------");
      System.out.println(elem);
    }
  }
}
