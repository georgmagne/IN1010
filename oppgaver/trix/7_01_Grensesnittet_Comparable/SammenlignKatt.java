import java.util.ArrayList;

public class SammenlignKatt {
        public static void main(String[] args) {

        ArrayList<Katt> katteliste = new ArrayList<>();

        Katt anne = new Katt("Anne", 4);
        Katt liss = new Katt("Liss", 8);
        Katt beate = new Katt("Beate", 3);

        katteliste.add(anne);
        katteliste.add(liss);
        katteliste.add(beate);

        Katt eldst = katteliste.get(0);
        for (Katt k : katteliste) {
            if (k.compareTo(eldst) > 0) {
                eldst = k;
            }
        }

        System.out.println(eldst);
    }
}
