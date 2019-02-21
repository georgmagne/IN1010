public class PasoFino extends Hest implements KanToelte {
  public PasoFino(String n, int a) {
    super(n, a);
  }

  public void toelt() {
    System.out.println(navn + " spurter bortover gresset.");
  }
  
}
