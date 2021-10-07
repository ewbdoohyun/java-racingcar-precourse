package racinggame.service.console;

import nextstep.utils.Console;
import racinggame.exception.EmptyInputException;
import racinggame.exception.NameInputException;
import racinggame.model.vo.CarVo;
import racinggame.model.vo.CarListVo;
import racinggame.model.vo.TrueFalse;

public class CarNameService {

    public CarListVo readCarNames() throws EmptyInputException, NameInputException {
        boolean isAvailable = true;
        CarListVo carListVo = readAndSplitLine();
        for (CarVo name : carListVo.getCarVoList()) {
            isAvailable = isAvailable && isNameAvailable(name).isTrue();
        }
        if(!isAvailable){
            throw new NameInputException();
        }
        return carListVo;
    }

    private TrueFalse isNameAvailable(CarVo carVo) {
        if (carVo.getCarName().length() == 0 || carVo.getCarName().length() > 5) {
            return TrueFalse.getFalse();
        }
        return TrueFalse.getTrue();
    }

    private CarListVo readAndSplitLine() throws EmptyInputException, NameInputException {
        String line = Console.readLine();
        if (line.length() == 0) {
            throw new EmptyInputException();
        }
        String[] names = line.split(",");
        if(names.length<2){
            throw new NameInputException();
        }
        return new CarListVo(names);
    }
}
