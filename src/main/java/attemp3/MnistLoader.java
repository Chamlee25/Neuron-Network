package attemp3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
            float[] data = new float[values.length - 1];
            for (int i = 1; i < values.length; i++) {
                data[i - 1] = Float.parseFloat(values[i]);
            }
            return new Mnist(data,actualValue);
        }
        return new Mnist();
    }


}



class Mnist{
    public float[] data;
    public float[] actualValue;
    public int actualvalue;
    public boolean empty;


    public Mnist(float[] data, int actualValue) {
        this.data = data;
        this.actualValue = new float[]{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f};
        this.actualValue[actualValue] = (float) actualValue;
        this.actualvalue = actualValue;
        empty =false;
    }

    public Mnist(){
        empty =true;
    }

}
