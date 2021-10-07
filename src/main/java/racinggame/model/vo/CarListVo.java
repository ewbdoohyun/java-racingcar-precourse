package racinggame.model.vo;

import java.util.ArrayList;
import java.util.List;

public class CarListVo {
    private List<CarVo> nameList;


    public CarListVo(String[] nameArray) {
        List<CarVo> carVoList = new ArrayList<>();
        for(String name : nameArray){
            carVoList.add(new CarVo(name));
        }
        this.nameList = carVoList;
    }

    public List<CarVo> getNameList() {
        return nameList;
    }
}
