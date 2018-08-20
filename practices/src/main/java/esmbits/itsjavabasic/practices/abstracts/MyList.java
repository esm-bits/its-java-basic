package esmbits.itsjavabasic.practices.abstracts;

public interface MyList {

    // (1) 以下のメソッドを持つMyListインタフェースを作って下さい
    //    1. add(String)
    //      リストの最後に指定された文字列を追加する
    //    2. get(int)
    //      指定された位置にある文字列を返す
    //    3. remove(int)
    //      指定された位置にある文字列を削除し、その文字列を返す
    //    4. size()
    //      リスト内にある文字列の数を返す
    //
    // (2) MyListインタフェースを実装する
    //     MyArrayListとMyLinkedListを実装して下さい
    //
    // (3) 2つの実装クラスを両方ともMyListとして扱う任意のコードを書いて下さい
    //     例えば、2つの実装クラス間の性能の違いを確認する、など


    /**
     * リストの最後に指定された文字列を追加する
     * @param str 文字列
     */
    public void add(String str);

    /**
     * 指定された位置にある文字列を返す
     * @param number 位置
     * @return 文字列
     */
    public String get(int number);

    /**
     * 指定された位置にある文字列を削除し、その文字列を返す
     * @param number 位置
     * @return 削除された文字列
     */
    public String remove(int number);

    /**
     * リスト内にある文字列の数を返す
     * @return 文字列の数
     */
    public int size();
}
