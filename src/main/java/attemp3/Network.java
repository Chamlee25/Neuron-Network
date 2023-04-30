package attemp3;



public class Network {

    public Layer[] layers;
    public Layer lastLayer;

    public int layerCount = 3;
    public int neuronCount = 4;
    public int weightCount = 4;


    public Network(){
        layers = new Layer[layerCount];
        for(int i = 0; i<layerCount; i++){
            layers[i] = new Layer(neuronCount,weightCount);
        }
        lastLayer = new Layer(2,4);

    }

    public float[] testOutput(float[] inputs) throws IllegalArgumentException {
        float[] values = inputs;
        for(int i =0; i<layerCount; i++){
            values = layers[i].layerFeedForwardFromPrevious(values);
        }
        return lastLayer.layerFeedForwardFromPrevious(values);
    }

}
