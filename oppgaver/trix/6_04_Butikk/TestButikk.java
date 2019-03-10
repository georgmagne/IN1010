public class TestButikk {
  public static void main(String[] args) {
    Butikk butikken = new Butikk();

    butikken.settInn(new Person("Stig", "Sitron"));
    butikken.settInn(new Person("Hedda", "Enganskopp"));
    butikken.settInn(new Person("Jawad", "Pasta"));
    butikken.settInn(new Person("Henrik", "Kaffe"));
    butikken.settInn(new Person("Mathias", "Tomat"));

    butikken.gaaTilKassen();

  }
}
