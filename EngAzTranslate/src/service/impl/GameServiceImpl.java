package service.impl;

import model.Word;
import service.FileService;
import service.GameService;
import util.InputUtil;
import util.RandomUtil;

import java.util.Random;

public class GameServiceImpl implements GameService {
private  final FileService fileService;
public  GameServiceImpl(){
    fileService=new FileServiceImpl();
}
    @Override
    public void add() {
        System.out.println("----------------------");
    String key=InputUtil.inputRequiredString("english : ");

    String value=InputUtil.inputRequiredString("Azerbaijan :");
        boolean isAdded = fileService.writeFile(new Word(key,value));
        System.out.println(isAdded ? "Seccessfully " : "Fail");
        System.out.println("-----------------------------");
}

    @Override
    public void play() {
        Word [] words=fileService.readFile();
        int point=0;
        for (int i = 0; i < 10 ; i++) {
         int randomIndex=RandomUtil.getRandomIndex(words.length);
          Word word=words[randomIndex];
          if (!word.isShowed()){
             String value=   InputUtil.inputRequiredString(word.getKey()+"=> ");
           if(word.getValue().equals(value)){
                point++;
           }
             word.setShowed(true);
          }else {
              i--;
          }

        }
        System.out.println("Congrats your poit is "+ point +"!");
    }

    @Override
    public void show() {
   Word[] words = fileService.readFile();
        System.out.println("--------Words----------");
   for (Word word:words) {
       System.out.println(word);

        }
        System.out.println("-----------------");
    }
}
