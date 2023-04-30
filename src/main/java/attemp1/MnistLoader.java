package attemp1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MnistLoader {

    BufferedReader br;


    public MnistLoader() throws IOException {
        br = new BufferedReader(new FileReader("D:\\programming\\java\\Neural Network\\src\\main\\resources\\mnist_test.csv"));
        String line = br.readLine(); // skip header line
    }
/*
    public float[] getNextPictureData(){

    }*/
}
