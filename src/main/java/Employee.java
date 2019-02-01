public class Employee extends Worker {

    private String type;

    public Employee(String name) {
        super(name);
        this.type = WorkerTypes.EMPLOYEE.getWorkerType();
    }

    @Override
    public void handleCall() {
        setAvailabilityAsFalse();
    }

    @Override
    public String getType() {
        return type;
    }

}
