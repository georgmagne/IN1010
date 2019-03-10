public Parkeringsplass <E> {
  private E kjoeretoey;

  public void parker(E kjoeretoey) {
    this.kjoeretoey = kjoeretoey;
  }

  public E hent() {
    E tmp = this.kjoeretoey;

    this.kjoeretoey = null; // Fjerner kjoeretoeyet fra Parkeringsplassen.

    return tmp; // Henter ut kjoeretoeyet som ble tatt ut.
  }
}
