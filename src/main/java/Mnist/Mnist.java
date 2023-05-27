package Mnist;

public class Mnist {
    public double[] data;
    public double[] actualValue;
    public int actualvalue;
    public boolean empty;


    public Mnist(double[] data, int actualValue) {
        this.data = data;
        this.actualValue = new double[]{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f};
        this.actualValue[actualValue] = (double) actualValue;
        this.actualvalue = actualValue;
        empty = false;
    }

    public Mnist() {
        empty = true;
    }

}
