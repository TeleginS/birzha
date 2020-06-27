package ru.telegin.birzha.model.user;

import org.hibernate.annotations.NaturalId;
import org.javamoney.moneta.Money;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import ru.telegin.birzha.model.Stock;
import ru.telegin.birzha.model.market.MarketActionName;
import ru.telegin.birzha.model.audit.DateAudit;

@Entity
@Table(name = "users_stocks")
public class UserStock extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private MarketActionName action;

    @NotBlank
    private Long quantity;

    @NotBlank
    private Money valueOfOne;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MarketActionName getAction() {
        return action;
    }

    public void setAction(MarketActionName action) {
        this.action = action;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Money getValueOfOne() {
        return valueOfOne;
    }

    public void setValueOfOne(Money valueOfOne) {
        this.valueOfOne = valueOfOne;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
