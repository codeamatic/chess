package codeamatic;

public class StockfishClient implements Client {

  /**
   * {@inheritDoc}
   */
  @Override
  public String getBestMove(String move) {
    return "B4";
  }
}
