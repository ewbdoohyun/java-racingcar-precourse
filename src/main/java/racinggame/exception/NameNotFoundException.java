package racinggame.exception;

public class NameNotFoundException extends Exception{
    public static final String MESSAGE = "[ERROR] 이름의 패턴이 정확하지 않습니다. 각 이름은 5자 이하. ,(콤마) 구분";
    public NameNotFoundException(){
        super(MESSAGE);
    }
}
