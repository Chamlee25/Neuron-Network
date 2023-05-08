package attemp3;



public class Network {

    public Layer[] layers;
    public Layer lastLayer;

    public int layerCount;
    public int neuronCount;
    public int weightCount;


    public Network(int layerCount, int neuronCount, int weightCount, int lastLayerNeuronSum, int lastLayerWeightSum) {
        this.layerCount = layerCount;
        this.neuronCount = neuronCount;
        this.weightCount = weightCount;
        layers = new Layer[layerCount];
        for(int i = 0; i<layerCount; i++){
            layers[i] = new Layer(neuronCount,weightCount);
        }
        lastLayer = new Layer(lastLayerNeuronSum,lastLayerWeightSum);
    }

    public float[] testOutput(float[] inputs,boolean smallInputMode) throws IllegalArgumentException {
        if(smallInputMode){
            float[] values = inputs;
            for(int i =0; i<layerCount; i++){
                values = layers[i].layerFeedForwardFromPrevious(values);
            }
            return lastLayer.layerFeedForwardFromPrevious(values);
        }else{
            float[] values = layers[0].layerFeedForward(inputs);
            for(int i =1; i<layerCount; i++){
                values = layers[i].layerFeedForwardFromPrevious(values);
            }
            return lastLayer.layerFeedForwardFromPrevious(values);
        }

    }

    public float[] learnWithOutput(float[] inputs,float[] expectedOutput, float learningRate) throws IllegalArgumentException {
        float[] values = layers[0].layerFeedForward(inputs);

        for (int i = 1; i < layerCount; i++) {
            values = layers[i].layerFeedForwardFromPrevious(values);
        }
        float[] result = lastLayer.layerFeedForwardFromPrevious(values);
        float[] deltas = new float[expectedOutput.length];
        for(int i =0; i<expectedOutput.length; i++){
            deltas[i] = (expectedOutput[i]-result[i])* Neuron.sigmoidDerivative(expectedOutput[0]);
        }
        lastLayer.deltas = deltas;

        //poslední vrstva
        for(int i =0; i<lastLayer.neurons.length; i++){
            lastLayer.neurons[i].updateLastNeuron(deltas[i],learningRate);
        }
        /*
        //předposlední vrstva
        for(int i=0; i<layers[layerCount-1].neurons.length;i++){
            layers[layerCount-1].neurons[i].updateHiddenNeuron(lastLayer,learningRate,i);
        }
        for(int i =0; i<layerCount-1;i++){
            for(int j =0; j<layers[i].neurons.length;j++){
                layers[i].neurons[j].updateHiddenNeuron(layers[i+1],learningRate,j);
            }
        }
        */
        return result;


    }



}
