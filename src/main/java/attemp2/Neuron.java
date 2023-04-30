package attemp2;

public class Neuron {
    public float[] weights;
    public float bias;


    public Neuron(float[] weights, float bias){
        this.weights = new float[weights.length];
        for(int i =0; i< weights.length; i++){
            this.weights[i] = weights[i];
        }
        this.bias = bias;
    }

    public float feedForward(float[] inputs) throws IllegalArgumentException {
        if(inputs.length != weights.length){
            throw new IllegalArgumentException("Neuron input array lenght must be " + weights.length + " but got " + inputs.length);
        }
        float sum =0f;
        for(int i =0; i<weights.length; i++){
            sum += weights[i]*inputs[i];
        }
        sum += bias;
        return  sigmoid(sum);
    }

    public static float sigmoid(float x){
        return (float) (1 / (1 + Math.exp(-x)));
    }

    public static float sigmoidDerivative(float x){
        float sigmoid = (float) (1 / (1 + Math.exp(-x)));
        return sigmoid * (1 - sigmoid);
    }

    public void updateWeightsUsingOneDelta(float delta, float learningRate, float[] prevOutputs) throws IllegalArgumentException {
        if(prevOutputs.length != weights.length){
            throw new IllegalArgumentException("Neuron input array lenght must be " + weights.length + " but got " + prevOutputs.length);
        }
        for(int i =0; i< weights.length; i++){
            weights[i] += delta*learningRate*prevOutputs[i];
        }
        bias += delta*learningRate;
    }
    public void updateWeights(float[] deltas, float learningRate, float[] prevOutputs, int numNeurons) throws IllegalArgumentException {
        if(prevOutputs.length != weights.length){
            throw new IllegalArgumentException("Neuron input array lenght must be " + weights.length + " but got " + prevOutputs.length);
        }
        for(int i = 0; i < numNeurons; i++) {
            float deltaSum = 0f;
            for(int j = 0; j < deltas.length; j++) {
                deltaSum += deltas[j] * weights[j];
            }
            weights[i] += deltaSum * learningRate * prevOutputs[i];
        }
    }




    public float[] getPrevLayerDeltas(float[] nextDeltas, float[] weights, int prevLayerSize) {
        float[] deltas = new float[prevLayerSize];
        for (int i = 0; i < prevLayerSize; i++) {
            float sum = 0f;
            for (int j = 0; j < nextDeltas.length; j++) {
                sum += nextDeltas[j] * weights[j * prevLayerSize + i];
            }
            deltas[i] = sum * sigmoidDerivative(sum);
        }
        return deltas;
    }




}
