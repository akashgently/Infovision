package telecom;

class BasicPlan implements Subscription {
    public double getRatePerMinute() { return 0.4; }
    public double getRatePerMB() { return 0.15; }
    public double getRatePerSMS() { return 0.25; }
}