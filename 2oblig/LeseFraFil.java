import java.io.*;
import java.util.*;
// import java.util.ArrayList;


public class LeseFraFil{
  protected ArrayList<String> linjer = new ArrayList<String>();
  protected ArrayList<String> legemidler = new ArrayList<String>();
  protected ArrayList<String> leger = new ArrayList<String>();
  protected ArrayList<String> resepter = new ArrayList<String>();

  public LeseFraFil (String filnavn) {
    File filen = new File(filnavn);
    Scanner fil = null;
    try {
      fil = new Scanner(filen);
    } catch (FileNotFoundException e) {
      System.out.println("Finner ikke filen: " + filnavn);
    }


    while (fil.hasNextLine()) {
      linjer.add(fil.nextLine());

    }

    for (int i = 0; i < linjer.size(); i++){
      if (linjer.get(i).indexOf("#") != -1){
        String infoLinje = linjer.get(i);
        System.out.println(infoLinje);
        String[] infoBiter = infoLinje.split(" ");
        // System.out.println(infoBiter[1]);
        String navn = infoBiter[1].toLowerCase();
        System.out.println(navn);

        if (navn.equals("legemidler")){
          System.out.println("fant legemidlene");
          legemidler.add(linjer.get(i+1)); // Hardkodet!
          legemidler.add(linjer.get(i+2));
          legemidler.add(linjer.get(i+3));
          legemidler.add(linjer.get(i+4));
        }

        if (navn.equals("leger")){
          System.out.println("fant legene");
          leger.add(linjer.get(i+1)); // Hardkodet!
          leger.add(linjer.get(i+2));
          leger.add(linjer.get(i+3));
          leger.add(linjer.get(i+4));
        }

        if (navn.equals("resepter")){
          System.out.println("fant reseptene");
          resepter.add(linjer.get(i+1)); // Hardkodet!
          resepter.add(linjer.get(i+2));
          resepter.add(linjer.get(i+3));
          resepter.add(linjer.get(i+4));
        }
      }
    }
  }
}
