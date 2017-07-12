package edu.bionic.domain;

import java.time.LocalDateTime;

/**
 * Created by bm on 10.07.17.
 */
public class Response {
    private Integer idProduct;
    private LocalDateTime localDateTime;
    private String nameBuyer;
    private String text;
    private Integer rating;


    public Response(Integer idProduct, LocalDateTime localDateTime, String nameBuyer, String text, Integer rating) {
        this.idProduct = idProduct;
        this.localDateTime = localDateTime;
        this.nameBuyer = nameBuyer;
        this.text = text;
        this.rating = rating;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getNameBuyer() {
        return nameBuyer;
    }

    public void setNameBuyer(String nameBuyer) {
        this.nameBuyer = nameBuyer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String printInfo() {
        return String.format("%d. %s %d %s \n %s", idProduct, nameBuyer, rating, localDateTime , text);
    }
}
