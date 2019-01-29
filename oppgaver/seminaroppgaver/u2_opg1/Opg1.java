class Opg1 {

  // Fra 0 t.o.m. 9
  /*
  public static void main(String[] args) {
    int[] arr = new int[10];
    for(int i = 0; i < arr.length; i++){
      arr[i] = i;
      //System.out.println(arr[i]);
    }

    int sum = 0;
    for (int i=0; i < 10; i++){
      sum += arr[i];
      System.out.println(arr[i] + " " + sum);
    }
  }
  */

  // Fra 9 t.o.m. 0

  /*
  public static void main(String[] args) {
    int[] tallrekke = new int[10];
    for (int i=9; i >= 0; i--){
      tallrekke[i] = i;
      System.out.println(tallrekke[i]);
    }
  }
  */


  //1c
  public static void main(String[] args) {
    String[] stjerne = new String[10];

    for (int i = 0; i < stjerne.length; i ++){
      stjerne[i] = ""; // Lager en tom streng;
      for (int j= 0; j < i + 1; j++){ // j, holder styr på antall stjerner, i på index.
        stjerne[i] += "*"; // * Blir lagt til for hvert trinn j er mindre enn i.
      }
      System.out.println(stjerne[i]);
    }
  }
}
