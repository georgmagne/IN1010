public class SortRute extends Rute{

  public SortRute(Labyrint lab, int rad, int kolonne){
    super(lab, rad, kolonne);
    super.status = '#';
  }

  public char tilTegn(){
    return super.status;
  }
}
