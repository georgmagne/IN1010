public class Prevensjon{

  public Prevensjon(Legemiddel middel, Lege lege, int pasient){
    super(middel, lege, pasient);
    super.reit = 3;
    
    if (super.pris >= 108){
      super.pris -= 108;
    } else{
      super.pris = 0;
    }
  }
}
