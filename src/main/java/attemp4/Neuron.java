package attemp4;



public class Neuron {

    public float[] weights;
    public float bias;
    public float[] inputs;

    public Layer currentLayer;


    public Neuron(float[] weights, float bias, Layer currentLayer) {
        this.weights = new float[weights.length];
        for (int i = 0; i < weights.length; i++) {
            this.weights[i] = weights[i];
        }
        this.bias = bias;
        this.currentLayer = currentLayer;
    }

    public float feedForward(float[] inputs, boolean activate) throws IllegalArgumentException {
        if (inputs.length != weights.length) {
            throw new IllegalArgumentException("Neuron input array lenght must be " + weights.length + " but got " + inputs.length);
        }
        this.inputs = inputs;
        float sum = 0f;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i] * inputs[i];
        }
        sum += bias;
        if(activate){
            return relu(sum);
        }
        return sum;



    }

    public void updateLastNeuron(float delta, float learningRate){
        for(int i =0; i< weights.length; i++){
            weights[i] += delta*learningRate*inputs[i];
        }
        bias += delta*learningRate;
    }





    private static float relu(float x) {
        return Math.max(0f, x);
    }

    private static double[] softmax(double[] input) {
        double[] output = new double[input.length];
        double sum = 0.0;

        // Výpočet exponentů a sumy exponentů
        for (int i = 0; i < input.length; i++) {
            output[i] = Math.exp(input[i]);
            sum += output[i];
        }

        // Normalizace na pravděpodobnosti
        for (int i = 0; i < output.length; i++) {
            output[i] /= sum;
        }

        return output;
    }


    public static float reluDerivative(float x) {
        return x > 0f ? 1f : 0f;
    }
}


