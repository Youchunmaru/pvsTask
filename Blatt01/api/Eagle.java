//package de.uulm.in.pm.api;
package Blatt01.api;

/** Bird that can do stuff. */
public final class Eagle extends AbstractBird implements BirdOfPrey {

  protected static final int HUNTED_FOOD_VALUE = 10;
  protected static final int TAKEOFF_FOOD_COST = 3;
  protected final String name;

  /**
   * @param legs added for 5.2
   * */
  public Eagle(int food, String name, int legs) {
    super(food, 2, legs);
    this.name = name;
  }

  @Override
  public void hunt() {
    takeOff();
    move();
    land();
    eat(HUNTED_FOOD_VALUE);
  }

  /** 5.3
   * @land @takeOff @move
   * @exception AnimalIsDeadException gets caught here
   *            and a err msg is printed
   * more information -> @link Blatt01.txt(Aufgabe 5)
   * */
  @Override
  public void land() {
    try {
      burnFood();
      super.land();
    }catch (AnimalIsDeadException animalIsDeadException){
      System.err.println("Animal is dead");
    }
  }

  @Override
  public void takeOff() {
    try {
      burnFood(TAKEOFF_FOOD_COST);
      super.takeOff();
    }catch (AnimalIsDeadException animalIsDeadException){
      System.err.println("Animal is dead");
    }
  }

  @Override
  public void move() {
    try {
      burnFood();
    }catch (AnimalIsDeadException animalIsDeadException){
      System.err.println("Animal is dead");
    }
  }
  /**
   * @toString returns a string with the name and number of wings of the eagle
   *           added for 3.2
   * more information -> @link Blatt01.txt(Aufgabe 3)
   * */
  @Override
  public String toString(){
    return "[name: "+this.name+" | wings: "+this.wings+"]";
  }
  /**
   * @equals checks if the both eagles are the same
   * @return is true if it is the exact same eagle or if name and number of wings are the same
   * added for 3.3
   * more information -> @link Blatt01.txt(Aufgabe 3)
   * */
  @Override
  public boolean equals(Object o){
    if (o == null) {
      return false;
    }
    if (o == this) {
      return true;
    }
    if (o.getClass()==this.getClass()) {
      Eagle oEagle = (Eagle) o;
      if ((this.name == oEagle.name)&&this.wings==oEagle.wings) {
        return true;
      }
      return false;
    }
    return false;
  }
}
