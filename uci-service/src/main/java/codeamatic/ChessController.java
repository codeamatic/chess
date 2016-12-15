package codeamatic;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.SpeechletRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.SimpleCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

import codeamatic.uci.client.Client;

/**
 * Controller that handles all API requests for ChessController functionality.
 */
@RestController
public class ChessController {

  private Client uciClient;

  @Autowired
  public ChessController(Client uciClient) {
    this.uciClient = uciClient;
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
    if("GameState".equals(intent.getName())) {
      // ...
      return null;
    } else if("MovePiece".equals(intent.getName())) {
      return uciClient.getBestMove("Test");
    }
    return null;
  }
}
