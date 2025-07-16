package telecom;

class PremiumPlan implements Subscription {
    public double getRatePerMinute() { return 0.8; }
    public double getRatePerMB() { return 0.3; }
    public double getRatePerSMS() { return 0.35; }
}
