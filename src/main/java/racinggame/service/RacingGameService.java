package racinggame.service;

import nextstep.utils.Randoms;
import racinggame.model.vo.CarVo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RacingGameService {

    private static final Comparator<CarVo> carVoComparator = (o1, o2) -> {
        if (o1.getCount() < o2.getCount()) {
            return 1;
        }
        if (o1.getCount() > o2.getCount()) {
            return -1;
        }
        return 0;
    };

    public List<CarVo> getWinner(List<CarVo> carVoList) {
        carVoList.sort(carVoComparator);
        List<CarVo> returnList = new ArrayList<>();
        returnList.add(carVoList.get(0));
        for (int i = 1; i < carVoList.size(); i++) {
            returnList = addIfSameCount(returnList, carVoList.get(i));
        }
        return returnList;
    }

    public List<CarVo> addIfSameCount(List<CarVo> carVoList, CarVo compare) {
        if (carVoList.get(0).getCount() == compare.getCount()) {
            carVoList.add(compare);
        }
        return carVoList;
    }

    public List<CarVo> run(List<CarVo> carVoList) {

        for (CarVo carVo : carVoList) {
            runOneCar(carVo);
        }
        return carVoList;
    }

    private CarVo runOneCar(CarVo carVo) {
        int random = Randoms.pickNumberInRange(0, 9);
        if (4 <= random) {
            carVo.forward();
        }
        return carVo;
    }
}
