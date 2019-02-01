public enum WorkerTypes {

    EMPLOYEE {
        @Override
        public String getWorkerType() {
            return EMPLOYEE.toString().toLowerCase();
        }
    },
    SUPERVISOR {
        @Override
        public String getWorkerType() {
            return SUPERVISOR.toString().toLowerCase();
        }
    },
    MANAGER {
        @Override
        public String getWorkerType() {
            return MANAGER.toString().toLowerCase();
        }
    };

    public abstract String getWorkerType();

}