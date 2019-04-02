public class HvitRute extends Rute{

  public HvitRute(Labyrint lab, int rad, int kolonne){
    super(lab, rad, kolonne);
    super.status = '.';
  }

  public char tilTegn(){
    return super.status;
  }
}
