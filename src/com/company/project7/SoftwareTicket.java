package com.company.project7;

public class SoftwareTicket extends Ticket {

    private String application;
    private String version;
    private Domain domain;

    public SoftwareTicket(String customerName, int id, String description,
                          int due, String application, String version, Domain domain) {
        super(customerName, id, description, due);
        this.application = application;
        this.version = version;
        this.domain = domain;
    }

    @Override
    public String toString() {
        return super.toString() + "\napp: " + application + "\nversion " + version + "\ndomain " + domain;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }
}
