import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestFindCallHandlerManagementAvailability {

    private static CallHandler handler = Main.callHandler;

    @Test
    public static void testFindCallHandlerManagementAvailability() {

        Main.executePreconditions();
        int numberOfEmployees = handler.employees.size();

        // test 1 - make same amount of calls as total amount of Employees and make sure
        // Supervisor & Manager are free.
        handler.makeNewCall(numberOfEmployees);
        checkSuperAndManagerAvailable();

        // test 2 - make one more call and make sure Supervisor became busy.
        handler.makeNewCall(1);
        checkSuperBusyAndManagerAvailable();

        // test 3 - make one more call and make sure Manager became busy.
        handler.makeNewCall(1);
        checkSuperAndManagerBusy();

    }

    // I didn't combine those 3 methods below into one with parameters on purpose. Sometimes we could
    // achieve better test-steps readability by specify distinct method names and just hide implementation.
    private static void checkSuperAndManagerAvailable() {
        assertEquals(handler.supervisor.getAvailability(), Boolean.valueOf(true),
                handler.supervisor.getType() + GlobalConstants.AVAILABLE_MESSAGE);
        assertEquals(handler.manager.getAvailability(), Boolean.valueOf(true),
                handler.manager.getType() + GlobalConstants.AVAILABLE_MESSAGE);
    }

    private static void checkSuperBusyAndManagerAvailable() {
        assertEquals(handler.supervisor.getAvailability(), Boolean.valueOf(false),
                handler.supervisor.getType() + GlobalConstants.BUSY_MESSAGE);
        assertEquals(handler.manager.getAvailability(), Boolean.valueOf(true),
                handler.manager.getType() + GlobalConstants.AVAILABLE_MESSAGE);
    }

    private static void checkSuperAndManagerBusy() {
        assertEquals(handler.supervisor.getAvailability(), Boolean.valueOf(false),
                handler.supervisor.getType() + GlobalConstants.BUSY_MESSAGE);
        assertEquals(handler.manager.getAvailability(), Boolean.valueOf(false),
                handler.manager.getType() + GlobalConstants.BUSY_MESSAGE);
    }

}
