package codeamatic.support;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Implementation for persisting {@link Move}'s in a text
 * based file system.
 */
public class FileStorage implements MoveRepository {

  private final static String FILENAME = "chess.txt";

  @Override
  public void saveMove(Move move) {
    writeToFile(move.getLocation());
  }

  @Override
  public List<Move> getMoves() {
    return null;
  }


  private void writeToFile(String location) {
    try {
      File file = new File(FILENAME);

      if(! file.exists()) {
        file.createNewFile();
      }

      FileWriter fw = new FileWriter(file, true);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter(bw);

      // Append to file
      pw.println(location);

      pw.close();
      fw.close();
    } catch(IOException ex) {
      //...
    }

  }
}
