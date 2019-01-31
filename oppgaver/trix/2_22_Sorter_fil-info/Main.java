import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Main {
  public static void main(String[] args) {
    
    File f = new File("navn.txt");

    Scanner filleser = null;

    try{
      filleser = new Scanner(f);
    } catch (FileNotFoundException e) {
      System.out.println("Fant ikke fil");
    }

    ArrayList<Hund> hunder = new ArrayList<>();
    ArrayList<Person> personer = new ArrayList<>();

    String linje = "";
    while (filleser.hasNextLine()) {
      linje = filleser.nextLine();

      String[] delt = linje.split(" ");

      if (delt[0].equals("P")){
        String navn = "";
        for (int i = 1; i < delt.length; i++){
          navn += delt[i] + " ";
        }
        Person p = new Person(navn);
        personer.add(p);

      } else if (delt[0].equals("H")) {
        Hund h = new Hund(delt[1]);
        hunder.add(h);
      } else {
        System.out.println("Feil format");
      }
    }
    System.out.println("Personer: ");
    for (Person p : personer) {
      System.out.println(p.getNavn());
    }
    System.out.println("Hunder: ");
    for (Hund h : hunder) {
      System.out.println(h.getNavn());
    }
  }
}

//   ArrayList<Hund> hunder = new ArrayList<>();
//   ArrayList<Person> personer = new ArrayList<>();
//
//   private String linje = "";
//
//     Scanner fil = new Scanner(new File("navn.txt"));
//
//     while (fil.hasNextLine()) {
//       linje = fil.nextLine();
//
//       String[] deltLinje = linje.split(" "); // Deler linje opp ved mellomrom, legger nye stringene inn i array.
//
//       if (deltLinje[0].equals("P")) {
//
//         //EVT dobbeltnavn
//         String navn = "";
//         for (int i = 1; i < deltLinje.length; i++) {
//           navn += deltLinje[i];
//         }
//         Person p = new Person(navn);
//         personer.add(p);
//       } else if (deltLinje[0].equals("H")){
//         Hund h = new Hund(deltLinje[1]);
//         hunder.add(h);
//       }
//     }
//
//     System.out.println("Personer: ");
//     for (Person pers : personer){
//       System.out.println(pers.getNavn());
//     }
//
//     System.out.println("Hunder: ");
//     for (Hund hund : hunder){
//       System.out.println(hund.getNavn());
//     }
//   }
// }
