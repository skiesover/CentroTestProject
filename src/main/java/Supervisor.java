public class Supervisor extends Worker {

    private String type;

    public Supervisor(String name) {
        super(name);
        this.type = WorkerTypes.SUPERVISOR.getWorkerType();
    }

    @Override
    public void handleCall() {
        System.out.println("All Employees are busy, Transferring the call to Supervisor!");
        setAvailabilityAsFalse();
    }

    @Override
    public String getType() {
        return type;
    }

}
