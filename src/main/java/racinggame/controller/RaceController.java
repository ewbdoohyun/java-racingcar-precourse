package racinggame.controller;

import racinggame.exception.EmptyInputException;
import racinggame.exception.NameInputException;
import racinggame.exception.TryCountException;
import racinggame.model.vo.CarVo;
import racinggame.model.vo.RaceCountVo;
import racinggame.service.RacingGameService;
import racinggame.service.console.CarNameService;
import racinggame.service.console.RaceCountService;

import java.util.List;

public class RaceController {

    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private final CarNameService carNameService;
    private final RaceCountService raceCountService;
    private final RacingGameService racingGameService;

    public RaceController() {
        //
        this.carNameService = new CarNameService();
        this.raceCountService = new RaceCountService();
        this.racingGameService = new RacingGameService();
    }

    public void run() {
        List<CarVo> carVoList = readCarListWithRetry();
        RaceCountVo raceCountVo = readRaceCountWithRetry();
        System.out.println("\n실행 결과");
        for(int i =0;i<raceCountVo.getRaceCount();i++){
            carVoList = racingGameService.run(carVoList);
            printCurrent(carVoList);
            System.out.println();
        }
        printWinner(racingGameService.getWinner(carVoList));
    }

    private void printWinner(List<CarVo> winnerList){
        StringBuilder builder = new StringBuilder();
        builder.append("최종 우승자는 ").append(winnerList.get(0).getCarName());
        for(int i = 1;i<winnerList.size();i++){
            builder.append(",").append(winnerList.get(i).getCarName());
        }
        builder.append(" 입니다.");
        System.out.println(builder);
    }

    private void printCurrent(List<CarVo> carVoList){
        for(CarVo carVo : carVoList){
            System.out.println(carVo.getCurrentMessage());
        }
    }

    private List<CarVo> readCarListWithRetry() {
        List<CarVo> carVoList;
        do{
            carVoList = readCarList();
        }while (carVoList == null);
        return carVoList;
    }

    private List<CarVo> readCarList() {
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
