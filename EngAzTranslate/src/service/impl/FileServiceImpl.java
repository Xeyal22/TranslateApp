package service.impl;

import model.Word;
import service.FileService;

import javax.management.RuntimeErrorException;
import java.io.*;

public class FileServiceImpl implements FileService {
    private static final String WORD_FILE_PATH="files/EngAz.txt";
    @Override
    public Word[] readFile() {
        File file = new File(WORD_FILE_PATH);
        try (InputStream inputStream = new FileInputStream(file);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);) {


            byte[] bytes = bufferedInputStream.readAllBytes();

            String wordFile = new String(bytes);
            String[] keyAndValues = wordFile.split("\n");
            Word[] words = new Word[keyAndValues.length];

            for (int i = 0; i < words.length; i++) {
                String[] keyAndValue = keyAndValues[i].split(" - ");
                words[i] = new Word(keyAndValue[0],keyAndValues[1]);


            }
            return words;
        } catch (IOException e) {

            throw new RuntimeException(e);

        }
    }

    @Override
    public boolean writeFile(Word word) {
        File file=new File(WORD_FILE_PATH);
        try(OutputStream outputStream=new FileOutputStream(file,true)) {
            outputStream.write(word.toString().getBytes());
            return true;
        }catch (IOException e){
            return false;
        }
    }


}
