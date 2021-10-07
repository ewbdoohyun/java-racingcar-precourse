package racinggame.service.console;

import nextstep.utils.Console;
import racinggame.exception.TryCountException;
import racinggame.model.vo.RaceCountVo;
import racinggame.model.vo.TrueFalse;

public class RaceCountService {

    public RaceCountVo readRaceCount() throws TryCountException {
        RaceCountVo raceCountVo = readRaceCountLine();
        if(!isAvailableRaceCount(raceCountVo).isTrue()){
            throw new TryCountException();
        }
        return raceCountVo;
    }
    private RaceCountVo readRaceCountLine() throws TryCountException {
        try {
            return new RaceCountVo(Integer.parseInt(Console.readLine()));
        }catch (NumberFormatException e){
            throw new TryCountException();
        }
    }
    private TrueFalse isAvailableRaceCount(RaceCountVo raceCountVo){
        if(raceCountVo.getRaceCount() < 1){
            return TrueFalse.getFalse();
        }
        return TrueFalse.getTrue();
    }
}
