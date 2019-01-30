public class Node{
  public int minne;
  public int antPros;

  public Node(int giMinne, int giAntPros){ //Kontruktør
    minne = giMinne; // Instansvariabler
    antPros = giAntPros;
  }

  public int getPros(){ // Returnerer Instansvariablen antPros
    return antPros;
  }

  public boolean nokMinne(int paakrevdMinne){
    return (minne >= paakrevdMinne);
  }
}
