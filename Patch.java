import java.util.HashMap;

public class Patch {

  HashMap<Character,Plant> patch;
  int size;

  Patch(int size){
    if (size<3||size>24){
      throw new IllegalArgumentException();
    }
    patch = new HashMap<>();
    this.size = size;
  }
  public boolean addPlantAt(Character key, Plant plant){
    if (!patch.containsKey(key)){
      return false;
    }
    if (patch.get(key)!=null){
      return false;
    }
    patch.put(key,plant);
    return true;
  }
}
class Plant{
  protected String name;

  Plant(String name){
    this.name = name;
  }
}