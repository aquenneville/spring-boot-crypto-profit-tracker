package github.aq.cryptoinvestmentwatcher.parse.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import github.aq.cryptoinvestmentwatcher.model.Transaction;

public class KrakenTransactionsCsvParser {

	
	public static List<Transaction> parse(String filename) {
		Reader in = null;
		List<Transaction> list = new ArrayList<>();
		
		try {
			in = new FileReader(Paths.get(filename).toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterable<CSVRecord> records = null;
		try {
			records = CSVFormat.EXCEL.parse(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (CSVRecord record : records) {
			Transaction tran = new Transaction();
			
			DateTimeFormatter dTF = DateTimeFormatter.ofPattern("MMM. DD, YYYY, HH:mm a"); //MMM. DD, YYYY, HH:mm PM/AM
			String dateTimeValue = record.get("Datetime");
			LocalDateTime ldt = LocalDateTime.parse(dateTimeValue, dTF);
			
		    String marketType = record.get("Type");
		    String accountId = record.get("Account");
		    String amount = record.get("Amount");
		    String value = record.get("Value");
		    String rate = record.get("Rate");
		    String fee = record.get("Fee");
		    String orderType = record.get("Sub Type");
		    
		    tran.setMarketType(marketType);
		    tran.setAccountId(accountId);
		    tran.setOrderType(orderType);
		    tran.setAmount(amount.split(" ")[0], amount.split(" ")[1]);
		    tran.setValue(value.split(" ")[0], value.split(" ")[1]);
		    tran.setRate(rate.split(" ")[0], rate.split(" ")[1]);
		    tran.setFee(fee.split(" ")[0], fee.split(" ")[1]);
		    tran.setDateTime(ldt);
		}
		return list;
	}
}
