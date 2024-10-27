package ru.mail.nikbabinov.main_quest.constants;

public enum SpeechHeroPetka {
    INDEX_HTML_SPEECH_1("Василий Иванович, куда ты нас опять завел...");


    private final String speech;

    SpeechHeroPetka(String speech) {
        this.speech = speech;
    }

    public String getSpeech() {
        return speech;
    }
}
