package racinggame.model.vo;

import java.util.ArrayList;
import java.util.List;

public class CarVo {
    private String carName;
    private int count;

    public CarVo(String carName) {
        this.carName = carName;
        count = 0;
    }

    public String getCarName() {
        return carName;
    }

    public void forward(){
        count++;
    }
    public int getCount(){
        return count;
    }

    public String getCurrentMessage(){
        StringBuilder builder = new StringBuilder();
        builder.append(carName).append(" : ");
        for(int i = 0;i<count;i++){
            builder.append("-");
        }
        return builder.toString();
    }

    public static List<CarVo> fromStringArray(String[] nameArray){
        List<CarVo> carVoList = new ArrayList<>();
        for(String name : nameArray){
            carVoList.add(new CarVo(name));
        }
        return carVoList;
    }
}
