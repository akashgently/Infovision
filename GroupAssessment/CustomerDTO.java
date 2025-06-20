package com.GroupAssessment;

public class CustomerDTO {
    private   int customerId;
    private  String customerName;
    private String mobile;
    private String queries;
    private String status;

    public CustomerDTO(int customerId, String customerName, String mobile, String queries, String status) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.mobile = mobile;
        this.queries = queries;
        this.status= status;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  "CustomerId=" + customerId +
                ", CustomerName='" + customerName + '\'' +
                ", Mobile No.='" + mobile + '\'' +
                ", Query='" + queries + '\'' +
                ", Status='" + status + '\'' +
                ';';
    }
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getQueries() {
        return queries;
    }

    public void setQueries(String queries) {
        this.queries = queries;
    }
}
