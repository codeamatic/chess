package codeamatic;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

import codeamatic.support.FileStorage;
import codeamatic.support.Move;
import codeamatic.support.MoveRepository;

/**
 * Controller that handles all API requests for ChessController functionality.
 */
@RestController
public class ChessController {

  private Client uciClient;

  private MoveRepository moveRepository;

  @Autowired
  public ChessController(Client uciClient, MoveRepository moveRepository) {
    this.uciClient = uciClient;
    this.moveRepository = moveRepository;
  }

  @RequestMapping(path = "/", method = RequestMethod.POST)
  public SpeechletResponse changeChessState(@RequestBody SpeechletRequestEnvelope requestEnvelope) {

    IntentRequest intentRequest = (IntentRequest) requestEnvelope.getRequest();

    String speechText = manageIntent(intentRequest.getIntent());

    // Create the plain text output.
    PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
    speech.setText(speechText);

    return SpeechletResponse.newTellResponse(speech);
  }

  /**
   * Manages functionality initialized based on the intent request.
   *
   * @param intent Intent object retrieved from JSON intentRequest
   */
  private String manageIntent(@NotNull Intent intent) {
    if ("GameState".equals(intent.getName())) {
      // ...
      return null;
    } else if ("MovePiece".equals(intent.getName())) {
      String current = intent.getSlot("Current").getValue();
      String target = intent.getSlot("Target").getValue();

      Move move = new Move(String.join("", current, target));

      moveRepository.saveMove(move);
      return uciClient.getBestMove(move.getLocation());
    }
    return null;
  }
}
