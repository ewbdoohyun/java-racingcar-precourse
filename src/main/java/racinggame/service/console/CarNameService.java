package racinggame.service.console;

import nextstep.utils.Console;
import racinggame.exception.EmptyInputException;
import racinggame.exception.NameInputException;
import racinggame.model.vo.NameListVo;

public class CarNameService {

    public NameListVo readCarNames() throws EmptyInputException, NameInputException {
        boolean isAvailable = true;
        NameListVo nameListVo = readAndSplitLine();

        for (String name : nameListVo.getNameList()) {
            isAvailable = isAvailable && isNameAvailable(name);
        }
        if(!isAvailable){
            throw new NameInputException();
        }
        return nameListVo;
    }

    private boolean isNameAvailable(String name) {
        if (name.length() == 0 || name.length() > 5) {
            return false;
        }
        return true;
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
