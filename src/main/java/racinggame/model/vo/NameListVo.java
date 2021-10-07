package racinggame.model.vo;

import java.util.ArrayList;
import java.util.List;

public class NameListVo {
    private List<CarNameVo> nameList;


    public NameListVo(String[] nameArray) {
        List<CarNameVo> carNameVoList = new ArrayList<>();
        for(String name : nameArray){
            carNameVoList.add(new CarNameVo(name));
        }
        this.nameList = carNameVoList;
    }

    public List<CarNameVo> getNameList() {
        return nameList;
    }
}
