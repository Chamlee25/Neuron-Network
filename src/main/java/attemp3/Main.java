package attemp3;


import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Network net = new Network(3,28,28,10,28);
        MnistLoader ml = new MnistLoader();
        Mnist m;
        float[] result;
        for(int i =0; i<1000; i++){
            m = ml.getNextPictureData();
            result = net.learnWithOutput(m.data, m.actualValue,0.01f);
            if(i%10==0){
                System.out.println(m.actualvalue);
                for(int j =0; j< result.length;j++){
                    System.out.println(j+ ": " +result[j]+"%");
                }
            }
        }










    }
}
