package attemp1;

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

    public float think(float[] inputs) throws Exception {
        if(inputs.length != weights.length){
            throw new Exception();
        }
        float sum =0f;
        for(int i =0; i<weights.length; i++){
            sum += weights[i]*inputs[i];
        }
        sum += bias;
        return  (float) (1f / (1f +Math.exp(-sum)));
    }


}
