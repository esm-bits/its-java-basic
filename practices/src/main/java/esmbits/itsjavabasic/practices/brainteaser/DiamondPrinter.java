package esmbits.itsjavabasic.practices.brainteaser;

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
        //
        // 大きさ:4
        //    *
        //   ***
        //  *****
        // *******
        //  *****
        //   ***
        //    *

        int length = 5;
        int side = 2*(length - 1) + 1;

        //出力する配列
        String diamond[][] = new String[side][side];

        //空の箱を作る
        for(int i = 0; i < side; i++) {
            for(int j = 0; j < side; j++) {
                diamond[i][j] = " ";
            }
        }

        //ひし形の作成
        int start = length - 1; //スタート位置
        int amount = 1; //1列の数
        for(int i = 0; i < side; i++) {
            for (int j = start ;j < start + amount; j++ ) {
                diamond[i][j] = "*";
            }
            if (i < length - 1) {
                start--;
                amount = amount + 2;
            }
            else{
                start++;
                amount = amount - 2;
            }
        }
        
        //出力
        //1列出力
        for(int i = 0; i < side; i++) {
            for(int j = 0; j < side; j++) {
                System.out.print(diamond[i][j]);
            }
            if(i < side -1){
              //改行
                System.out.println();
            }
        }
    }
}
