package telecom;

class Subscriber {
    private String id;
    private String fullName;
    private Subscription subscription;

    public Subscriber(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public void subscribeToPlan(Subscription subscription) {
        this.subscription = subscription;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
}

