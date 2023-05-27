package attemp4;



public class Network {

    public Layer[] layers;





    public Network() {

        layers = new Layer[3];


        layers[0] = new Layer(28*28,1);
        layers[1] = new Layer(256, 28*28);
        layers[2] = new Layer(10,256);
    }

    public double[] testOutput(double[] input){
        double[] first = layers[0].layerFeedForward(input,false);
        double[] hidden = layers[1].layerFeedForwardFromPrevious(first,true);
        double[] last = layers[2].layerFeedForwardFromPrevious(hidden,false);
        last = Neuron.softmax(last);
        return last;
    }


}
