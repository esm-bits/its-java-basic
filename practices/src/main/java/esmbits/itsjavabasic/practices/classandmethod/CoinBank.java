package esmbits.itsjavabasic.practices.classandmethod;


/**
 * 貯金箱.
 */
public class CoinBank {

    // 貯金箱クラス(CoinBank)、そのテストクラス(CoinBankTest)を作る.
    // ・種類問わず全部で100枚まで入る

    // メソッド一覧
    // ・putCoins 硬貨の種類と枚数を指定して入れる.入った枚数を返す.
    // ・pickCoins 硬貨の種類と枚数を指定して取り出す.取り出した枚数を返す.
    // ・countCoins 2種類作る.
    //   1.硬貨の種類を指定する版: その硬貨が何枚入っているかを返す.
    //   2.硬貨の種類を指定しない版: 全体で何枚入っているかを返す.
    // ・getAmount 貯金箱全体の総額を返す.
    // ・isExactMatch この貯金箱に入っている各々の硬貨の枚数と、指定した貯金箱のそれが完全に一致する場合にtrueを返す.

    int TtlCnt001 = 0;
    int TtlCnt005 = 0;
    int TtlCnt010 = 0;
    int TtlCnt050 = 0;
    int TtlCnt100 = 0;
    int TtlCnt500 = 0;

    // ・putCoins 硬貨の種類と枚数を指定して入れる.入った枚数を返す.
    static int putCoins(CoinBank b,
                            int PutCnt001,
                            int PutCnt005,
                            int PutCnt010,
                            int PutCnt050,
                            int PutCnt100,
                            int PutCnt500){

        b.TtlCnt001 += PutCnt001;
        b.TtlCnt005 += PutCnt005;
        b.TtlCnt010 += PutCnt010;
        b.TtlCnt050 += PutCnt050;
        b.TtlCnt100 += PutCnt100;
        b.TtlCnt500 += PutCnt500;

        System.out.println("1円玉の枚数" + b.TtlCnt001);
        System.out.println("5円玉の枚数" + b.TtlCnt005);
        System.out.println("10円玉の枚数" + b.TtlCnt010);
        System.out.println("50円玉の枚数" + b.TtlCnt050);
        System.out.println("100円玉の枚数" + b.TtlCnt100);
        System.out.println("500円玉の枚数" + b.TtlCnt500);

        return PutCnt001 + PutCnt005 + PutCnt010 + PutCnt050 + PutCnt100 + PutCnt500;
    }

    // ・pickCoins 硬貨の種類と枚数を指定して取り出す.取り出した枚数を返す.
    static int pickCoins(CoinBank b,
                            int PickCnt001,
                            int PickCnt005,
                            int PickCnt010,
                            int PickCnt050,
                            int PickCnt100,
                            int PickCnt500){

        b.TtlCnt001    -= PickCnt001;
        b.TtlCnt005    -= PickCnt005;
        b.TtlCnt010    -= PickCnt010;
        b.TtlCnt050    -= PickCnt050;
        b.TtlCnt100    -= PickCnt100;
        b.TtlCnt500    -= PickCnt500;

        System.out.println("1円玉の枚数" + b.TtlCnt001);
        System.out.println("5円玉の枚数" + b.TtlCnt005);
        System.out.println("10円玉の枚数" + b.TtlCnt010);
        System.out.println("50円玉の枚数" + b.TtlCnt050);
        System.out.println("100円玉の枚数" + b.TtlCnt100);
        System.out.println("500円玉の枚数" + b.TtlCnt500);

        return PickCnt001 + PickCnt005 + PickCnt010 + PickCnt050 + PickCnt100 + PickCnt500;
    }

    // ・countCoins 2種類作る.
    //   1.硬貨の種類を指定する版: その硬貨が何枚入っているかを返す.
    static int countCoins(CoinBank b,int CoinType){

        int rtnCnt =0;

        switch (CoinType) {
            case 1:
                rtnCnt = b.TtlCnt001;break;
            case 5:
                rtnCnt = b.TtlCnt005;break;
            case 10:
                rtnCnt = b.TtlCnt010;break;
            case 50:
                rtnCnt = b.TtlCnt050;break;
            case 100:
                rtnCnt = b.TtlCnt100;break;
            case 500:
                rtnCnt = b.TtlCnt500;break;
        }
        return rtnCnt;
    }

    //   2.硬貨の種類を指定しない版: 全体で何枚入っているかを返す.
    static int countCoins(CoinBank b){

        return b.TtlCnt001 + b.TtlCnt005 + b.TtlCnt010 + b.TtlCnt050 + b.TtlCnt100 + b.TtlCnt500;
    }

    // ・getAmount 貯金箱全体の総額を返す.
    static long getAmount(CoinBank b){
        long Amount =0;
        Amount = b.TtlCnt001+(b.TtlCnt005*5)+(b.TtlCnt010*10)+(b.TtlCnt050*50)+(b.TtlCnt100*100)+(b.TtlCnt500*500);
        return Amount;
    }


    // ・isExactMatch この貯金箱に入っている各々の硬貨の枚数と、指定した貯金箱のそれが完全に一致する場合にtrueを返す.
    static boolean isExactMatch(CoinBank b,CoinBank b2){

        if(b.TtlCnt001 == b2.TtlCnt001 &&
                b.TtlCnt005 == b2.TtlCnt005 &&
                b.TtlCnt010 == b2.TtlCnt010 &&
                b.TtlCnt050 == b2.TtlCnt050 &&
                b.TtlCnt100 == b2.TtlCnt100 &&
                b.TtlCnt500 == b2.TtlCnt500)
        {
                return true;
        } else {
                return false;
        }
    }


    public static void main(String... args) {
        CoinBank bk = new CoinBank();
        CoinBank bk2 = new CoinBank();

        bk2.TtlCnt001 = 0;
        bk2.TtlCnt005 = 1;
        bk2.TtlCnt010 = 2;
        bk2.TtlCnt050 = 3;
        bk2.TtlCnt100 = 4;
        bk2.TtlCnt500 = 5;

        boolean chk = isExactMatch(bk,bk2);
        System.out.println("bkとbk2は等しいか" + chk);

        int a = putCoins(bk,1,2,3,4,5,6);
        System.out.println("コインを入れた枚数" + a);

        int b = pickCoins(bk,1,1,1,1,1,1);
        System.out.println("コインを取り出した枚数" + b);

        int c = countCoins(bk,100);
        System.out.println("100円玉の枚数" + c);

        int d = countCoins(bk);
        System.out.println("全体の枚数" + d);

        long e = getAmount(bk);
        System.out.println("貯金箱全体の総額" + e);

        boolean chk2 = isExactMatch(bk,bk2);
        System.out.println("bkとbk2は等しいか" + chk2);

    }

}