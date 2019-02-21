public class Islandshest extends Hest implements KanToelte, KanPasse {

  public Islandshest(String n, int a){
    super(n, a);
  }

  public void toelt(){
    System.out.println(navn + "toeffer avgaarde med hevede bein.");
  }

  public void pass(){
    System.out.println(navn + " ser ut til aa sveve bortover bakken.");
  }
}
