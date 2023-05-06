//package de.uulm.in.pm.api;
package Blatt01.api;

/** Abstract class for birds. */
public abstract class AbstractBird extends AbstractAnimal implements Flyable {

  protected final int wings;
  private boolean inTheAir;

  /**
   * Bird with two legs.
   * @param legs added for 5.2
   * 
   * @param food How fed is the bird
   * @param wings How many wings does it have
   */
  protected AbstractBird(int food, int wings, int legs) {
    super(food, legs);
    this.wings = wings;
    this.inTheAir = false;
  }

  @Override
  public boolean isFlying() {
    return inTheAir;
  }

  @Override
  public void land() {
    inTheAir = false;
  }

  @Override
  public void takeOff() {
    inTheAir = true;
  }
}
