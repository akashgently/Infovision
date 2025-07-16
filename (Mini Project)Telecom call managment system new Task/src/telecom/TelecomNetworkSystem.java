package telecom;

import java.util.*;

public class TelecomNetworkSystem {
    public static void main(String[] args) {

        Subscriber jaya = new Subscriber("1", "Jaya");
        Subscriber abu = new Subscriber("2", "Abu");


        jaya.subscribeToPlan(SubscriptionFactory.createSubscription("Premium"));
        abu.subscribeToPlan(SubscriptionFactory.createSubscription("Basic"));


        Thread Jaya = new Thread(new UsageTracker(jaya, 120, 1.5, 50));
        Thread Abu = new Thread(new UsageTracker(abu, 90, 2.0, 30));

        Jaya.start();
        Abu.start();


        BillingEngine billingEngine = BillingEngine.getInstance();
        billingEngine.generateBill(jaya);
        billingEngine.generateBill(abu);
    }
}
