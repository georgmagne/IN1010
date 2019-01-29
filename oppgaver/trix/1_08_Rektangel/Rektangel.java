class Rektangel {

  double lengde, bredde;
  public Rektangel (double a, double b) {  //Konstruktør
    lengde = a;
    bredde = b;
  }

  public void oekLengde (int okning) { //Øker lengden som er angitt
    lengde += okning;
  }

  public void oekBredde (int okning) { // Øker Bredden som er angitt
    bredde += okning;
  }

  public double areal () { //Beregner areal
    double a = lengde * bredde;
    return a;
  }

  public double omkrets () { //Beregner omkrets
    double o = 2*lengde + 2*bredde;
    return o;
  }
}
