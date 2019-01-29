class Main {
  public static void main(String[] args) {
    Rektangel firkant1 = new Rektangel(5 , 4);
    Rektangel firkant2 = new Rektangel(6, 10);
    System.out.println(firkant1.areal());
    System.out.println(firkant2.areal());
    firkant1.oekLengde(5);
    firkant2.oekBredde(4);
    System.out.println(firkant1.omkrets());
    System.out.println(firkant2.omkrets());
  }

}
