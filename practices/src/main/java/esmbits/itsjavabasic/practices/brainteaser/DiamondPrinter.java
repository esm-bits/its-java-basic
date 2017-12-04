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
        
        int stageCount = Integer.parseInt(args[0]);
        if(stageCount < 2) {
            java.lang.System.out.println("引数には、2以上の整数を指定ください。");
            System.exit(-1);
        }
        
        Diamond diamond = new Diamond();
        diamond.editDiamond(stageCount);
    }
    
    static class Diamond {
        Diamond() {
            
        }
        
        public void editDiamond(int a) {

            int n = calcLengthOneSide(a);
            String s = new String("");

            for (int i = 0; i < n; i++) {
                //出力文字列を初期化
                s = "";
                for (int j = 0; j < n; j++) {
                    //空白の数を算出する
                    int spaceCount = Math.abs((a - 1) - i);
                    
                    if(j < spaceCount) {
                        //前半の空白を出力する範囲
                        s = s + Constants.KINDS_OF_CHAR.SPACE;
                    } else if(j >= spaceCount && j < n - spaceCount) {
                        //描画文字を出力する範囲
                        s = s + Constants.KINDS_OF_CHAR.DRAW_CHAR;
                    } else {
                        //後半の空白を出力する範囲
                        s = s + Constants.KINDS_OF_CHAR.SPACE;
                    }
                }
                java.lang.System.out.println(s);
            }
        }
        
        // 図形の幅(高さ)を求める
        public int calcLengthOneSide(int b) {
            return 2*b-1;
        }        
    }
    
    //定数定義
    public static final class Constants {
        private Constants() {
        }
        public static class KINDS_OF_CHAR {
            public static final String SPACE = " ";
            public static final String DRAW_CHAR = "*";
        }
    }
}
