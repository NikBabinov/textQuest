package ru.mail.nikbabinov.main_quest.constants;

public enum SpeechHeroVasiliy {
    INDEX_HTML_SPEECH_1("Да Петька...пора транспорт искать а то к Анке не успеем....тьфу..."),
    QUESTION_HTML_SPEECH_1("Ну что Петька, жми на кузню или пойдем дальше...за конем"),
    QUESTION_HTML_SPEECH_2("Петька, мне кажется что в кузнице что то осталось"),
    QUESTION_HTML_SPEECH_3("Петька, давай быстрей за конем!"),
    LAST_PAGE_HTML_SPEECH_1("А вот и Анка! Молодец Петр! Орден дам!"),
    FIELD_PAGE_HTML_SPEECH_1("Петька запрягай коня!"),
    FIELD_PAGE_HTML_NO_HORSE("Нет Петр, сначало снаряжение для коня надо найти"),
    FIELD_PAGE_HTML_NO_HORSE_TAKE_POINTER("Петр, ну куда там без коня"),
    FIELD_PAGE_HTML_SUCESS_TAKE_HORSE("Отлично! Поскакали быстрее к Анке");


    private final String speech;

    SpeechHeroVasiliy(String speech) {
        this.speech = speech;
    }

    public String getSpeech() {
        return speech;
    }
}
