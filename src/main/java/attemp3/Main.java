package attemp3;



public class Main {
    public static void main(String[] args){
        Network n = new Network();
        float[] input = {0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f};
        float[] expectedOutput = {0f,1f};
        float[] firstOutput = n.learnWithOutput(input,expectedOutput,0.01f);
        for(int i =0; i<1000; i++){
            n.learnWithOutput(input,expectedOutput,0.01f);
        }
        float[] thirdOutput = n.testOutput(input);
        System.out.print("First case:\n0: " +firstOutput[0] + "%\n1: " +firstOutput[1] +"%\n");

        System.out.print("Second case:\n0: " +thirdOutput[0] + "%\n1: " +thirdOutput[1] + "%");
    }
}
