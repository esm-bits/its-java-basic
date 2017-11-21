package esmbits.itsjavabasic.practices.brainteaser;

public class DiamondPrinter {
    
    private static String getRow(int size, int maxWidth ,int current) {
        StringBuilder row = new StringBuilder("");
//        int range = size - current;
        for(int i = 0; i < maxWidth; i++) {
            row.append("*");
        }
        return row.append("\n").toString();
    }

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
        // 大きさ:4
        //     *
        //    ***
        //   *****
        //  *******
        // *********
        //  *******
        //   *****
        //    ***
        //     *
        int size = Integer.parseInt(args[0]);
        if(size < 2) throw new IndexOutOfBoundsException("sizeには2以上の数値を指定してください。");

        int maxWidth = 2 * size - 1;
        int maxHeight = 2 * size - 1;
        
        StringBuilder result = new StringBuilder("");
        
        for(int i = 0; i < maxHeight; i++) {
          result.append( getRow(size, maxWidth, i) );
        }
        
        System.out.println(result);
    }
}
