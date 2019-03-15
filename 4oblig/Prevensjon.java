public class Prevensjon extends HvitResept{

  public Prevensjon(Legemiddel middel, Lege lege, int pasient){
    super(middel, lege, pasient, 3);
  }

  public Prevensjon(Legemiddel middel, Lege lege, int pasient, int reit){ // Overloading for mulighet til å spesifisere reit etter ønske utover 3.
    super(middel, lege, pasient, reit);
  }


  @Override
  public double prisAaBetale(){
    if (super.middel.hentPris() < 108){
      return 0;
    } else {
      return super.middel.hentPris() - 108;
    }
  }

  @Override
  public String toString(){
    return "Type: Prevensjon - " + super.toString() + "\nRabatt: 108\nÅ Betale: " + prisAaBetale();
  }
}
