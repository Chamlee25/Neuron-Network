package attemp3;

public class Neuron {

    public float[] weights;
    public float bias;

    public float[] inputs;

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
        this.inputs = inputs;
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

    public void updateLastNeuron(float delta, float learningRate){
        for(int i =0; i< weights.length; i++){
            weights[i] += delta*learningRate*inputs[i];
        }
        bias += delta*learningRate;
    }

    public void updateHiddenNeuron(){

    }







}
