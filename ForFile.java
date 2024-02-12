package My_Dictonary_package;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static My_Dictonary_package.dictonary_application.*;

public class ForFile {
    static Pattern patternForAllWords = Pattern.compile("(.+)(\\[.*])(.+)(Войти)");

    static void saveListWords() throws IOException {
        сleanFile();
        for(Word w: listWords){
            saveTextWord(w);
        }
        System.out.println("Файл сохранен");

    }

    static void saveTextWord(Word word) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, true );

        fileWriter.write(word.wordAndTranslate.getKey());
        fileWriter.write(delimetr);
        for(int i=0; i<word.wordAndTranslate.getValue().length; i++){
            fileWriter.write(word.wordAndTranslate.getValue()[i] + delimetrForArray);
            // fileWriter.write(word.wordAndTranslate.getValue()[i]);
        }
        // fileWriter.write(endArray+delimetr_WordAndProgres+word.progressWord+"\n");
        fileWriter.write(endArray+delimetr_WordAndProgres+word.progressWord + "\n");
        fileWriter.close();
    }

    static List<Word> readAllFile() throws FileNotFoundException {
        System.out.println("Файл прочитан");
        listWords.removeAll(listWords);
        Scanner scanner = new Scanner(new File(fileName));
        StringBuilder line = new StringBuilder();
        while (scanner.hasNextLine()){
            line.append(scanner.nextLine());
        }
        Pattern pattern = Pattern.compile("(\\w+)(,,-,,)(.+?)(,,,,---)(\\d+)");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()){
            // System.out.println(matcher.group());
            String key = matcher.group(1);
            String [] value = matcher.group(3).split(",");
            int progress = Integer.parseInt(matcher.group(5));
            Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(key, value);
            Word w = new Word(entry, progress);
            listWords.add(w);

        }

        return listWords;

    }

    static void сleanFile() throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write("");
        fileWriter.close();
        System.out.println("Файл очищен");
    }


    static String getWordFromFile(String word) throws FileNotFoundException {
        Scanner scannerGetWordFromFile = new Scanner(fileAllWordTxt);
        boolean hasWord = false;
        // Pattern pattern1 = Pattern.compile(word);
        while (scannerGetWordFromFile.hasNextLine()){
            String oneline = scannerGetWordFromFile.nextLine();
            Matcher matcherOneLine1 = patternForAllWords.matcher(oneline);
            while (matcherOneLine1.find()){
                if(matcherOneLine1.group(1).strip().equals(word)){
                    System.out.println(matcherOneLine1.group(1).strip() + "-" + matcherOneLine1.group(3).strip());
                    return matcherOneLine1.group(1).strip();
                }

            }

        }
        System.out.println("Нет такого слова");
        return null;

    }

    static void loadAllWordsInList() throws FileNotFoundException {
        Scanner scannerGetWordFromFile = new Scanner(fileAllWordTxt);
        while (scannerGetWordFromFile.hasNextLine()){
            String oneline = scannerGetWordFromFile.nextLine();
           // System.out.println(oneline);
            Matcher matcherOneLine = patternForAllWords.matcher(oneline);
            while (matcherOneLine.find()){

                // System.out.println(matcherOneLine.group());
                hashMapAllWordsFromFile.put(matcherOneLine.group(1).strip(), matcherOneLine.group(3).strip().split(", "));

            }


    }
        System.out.println("Загрузка всех слов в  hashMapAllWordsFromFile завершена");
        fileLoaded = true;
    }



}

