package racinggame.exception;

public class NameInputException extends Exception{
    public static final String MESSAGE = "[ERROR] 이름의 패턴이 정확하지 않습니다. 각 이름은 5자 이하. ,(콤마) 구분으로 한 두 개 이상의 이름이 필요합니다.";
    public NameInputException(){
        super(MESSAGE);
    }
}
