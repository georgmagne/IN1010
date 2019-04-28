import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.NoSuchElementException;

public class DekryptMonitor {
  LinkedList<Melding> meldinger;
  int antMeldinger = 0;
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
      antMeldinger++;
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
          break;
        }
        System.out.println("her er jeg");
        ikkeTomt.await();
      }

      antMeldinger--;
      try{
        Melding taUt = meldinger.removeFirst();
        return taUt;

      } catch (NoSuchElementException e1){
        System.out.println("nooo");
      }
      // System.out.println("Tar ut: " + i);
      // i++;

    } catch (InterruptedException e){

    // } catch (NoSuchElementException e1){
    //   System.out.println("Ferdig!");
    } finally {
      laas.unlock();
    }

    return null; // Tomt for meldinger.
  }

  public LinkedList<Melding> hentMeldinger(){
    return this.meldinger;
  }

}
