package telecom;

class UsageTracker implements Runnable {
    private Subscriber subscriber;
    private double callDuration;
    private double dataUsed;
    private int smsCount;

    public UsageTracker(Subscriber subscriber, double callDuration, double dataUsed, int smsCount) {
        this.subscriber = subscriber;
        this.callDuration = callDuration;
        this.dataUsed = dataUsed;
        this.smsCount = smsCount;
    }

    @Override
    public void run() {
        try {
            double callCost = subscriber.getSubscription().getRatePerMinute() * callDuration;
            double dataCost = subscriber.getSubscription().getRatePerMB() * dataUsed;
            double smsCost = subscriber.getSubscription().getRatePerSMS() * smsCount;

            double totalCost = callCost + dataCost + smsCost;
            System.out.println("Subscriber " + subscriber.getFullName() + " has incurred: rs." + totalCost);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
