public class Scouts {

  /**
   * dont use äöü
   * */
  public static void main(String[] args) {
    String[] words = new String[]{"Weizen",
      "Stein",
      "Wolle",
      "Holz",
      "Catan",
      "Pfadfinder",
      "Baum",
      "Wasser",
      "Grass",
      "Haus",
      "Wachturm",
      "Markt",
      "Fisch",
      "Weizen",
      "Stein",
      "Wolle",
      "Holz",
      "Catan",
      "Pfadfinder",
      "Baum",
      "Wasser",
      "Grass",
      "Haus",
      "Wachturm",
      "Markt",
      "Fisch"};
    int i = 1;
    for (String word:words) {
      System.out.print(word + " + ");
      i = (int) (Math.random()*26);
      System.out.print(i+1);
      char[] chars = word.toUpperCase().toCharArray();
      String out = "";
      for (char c:chars) {
        out += ((char)(((c-64)+(i))%26 + 65));
      }
      System.out.print(" :\n" + out + "\n");
    }
  }
}
