package ru.mail.nikbabinov.main_quest.constants;

public enum ButtonText {
    INDEX_HTML_START_BUTTON("старт"),
    LAST_HTML_INDEX_BUTTON("домой"),
    FIELD_HTML_BACK_BUTTON("назад");


    private final String textButton;

    ButtonText(String textButton) {
        this.textButton = textButton;
    }

    public String getTextButton() {
        return textButton;
    }
}
