import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Lab_Assignment_4_Julian_Spindola {
    public static void main(String[] args) {
        final int TIME = 30;
        Queue<Integer> processes = new LinkedList<Integer>();
        Random rand = new Random();
        int process;

        for (int i = 0; i < 50; i++) {
            processes.add(rand.nextInt(1, 6)); //Create queue of processes with random value 1-5
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
        //Processing unit/resource. {Process processing time, 0 = doesn't have process - 1 = has process}
        int[][] resources = {{0, 0},{0, 0},{0, 0}};

        for (int i = 0; i < TIME; i++) { //for each time unit
            boolean hasTransferred = false; //initialize hasTransferred variable to false

            for (int j = 0; j < resources.length; j++) { //Loop through each Processing unit/resource
                if(resources[j][1] == 1){ //If resources has a process
                    resources[j][0]--; //decrement processing time
                    System.out.println("Current Process in resource " + j + " has "+ resources[j][0] +" processing time left");
                }

                while(!hasTransferred){ //While hasTransferred is false
                    if(resources[j][1] == 0){ //if resource doesn't have a process
                        process = processes.remove(); //Initialize process variable to next process in queue
                        resources[j][0] = process; //assign process to the resource
                        System.out.println("Transferring process with processing time of "+ process +" to resource " + j + "");
                        resources[j][1] = 1; //set resource to have a process
                        hasTransferred = true; //Assign hasTransferred to true.
                    } else { //If transfer has occurred
                        break; //Don't initialize loop, break.
                    }
                }

                if (resources[j][0] == 0){ //If a resource's processing time is 0
                    resources[j][1] = 0; //Set resource to not have a process.
                }
            }
            System.out.println("");
        }
    }
}