package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * An implementation of a Searcher that performs an iterative search, storing
 * the list of next states in a Stack. This results in a depth-first search.
 * 
 */
public class StackBasedDepthFirstSearcher<T> extends Searcher<T> {

	/**
	 * StackBasedDepthFirstSearcher.
	 * 
	 * @param searchProblem : search problem
	 */
	public StackBasedDepthFirstSearcher(SearchProblem<T> searchProblem) {
		super(searchProblem);
	}

	@Override
	public List<T> findSolution() {
		// TODO
		List<T> path = new ArrayList<>();
		Stack<T> searchStack = new Stack<T>();
		visited.add(searchStack.push(searchProblem.getInitialState()));
		while (!searchStack.isEmpty()) {
			visited.add(searchStack.peek());
			if (searchProblem.isGoal(searchStack.peek())) {
				while (!searchStack.isEmpty()) {
					path.add(0, searchStack.pop());
				}
				return path;
			}

			List<T> nextSearch = searchProblem.getSuccessors(searchStack.peek());
			if (nextSearch.isEmpty()) {
				searchStack.pop();
			} else {
				int count = 0;
				for (int i = 0; i < nextSearch.size(); i++) {
					if (!visited.contains(nextSearch.get(i))) {
						searchStack.push(nextSearch.get(i));
						break;
					}
					count++;
				}
				if (count == nextSearch.size()) {
					searchStack.pop();
				}
			}
		}
		while (!searchStack.isEmpty()) {
			path.add(0, searchStack.pop());
		}
		return path;
	}
}
