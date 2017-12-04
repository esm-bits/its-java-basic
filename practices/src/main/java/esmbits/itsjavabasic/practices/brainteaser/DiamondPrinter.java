package esmbits.itsjavabasic.practices.brainteaser;

public class DiamondPrinter {
    
    /**
     * 1行あたりのダイアモンド（*）を返却します。
     * 
     * 1行あたりの構成
     * range + (maxWidth - 2*range) + range ( = maxWidth)
     * 
     * @param size 大きさ
     * @param maxWidth 1行あたりの幅（呼び出し側で計算する）
     * @param current 現在の行
     * @return String
     */
    private static String getRow(int size, int maxWidth ,int current) {
        StringBuilder row = new StringBuilder("");
        
        // 中心からどれだけ離れているかを計算
        int range = Math.abs(size - current);

        for(int i = 0; i < maxWidth; i++) {
            if(i < range) {
                // 左側空白
                row.append(" ");
            } else if(i >= (maxWidth - range)) {
                // 右側空白
                row.append(" ");
            } else {
                row.append("*");
            }
        }
        
        return row.append("\n").toString(); // 末尾に改行をつけて返却
    }

    public static void main(String... args) {

        // コンソールにひし形(◆)を出力する.
        // 大きさは任意に変えられるようにする.
        //
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
        // 大きさ:4
        //     *
        //    ***
        //   *****
        //  *******
        //   *****
        //    ***
        //     *
        int size = Integer.parseInt(args[0]);
        if(size < 2) throw new IndexOutOfBoundsException("sizeには2以上の数値を指定してください。");

        int maxWidth = 2 * size - 1;
        int maxHeight = 2 * size - 1;
        
        StringBuilder result = new StringBuilder("");
        
        for(int i = 1; i <= maxHeight; i++) {
          result.append( getRow(size, maxWidth, i) );
        }
        
        System.out.println(result);
    }
}
