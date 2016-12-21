package codeamatic;

/**
 * Interface for interacting with a UCI Engine
 */
public interface Client {

  /**
   *  Retrieve the best calculated move from the UCI engine after
   *  processing the challenger's move.
   *
   *  <p>
   *  The move argument is required to be in long algebraic notation.
   *  </p>
   *
   * @param move String algebraic (long) notation of the challenger's chess move.
   * @return String the best move calculated by the UCI engine.
   */
  String getBestMove(String move);

}
