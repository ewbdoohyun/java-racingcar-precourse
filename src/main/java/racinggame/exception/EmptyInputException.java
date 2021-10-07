package racinggame.exception;

public class EmptyInputException extends Exception{
    public static final String MESSAGE = "[ERROR] 올바르게 입력해 주세요.";
    public EmptyInputException(){
        super(MESSAGE);
    }
}
