public class Parkeringshus {
  private Parkeringsplass[] etasje1;
  private Parkeringsplass[] etasje2;

  public Parkeringshus () {
    this.etasje1 = new Parkeringsplass[10];
    this.etasje2 = new Parkeringsplass[10];
  }

  public static void main(String[] args) {
    Bil bil1 = new Bil(1233, 5);
    Bil bil2 = new Bil(1111, 33);
    Bil bil3 = new bil (1337, 420);

    Motorsykkel motor1 = new Motorsykkel(1211, 1000);
    Motorsykkel motor2 = new Motorsykkel(2323, 5000);
    Motorsykkel motor2 = new Motorsykkel(1112, 1233);

    for (int i = 0; i < etasje1.length; i++) {
      etaje1[i] = new Parkeringsplass();
    }
  }
}
