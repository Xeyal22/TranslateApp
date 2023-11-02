package util;

import enums.Options;

public class MenuUtil {
    public static int showMenu(){
        System.out.println(
                "\n-----------------Translate-------------\n"+
                        Options.PLAY.getVal()+
                        Options.ADD.getVal()+
                        Options.SHOW.getVal()+
                        Options.EXIT.getVal()
        );
            return InputUtil.inputRequiredInt("Choose option : ");
    }
}
