package telecom;

class UsageRecord {
    private double callDuration;
    private double dataUsed;
    private int smsCount;
    private double totalCost;

    public UsageRecord(double callDuration, double dataUsed, int smsCount, double totalCost) {
        this.callDuration = callDuration;
        this.dataUsed = dataUsed;
        this.smsCount = smsCount;
        this.totalCost = totalCost;
    }

    public double getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(double callDuration) {
        this.callDuration = callDuration;
    }

    public double getDataUsed() {
        return dataUsed;
    }

    public void setDataUsed(double dataUsed) {
        this.dataUsed = dataUsed;
    }

    public int getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(int smsCount) {
        this.smsCount = smsCount;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}

