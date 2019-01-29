public class BoolskeVerdier {
  public static void main(String[] args) {
    boolean sann = true;
    boolean usann = false;
    System.out.println(sann);

    if (sann == true) {
      System.out.println("Første test slo til!");
    }
    if (sann == usann) {
      System.out.println("Dette er feil");
    } else {
      System.out.println("Andre test slo ikke til");
    }
  }
}
