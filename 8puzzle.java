package puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import search.SearchProblem;
import search.Solver;

/**
 * A class to represent an instance of the eight-puzzle. The spaces in an
 * 8-puzzle are indexed as follows: 0 | 1 | 2 --+---+--- 3 | 4 | 5 --+---+--- 6
 * | 7 | 8 The puzzle contains the eight numbers 1-8, and an empty space. If we
 * represent the empty space as 0, then the puzzle is solved when the values in
 * the puzzle are as follows: 1 | 2 | 3 --+---+--- 4 | 5 | 6 --+---+--- 7 | 8 |
 * 0 That is, when the space at index 0 contains value 1, the space at index 1
 * contains value 2, and so on. From any given state, you can swap the empty
 * space with a space adjacent to it (that is, above, below, left, or right of
 * it, without wrapping around). For example, if the empty space is at index 2,
 * you may swap it with the value at index 1 or 5, but not any other index. Only
 * half of all possible puzzle states are solvable! See:
 * https://en.wikipedia.org/wiki/15_puzzle for details.
 * 
 * 
 * @author liberato
 *
 */
public class EightPuzzle implements SearchProblem<List<Integer>> {
	public List<Integer> startingValues;

	/**
	 * Creates a new instance of the 8 puzzle with the given starting values. The
	 * values are indexed as described above, and should contain exactly the nine
	 * integers from 0 to 8.
	 * 
	 * @param startingValues the starting values, 0 -- 8
	 * @throws IllegalArgumentException if startingValues is invalid
	 */
	public EightPuzzle(List<Integer> startingValues) {
		if (startingValues.size() != 9) {
			throw new IllegalArgumentException("starting values size is not 9");
		}
		for (int i = 0; i < 9; i++) {
			if (!startingValues.contains(i)) {
				throw new IllegalArgumentException("value that is not from 0 - 8 inside starting values");
			}
		}
		this.startingValues = new ArrayList<Integer>(startingValues);
	}

	@Override
	public List<Integer> getInitialState() {
		// TODO
		return startingValues;
	}

	@Override
	public List<List<Integer>> getSuccessors(List<Integer> currentState) {
		// TODO
		List<List<Integer>> successors = new ArrayList<>();
		int blankindex = currentState.indexOf(0);

		if (blankindex == 0) {
			List<Integer> listOne = new ArrayList<>(currentState);
			Collections.swap(listOne, blankindex, 1);
			successors.add(listOne);
			List<Integer> listTwo = new ArrayList<>(currentState);
			Collections.swap(listTwo, blankindex, 3);
			successors.add(listTwo);
		} else if (blankindex == 1) {
			List<Integer> listOne = new ArrayList<>(currentState);
			Collections.swap(listOne, blankindex, 0);
			successors.add(listOne);
			List<Integer> listTwo = new ArrayList<>(currentState);
			Collections.swap(listTwo, blankindex, 2);
			successors.add(listTwo);
			List<Integer> listThree = new ArrayList<>(currentState);
			Collections.swap(listThree, blankindex, 4);
			successors.add(listThree);
		} else if (blankindex == 2) {
			List<Integer> listOne = new ArrayList<>(currentState);
			Collections.swap(listOne, blankindex, 1);
			successors.add(listOne);
			List<Integer> listTwo = new ArrayList<>(currentState);
			Collections.swap(listTwo, blankindex, 5);
			successors.add(listTwo);
		} else if (blankindex == 3) {
			List<Integer> listOne = new ArrayList<>(currentState);
			Collections.swap(listOne, blankindex, 0);
			successors.add(listOne);
			List<Integer> listTwo = new ArrayList<>(currentState);
			Collections.swap(listTwo, blankindex, 4);
			successors.add(listTwo);
			List<Integer> listThree = new ArrayList<>(currentState);
			Collections.swap(listThree, blankindex, 6);
			successors.add(listThree);
		} else if (blankindex == 4) {
			List<Integer> listOne = new ArrayList<>(currentState);
			Collections.swap(listOne, blankindex, 1);
			successors.add(listOne);
			List<Integer> listTwo = new ArrayList<>(currentState);
			Collections.swap(listTwo, blankindex, 3);
			successors.add(listTwo);
			List<Integer> listThree = new ArrayList<>(currentState);
			Collections.swap(listThree, blankindex, 5);
			successors.add(listThree);
			List<Integer> listFour = new ArrayList<>(currentState);
			Collections.swap(listFour, blankindex, 7);
			successors.add(listFour);
		} else if (blankindex == 5) {
			List<Integer> listOne = new ArrayList<>(currentState);
			Collections.swap(listOne, blankindex, 2);
			successors.add(listOne);
			List<Integer> listTwo = new ArrayList<>(currentState);
			Collections.swap(listTwo, blankindex, 4);
			successors.add(listTwo);
			List<Integer> listThree = new ArrayList<>(currentState);
			Collections.swap(listThree, blankindex, 8);
			successors.add(listThree);
		} else if (blankindex == 6) {
			List<Integer> listOne = new ArrayList<>(currentState);
			Collections.swap(listOne, blankindex, 3);
			successors.add(listOne);
			List<Integer> listTwo = new ArrayList<>(currentState);
			Collections.swap(listTwo, blankindex, 7);
			successors.add(listTwo);
		} else if (blankindex == 7) {
			List<Integer> listOne = new ArrayList<>(currentState);
			Collections.swap(listOne, blankindex, 4);
			successors.add(listOne);
			List<Integer> listTwo = new ArrayList<>(currentState);
			Collections.swap(listTwo, blankindex, 6);
			successors.add(listTwo);
			List<Integer> listThree = new ArrayList<>(currentState);
			Collections.swap(listThree, blankindex, 8);
			successors.add(listThree);
		} else if (blankindex == 8) {
			List<Integer> listOne = new ArrayList<>(currentState);
			Collections.swap(listOne, blankindex, 5);
			successors.add(listOne);
			List<Integer> listTwo = new ArrayList<>(currentState);
			Collections.swap(listTwo, blankindex, 7);
			successors.add(listTwo);
		}
		return successors;
	}

	@Override
	public boolean isGoal(List<Integer> state) {
		// TODO
		if (state.get(state.size() - 1) != 0) {
			return false;
		}
		for (int i = 2; i < state.size() - 1; i++) {
			if (!(state.get(i) > state.get(i - 1))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * supporting man method.
	 */
	public static void main(String[] args) {
		EightPuzzle e = new EightPuzzle(Arrays.asList(new Integer[] { 1, 2, 3, 4, 0, 6, 7, 5, 8 }));

		List<List<Integer>> r = new Solver<List<Integer>>(e).solveWithBFS();
		for (List<Integer> l : r) {
			System.out.println(l);
		}
	}
}
