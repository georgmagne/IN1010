public class StringKonv {
    /**
   * Konverterer losning-String fra oblig 5 til en boolean[][]-representasjon
   * av losningstien.
   * @param losningString String-representasjon av utveien
   * @param bredde        bredde til labyrinten
   * @param hoyde         hoyde til labyrinten
   * @return              2D-representasjon av rutene der true indikerer at
   *                      ruten er en del av utveien.
   */

  public static void main(String[] args) {
    String losning = "(1,1) --> (2,1) --> (2,0) --> Ute!";
    boolean[][] troll = losningStringTilTabell(losning, 5, 5);

    // System.out.println(troll);
    for (boolean[] liste: troll){
      System.out.println();
      for (boolean elem: liste){
        if(elem){
          System.out.print("T");
        } else {
          System.out.print(".");
        }
        // System.out.print(" " + elem);
      }
    }

  }

  // Endre litt på prekoden for å passe (rad, kolonne) format, da det var dette jeg bruke på oblig 5.
  static boolean[][] losningStringTilTabell(String losningString, int bredde, int hoyde) {
      boolean[][] losning = new boolean[hoyde][bredde];
      java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\(([0-9]+),([0-9]+)\\)");
      java.util.regex.Matcher m = p.matcher(losningString.replaceAll("\\s",""));
      while (m.find()) {
          int x = Integer.parseInt(m.group(1));
          int y = Integer.parseInt(m.group(2));
          losning[x][y] = true; // Endret kun denne linjen.. byttet fra [y][x] til [x][y].
      }
      return losning;
  }

}
