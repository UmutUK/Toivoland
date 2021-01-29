package com.toivoland.dictionary.data.collection;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LoadInsertSearchDictionaryData {

    private static final LoadInsertSearchDictionaryData instance = new LoadInsertSearchDictionaryData();
    private static final String ENGLISH_DICTIONARY_FILE_PATH = "./resources/EnglishDictionary.txt";
    private static final String GERMAN_DICTIONARY_FILE_PATH = "./resources/DeutchDictionary.txt";
    private static final String RUSSIAN_DICTIONARY_FILE_PATH = "./resources/RussianDictionary.txt";



    private Map<String, DictionaryData> turkishWordSearchMap = new HashMap<String, DictionaryData>();
    private Map<String, DictionaryData> englishWordSearchMap = new HashMap<String, DictionaryData>();
    private Map<String, DictionaryData> germanWordSearchMap = new HashMap<String, DictionaryData>();
    private Map<String, DictionaryData> russianWordSearchMap = new HashMap<String, DictionaryData>();

    private LoadInsertSearchDictionaryData() { }

    protected static LoadInsertSearchDictionaryData getInstance(){
        return  instance;
    }

    protected void loadDictionary(){
        loadEnglishDictionary();
        loadGermanDictionary();
        loadRussianDictionary();
    }

    protected void insertAllDataToDictionary(){
        insertEnglishDictionary();
        insertGermanDictionary();
        insertRussianDictionary();
    }

    private void loadEnglishDictionary(){
        try {
            FileReader fileReader = new FileReader(ENGLISH_DICTIONARY_FILE_PATH);
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            String [] splitter ;
            while ((line = reader.readLine()) != null) {
                splitter = line.split("\\|");
                englishWordSearchMap.put(splitter[0].trim(), new DictionaryData(splitter[0], splitter[1], splitter[2], splitter[3]));
                turkishWordSearchMap.put(splitter[2].trim() + LanguageFlags.ENGLISH_FLAG, new DictionaryData(splitter[0], splitter[1], splitter[2], splitter[3]));
            }

            reader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadGermanDictionary(){
        try {
            FileReader fileReader = new FileReader(GERMAN_DICTIONARY_FILE_PATH);
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            String [] splitter ;
            while ((line = reader.readLine()) != null) {
                splitter = line.split("\\|");
                germanWordSearchMap.put(splitter[0].trim(), new DictionaryData(splitter[0], splitter[1], splitter[2], splitter[3]));
                turkishWordSearchMap.put(splitter[2].trim() + LanguageFlags.GERMAN_FLAG, new DictionaryData(splitter[0], splitter[1], splitter[2], splitter[3]));
            }

            reader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadRussianDictionary(){
        try {
            FileReader fileReader = new FileReader(RUSSIAN_DICTIONARY_FILE_PATH);
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            String [] splitter ;
            while ((line = reader.readLine()) != null) {
                splitter = line.split("\\|");
                russianWordSearchMap.put(splitter[0].trim(), new DictionaryData(splitter[0], splitter[1], splitter[2], splitter[3]));
                turkishWordSearchMap.put(splitter[2].trim() + LanguageFlags.RUSSIAN_FLAG, new DictionaryData(splitter[0], splitter[1], splitter[2], splitter[3]));
            }

            reader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertEnglishDictionary(){
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(ENGLISH_DICTIONARY_FILE_PATH);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (Map.Entry<String,DictionaryData> entry: englishWordSearchMap.entrySet()) {
                bufferedWriter.write(entry.getValue().getForeignLanguageMeaning() + "|" + entry.getValue().getForeignLanguageExampleSentence()
                + "|" + entry.getValue().getTurkishMeaning() + "|" + entry.getValue().getTurkishExampleSentence());
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();

                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException ex) {
                System.err.format("IOException: %s%n", ex);
            }
        }
    }

    private void insertGermanDictionary(){
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(GERMAN_DICTIONARY_FILE_PATH);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (Map.Entry<String,DictionaryData> entry: germanWordSearchMap.entrySet()) {
                bufferedWriter.write(entry.getValue().getForeignLanguageMeaning() + "|" + entry.getValue().getForeignLanguageExampleSentence()
                        + "|" + entry.getValue().getTurkishMeaning() + "|" + entry.getValue().getTurkishExampleSentence());
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();

                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException ex) {
                System.err.format("IOException: %s%n", ex);
            }
        }
    }

    private void insertRussianDictionary(){
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(RUSSIAN_DICTIONARY_FILE_PATH);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (Map.Entry<String,DictionaryData> entry: russianWordSearchMap.entrySet()) {
                bufferedWriter.write(entry.getValue().getForeignLanguageMeaning() + "|" + entry.getValue().getForeignLanguageExampleSentence()
                        + "|" + entry.getValue().getTurkishMeaning() + "|" + entry.getValue().getTurkishExampleSentence());
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();

                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException ex) {
                System.err.format("IOException: %s%n", ex);
            }
        }
    }

    public void setEnglishWordSearchMap(String englishMeaning, String englishExampleSentence,
                                        String turkishMeaning, String turkishExampleSentence) {
        englishWordSearchMap.put(englishMeaning, new DictionaryData(englishMeaning, englishExampleSentence, turkishMeaning, turkishExampleSentence));
    }

    public void setGermanWordSearchMap(String germanMeaning, String germanExampleSentence,
                                       String turkishMeaning, String turkishExampleSentence) {
        germanWordSearchMap.put(germanMeaning, new DictionaryData(germanMeaning,germanExampleSentence, turkishMeaning, turkishExampleSentence));
    }

    public void setRussianWordSearchMap(String russianMeaning, String russianExampleSentence,
                                        String turkishMeaning, String turkishExampleSentence) {
        russianWordSearchMap.put(russianMeaning, new DictionaryData(russianMeaning, russianExampleSentence, turkishMeaning, turkishExampleSentence));
    }

    public void setTurkishWordSearchMap(String foreignLanguageFlag, String foreignLanguageMeaning, String foreignLanguageMeaningExampleSentence,
                                        String turkishMeaning, String turkishExampleSentence) {
        turkishWordSearchMap.put(turkishMeaning + foreignLanguageFlag, new DictionaryData(foreignLanguageMeaning, foreignLanguageMeaningExampleSentence, turkishMeaning, turkishExampleSentence));
    }

    public Map<String, DictionaryData> getEnglishWordSearchMap() {
        return englishWordSearchMap;
    }

    public Map<String, DictionaryData> getGermanWordSearchMap() {
        return germanWordSearchMap;
    }

    public Map<String, DictionaryData> getRussianWordSearchMap() {
        return russianWordSearchMap;
    }

    protected Map<String, DictionaryData> getTurkishWordSearchMap() {
        return turkishWordSearchMap;
    }
}
