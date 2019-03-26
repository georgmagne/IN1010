public class HvitResept extends Resept {

    public HvitResept(Legemiddel middel, Lege lege, Pasient pasient, int reit) {
      super(middel, lege, pasient, reit);
    }

    @Override
    public String farge(){
      return "Hvit";
    }

    @Override
    public String toString(){
      return "\nFarge: " + farge() + "\n" + super.toString() + "\nPris: " + super.middel.hentPris();
    }

    @Override
    public double prisAaBetale(){
      return super.middel.hentPris();
    }

    public double hentPris(){
      return super.middel.hentPris();
    }
}
