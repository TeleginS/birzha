package ru.telegin.birzha.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import ru.telegin.birzha.model.audit.DateAudit;
import ru.telegin.birzha.model.market.Market;

@Entity
@Table(name = "stocks")
public class Stock extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 10)
    private String ticker;

    @Size(max = 40)
    private String name;

    @Size(max = 1000)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "market_id", nullable = false)
    private Market market;

    @OneToMany(
            mappedBy = "stock",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 100)
    private List<StockHistoryValues> historyValues = new ArrayList<>();

    @OneToMany(
            mappedBy = "stock",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 100)
    private List<StockHistoryDividend> historyDividends = new ArrayList<>();

    public Stock() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public List<StockHistoryValues> getHistoryValues() {
        return historyValues;
    }

    public void setHistoryValues(List<StockHistoryValues> historyValues) {
        this.historyValues = historyValues;
    }

    public List<StockHistoryDividend> getHistoryDividends() {
        return historyDividends;
    }

    public void setHistoryDividends(List<StockHistoryDividend> historyDividends) {
        this.historyDividends = historyDividends;
    }
}
