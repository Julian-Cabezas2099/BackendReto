package com.Reto3.springboot.app.Models.reports;

import com.Reto3.springboot.app.Models.entities.Client;

public class TopClient {

    private Long total;
    private Client cliente;

    

    public TopClient(Long total, Client cliente) {
        this.total = total;
        this.cliente = cliente;
    }
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
    public Client getCliente() {
        return cliente;
    }
    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    

    
}
