package br.com.caelum.fj27.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Embeddable
public class Price {

    @Enumerated(EnumType.STRING)
    @NotNull
    private BookType bookType;

    @Column(scale = 2)
    @DecimalMin("10")
    @NotNull
    private BigDecimal value;

    public Price(BookType bookType, BigDecimal value) {
        this.bookType = bookType;
        this.value = value;
    }

    /**
     * @deprecated frameworks only
     */
    public Price(){}

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Price{" +
                "bookType=" + bookType +
                ", value=" + value +
                '}';
    }
}
