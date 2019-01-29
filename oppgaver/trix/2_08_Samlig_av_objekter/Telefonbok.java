import java.util.ArrayList;

public class Telefonbok {

  public static void main(String[] args) {
    Person p0 = new Person("Georg", "93634164", "Helgesens gate 80c");
    Person p1 = new Person("Jennipher", "1234763", "Helgesens gate 80c");
    Person p2 = new Person("Ape", "12345667", "Helgesens gate 69");

/*    Person[] personListe = new Person[10];
    personListe[0] = p0;
    personListe[1] = p1;
    personListe[2] = p2;

    for (Person elem: personListe){
      if (elem != null){
        elem.skrivInfo();
      }
    }
*/

    //
    ArrayList<Person> personer = new ArrayList<Person>();
    personer.add(p0);
    personer.add(p1);
    personer.add(p2);

    for (Person elem: personer) {
      elem.skrivInfo();
    }


  }
}
