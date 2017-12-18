package esmbits.itsjavabasic.practices.brainteaser;

import java.util.ArrayList;
import java.util.Collections;

public class DiamondPrinter {

    public static void main(String... args) {

        // コンソールにひし形(◆)を出力する.
        // 大きさは任意に変えられるようにする.

        // 大きさ:2
        //  *
        // ***
        //  *
        //
        // 大きさ:3
        //   *
        //  ***
        // *****
        //  ***
        //   *



        // 大きさ未設定のため、エラー
        if ((args == null) || (args.length == 0)) {
            System.out.println("大きさが未設定です。");
        }
        for (String s : args) {
            try {
                int i = Integer.parseInt(s);
                // 大きさが"1"以下はひし形を作成できないため、エラー
                if (i < 2) {
                    System.out.println("ひし形ができない大きさです。（大きさ = " + s +"）");
                }
                // 大きさ分のひし形を出力
                print(i);
            } catch (NumberFormatException nfex) {
                // 大きさが数字ではないため、エラー
                System.out.println("大きさが数字ではありません。（大きさ = " + s + "）");
            }

        }
    }


    /*
     *  指定された大きさのひし形を出力する
     *
     *  @param size 大きさ
     */
    private static void print(int size) {

        /** アスタリスク */
        final String asterisk = "*";
        /** 空白 */
        final String blank = " ";

        // １行の文字列（昇順リスト）
        ArrayList<String> listAsc = new ArrayList<String>();
        // １行の文字列（逆順リスト）
        ArrayList<String> listDsc = new ArrayList<String>();

        for (int line = 1; line <= size; line++) {
            // asterisk出力数
            int aNum = (line * 2) - 1;
            // blank出力数
            int bNum = Math.abs(line - size);
            // １行の文字列を組み立て
            listAsc.add(String.join("", Collections.nCopies(bNum, blank))
                      + String.join("", Collections.nCopies(aNum, asterisk))
                      + String.join("", Collections.nCopies(bNum, blank)));
        }

        // 昇順リストを出力
        for (String list : listAsc) {
            System.out.println(list);
        }

        // 昇順リストを逆順リストに変換
        Collections.reverse(listAsc);
        listDsc.addAll(listAsc);
        listDsc.remove(0);  // １要素目は既に出力済（重複）のため削除

        // 逆順リストを出力
        for (String list : listDsc) {
            System.out.println(list);
        }
    }
}
