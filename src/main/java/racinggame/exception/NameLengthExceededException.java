package racinggame.exception;

public class NameLengthExceededException extends Exception{
    public static final String MESSAGE = "[ERROR] 이름이 5자를 초과했습니다.";
    public NameLengthExceededException(){
        super(MESSAGE);
    }
}
