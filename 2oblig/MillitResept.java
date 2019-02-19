public class MillitResept extends HvitResept {

    public MillitResept(Legemiddel middel, Lege lege, int pasient) {
      super(middel, lege, pasient);
      super.pris = 0;
    }
}
