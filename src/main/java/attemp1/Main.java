package attemp1;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {

        Network NeuronNetwork = new Network();
        System.out.println("Neuron network created.");
        System.out.println("Number of layers: " + NeuronNetwork.layers.length);
        System.out.println("Number of total neurons: " + (int) (Math.pow(NeuronNetwork.size,2)+1) );

        Random r = new Random();
        float[] inputs = new float[NeuronNetwork.size*NeuronNetwork.size];
        for(int i =0; i<NeuronNetwork.layers.length* NeuronNetwork.size; i++){
            inputs[i] = r.nextFloat(-1,1);
        }

        float[] value = NeuronNetwork.layers[0].layerThink(inputs);
        for(int i =1; i<NeuronNetwork.layers.length; i++){
            value = NeuronNetwork.layers[i].layerThinkFromPreviousLayerInput(value);
        }
        float[] result = NeuronNetwork.lastLayer.layerThink(value);
        System.out.println("Final result of neuron network counting is: " + result[0] +".");
        System.out.println("This is just a number counted by last neuron, output could be represented in many ways.");


    }
}