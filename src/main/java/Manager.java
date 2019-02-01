public class Manager extends Worker {

    private String type;

    public Manager(String name) {
        super(name);
        this.type = WorkerTypes.MANAGER.getWorkerType();
    }

    @Override
    public void handleCall() {
        System.out.println("All Employees and Supervisor are busy, Transferring the call to Manager!");
        setAvailabilityAsFalse();
    }

    @Override
    public String getType() {
        return type;
    }

}
