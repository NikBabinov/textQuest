package ru.mail.nikbabinov.main_quest.constants;

public enum SpeechHeroAnka {
    LAST_PAGE_HTML_SPEECH_1("Петр давй уже домой, а  то Василий устал...Жми на коня и поскакали...");

    private final String speech;

    SpeechHeroAnka(String speech) {
        this.speech = speech;
    }

    public String getSpeech() {
        return speech;
    }
}
