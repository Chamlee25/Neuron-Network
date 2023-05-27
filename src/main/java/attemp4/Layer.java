package attemp4;


import java.util.Random;

public class Layer {

    int weightSum;
    public Neuron[] neurons;

    public double[] deltas;
    public double[] outputs;
    static Random r = new Random();

    public Layer(int neuronSum, int weightSum){
        this.weightSum = weightSum;
        neurons = new Neuron[neuronSum];
        for(int i =0; i<neuronSum; i++){
            double[] weights = new double[weightSum];
            for(int j =0; j<weightSum; j++){
                weights[j] = r.nextdouble(-0.5f,0.5f);
            }
            neurons[i] = new Neuron(weights,r.nextdouble(0.1f,0.5f),this);
        }
        deltas = new double[neuronSum];
    }

    public double[] layerFeedForward(double[] inputs, boolean activate) throws IllegalArgumentException {
        if(inputs.length != neurons.length * weightSum){
            throw new IllegalArgumentException("Input array lenght must be " + neurons.length*weightSum + " but got " + inputs.length);
        }
        double[] output = new double[neurons.length];
        double[] neuronFood = new double[weightSum];
        for(int i =0; i< inputs.length; i+=weightSum){

            for(int j =0; j<weightSum; j++){
                neuronFood[j] = inputs[i+j];
            }
            output[i/weightSum] = neurons[i/weightSum].feedForward(neuronFood,activate);
        }
        outputs = output;
        return output;

    }
    public double[] layerFeedForwardFromPrevious(double[] inputs,boolean activate) throws IllegalArgumentException {
        double[] output = new double[neurons.length*weightSum];
        for(int i =0; i<weightSum; i++){
            for(int j =0; j< neurons.length; j++){
                output[i+j] = inputs[j];
            }
        }
        return layerFeedForward(output,activate);
    }

}
