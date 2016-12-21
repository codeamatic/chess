package codeamatic.support;

import java.util.List;

/**
 * Interface for persisting {@link Move}'s.
 */
public interface MoveRepository {

  void saveMove(Move move);

  List<Move> getMoves();
}
