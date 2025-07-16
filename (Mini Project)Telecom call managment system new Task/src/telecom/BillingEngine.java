package telecom;

class BillingEngine {
    private static BillingEngine instance;

    private BillingEngine() {}

    public static BillingEngine getInstance() {
        if (instance == null) {
            instance = new BillingEngine();
        }
        return instance;
    }

    public void generateBill(Subscriber subscriber) {

        System.out.println("Generating monthly bill for " + subscriber.getFullName());
    }
}
