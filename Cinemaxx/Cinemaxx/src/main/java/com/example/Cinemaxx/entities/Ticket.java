package com.example.Cinemaxx.entities;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Projection projection;

    private Integer price;

    private Integer seatRow;

    private Integer seatColumn;

    public Ticket(Projection projection, Integer price, Integer seatRow, Integer seatColumn) {
        this.projection = projection;
        this.price = price;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
    }

    public Ticket() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Projection getProjection() {
        return projection;
    }

    public void setProjection(Projection projection) {
        this.projection = projection;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(Integer seatRow) {
        this.seatRow = seatRow;
    }

    public Integer getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(Integer seatColumn) {
        this.seatColumn = seatColumn;
    }
}
