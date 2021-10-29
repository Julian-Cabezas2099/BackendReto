package com.Reto3.springboot.app.Models.reports;

import com.Reto3.springboot.app.Models.entities.Client;

public class TopClient {

    private Long total;
    private Client client;

    

    public TopClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
    public Client getclient() {
        return client;
    }
    public void setclient(Client client) {
        this.client = client;
    }

    

    
}
