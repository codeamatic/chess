package codeamatic.support;

/**
 * Model for chess movement.
 */
public class Move {

  /**
   *  Identify a chess piece location on the board
   *  based on Algebraic Notation.
   *
   *  example: e2e4
   */
  private String location;

  public Move(String location) {
    this.location = location;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}
