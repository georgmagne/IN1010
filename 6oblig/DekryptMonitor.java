import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.NoSuchElementException;

public class DekryptMonitor {
  LinkedList<Melding> meldinger;
  Lock laas = new ReentrantLock();
  Condition ikkeTomt = laas.newCondition();
  public boolean ferdigMedDekrypt = false;


  public DekryptMonitor(){
    meldinger = new LinkedList<>();
  }

  public void leggTilMelding(Melding melding){
    laas.lock();

    try{
      meldinger.add(melding);
      ikkeTomt.signalAll();

    } finally {
      laas.unlock();
    }
  }

  public Melding taUtMelding(){
    laas.lock();
    try{
      while (meldinger.size() == 0){
        if(ferdigMedDekrypt){
          System.out.println("Går ut");
          break;
        }
        ikkeTomt.await();
      }

      try{
        Melding taUt = meldinger.removeFirst();
        return taUt;

      } catch (NoSuchElementException e1){
        // System.out.println("Feil i dekryptMonitor");
      }

    } catch (InterruptedException e){

    } finally {
      laas.unlock();
    }

    return null; // Tomt for meldinger.
  }

  public LinkedList<Melding> hentMeldinger(){
    return this.meldinger;
  }

}
