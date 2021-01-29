package com.toivoland.dictionary.data.collection;

import java.util.ArrayList;
import java.util.List;

public class DataCollectionAccessor {

    private static final DataCollectionAccessor instance = new DataCollectionAccessor();

    private DataCollectionAccessor(){}

    public static DataCollectionAccessor getInstance(){
        return  instance;
    }

    public void load(){
        LoadInsertSearchDictionaryData.getInstance().loadDictionary();
    }

    public void insert(){
        LoadInsertSearchDictionaryData.getInstance().insertAllDataToDictionary();
    }

    public String getSearchResult(String searchAreaLanguageText, String findingAreaLanguageText, String searchWord){

        //return list contains word, and example sentences.The order of the data; meaning, searchLanguageExample, findLanguageExample
        StringBuilder stringBuilder = new StringBuilder();

        if(searchAreaLanguageText.equals(LanguageFlags.TURKISH)) {
            if(findingAreaLanguageText.equals(LanguageFlags.ENGLISH)) {
                if(LoadInsertSearchDictionaryData.getInstance().getTurkishWordSearchMap().containsKey(searchWord + LanguageFlags.ENGLISH_FLAG)){
                    stringBuilder.append(LoadInsertSearchDictionaryData.getInstance().getTurkishWordSearchMap().get(searchWord + LanguageFlags.ENGLISH_FLAG).getForeignLanguageMeaning());
                    stringBuilder.append("\n");
                    stringBuilder.append(LoadInsertSearchDictionaryData.getInstance().getTurkishWordSearchMap().get(searchWord + LanguageFlags.ENGLISH_FLAG).getTurkishExampleSentence());
                    stringBuilder.append("\n");
                    stringBuilder.append(LoadInsertSearchDictionaryData.getInstance().getTurkishWordSearchMap().get(searchWord + LanguageFlags.ENGLISH_FLAG).getForeignLanguageExampleSentence());
                }
            }
            else if (findingAreaLanguageText.equals(LanguageFlags.GERMAN)) {
                if(LoadInsertSearchDictionaryData.getInstance().getTurkishWordSearchMap().containsKey(searchWord + LanguageFlags.GERMAN_FLAG)) {
                    stringBuilder.append(LoadInsertSearchDictionaryData.getInstance().getTurkishWordSearchMap().get(searchWord + LanguageFlags.GERMAN_FLAG).getForeignLanguageMeaning());
                    stringBuilder.append("\n");
                    stringBuilder.append(LoadInsertSearchDictionaryData.getInstance().getTurkishWordSearchMap().get(searchWord + LanguageFlags.GERMAN_FLAG).getTurkishExampleSentence());
                    stringBuilder.append("\n");
                    stringBuilder.append(LoadInsertSearchDictionaryData.getInstance().getTurkishWordSearchMap().get(searchWord + LanguageFlags.GERMAN_FLAG).getForeignLanguageExampleSentence());
                }
            }
            else{
                if(LoadInsertSearchDictionaryData.getInstance().getTurkishWordSearchMap().containsKey(searchWord + LanguageFlags.RUSSIAN_FLAG)) {
                    stringBuilder.append(LoadInsertSearchDictionaryData.getInstance().getTurkishWordSearchMap().get(searchWord + LanguageFlags.RUSSIAN_FLAG).getForeignLanguageMeaning());
                    stringBuilder.append("\n");
                    stringBuilder.append(LoadInsertSearchDictionaryData.getInstance().getTurkishWordSearchMap().get(searchWord + LanguageFlags.RUSSIAN_FLAG).getTurkishExampleSentence());
                    stringBuilder.append("\n");
                    stringBuilder.append(LoadInsertSearchDictionaryData.getInstance().getTurkishWordSearchMap().get(searchWord + LanguageFlags.RUSSIAN_FLAG).getForeignLanguageExampleSentence());
                }
            }
        }else {
            if (searchAreaLanguageText.equals(LanguageFlags.ENGLISH)) {
                if(LoadInsertSearchDictionaryData.getInstance().getEnglishWordSearchMap().containsKey(searchWord)) {
                    stringBuilder.append(LoadInsertSearchDictionaryData.getInstance().getEnglishWordSearchMap().get(searchWord).getTurkishMeaning());
                    stringBuilder.append("\n");
                    stringBuilder.append(LoadInsertSearchDictionaryData.getInstance().getEnglishWordSearchMap().get(searchWord).getForeignLanguageExampleSentence());
                    stringBuilder.append("\n");
                    stringBuilder.append(LoadInsertSearchDictionaryData.getInstance().getEnglishWordSearchMap().get(searchWord).getTurkishExampleSentence());
                }
            }else if (searchAreaLanguageText.equals(LanguageFlags.GERMAN)) {
                if(LoadInsertSearchDictionaryData.getInstance().getGermanWordSearchMap().containsKey(searchWord)) {
                    stringBuilder.append(LoadInsertSearchDictionaryData.getInstance().getGermanWordSearchMap().get(searchWord).getTurkishMeaning());
                    stringBuilder.append("\n");
                    stringBuilder.append(LoadInsertSearchDictionaryData.getInstance().getGermanWordSearchMap().get(searchWord).getForeignLanguageExampleSentence());
                    stringBuilder.append("\n");
                    stringBuilder.append(LoadInsertSearchDictionaryData.getInstance().getGermanWordSearchMap().get(searchWord).getTurkishExampleSentence());
                }
            }else{
                if(LoadInsertSearchDictionaryData.getInstance().getRussianWordSearchMap().containsKey(searchWord)) {
                    stringBuilder.append(LoadInsertSearchDictionaryData.getInstance().getRussianWordSearchMap().get(searchWord).getTurkishMeaning());
                    stringBuilder.append("\n");
                    stringBuilder.append(LoadInsertSearchDictionaryData.getInstance().getRussianWordSearchMap().get(searchWord).getForeignLanguageExampleSentence());
                    stringBuilder.append("\n");
                    stringBuilder.append(LoadInsertSearchDictionaryData.getInstance().getRussianWordSearchMap().get(searchWord).getTurkishExampleSentence());
                }
            }
        }
        return stringBuilder.toString();
    }

    public void addDataDictionary(String firstAdditionAreaLanguageText, String searchAreaLanguageMeaning,String searchAreaLanguageExampleSentence,
                                  String SecondAdditionAreaLanguageText, String findingAreaLanguageMeaning, String findingAreaLanguageExampleSentence){

        if(firstAdditionAreaLanguageText.equals(LanguageFlags.TURKISH)) {
            if(SecondAdditionAreaLanguageText.equals(LanguageFlags.ENGLISH)) {
                LoadInsertSearchDictionaryData.getInstance().setEnglishWordSearchMap(findingAreaLanguageMeaning, findingAreaLanguageExampleSentence,
                        firstAdditionAreaLanguageText, firstAdditionAreaLanguageText);
                LoadInsertSearchDictionaryData.getInstance().setTurkishWordSearchMap(LanguageFlags.ENGLISH_FLAG, findingAreaLanguageMeaning, findingAreaLanguageExampleSentence,
                        firstAdditionAreaLanguageText, firstAdditionAreaLanguageText);
            }
            else if (SecondAdditionAreaLanguageText.equals(LanguageFlags.GERMAN)) {
                LoadInsertSearchDictionaryData.getInstance().setGermanWordSearchMap(findingAreaLanguageMeaning, findingAreaLanguageExampleSentence,
                        firstAdditionAreaLanguageText, firstAdditionAreaLanguageText);
                LoadInsertSearchDictionaryData.getInstance().setTurkishWordSearchMap(LanguageFlags.GERMAN_FLAG, findingAreaLanguageMeaning, findingAreaLanguageExampleSentence,
                        firstAdditionAreaLanguageText, firstAdditionAreaLanguageText);
            }
            else{
                LoadInsertSearchDictionaryData.getInstance().setRussianWordSearchMap(findingAreaLanguageMeaning, findingAreaLanguageExampleSentence,
                        firstAdditionAreaLanguageText, firstAdditionAreaLanguageText);
                LoadInsertSearchDictionaryData.getInstance().setTurkishWordSearchMap(LanguageFlags.RUSSIAN_FLAG, findingAreaLanguageMeaning, findingAreaLanguageExampleSentence,
                        firstAdditionAreaLanguageText, firstAdditionAreaLanguageText);
            }
        }else {
            if(firstAdditionAreaLanguageText.equals(LanguageFlags.ENGLISH)) {
                LoadInsertSearchDictionaryData.getInstance().setEnglishWordSearchMap(searchAreaLanguageMeaning, searchAreaLanguageExampleSentence,
                        findingAreaLanguageMeaning, findingAreaLanguageExampleSentence);
                LoadInsertSearchDictionaryData.getInstance().setTurkishWordSearchMap(LanguageFlags.ENGLISH_FLAG, searchAreaLanguageMeaning, searchAreaLanguageExampleSentence,
                        findingAreaLanguageMeaning, findingAreaLanguageExampleSentence);
            }
            else if (firstAdditionAreaLanguageText.equals(LanguageFlags.GERMAN)) {
                LoadInsertSearchDictionaryData.getInstance().setGermanWordSearchMap(searchAreaLanguageMeaning, searchAreaLanguageExampleSentence,
                        findingAreaLanguageMeaning, findingAreaLanguageExampleSentence);
                LoadInsertSearchDictionaryData.getInstance().setTurkishWordSearchMap(LanguageFlags.GERMAN_FLAG, searchAreaLanguageMeaning, searchAreaLanguageExampleSentence,
                        findingAreaLanguageMeaning, findingAreaLanguageExampleSentence);
            }
            else{
                LoadInsertSearchDictionaryData.getInstance().setRussianWordSearchMap(searchAreaLanguageMeaning, searchAreaLanguageExampleSentence,
                        findingAreaLanguageMeaning, findingAreaLanguageExampleSentence);
                LoadInsertSearchDictionaryData.getInstance().setTurkishWordSearchMap(LanguageFlags.RUSSIAN_FLAG, searchAreaLanguageMeaning, searchAreaLanguageExampleSentence,
                        findingAreaLanguageMeaning, findingAreaLanguageExampleSentence);
            }
        }
    }
}
