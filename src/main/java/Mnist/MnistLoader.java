package Mnist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MnistLoader {
    BufferedReader br;
    String line;


    public MnistLoader() throws IOException {
        br = new BufferedReader(new FileReader("D:\\programming\\java\\Neural Network\\Neuron-Network\\src\\main\\resources\\mnist_train.csv"));
        line = br.readLine(); // skip header line
    }
    public Mnist getNextPictureData() throws IOException {
        if((line = br.readLine()) != null){
            String[] values = line.split(",");
            int actualValue = Integer.parseInt(values[0]);
            double[] data = new double[values.length - 1];
            for (int i = 1; i < values.length; i++) {
                data[i - 1] = Double.parseDouble(values[i]);
            }
            return new Mnist(data,actualValue);
        }
        return new Mnist();
    }


}



