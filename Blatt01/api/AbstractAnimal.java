//package de.uulm.in.pm.api;
package Blatt01.api;

/** Abstract class for animals. */
public abstract class AbstractAnimal implements Ingestable, Moveable {

  protected static final int HUNGER_LIMIT = 10;

  protected final int legs;
  private int food;

/**
 * @exception IllegalArgumentException added for 5.1  with a err msg for 5.2
 * */
  protected AbstractAnimal(int food, int legs) {

    if ((legs < 0) || (legs > 1000)) {
      throw new IllegalArgumentException("negative legs or legs > 1000 make no sense");
    }else {
      this.food = food;
      this.legs = legs;
    }
  }

  @Override
  public void eat() {
    this.food = this.food + 1;
  }

  @Override
  public void eat(int food) {
    for (int i = food; i > 0; i--) {
      eat();
    }
  }

  @Override
  public boolean isHungry() {
    return food <= HUNGER_LIMIT;
  }

  @Override
  public boolean isDead() {
    return food <= 0;
  }
/**
 * @exception AnimalIsDeadException is thrown when @isDead returns true
 *            added for 5.3
 * more information -> @link Blatt01.txt(Aufgabe 5)
 * */
  protected void burnFood() throws AnimalIsDeadException {
    this.food = this.food - 1;
      if (isDead()) {
        throw new AnimalIsDeadException();
      }
  }

  protected void burnFood(int food) throws AnimalIsDeadException {
    for (int i = food; i > 0; i--) {
      burnFood();
    }
  }
}
