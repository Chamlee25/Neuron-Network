package attemp3;


import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Network net = new Network(3,28,28,10,28);
        MnistLoader ml = new MnistLoader();
        Mnist m;
        float[] result;
        for(int i =0; i< 1000; i++){
            m = ml.getNextPictureData();
            if(i%100==0 || i%100==1){
                result = net.learnWithOutput(m.data,m.actualValue,0.01f);
                System.out.println("Case: " + i +" should be:" + m.actualvalue);
                for(int j =0; j<result.length; j++){
                    System.out.println(j+": " +result[j]);
                }

            }else{
                net.learnWithOutput(m.data,m.actualValue,0.01f);
            }
        }






        /*
        //test učení NEMAZAT!!!!!!!!!!!!!!!!!!!!
        float[] beforeLearning = net.learnWithOutput(m.data,m.actualValue,0.01f);
        float[] afterLearning = net.testOutput(m.data,false);
        for(int i =0; i< beforeLearning.length; i++){
            System.out.println(i+": " + beforeLearning[i]);
        }
        System.out.print("\n" + m.actualvalue + "\n");
        for(int i =0; i< afterLearning.length; i++){
            System.out.println(i+": " + afterLearning[i]);
        }

        System.out.println("\n"+Arrays.equals(beforeLearning,afterLearning));
        */












    }
}
