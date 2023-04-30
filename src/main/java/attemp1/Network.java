package attemp1;

public class Network {
    public Layer[] layers;
    public Layer lastLayer;

    public int size = 20;

    public Network(){
        layers = new Layer[size];
        for(int i = 0; i<size; i++){
            layers[i] = new Layer(size,size);
        }
        lastLayer = new Layer(1,size);

    }


}
