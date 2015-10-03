/**
Copyright 2014-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with the License. A copy of the License is located at

    http://aws.amazon.com/apache2.0/

or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
*/
package lebron;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;

/**
* This sample shows how to create a simple speechlet for handling speechlet requests.
* 
*/
public class LebronSpeechlet implements Speechlet {
private static final Logger log = LoggerFactory.getLogger(LebronSpeechlet.class);

String id = null;
String school = null;
String studentName = null;
String className = null;
String grade = null;

@Override
public void onSessionStarted(final SessionStartedRequest request, final Session session)
        throws SpeechletException {
    log.info("onSessionStarted requestId={}, sessionId={}", request.getRequestId(),
            session.getSessionId());
    // any initialization logic goes here
}

@Override
public SpeechletResponse onLaunch(final LaunchRequest request, final Session session)
        throws SpeechletException {
    log.info("onLaunch requestId={}, sessionId={}", request.getRequestId(),
            session.getSessionId());
    return getWelcomeResponse();
}

@Override
public SpeechletResponse onIntent(final IntentRequest request, final Session session)
        throws SpeechletException {
    log.info("onIntent requestId={}, sessionId={}", request.getRequestId(),
            session.getSessionId());

    Intent intent = request.getIntent();
    String intentName = (intent != null) ? intent.getName() : null;

    if ("HelloWorldIntent".equals(intentName)) {
        return getWelcomeResponse(); }
    else if ("HelpIntent".equals(intentName)) {
        return getHelpResponse();
    } else {
        String response = session.toString();
        if(id == null)
        {
            id = response;
            return onSayID();
        }
        else if(school == null)
        {
            school = response;
            return onSaySchool();
        }
        else if(studentName == null)
        {
            school = response;
            return onSayName();
        }
        else if(className == null)
        {
            school = response;
            return onSayClass();
        }
        else
        {
            grade = response;
            return onSayGrade();
        }
    }
}

@Override
public void onSessionEnded(final SessionEndedRequest request, final Session session)
        throws SpeechletException {
    log.info("onSessionEnded requestId={}, sessionId={}", request.getRequestId(),
            session.getSessionId());
    // any cleanup logic goes here
}


/**
 * Creates and returns a {@code SpeechletResponse} with a welcome message.
 *
 * @return SpeechletResponse spoken and visual response for the given intent
 */
private SpeechletResponse getWelcomeResponse() {
    String speechText = "Hello, what is your student ID? Pleese say the individual digits of the number one at a time.";

    // Create the Simple card content.
    SimpleCard card = new SimpleCard();
    card.setTitle("Lebron");
    card.setContent(speechText);

    // Create the plain text output.
    PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
    speech.setText(speechText);

    // Create reprompt
    Reprompt reprompt = new Reprompt();
    reprompt.setOutputSpeech(speech);

    return SpeechletResponse.newAskResponse(speech, reprompt, card);
}

/**
 * Creates a {@code SpeechletResponse} for the hello intent.
 *
 * @return SpeechletResponse spoken and visual response for the given intent
 */

/**
 * Creates a {@code SpeechletResponse} for the help intent.
 *
 * @return SpeechletResponse spoken and visual response for the given intent
 */
private SpeechletResponse getHelpResponse() {
    String speechText = "You can say hello to me!";

    // Create the Simple card content.
    SimpleCard card = new SimpleCard();
    card.setTitle("Lebron");
    card.setContent(speechText);

    // Create the plain text output.
    PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
    speech.setText(speechText);

    // Create reprompt
    Reprompt reprompt = new Reprompt();
    reprompt.setOutputSpeech(speech);

    return SpeechletResponse.newAskResponse(speech, reprompt, card);
}

private SpeechletResponse onSayID() {
    String speechText = "What school do you go to?";

    // Create the Simple card content.
    SimpleCard card = new SimpleCard();
    card.setTitle("Lebron");
    card.setContent(speechText);

    // Create the plain text output.
    PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
    speech.setText(speechText);

    // Create reprompt
    Reprompt reprompt = new Reprompt();
    reprompt.setOutputSpeech(speech);

    return SpeechletResponse.newAskResponse(speech, reprompt, card);
}

private SpeechletResponse onSaySchool() {
    String speechText = "What is your name?";

    // Create the Simple card content.
    SimpleCard card = new SimpleCard();
    card.setTitle("Lebron");
    card.setContent(speechText);

    // Create the plain text output.
    PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
    speech.setText(speechText);

    // Create reprompt
    Reprompt reprompt = new Reprompt();
    reprompt.setOutputSpeech(speech);

    return SpeechletResponse.newAskResponse(speech, reprompt, card);
}

private SpeechletResponse onSayName() {
    String speechText = "What class are you talking about?";

    // Create the Simple card content.
    SimpleCard card = new SimpleCard();
    card.setTitle("Lebron");
    card.setContent(speechText);

    // Create the plain text output.
    PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
    speech.setText(speechText);

    // Create reprompt
    Reprompt reprompt = new Reprompt();
    reprompt.setOutputSpeech(speech);

    return SpeechletResponse.newAskResponse(speech, reprompt, card);
}

private SpeechletResponse onSayClass() {
    String speechText = "What grade did you get?;

    // Create the Simple card content.
    SimpleCard card = new SimpleCard();
    card.setTitle("Lebron");
    card.setContent(speechText);

    // Create the plain text output.
    PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
    speech.setText(speechText);

    // Create reprompt
    Reprompt reprompt = new Reprompt();
    reprompt.setOutputSpeech(speech);

    return SpeechletResponse.newAskResponse(speech, reprompt, card);
}

private SpeechletResponse onSayGrade() {
    String speechText = "Thank you.";

    // Create the Simple card content.
    SimpleCard card = new SimpleCard();
    card.setTitle("Lebron");
    card.setContent(speechText);

    // Create the plain text output.
    PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
    speech.setText(speechText);

    // Create reprompt
    Reprompt reprompt = new Reprompt();
    reprompt.setOutputSpeech(speech);

    return SpeechletResponse.newAskResponse(speech, reprompt, card);
    
    //submit grade
}
}
