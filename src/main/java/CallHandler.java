import java.util.*;

public class CallHandler {

    public Worker supervisor;
    public Worker manager;
    public List<Worker> employees;
    private List<Worker> workers;

    public CallHandler() {
        this.workers = new ArrayList<>();
    }

    // this method returns current Class in order ro achieve fluent pattern (method-chaining)
    public CallHandler addWorker(Worker worker) {
        workers.add(worker);
        return this;
    }

    public void defineUserTypes() {
        employees = new ArrayList<>();
        for (Worker worker : workers) {
            if (worker.getType().equals(WorkerTypes.EMPLOYEE.getWorkerType())) {
                employees.add(worker);
            }
            if (worker.getType().equals(WorkerTypes.SUPERVISOR.getWorkerType())) {
                supervisor = worker;
            }
            if (worker.getType().equals(WorkerTypes.MANAGER.getWorkerType())) {
                manager = worker;
            }
        }
    }

    public void makeNewCall(int numberOfCalls) {
        for (int i = 0; i < numberOfCalls; i++) {
            makeNewCall();
        }
    }

    private void makeNewCall() {
        System.out.println(GlobalConstants.NEW_LINE + "New Call...");

        Optional<Worker> callHandler = findCallHandler();

        callHandler.ifPresent(worker -> System.out.println(worker.getType() +
                GlobalConstants.SPACE + worker.getName() + GlobalConstants.SPACE + "handles the call."));
    }

    // optional returned type is used here because it is a bad practice to return null.
    private Optional<Worker> findCallHandler() {

        // shuffling employees so they are randomly selected for the call.
        Collections.shuffle(employees);

        int employeesCount = 0;
        for (Worker worker : employees) {

            if (worker.getAvailability()) {
                worker.handleCall();
                return Optional.of(worker);

            } else {
                employeesCount++;
            }
        }
        if (employeesCount == employees.size()) {
            return transferCallTo(supervisor);
        }
        return Optional.empty();
    }

    private Optional<Worker> transferCallTo(Worker worker) {

        if (worker.getAvailability()) {
            worker.handleCall();
            return Optional.of(worker);
        } else {
            if (worker.getType().equals(WorkerTypes.SUPERVISOR.getWorkerType())) {
                return transferCallTo(manager);
            }
        }
        System.out.println(GlobalConstants.ALL_BUSY_MESSAGE);
        return Optional.empty();
    }

}