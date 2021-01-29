package com.toivoland.dictionary.data.collection;

public class DictionaryData {

    private String foreignLanguageMeaning;
    private String turkishMeaning;
    private String foreignLanguageExampleSentence;
    private String turkishExampleSentence;

    DictionaryData(String foreignLanguageMeaning, String foreignLanguageExampleSentence, String turkishMeaning, String turkishExampleSentence){

        this.foreignLanguageMeaning = foreignLanguageMeaning;
        this.foreignLanguageExampleSentence = foreignLanguageExampleSentence;
        this.turkishMeaning = turkishMeaning;
        this.turkishExampleSentence = turkishExampleSentence;
    }

    protected String getForeignLanguageMeaning() {
        return foreignLanguageMeaning;
    }

    protected String getForeignLanguageExampleSentence() {
        return foreignLanguageExampleSentence;
    }

    protected String getTurkishMeaning() {
        return turkishMeaning;
    }

    protected String getTurkishExampleSentence() {
        return turkishExampleSentence;
    }

}
