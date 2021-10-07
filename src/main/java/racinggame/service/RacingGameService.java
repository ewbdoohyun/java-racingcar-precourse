package racinggame.service;

import nextstep.utils.Randoms;
import racinggame.model.vo.CarVo;

import java.util.List;

public class RacingGameService {

    public List<CarVo> run(List<CarVo> carVoList){

        for(CarVo carVo : carVoList){
            runOneCar(carVo);
        }
        return carVoList;
    }

    private CarVo runOneCar(CarVo carVo){
        int random = Randoms.pickNumberInRange(0,9);
        if(4 <= random){
            carVo.forward();
        }
        return carVo;
    }
}
