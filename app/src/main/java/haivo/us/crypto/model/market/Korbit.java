package haivo.us.crypto.model.market;

import haivo.us.crypto.model.CheckerInfo;
import haivo.us.crypto.model.Market;
import haivo.us.crypto.model.Ticker;
import haivo.us.crypto.model.currency.Currency;
import haivo.us.crypto.model.currency.VirtualCurrency;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.json.JSONObject;

public class Korbit extends Market {
    private static final HashMap<String, CharSequence[]> CURRENCY_PAIRS;
    private static final String NAME = "Korbit";
    private static final String TTS_NAME = "Korbit";
    private static final String URL = "https://api.korbit.co.kr/v1/ticker/detailed";

    static {
        CURRENCY_PAIRS = new LinkedHashMap();
        CURRENCY_PAIRS.put(VirtualCurrency.BTC, new String[]{Currency.KRW});
    }

    public Korbit() {
        super(TTS_NAME, TTS_NAME, CURRENCY_PAIRS);
    }

    public String getUrl(int requestId, CheckerInfo checkerInfo) {
        return URL;
    }

    protected void parseTickerFromJsonObject(int requestId, JSONObject jsonObject, Ticker ticker, CheckerInfo checkerInfo) throws
                                                                                                                           Exception {
        ticker.bid = jsonObject.getDouble("bid");
        ticker.ask = jsonObject.getDouble("ask");
        ticker.vol = jsonObject.getDouble("volume");
        ticker.high = jsonObject.getDouble("high");
        ticker.low = jsonObject.getDouble("low");
        ticker.last = jsonObject.getDouble("last");
        ticker.timestamp = jsonObject.getLong("timestamp");
    }
}
