package telecom;

class SubscriptionFactory {
    public static Subscription createSubscription(String planType) {
        if (planType.equalsIgnoreCase("Basic")) {
            return new BasicPlan();
        } else if (planType.equalsIgnoreCase("Premium")) {
            return new PremiumPlan();
        } else if (planType.equalsIgnoreCase("DataOnly")) {
            return new DataOnlyPlan();
        }
        return null;
    }
}
