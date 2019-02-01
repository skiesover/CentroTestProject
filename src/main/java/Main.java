/*
This is Main Class for Ildar Lutfullin's Call Center project for Centro company.
P.S. It doesn't implement actual calls functionality (such as calls duration and setting employees available after call's ending).
 */

public class Main {

    public static CallHandler callHandler = new CallHandler();

    public static void main(String[] args) {

        System.out.println(GlobalConstants.INTRODUCTION_MESSAGE + GlobalConstants.NEW_LINE);

        executePreconditions();
        makeCalls();

    }

    // this method creates workers of 3 types: Employee, Supervisor & Manager.
    public static void executePreconditions() {

        callHandler
                .addWorker(new Employee("Tim"))
                .addWorker(new Employee("Lisa"))
                .addWorker(new Employee("Ildar"))
                .addWorker(new Employee("Rebecca"))

                // method is scalable and extensible - uncomment line below to add new Employee.
                // .addWorker(new Employee("Kim"))

                .addWorker(new Supervisor("Sarah"))
                .addWorker(new Manager("John"))

                /*
                Application allows to create more than 1 Manager or Supervisor object.
                However, newly created Manager will 'override' old one and will receive all transferred calls.
                Thus, requirement to have maximum 1 functioning Manager & Supervisor is met.
                 */
                .addWorker(new Manager("Anna"));

        callHandler.defineUserTypes();

    }

    /*
    Please specify a number of calls you want to make to the Call Center.
    If, for example, you have 4 Employees and make 2 calls - those calls will be distributed among 2 randomly selected Employees.
    If you have 4 Employees and make 6 calls - then first 4 calls will be distributed among 4 Employees, and 5th call will be
    forwarded to Supervisor, and last 6th call will be forwarded to Manager.
     */
    public static void makeCalls() {
        callHandler.makeNewCall(7);
    }
}