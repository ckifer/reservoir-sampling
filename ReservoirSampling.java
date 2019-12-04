import java.util.Arrays; 
import java.util.Random; 

public class ReservoirSampling  
{ 
    // reservoir sampling is taking in a stream of numbers with a capacity K that 
    static int[] selectSamples(int stream[], int n, int k) 
    { 
        // define i 
        int i;  
          
        // array that is the reservoir with length of k (number of items allowed in reservoir)
        int reservoir[] = new int[k]; 
        // add the first k items of the stream into the reservoir
        for (i = 0; i < k; i++) 
            reservoir[i] = stream[i]; 
        
        // :O
        Random r = new Random(); 
        
        // switch out 'random' indexes if the value of j is an index in the reservoir
        // i will start at k (4) and 'maybe' swap items out until i is the length of the stream (12)
        for (; i < n; i++) 
        { 
            // 'random' value between current 0 and i (4)
            int j = r.nextInt(i); 
              
            // If the index is smaller than k (the length of the reservoir), 
            // then replace the element present at the index with element i from the stream
            if(j < k) 
                reservoir[j] = stream[i];             
        } 
        return reservoir;
    } 

    // simply use random generator to generate a 'random' list of 
    // streamLength ints from 0 to 100 to be the stream input
    public static int[] generateStream(int streamLength) {
        Random random = new Random();
        int[] arr = new int[streamLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(101);
        }
        return arr;
    }
      
    
    public static void main(String[] args) {
        // length of stream
        int n = 12;

        // stream of 'random' ints
        int stream[] = generateStream(n); 

        // print out input
        System.out.println("'Randomly' generated input: " + Arrays.toString(stream));

        // number of samples to choose from stream
        int k = 4;

        int[] reservoir = new int[k];
        // get random selection 5 times
        for(int i = 0; i < 5; i++){
            reservoir = selectSamples(stream, n, k); 

            System.out.println("These are 'randomly' selected items: "); 
            System.out.println(Arrays.toString(reservoir));
        }
    } 
}