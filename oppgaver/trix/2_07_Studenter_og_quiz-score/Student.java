public class Student {
  public String navn;
  public int score;
  public int deltakelser;

  public Student(String giNavn){
    navn = giNavn; // Gir objektet navn fra parameter.
    score = 0;
    deltakelser = 0;
  }

  public String getName(){
    return navn;
  }

  public void leggTilQuizScore(int giScore){
    score += giScore;
    deltakelser += 1;
  }

  public int hentTotalScore(){
    return score;

  }

  public double hentGjennomsnittligScore(){
    return score/deltakelser;
  }
}
