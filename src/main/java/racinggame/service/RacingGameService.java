package racinggame.service;

import nextstep.utils.Randoms;
import racinggame.model.vo.CarListVo;
import racinggame.model.vo.CarVo;

public class RacingGameService {

    public CarListVo run(CarListVo carListVo){

        for(CarVo carVo : carListVo.getNameList()){
            runOneCar(carVo);
        }
        return carListVo;
    }

    private CarVo runOneCar(CarVo carVo){
        int random = Randoms.pickNumberInRange(0,9);
        if(4 <= random){
            carVo.forward();
        }
        return carVo;
    }
}
