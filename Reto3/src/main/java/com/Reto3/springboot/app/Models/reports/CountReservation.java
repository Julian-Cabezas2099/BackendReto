package com.Reto3.springboot.app.Models.reports;

public class CountReservation {

    private Integer completed;
    private Integer cancelled;

    
    public CountReservation(Integer completed, Integer cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }
    public Integer getCompleted() {
        return completed;
    }
    public void setCompleted(Integer completed) {
        this.completed = completed;
    }
    public Integer getCancelled() {
        return cancelled;
    }
    public void setCancelled(Integer cancelled) {
        this.cancelled = cancelled;
    }

    
    
 

    
    
}
