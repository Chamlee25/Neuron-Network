package attemp4;

import Mnist.Mnist;
import Mnist.MnistLoader;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Network net = new Network();
        MnistLoader ml = new MnistLoader();
        Mnist m;
        /*
        double[] test = net.testOutput(m.data);
        for(int i =0; i<10; i++){
            System.out.println("Case "+ i + ": " + String.format("%.15f",test[i]));
        }
        System.out.println(m.actualvalue);
        net.learn(m.data,m.actualValue,0.01);
        double[] test2 = net.testOutput(m.data);
        for(int i =0; i<10; i++){
            System.out.println("Case "+ i + ": " + String.format("%.15f",test2[i]));
        }
        */
        for(int i =0; i<60000; i++){
            m = ml.getNextPictureData();
            net.learn(m.data,m.actualValue,0.001);
            if(i%2000==0){
                double[] x = net.testOutput(m.data);
                for(int j =0; j<10; j++){
                    System.out.println("Case "+ i + ": " + String.format("%.15f",x[j]));
                }
                System.out.println(m.actualvalue);
            }
        }






    }
}
