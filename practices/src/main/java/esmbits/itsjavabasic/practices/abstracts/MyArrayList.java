package esmbits.itsjavabasic.practices.abstracts;

public class MyArrayList implements MyList {

	private String[] strArray = null;

    /**
     * 要素の数.
     */
	private int index = 0;

	public MyArrayList() {
		this.strArray = new String[5];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(String str) {
	    // インデクスが配列要素より大きい場合は、要素を5増やして置き換え
		if(index >= strArray.length) {
			String[] cloneArray = strArray.clone();
			strArray = new String[strArray.length + 5];
			for(int i = 0; i < cloneArray.length; i++) {
				strArray[i] = cloneArray[i];
			}
		}
		strArray[index] = str;
		index++;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public String get(int number) {

	    //指定された要素番号のデータを取得
	    String bufString = null;

	    // 要素の数より大きな番号が指定された場合、例外を送出
	    if (number >= index) {
	        throw new IndexOutOfBoundsException();
        }

	    if (this.strArray.length >= number) {
	        bufString = this.strArray[number];
	    }
	    return bufString;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public String remove(int number) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public int size() {
		return index;
	}

}
