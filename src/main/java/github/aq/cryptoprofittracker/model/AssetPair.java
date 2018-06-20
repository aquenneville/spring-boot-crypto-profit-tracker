package github.aq.cryptoprofittracker.model;

public enum AssetPair {
	BTCUSD,
	BTCUSDT,
	ETHUSD,
	XRPUSD,
	BCHBTC,
	LTCBTC,
	XMRBTC,
	ETCBTC,	
	NEOBTC,
	ONTBTC,
	XVGBTC,
	TRXBTC, 
	BCHUSD;
	
	public String toString() {
		return this.name().toLowerCase();
	}
}

