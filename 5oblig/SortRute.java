public class SortRute extends Rute{

  public SortRute(Labyrint lab, int rad, int kolonne){
    super(lab, rad, kolonne);
    super.status = '#';
  }

  @Override
  public void gaa(Rute besokt){
    System.out.println("Jeg er en sort rute" + this);
    return;
  }

  public char tilTegn(){
    return super.status;
  }
}
