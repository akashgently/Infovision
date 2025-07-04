package com.Day20;

public class TelecomApp {
    public static void main(String[] args) throws InterruptedException {
        CustomerService customerService = new CustomerService();
        CallManager callManager = CallManager.getInstance();
        BillingEngine billingEngine = BillingEngine.getInstance();

        Customer alice = new Customer("1", "Akash", "111");
        Customer bob = new Customer("2", "Gently", "222");

        customerService.addCustomer(alice);
        customerService.addCustomer(bob);

        customerService.activatePlan("111", "postpaid");
        customerService.activatePlan("222", "prepaid");

        callManager.simulateCall("111", "222", 5);
        callManager.simulateCall("222", "111", 10);

        Thread.sleep(6000);

        billingEngine.generateBills(customerService, callManager);
    }
}
