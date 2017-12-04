package esmbits.itsjavabasic.practices.brainteaser;

import java.util.Optional;
import java.util.stream.IntStream;

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

        IntStream.rangeClosed(1, 2 * size - 1)
            .mapToObj(i ->
                IntStream.rangeClosed(1, 2 * size - 1)
                    .mapToObj(j ->
                        Math.abs(size - i) + Math.abs(size - j) < size ? "*" : " ")
                    .reduce((j,k) -> j.concat(k)))
            .reduce((i,j) -> i.flatMap(i2 -> j.map(j2 -> i2.concat(System.getProperty("line.separator")).concat(j2))))
            .flatMap(i -> i)
            .ifPresent(i -> System.out.println(i));
    }
}
