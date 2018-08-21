package esmbits.itsjavabasic.practices.abstracts;

public class MyArrayList implements MyList {

	private String[] strArray = null;

	private int index = 0;

	public MyArrayList() {
		this.strArray = new String[5];
	}

	@Override
	public void add(String str) {
		// TODO 自動生成されたメソッド・スタブ
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
		// TODO 自動生成されたメソッド・スタブ
		return null;
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
