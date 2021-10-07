package racinggame.exception;

public class TryCountException extends Exception{
    public static final String MESSAGE = "[ERROR] 경주 시도 횟수는 1회 이상 양의 정수여야 합니다.";
    public TryCountException(){
        super(MESSAGE);
    }
}
