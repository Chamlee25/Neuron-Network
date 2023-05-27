package attemp4;

import Mnist.Mnist;
import Mnist.MnistLoader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Network net = new Network();
        MnistLoader ml = new MnistLoader();
        Mnist m = ml.getNextPictureData();
        double[] test = net.testOutput(m.data);
        for(int i =0; i<10; i++){
            System.out.println("Case "+ i + ": " + test[i]);
        }



    }
}
