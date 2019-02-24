public class MillitResept extends HvitResept {

    public MillitResept(Legemiddel middel, Lege lege, int pasient, int reit) {
      super(middel, lege, pasient, reit);
    }

    @Override
    public double prisAaBetale(){
      return 0; //Gratis for millitærpersonell.
    }

    @Override
    public String toString(){
      return "Type: Millitær - " + super.toString() + "\nRabatt: 100%" + // Prøvde super.super.middel.hentPris(), funket ikke, hvorfor?
      "\nÅ betale: " + prisAaBetale();
    }
}
