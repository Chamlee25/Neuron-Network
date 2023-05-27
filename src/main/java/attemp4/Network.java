package attemp4;



public class Network {

    public Layer[] layers;
    public Layer lastLayer;




    public Network() {

        layers = new Layer[3];

        layers[0] = new Layer(28*28,1);
        layers[1] = new Layer(256, 28*28);
        lastLayer = new Layer(10,256);
    }


}
