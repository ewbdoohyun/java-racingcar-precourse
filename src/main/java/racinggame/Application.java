package racinggame;

import racinggame.controller.RaceController;

public class Application {

    public static void main(String[] args) {
        RaceController raceController = new RaceController();
        raceController.run();
    }
}
