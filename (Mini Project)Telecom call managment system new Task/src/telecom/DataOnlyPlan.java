package telecom;

public class DataOnlyPlan implements Subscription {
    public double getRatePerMinute() { return 0.0; }
    public double getRatePerMB() { return 0.05; }
    public double getRatePerSMS() { return 0.1; }
}
