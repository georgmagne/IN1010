class Bil{
  private String eier;
  private String merke;

  public Bil(String giEier, String giMerke){
    eier = giEier;
    merke = giMerke;
  }
  public void getInfo(){
    System.out.println("Eier: " + eier + ", Merke: " + merke);
  }
}
