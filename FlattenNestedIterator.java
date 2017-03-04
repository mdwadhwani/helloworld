/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
   
    private Stack<NestedInteger> stack;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        if(nestedList !=null)
        {
            stack = new Stack<NestedInteger>();
            for(int i= nestedList.size() -1 ; i > -1 ; i--)
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty())
        {
            NestedInteger val = stack.peek(); // b'c its just a check if there are more elements
            if(val.isInteger())
            {
                return true; 
            }
       
            //else val is a nestedInteger with multiple integers
            val = stack.pop(); // take out the NestedInteger
            List<NestedInteger> internalList = val.getList(); 
            for(int i = internalList.size() -1 ; i > -1 ; i--)
            {
                stack.push(internalList.get(i));
            }
        }
        return false;
    }  
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */