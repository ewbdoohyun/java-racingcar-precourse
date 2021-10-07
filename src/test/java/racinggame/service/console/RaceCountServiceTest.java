package racinggame.service.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.exception.TryCountException;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class RaceCountServiceTest {
    RaceCountService raceCountService;

    @BeforeEach
    void init(){
        raceCountService = new RaceCountService();
    }
    @Test
    void 레이스_횟수_입력_테스트() throws TryCountException {
        ByteArrayInputStream in = new ByteArrayInputStream("-1\nasd\n5\n\n".getBytes());
        System.setIn(in);
        assertThrows(TryCountException.class,()->raceCountService.readRaceCount());
        assertThrows(TryCountException.class,()->raceCountService.readRaceCount());
        assertNotNull(raceCountService.readRaceCount());
        assertThrows(TryCountException.class,()->raceCountService.readRaceCount());

    }
}