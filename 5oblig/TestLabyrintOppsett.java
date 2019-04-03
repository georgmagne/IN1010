import java.io.File;

public class TestLabyrintOppsett {

  public static void main(String[] args) {
    Labyrint labyrint = null;

    try{
      File fil = new File("labyrinter/1.in");
      labyrint = labyrint.lesFraFil(fil);
    } catch (java.io.FileNotFoundException e) {
      e.getMessage();
    }

    labyrint.skrivUtLab();
  }
}
