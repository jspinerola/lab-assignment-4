import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int TIME = 30;
        Queue<Integer> processes = new LinkedList<Integer>();
        Random rand = new Random();
        int process;

        for (int i = 0; i < 50; i++) {
            processes.add(rand.nextInt(1, 6));
        }

/*      Test Cases:
        processes.add(1);
        processes.add(1);
        processes.add(2);
        processes.add(2);
        processes.add(1);
        processes.add(5);
        processes.add(4);
        processes.add(3);
        processes.add(2);
*/

        int[][] resources = {{0, 0},{0, 0},{0, 0}};

        for (int i = 0; i < TIME; i++) {
            System.out.println("");
            boolean hasTransferred = false;

            for (int j = 0; j < resources.length; j++) { //loop through each resource
                if(resources[j][1] == 1){
                    resources[j][0]--;
                    System.out.println("Current Process in resource " + j + " has "+ resources[j][0] +" processing time left");
                }

                while(!hasTransferred){
                    if(resources[j][1] == 0){
                        process = processes.remove();
                        resources[j][0] = process;
                        System.out.println("Transferring process with processing time of "+ process +" to resource " + j + "");
                        resources[j][1] = 1;
                        hasTransferred = true;
                    } else {
                        break;
                    }
                }

                if (resources[j][0] == 0){
                    resources[j][1] = 0;
                }
            }
        }
    }
}