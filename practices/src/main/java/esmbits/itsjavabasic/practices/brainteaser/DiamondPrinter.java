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
        if(args != null && args.length > 0) {
            try {
            print(Integer.valueOf(args[0]));
            }catch(Exception e){
            }
        }
    }

    private static void print(int size) {
        String str = "";
        for (int i = 1; i <= size * 2 - 1; i++) {
            for (int j = 1; j <= size * 2 - 1; j++) {
                if (Math.abs(size - i) + Math.abs(size - j) < size) {
                    str += "*";
                } else {
                    str += " ";
                }
            }
            str += System.getProperty("line.separator");
        }
        System.out.println(str);
    }
}
