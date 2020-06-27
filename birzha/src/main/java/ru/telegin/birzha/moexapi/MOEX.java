package ru.telegin.birzha.moexapi;

public class MOEX {
    public static final String API_BASE_URL = System.getProperty("moexapi.baseurl.api", "https://iss.moex.com/iss/");
    public static final String SECURITY_INFO_URL = System.getProperty("moexapi.baseurl.api", "https://iss.moex.com/iss/");

    public static final String ENGINE_STOCK = System.getProperty("moexapi.engine.stock", "stock");
    public static final String ENGINE_STOCK_MARKET_SHARE = System.getProperty("moexapi.engine.stock.market.share", "shares");
    public static final String ENGINE_STOCK_MARKET_BOND = System.getProperty("moexapi.engine.stock.market.bond", "bonds");
}
