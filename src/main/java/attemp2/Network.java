package attemp2;


import java.util.ArrayList;

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

    public float[] learnWithOutput(float[] inputs,float[] expectedOutput, float learningRate) throws IllegalArgumentException {
        ArrayList<float[]> outputs = new ArrayList<>();
        outputs.add(inputs);
        float[] values = inputs;
        for (int i = 0; i < layerCount; i++) {
            values = layers[i].layerFeedForwardFromPrevious(values);
            outputs.add(values);
        }
        float[] result = lastLayer.layerFeedForwardFromPrevious(values);
        float[] deltas = new float[expectedOutput.length];
        for(int i =0; i<expectedOutput.length; i++){
            deltas[i] = (result[i]-expectedOutput[i])*Neuron.sigmoidDerivative(expectedOutput[0]);
        }

        //poslední vrstva
        for(int i =0; i<lastLayer.neurons.length; i++){
            lastLayer.neurons[i].updateWeightsUsingOneDelta(deltas[i],learningRate,outputs.get(layerCount));
        }
        /*
        //připojení předoposlední vrstvy na poslední
        for(int i =0; i<layers[layerCount-1].neurons.length; i++){
            layers[layerCount-1].neurons[i].updateWeights(layers[layerCount-1].neurons[i].getPrevLayerDeltas(deltas,layers[layerCount-1].neurons[i].weights,2),learningRate,outputs.get(layerCount-1),layers[layerCount-1].neurons.length);
        }
        */


        return result;


    }


}