public class Main{
  public static void main(String[] args) {
    Student joakim = new Student("Joakim");
    Student kristin = new Student("kristin");
    Student dag = new Student("Dag");

    joakim.leggTilQuizScore(10);
    joakim.leggTilQuizScore(10);
    kristin.leggTilQuizScore(10);
    dag.leggTilQuizScore(10);
    dag.leggTilQuizScore(11);
    kristin.leggTilQuizScore(10);
    joakim.leggTilQuizScore(10);
    joakim.leggTilQuizScore(10);

    System.out.println("Joakim sin totale score: " + joakim.hentTotalScore() + "\nGjennomsnittligscore: " + joakim.hentGjennomsnittligScore() + "\n\n");
    System.out.println("Dag sin totale score: " + dag.hentTotalScore() + "\nGjennomsnittligscore: " + dag.hentGjennomsnittligScore() + "\n\n");
    System.out.println("Kristin sin totale score: " + kristin.hentTotalScore() + "\nGjennomsnittligscore: " + kristin.hentGjennomsnittligScore() + "\n\n");
  }
}
