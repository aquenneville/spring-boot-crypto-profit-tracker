package github.aq.cryptoprofittracker.model;

import java.time.LocalDateTime;

public class Transaction {
	
	public Transaction() {
		id = TransactionIdIncrementer.computeNextId();
	}
	
	public enum Currency {
		USD(Boolean.TRUE), 
		EUR(Boolean.TRUE),
		GBP(Boolean.TRUE),
		BTC(Boolean.FALSE), 
		XRP(Boolean.FALSE), 
		ETH(Boolean.FALSE), 
		LTC(Boolean.FALSE),  
		STR(Boolean.FALSE), 
		BCH(Boolean.FALSE), 
		EOS(Boolean.FALSE), 
		XMR(Boolean.FALSE), 
		ETC(Boolean.FALSE),
		NEO(Boolean.FALSE),
		ONT(Boolean.FALSE),
		XVG(Boolean.FALSE),
		TRX(Boolean.FALSE);  
		
		Boolean isFiat;
		
		Currency(Boolean isFiat) {
		    this.isFiat = isFiat;
		}
		
		public boolean isFiat() {
		    return isFiat; 
		}
	}
	
	public enum OrderType {
		BUY, SELL;
	}
	
	public class AmountCurrency {
		private double amount;
		private Currency currency;
		
		public AmountCurrency(String amount, String currency) {
			
		    try {
		    	this.amount = Double.parseDouble(amount);
		    } catch (NumberFormatException e) {
		    	this.amount = 0d;
		    }
			switch(currency) {
				case "BTC": this.currency = Currency.BTC; break;
				case "USD": this.currency = Currency.USD; break;
				case "EUR": this.currency = Currency.EUR; break;
				case "ETH": this.currency = Currency.ETH; break;
				case "BCH": this.currency = Currency.BCH; break;
			}
		}
					
		public double getAmount() {
			return amount;
		}
		
		public Currency getCurrency() {
			return currency;
		}
						
	}
	
	private Exchange exchange;
	private String marketType; 
	private LocalDateTime dateTime; 
	private String accountId;
	private AmountCurrency amount;
	private AmountCurrency value;
	private AmountCurrency rate;
	private AmountCurrency fee;
	private OrderType orderType;
	private long id;
	private String websiteTxId;
	private String websiteTxRefId;
	
	public String getMarketType() {
		return marketType;
	}

	public void setMarketType(String marketType) {
		this.marketType = marketType;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public AmountCurrency getAmount() {
		return amount;
	}

	public void setAmount(String amount, String currency) {
		this.amount = new AmountCurrency(amount, currency);
	}
	
	public void setAmount(AmountCurrency amount) {
		this.amount = amount;
	}

	public AmountCurrency getValue() {
		return value;
	}

	public void setValue(AmountCurrency value) {
		this.value = value;
	}

	public void setValue(String amount, String currency) {
		this.value = new AmountCurrency(amount, currency);
	}
	
	public AmountCurrency getRate() {
		return rate;
	}

	public void setRate(AmountCurrency rate) {
		this.rate = rate;
	}

	public void setRate(String amount, String currency) {
		this.rate = new AmountCurrency(amount, currency);
	}
	
	public AmountCurrency getFee() {
		return fee;
	}

	public void setFee(String amount, String currency) {
		this.fee = new AmountCurrency(amount, currency);
	}

	public void setFee(AmountCurrency fee) {
		this.fee = fee;
	}
	
	public String getOrderType() {
		if (orderType == null) {
			return "";
		}
		return orderType.name();
	}

	public void setOrderType(String orderType) {
		switch(orderType) {
			case "BUY": this.orderType = OrderType.BUY; break;
			case "SELL": this.orderType = OrderType.SELL; break;
		}
	}
	
	public Exchange getExchange() {
		return exchange;
	}

	public void setExchange(Exchange exchange) {
		this.exchange = exchange;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getWebsiteTxId() {
		return websiteTxId;
	}

	public void setWebsiteTxId(String websiteTxId) {
		this.websiteTxId = websiteTxId;
	}

	public String getWebsiteTxRefId() {
		return websiteTxRefId;
	}

	public void setWebsiteTxRefId(String websiteTxRefId) {
		this.websiteTxRefId = websiteTxRefId;
	}

	public static void main(String[] args) {
		

	}

	public static class TransactionIdIncrementer {

		public static long idCounter = 0;
		
		public static long computeNextId() {
			idCounter ++;
			return idCounter;
		}
	}
	
}
