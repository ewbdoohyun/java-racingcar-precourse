package racinggame.model.vo;

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
}
