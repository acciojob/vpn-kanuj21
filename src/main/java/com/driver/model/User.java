package com.driver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String password;
    private String originalIP;
    private String maskedIP;
    private boolean isConnected;

    @ManyToMany
    private List<ServiceProvider> serviceProviderList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Connection> connectionList = new ArrayList<>();

    @OneToOne(mappedBy = "user")
    private Country originalCountry;
    public User() {
    }

    public User(String userName, String password, String originalIP, String maskedIP) {
        this.userName = userName;
        this.password = password;
        this.originalIP = originalIP;
        this.maskedIP = maskedIP;

    }

    public int getId() {
        return id;
    }

    public List<ServiceProvider> getServiceProviderList() {
        return serviceProviderList;
    }

    public void setServiceProviderList(List<ServiceProvider> serviceProviderList) {
        this.serviceProviderList = serviceProviderList;
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }

    public Country getOriginalCountry() {
        return originalCountry;
    }

    public void setOriginalCountry(Country originalCountry) {
        this.originalCountry = originalCountry;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOriginalIp() {
        return originalIP;
    }

    public void setOriginalIp(String originalIP) {
        this.originalIP = originalIP;
    }

    public String getMaskedIp() {
        return maskedIP;
    }

    public void setMaskedIp(String maskedIP) {
        this.maskedIP = maskedIP;
    }

    public boolean getConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }
}
