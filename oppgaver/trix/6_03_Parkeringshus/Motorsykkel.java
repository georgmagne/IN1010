public class Motorsykkel {
  private int regnr, motorStr;

  public Motorsykkel (int regnr, int motorStr) {
    this.regnr = regnr;
    this.motorStr = motorStr;
  }

  public int hentRegnr () {
    return regnr;
  }

  public int hentMotorStr() {
    return motorStr;
  }
}
