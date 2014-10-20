/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sphinxjava;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author felipe
 */
public class SphinxJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration();

// Set path to acoustic model.
        configuration.setAcousticModelPath("resource:/WSJ_8gau_13dCep_16k_40mel_130Hz_6800Hz");
// Set path to dictionary.
        configuration.setDictionaryPath("resource:/WSJ_8gau_13dCep_16k_40mel_130Hz_6800Hz/dict/cmudict.0.6d");
// Set language model.
        configuration.setLanguageModelPath("models/language/en-us.lm.dmp");

        LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
// Start recognition process pruning previously cached data.
        recognizer.startRecognition(true);
        SpeechResult result;
        while ((result = recognizer.getResult()) != null) {
            System.out.println(result.getHypothesis());
        }
// Pause recognition process. It can be resumed then with startRecognition(false).
//        recognizer.stopRecognition();

    }

}
