public abstract class Worker {

    private String name;
    private Boolean isAvailable = true;

    public Worker(String personName) {
        this.name = personName;
    }

    public abstract void handleCall();

    public abstract String getType();

    public String getName() {
        return name;
    }

    public void setAvailabilityAsFalse() {
        isAvailable = false;
    }

    public Boolean getAvailability() {
        return isAvailable;
    }

}

