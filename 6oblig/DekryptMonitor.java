import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class DekryptMonitor {
  LinkedList<Melding> meldinger;
  int antMeldinger = 0;
  Lock laas = new ReentrantLock();
  Condition ikkeTomt = laas.newCondition();


  public DekryptMonitor(){
    meldinger = new LinkedList<>();
  }

  public void leggTilMelding(Melding melding){
    laas.lock();

    try{
      meldinger.add(melding);
      antMeldinger++;
      ikkeTomt.signalAll();

    } finally {
      laas.unlock();
    }
  }

  public Melding taUtMelding(){
    laas.lock();

    try{
      while (antMeldinger == 0){
        ikkeTomt.await();
      }

      antMeldinger--;
      Melding taUt = meldinger.removeFirst();

    } catch (InterruptedException e){

    } finally {
      laas.unlock();
    }

    return null; // Tomt for meldinger.
  }

}
