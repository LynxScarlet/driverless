
import com.driverless.car.impl.Driverless;
import com.driverless.entity.CarDirections;
import com.driverless.entity.CarPark;
import com.driverless.entity.CarState;
import com.driverless.exception.CarOutBorderlineException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class testDriverless {
    private Driverless driverless;

    private CarState carState;

    private CarPark carPark;

    @Before
    public void setUp() throws Exception{
        CarPark carPark = new CarPark(3,3);
        CarState carState = new CarState(2,2,"NORTH");
        driverless = new Driverless(carState,carPark);
    }

    /**
     * test car move
     */

    @Test
    public void move(){
        driverless.move("1");
        assertEquals(driverless.getCarState().getPositionX(), 2);
        assertEquals(driverless.getCarState().getPositionY(), 3);
        assertEquals(driverless.getCarState().getDirection(), CarDirections.NORTH.getDirection());
    }

    /**
     * turn test
     */
    @Test
    public void turn(){
        driverless.move("TURN");
        driverless.move("1");
        assertEquals(driverless.getCarState().getPositionX(), 3);
        assertEquals(driverless.getCarState().getPositionY(), 2);
        assertEquals(driverless.getCarState().getDirection(), CarDirections.EAST.getDirection());
    }

    /**
     * exception test
     */
    @Test
    public void carOutBoundariesException(){
        try{
            driverless.move("2");
        }catch (Exception e) {
            assertEquals(e.getMessage(), new CarOutBorderlineException().getMessage());
        }
    }

}
