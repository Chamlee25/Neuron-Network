package attemp4;


import java.util.Random;

public class Layer {

    int weightSum;
    public Neuron[] neurons;

    public float[] deltas;
    public float[] outputs;
    static Random r = new Random();

    public Layer(int neuronSum, int weightSum){
        this.weightSum = weightSum;
        neurons = new Neuron[neuronSum];
        for(int i =0; i<neuronSum; i++){
            float[] weights = new float[weightSum];
            for(int j =0; j<weightSum; j++){
                weights[j] = r.nextFloat(-0.5f,0.5f);
            }
            neurons[i] = new Neuron(weights,r.nextFloat(0.1f,0.5f),this);
        }
        deltas = new float[neuronSum];
    }

    public float[] layerFeedForward(float[] inputs) throws IllegalArgumentException {
        if(inputs.length != neurons.length * weightSum){
            throw new IllegalArgumentException("Input array lenght must be " + neurons.length*weightSum + " but got " + inputs.length);
        }
        float[] output = new float[neurons.length];
        float[] neuronFood = new float[weightSum];
        for(int i =0; i< inputs.length; i+=weightSum){

            for(int j =0; j<weightSum; j++){
                neuronFood[j] = inputs[i+j];
            }
            output[i/weightSum] = neurons[i/weightSum].feedForward(neuronFood,true);
        }
        outputs = output;
        return output;

    }

}
