public class Person {
  Bil3 enBil;
  public Person (Bil3 giBil) { // Person konstruktør
    enBil = giBil;
  }

  public void skrivPerson() {
    System.out.println( enBil.getNummer() );
  }
}
