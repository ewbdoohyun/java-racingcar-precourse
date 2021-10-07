package racinggame.model.vo;

import java.util.Arrays;
import java.util.List;

public class NameListVo {
    private List<String> nameList;


    public NameListVo(String[] nameArray) {
        this.nameList = Arrays.asList(nameArray);
    }

    public List<String> getNameList() {
        return nameList;
    }
}
