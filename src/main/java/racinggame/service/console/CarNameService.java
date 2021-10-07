package racinggame.service.console;

import nextstep.utils.Console;
import racinggame.exception.EmptyInputException;
import racinggame.exception.NameInputException;
import racinggame.model.vo.CarVo;
import racinggame.model.vo.NameListVo;
import racinggame.model.vo.TrueFalse;

public class CarNameService {

    public NameListVo readCarNames() throws EmptyInputException, NameInputException {
        boolean isAvailable = true;
        NameListVo nameListVo = readAndSplitLine();
        for (CarVo name : nameListVo.getNameList()) {
            isAvailable = isAvailable && isNameAvailable(name).isTrue();
        }
        if(!isAvailable){
            throw new NameInputException();
        }
        return nameListVo;
    }

    private TrueFalse isNameAvailable(CarVo carVo) {
        if (carVo.getCarName().length() == 0 || carVo.getCarName().length() > 5) {
            return TrueFalse.getFalse();
        }
        return TrueFalse.getTrue();
    }

    private NameListVo readAndSplitLine() throws EmptyInputException, NameInputException {
        String line = Console.readLine();
        if (line.length() == 0) {
            throw new EmptyInputException();
        }
        String[] names = line.split(",");
        if(names.length<2){
            throw new NameInputException();
        }
        return new NameListVo(names);
    }
}
