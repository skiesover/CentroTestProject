import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestFindCallHandlerAllWorkersAvailability {

    private static CallHandler handler = Main.callHandler;

    @Test
    public static void testFindCallHandlerAllWorkersAvailability() {

        // preconditions
        Main.executePreconditions();
        // number of workers == number of Employees + Supervisor + Manager
        int numberOfWorkers = handler.employees.size() + 2;

        // step 1 - make same amount of calls as total amount of Workers
        handler.makeNewCall(numberOfWorkers);

        // step 2 - make sure all workers are busy
        checkAllWorkersBusy();

    }

    private static void checkAllWorkersBusy() {
        List<Worker> workers = new ArrayList<>();
        workers.addAll(handler.employees);
        workers.add(handler.supervisor);
        workers.add(handler.manager);

        for (Worker worker : workers) {
            assertEquals(worker.getAvailability(), Boolean.valueOf(false),
                    worker.getType() + GlobalConstants.BUSY_MESSAGE);
        }
    }
}
