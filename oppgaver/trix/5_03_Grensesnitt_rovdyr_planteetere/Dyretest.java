class Dyretest{
  public static void main(String[] args) {
    Rovdyr[] rovdyrliste = new Rovdyr[2];
    rovdyrliste[0] = new Bjorn();
    rovdyrliste[1] = new Ulv();

    Planteeter[] planteeterliste = new Planteeter[2];
    planteeterliste[0] = new Elg();
    planteeterliste[1] = new Sau();

    rovdyrliste[0].gaaPaaJakt();
    rovdyrliste[1].gaaPaaJakt();
    planteeterliste[0].beskytt();
    planteeterliste[1].beskytt();
    
  }
}
