package racinggame.controller;

import racinggame.exception.EmptyInputException;
import racinggame.exception.NameInputException;
import racinggame.exception.TryCountException;
import racinggame.model.vo.CarListVo;
import racinggame.model.vo.RaceCountVo;
import racinggame.service.console.CarNameService;
import racinggame.service.console.RaceCountService;

public class RaceController {

    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private final CarNameService carNameService;
    private final RaceCountService raceCountService;

    public RaceController() {
        //
        this.carNameService = new CarNameService();
        this.raceCountService = new RaceCountService();
    }

    public void run() {
        CarListVo carListVo = readCarListWithRetry();
        RaceCountVo raceCountVo = readRaceCountWithRetry();

    }

    private CarListVo readCarListWithRetry() {
        CarListVo carListVo;
        do{
            carListVo = readCarList();
        }while (carListVo == null);
        return carListVo;
    }

    private CarListVo readCarList() {
        try {
            System.out.println(CAR_NAME_MESSAGE);
            return carNameService.readCarNames();
        } catch (EmptyInputException | NameInputException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    private RaceCountVo readRaceCountWithRetry(){
        RaceCountVo raceCountVo;
        do{
            raceCountVo = readRaceCount();
        }while (raceCountVo == null);
        return raceCountVo;
    }

    private RaceCountVo readRaceCount() {
        try {
            System.out.println(RACE_COUNT_MESSAGE);
            return raceCountService.readRaceCount();
        } catch (TryCountException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
