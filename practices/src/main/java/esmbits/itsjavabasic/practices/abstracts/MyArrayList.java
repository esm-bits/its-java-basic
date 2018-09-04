package esmbits.itsjavabasic.practices.abstracts;

public class MyArrayList implements MyList {

	private String[] strArray = null;

	private int index = 0;

	public MyArrayList() {
	    // TODO Addしていない配列に空文字が入る？
		this.strArray = new String[5];
	}

	@Override
	public void add(String str) {
	    // インデクスが配列要素より大きい場合は、要素を5増やして置き換え
		if(index > strArray.length) {
			String[] cloneArray = strArray.clone();
			strArray = new String[strArray.length + 5];
			for(int i = 0; i < cloneArray.length; i++) {
				strArray[i] = cloneArray[i];
			}
		}
		strArray[index] = str;
		index++;
	}

	@Override
	public String get(int number) {
	    //TODO

	    //指定された要素番号のデータを取得
	    String bufString = null;

	    if (this.strArray.length >= number) {
	        bufString = this.strArray[number];
	    }
	    return bufString;
	}

	@Override
	public String remove(int number) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public int size() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

}
