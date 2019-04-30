import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.NoSuchElementException;



public class KryptMonitor {
  LinkedList<Melding> meldinger;
  public boolean ferdigMedLytting = false;

  Lock laas = new ReentrantLock();
  Condition ikkeTomt = laas.newCondition();

  public KryptMonitor(){
    meldinger = new LinkedList<>();
  }

  public void leggTilMelding(Melding melding){
    laas.lock();
    try {
      meldinger.add(melding);
      ikkeTomt.signalAll();
    } finally {
      laas.unlock();
    }
  }


  public Melding taUtMelding(){
    laas.lock();
    try {
      while (meldinger.size() == 0){
        if(ferdigMedLytting){
          return null;
        }
        ikkeTomt.await();
      }
      try {
        Melding skalDekryptes = meldinger.removeFirst();
        return skalDekryptes;
      } catch (NoSuchElementException e){
        System.out.println("Feil i kryptMonitor");
      }

    } catch (InterruptedException e) {
    } finally {
      laas.unlock();
    }
    return null; // Tomt for meldinger.
  }

  public LinkedList<Melding> hentMeldinger(){
    return this.meldinger;
  }

}
