/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.sphinxjava;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
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
//        configuration.setAcousticModelPath("resource:/WSJ_8gau_13dCep_16k_40mel_130Hz_6800Hz");
        configuration.setAcousticModelPath("voxforge-es-0.1.1/model_parameters/voxforge_es_sphinx.cd_cont_1500");
// Set path to dictionary.
//        configuration.setDictionaryPath("resource:/WSJ_8gau_13dCep_16k_40mel_130Hz_6800Hz/dict/cmudict.0.6d");
//        configuration.setDictionaryPath("voxforge-es-0.1.1/etc/voxforge_es_sphinx.dic");
//        configuration.setDictionaryPath("voxforge-es-0.1.1/etc/voxforge_es_sphinx_MX.dic");
//        configuration.setDictionaryPath("modeloMedicinaEspañol/medicina.dic");
        configuration.setDictionaryPath("medic.dic");
//        configuration.setDictionaryPath("temp.dic");
//        configuration.setDictionaryPath("voxforge-es-0.1.1/etc/med.dic");
// Set language model.
//        configuration.setLanguageModelPath("models/language/en-us.lm.dmp");
//        configuration.setLanguageModelPath("voxforge-es-0.1.1/etc/voxforge_es_sphinx.transcription.test.lm");
//        configuration.setLanguageModelPath("modeloMedicinaEspañol/medicina.lm");
        configuration.setLanguageModelPath("medic.lm");
//        configuration.setLanguageModelPath("voxforge-es-0.1.1/etc/med.lm");
        
        System.out.println("esta agregando la config al recognizer");
        LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
// Start recognition process pruning previously cached data.
//        recognizer.startRecognition(true);
//        SpeechResult result = recognizer.getResult();
//        System.out.println(result.getHypothesis());
//        int i = 0;
//        while ((result = recognizer.getResult()) != null) {
//            i++;
//            System.out.println("resultado " + i);
//            System.out.println(result.getHypothesis());
//        }
        recognizer.startRecognition(true);
        System.out.println("config agregada, diga algo en español");
        while (true) {
            long time_start, time_end;
            time_start = System.currentTimeMillis();
            String utterance = recognizer.getResult().getHypothesis();
            time_end = System.currentTimeMillis();
            System.out.println("the task has taken " + (time_end - time_start) + " milliseconds");
            if (utterance.equals("personas")) {
                break;
            } else {
                System.out.println(utterance);
            }
        }
        recognizer.stopRecognition();
        System.out.println("Reconocedor detenido");
// Pause recognition process. It can be resumed then with startRecognition(false).
//        recognizer.stopRecognition();

    }

}
