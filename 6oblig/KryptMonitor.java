import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;


public class KryptMonitor {
  LinkedList<Melding> meldinger;
  int antMeldinger = 0;
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
      antMeldinger++;
      ikkeTomt.signalAll();
    } finally {
      laas.unlock();
    }
  }


  public Melding taUtMelding(){
    laas.lock();
    try {
      while (antMeldinger == 0){
        if(ferdigMedLytting){
          break;
        }
        ikkeTomt.await();
      }
      System.out.println("jeg er her");
      antMeldinger--;
      Melding skalDekryptes = meldinger.removeFirst();
      return skalDekryptes;

    } catch (InterruptedException e) {
      System.out.println("neo feil skjedde");
    } finally {
      laas.unlock();
    }
    return null; // Tomt for meldinger.
  }

  public LinkedList<Melding> hentMeldinger(){
    return this.meldinger;
  }

}
