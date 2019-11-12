import java.util.ArrayList;

/**
 * The Database class stores all the data that was processed using other classes in ArrayLists
 */
class Database {
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Home> homes = new ArrayList<>();
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<Plan> plans = new ArrayList<>();
    private ArrayList<Contract> contracts = new ArrayList<>();
    private ArrayList<Claim> claims = new ArrayList<>();

    void insertHome(Home home) {
        homes.add(home);
    }

    void insertCar(Car car) {
        cars.add(car);
    }

    void insertCustomer(Customer customer) {
        customers.add(customer);
    }

    void insertPlan(Plan plan) {
        plans.add(plan);
    }

    void insertClaim(Claim claim) {
        claims.add(claim);
    }

    void insertContract(Contract contract) {
        contracts.add(contract);
    }

    Plan getPlan(String name) {
        for (Plan plan : plans) {
            if (plan.name.equals(name))
                return plan;
        }
        return null;
    }

    Customer getCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name))
                return customer;
        }
        return null;
    }

    Contract getContract(String name) {
        for (Contract contract : contracts) {
            if (contract.getContractName().equals(name))
                return contract;
        }
        return null;
    }

    /**
     * There is at most one home owned by each person.
     */
    Home getHome(String ownerName) {
        for (Home home : homes) {
            if (home.getOwnerName().equals(ownerName))
                return home;
        }
        return null;
    }

    /**
     * There is at most one car owned by each person.
     */
    Car getCar(String ownerName) {
        for (Car car : cars) {
            if (car.getOwnerName().equals(ownerName))
                return car;
        }
        return null;
    }

    /**
     * Calculates the total amount that was claimed by the costumer
     * @return Total claimed amount
     */
    long totalClaimAmountByCustomer(String customerName) {
        long totalClaimed = 0;
        for (Claim claim : claims) {
            if (getContract(claim.getContractName()).getCustomerName().equals(customerName))
                totalClaimed += claim.getAmount();
        }
        return totalClaimed;
    }

    /**
     * Calculates the total amount that was received from the claims by the customer
     * @return Total received from the claims by the costumer
     */
    long totalReceivedAmountByCustomer(String customerName) {
        long totalReceived = 0;
        for (Claim claim : claims) {
            Contract contract = getContract(claim.getContractName());
            if (contract.getCustomerName().equals(customerName)) {
                if (claim.wasSuccessful()) {
                    long deductible = getPlan(contract.getPlanName()).getDeductible();
                    totalReceived += Math.max(0, claim.getAmount() - deductible);
                }
            }
        }
        return totalReceived;
    }

    /**
     * Calculates the number of costumers that are under the given plan
     * @return Total number of customers of the plan
     */
    long numberOfCustomers(String plan) {
        long counter = 0;
        for (Contract contract : contracts) {
            if (contract.getPlanName().equals(plan)) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Calculates all the money that the customers received from their claims
     * @return Total received from claims by all the costumers of the plan
     */
    long totalPaidToCostumers(String plan) {
        long total = 0;
        ArrayList<String> occurs = new ArrayList<>();
        for (Claim claim : claims) {
            Contract contract = getContract(claim.getContractName());
            if (contract.getPlanName().equals(plan) && claim.wasSuccessful() && !occurs.contains(contract.getCustomerName())) {
                total += totalReceivedAmountByCustomer(contract.getCustomerName());
                occurs.add(contract.getCustomerName());
            }
        }
        return total;
    }

}
