package racinggame.service.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.exception.EmptyInputException;
import racinggame.exception.NameInputException;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;



class CarNameServiceTest {
    CarNameService carNameService;

    @BeforeEach
    void init(){
        carNameService = new CarNameService();
    }
    @Test
    void 이름_입력_테스트() throws EmptyInputException, NameInputException {
        ByteArrayInputStream in = new ByteArrayInputStream(",hell,dddd\nhe,\nhello\nhello,wor,ld\n\n".getBytes());
        System.setIn(in);
        assertThrows(NameInputException.class,()->carNameService.readCarNames());
        assertThrows(NameInputException.class,()->carNameService.readCarNames());
        assertThrows(NameInputException.class,()->carNameService.readCarNames());
        assertNotNull(carNameService.readCarNames());
        assertThrows(EmptyInputException.class,()->carNameService.readCarNames());

    }
}