package attemp1;

import java.util.Random;

public class Layer {
    int weightSum;
    public Neuron[] neurons;
    static Random r = new Random();

    public Layer(int neuronSum, int weightSum){
        this.weightSum = weightSum;
        neurons = new Neuron[neuronSum];
        for(int i =0; i<neuronSum; i++){
            float[] weights = new float[weightSum];
            for(int j =0; j<weightSum; j++){
                weights[j] = r.nextFloat(-0.5f,0.5f);
            }
            neurons[i] = new Neuron(weights,r.nextFloat(0.1f,0.5f));
        }
    }

    public float[] layerThink(float[] inputs) throws Exception {
        if(inputs.length != neurons.length * weightSum){
            throw new Exception();
        }
        float[] output = new float[neurons.length];
        float[] neuronFood = new float[weightSum];
        for(int i =0; i< inputs.length; i+=weightSum){

            for(int j =0; j<weightSum; j++){
                neuronFood[j] = inputs[i+j];
            }
            output[i/weightSum] = neurons[i/weightSum].think(neuronFood);
        }
        return output;

    }

    public float[] layerThinkFromPreviousLayerInput(float[] inputs) throws Exception {
        float[] output = new float[inputs.length*weightSum];
        for(int i =0; i<weightSum; i++){
            for(int j =0; j< inputs.length; j++){
                output[i+j] = inputs[j];
            }
        }
        return layerThink(output);
    }
}
