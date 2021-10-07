package racinggame.model.vo;

public class TrueFalse {
    private final boolean isTrue;
    private static final TrueFalse trueObject = new TrueFalse(true);
    private static final TrueFalse falseObject = new TrueFalse(false);

    private TrueFalse(boolean isTrue) {
        this.isTrue = isTrue;
    }
    public boolean isTrue() {
        return isTrue;
    }
    public static TrueFalse getTrue(){
        return trueObject;
    }
    public static TrueFalse getFalse(){
        return falseObject;
    }
}
