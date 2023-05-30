package attemp4;



public class Neuron {

    public double[] weights;
    public double bias;
    public double[] inputs;

    public Layer currentLayer;


    public Neuron(double[] weights, double bias, Layer currentLayer) {
        this.weights = new double[weights.length];
        for (int i = 0; i < weights.length; i++) {
            this.weights[i] = weights[i];
        }
        this.bias = bias;
        this.currentLayer = currentLayer;
    }

    public double feedForward(double[] inputs, boolean activate) throws IllegalArgumentException {
        if (inputs.length != weights.length) {
            throw new IllegalArgumentException("Neuron input array lenght must be " + weights.length + " but got " + inputs.length);
        }
        this.inputs = inputs;
        double sum = 0f;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i] * inputs[i];
        }
        sum += bias;
        if(activate){
            return relu(sum);
        }
        return sum;



    }

    public void updateLastNeuron(double delta, double learningRate){
        for(int i =0; i< weights.length; i++){
            weights[i] += delta*learningRate*inputs[i];
        }
        bias += delta*learningRate;
    }





    public static double relu(double x) {
        return Math.max(0f, x);
    }

    public static double[] softmax(double[] input) {
        double[] output = new double[input.length];
        double sum = 0.0f;

        // Výpočet exponentů a sumy exponentů
        for (int i = 0; i < input.length; i++) {
            output[i] = (double) Math.exp(input[i]);
            sum += output[i];
        }

        // Normalizace na pravděpodobnosti
        for (int i = 0; i < output.length; i++) {
            output[i] /= sum;
        }

        return output;
    }

    public static double[] softmaxDerivative(double[] softmaxOutput) {
        int N = softmaxOutput.length;
        double[] derivative = new double[N];

        for (int i = 0; i < N; i++) {
            double sumExp = 0.0;
            for (int j = 0; j < N; j++) {
                sumExp += Math.exp(softmaxOutput[j]);
            }
            double softmax_i = Math.exp(softmaxOutput[i]) / sumExp;

            derivative[i] = softmax_i * (1 - softmax_i);
        }

        return derivative;
    }


    public static double reluDerivative(double x) {
        return x > 0f ? 1f : 0f;
    }
}


