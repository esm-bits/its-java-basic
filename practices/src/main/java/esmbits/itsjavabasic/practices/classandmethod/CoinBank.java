package esmbits.itsjavabasic.practices.classandmethod;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * 貯金箱.
 */
public class CoinBank {

    // 変数宣言
    // 硬貨種類枚数領域
    Hashtable<String, Integer> coinKindCounts = new Hashtable<String, Integer>();

    // 許容硬貨種類リスト
    ArrayList<String> coinKinds = new ArrayList<String>() {
        {
          add("1");
          add("5");
          add("10");
          add("50");
          add("100");
          add("500");
        }
      };

    // 貯金箱クラス(CoinBank)、そのテストクラス(CoinBankTest)を作る.
    // ・種類問わず全部で100枚まで入る

    // メソッド一覧
    // ・putCoins 硬貨の種類と枚数を指定して入れる.入った枚数を返す.
    // ・pickCoins 硬貨の種類と枚数を指定して取り出す.取り出した枚数を返す.
    // ・countCoins 2種類作る.
    //   1.硬貨の種類を指定する版: その硬貨が何枚入っているかを返す.
    //   2.硬貨の種類を指定しない版: 全体で何枚入っているかを返す.
    // ・getAmount 貯金箱全体の総額を返す.
    // ・isExactMatch この貯金箱に入っている各々の硬貨の枚数と、指定した貯金箱のそれが完全に一致する場合にtrueを返す.


    // ・putCoins 硬貨の種類と枚数を指定して入れる.入った枚数を返す.
    public int putCoins(String coinKind, int coinCount) {
    	int coinCountValue = coinCount;

    	// 許容硬貨種類でないときはエラー
    	if (coinKinds.contains(coinKind) == false) {
            System.out.println("存在しない硬貨の種類を入れようとしています.");
            return -1;

    	}

    	// すでに入っている枚数を算出し、入れる硬貨の枚数が100を超える場合は100を超えないようにする
    	int putedCoinCount = countCoins();
    	if (putedCoinCount + coinCountValue > 100 ) {
    	    coinCountValue = 100 - putedCoinCount;
    	}

        // 硬貨種類枚数領域に格納
	    if(coinKindCounts.containsKey(coinKind)){
	    	coinKindCounts.replace(coinKind, coinKindCounts.get(coinKind) + coinCountValue);

	    } else {
	    	coinKindCounts.put(coinKind, coinCountValue);
	    }

        return coinCountValue;
    }


	// ・pickCoins 硬貨の種類と枚数を指定して取り出す.取り出した枚数を返す.
    public int pickCoins(String coinKind, int coinCount) {
    	int coinCountValue = 0;
    	int pickedCount = coinCount;

    	// 硬貨種類枚数領域を編集
	    if(coinKindCounts.containsKey(coinKind.toString())){
	        // すでに入っている枚数を算出する
	        int putedCoinCount = countCoins(coinKind);
	        // 入れる硬貨の枚数＜取り出す硬貨の枚数の場合、取り出せた硬貨の枚数を返す
	        if (putedCoinCount > coinCount ) {
	            coinCountValue = putedCoinCount - coinCount;
	        } else {
	            coinCountValue = 0;
	            pickedCount = putedCoinCount;
	        }
            coinKindCounts.replace(coinKind, coinCountValue);

	    } else {
	    	System.out.println("存在しない硬貨の種類を取り出しています.");
	    	return -1;
	    }
        // 取り出した枚数を返す
        return pickedCount;
    }

    // ・countCoins 2種類作る.
    //   1.硬貨の種類を指定する版: その硬貨が何枚入っているかを返す.
    //   2.硬貨の種類を指定しない版: 全体で何枚入っているかを返す.
    public int countCoins(String coinKind){

        // 硬貨種類枚数領域を編集
	    if(coinKindCounts.containsKey(coinKind)){
	    	return coinKindCounts.get(coinKind);
	    } else {
	    	System.out.println("存在しない硬貨の種類を指定しています.");
	    	return -1;
	    }
    }

    public int countCoins(){
    	int coinCountValue = 0;

	    Enumeration<String> keys = coinKindCounts.keys();
	    while(keys.hasMoreElements()) {
	        String key = (String) keys.nextElement();
	        coinCountValue += coinKindCounts.get(key);
	    }
	    return coinCountValue;
    }

    // ・getAmount 貯金箱全体の総額を返す.
    public int getAmount(){
    	int coinCountValue = 0;

	    Enumeration<String> keys = coinKindCounts.keys();
	    while(keys.hasMoreElements()) {
	        String key = (String) keys.nextElement();
	        coinCountValue += coinKindCounts.get(key) * Integer.parseInt(key);
	    }
	    return coinCountValue;
    }

    // ・isExactMatch この貯金箱に入っている各々の硬貨の枚数と、
    //       指定した貯金箱のそれが完全に一致する場合にtrueを返す.
    public boolean isExactMatch(CoinBank thatCoin){

        Enumeration<String> thiskeys = coinKindCounts.keys();
        Enumeration<String> thatkeys = thatCoin.coinKindCounts.keys();

        // この貯金箱を基準に比較
        while(thiskeys.hasMoreElements()) {
            String key = (String) thiskeys.nextElement();
            if (thatCoin.coinKindCounts.get(key) == null ||
                coinKindCounts.get(key) == null ||
                !(thatCoin.coinKindCounts.get(key).equals(coinKindCounts.get(key)))) {
                return false;
            }
        }

        // あの貯金箱を基準に比較
        while(thatkeys.hasMoreElements()) {
            String key = (String) thatkeys.nextElement();
            if (thatCoin.coinKindCounts.get(key) == null ||
                coinKindCounts.get(key) == null ||
                !(thatCoin.coinKindCounts.get(key).equals(coinKindCounts.get(key)))) {
                return false;
            }
        }

        return true;

    }


}
