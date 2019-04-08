import java.util.Random;

public class Main {

    private static double testUF(UF uf,int m){
        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();

        for (int i=0;i<m;i++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a,b);
        }

        for (int i=0;i<m;i++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a,b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime)/1000000000.0;

    }

    public static void  main(String[] args){

        int size = 1000000;
        int m = 1000000;

//        UnionFindOne uf1 = new UnionFindOne(size);
//        System.out.println("UnionFindOne : "+testUF(uf1,m)+ " s");
//
//        UnionFindTwo uf2 = new UnionFindTwo(size);
//        System.out.println("UnionFindTwo : "+testUF(uf2,m)+" s");

        UnionFindThree uf3 = new UnionFindThree(size);
        System.out.println("UnionFindThree:  " + testUF(uf3,m)+" s");

        UnionFindFour uf4 = new UnionFindFour(size);
        System.out.println("UnionFindFour:  " + testUF(uf4,m)+" s");

        UnionFindFive uf5 = new UnionFindFive(size);
        System.out.println("UnionFindFive:  " + testUF(uf5,m)+" s");

        UnionFindSix uf6 = new UnionFindSix(size);
        System.out.println("UnionFindSix:  " + testUF(uf6,m)+" s");
    }
}
