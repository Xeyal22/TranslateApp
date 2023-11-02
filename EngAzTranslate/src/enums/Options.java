package enums;

public enum Options {
    PLAY("[1].Play\n"),
    ADD("[2].Add\n"),
    SHOW("[3].Show\n"),
    EXIT("[0].Exit");
private final String val;
    Options(String val){
        this.val=val;

    }
    public String getVal(){
        return val;
    }
}
