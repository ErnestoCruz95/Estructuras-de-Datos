package Stacks;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("Testing array reversing");
		int[] inputArray = {1, 2, 3, 4, 5};
		
		// TODO: push every item in inputArray into a Stack
		
		int[] outputArray = new int[inputArray.length];
		
		Stack<Integer> inputStak = new Stack<Integer>();
		for (int i = 0; i < inputArray.length; i++) {
			inputStak.push(inputArray[i]);
		}
		
		// TODO: pop every item in inputArray and save them in outputArray
		
		for (int i = 0; i < outputArray.length; i++) {
			outputArray[i]=inputStak.pop();
		}
		
		System.out.println("Input: " + Arrays.toString(inputArray));
		System.out.println("Output: " + Arrays.toString(outputArray));
		System.out.println();
		
		System.out.println("Testing train ordering");
		Stack<Integer> train = new Stack<Integer>();
		train.push(3);
		train.push(2);
		train.push(1);
		train.push(3);
		train.push(2);
		
		System.out.println("Train as it arrived to the station: " + Arrays.toString(train.toArray()));
		
		// TODO: sort the wagons in priority order
		
		Stack<Integer> holdingTrackOne= new Stack<Integer>();
		Stack<Integer> holdingTrackTwo= new Stack<Integer>();
		//Stack<Integer> outputTrack = new Stack<Integer>();
		Stack<Integer> finalTrain = new Stack<Integer>();
		
/*		while(!train.empty()) {
			
			switch (train.peek()) {
			case 1:
				outputTrack.push(train.pop());
				break;

			case 2:
				holdingTrackOne.push(train.pop());
				break;
		
			case 3:
				holdingTrackTwo.push(train.pop());
				break;
			}
			
		}
		
		while (!holdingTrackOne.empty()) {
			outputTrack.push(holdingTrackOne.pop());
			
		}
		
		while (!holdingTrackTwo.empty()) {
			outputTrack.push(holdingTrackTwo.pop());
			
		}
		
		while (!outputTrack.empty()) {
			train.push(outputTrack.pop());
			
		}*/
		
		while(!train.empty()) {
			
			switch (train.peek()) {
			case 1:
				holdingTrackOne.push(train.pop());
				break;

			case 2:
				holdingTrackTwo.push(train.pop());
				break;
		
			case 3:
				finalTrain.push(train.pop());
				break;
			}
			
		}
		
		while (!holdingTrackTwo.empty()) {
			finalTrain.push(holdingTrackTwo.pop());
			
		}
		
		while (!holdingTrackOne.empty()) {
			finalTrain.push(holdingTrackOne.pop());
			
		}
		
		
		System.out.println("Train ordered by priority: " + Arrays.toString(finalTrain.toArray()));
		//System.out.println("Train ordered by priority: " + Arrays.toString(train.toArray()));
		System.out.println();
		
		Stack<Integer> towerOne = new Stack<Integer>();
		Stack<Integer> towerTwo = new Stack<Integer>();
		Stack<Integer> towerThree = new Stack<Integer>();
		
		towerOne.push(3);
		towerOne.push(2);
		towerOne.push(1);
		
		System.out.println("At the beginning");
		System.out.println("Hanoi tower #1: " + Arrays.toString(towerOne.toArray()));
		System.out.println("Hanoi tower #2: " + Arrays.toString(towerTwo.toArray()));
		System.out.println("Hanoi tower #3: " + Arrays.toString(towerThree.toArray()));
		
		// TODO: run a simulation so that towerTwo ends with all discs in correct order.
		
		
		towerTwo.push(towerOne.pop());
		towerThree.push(towerOne.pop());
		towerThree.push(towerTwo.pop());
		towerTwo.push(towerOne.pop());
		towerOne.push(towerThree.pop());
		towerTwo.push(towerThree.pop());
		towerTwo.push(towerOne.pop());
		
		
		
		System.out.println("At the end");
		System.out.println("Hanoi tower #1: " + Arrays.toString(towerOne.toArray()));
		System.out.println("Hanoi tower #2: " + Arrays.toString(towerTwo.toArray()));
		System.out.println("Hanoi tower #3: " + Arrays.toString(towerThree.toArray()));
		System.out.println();
	}
}
