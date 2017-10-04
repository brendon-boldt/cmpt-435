import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Fractionalknapsack {
	
	
	
	public static void sortitems(ArrayList<Item> svd)
	{
		// Sort items by value to size ratio in descending order
		Collections.sort(svd, new Comparator<Item>(){
		     public int compare(Item o1, Item o2){
		         if(o1.density == o2.density)
		             return 0;
		         return o1.density > o2.density ? -1 : 1;
		     }
		});
		
		
	}
	
	public static double greedyfractionalknapsack(ArrayList<Item> svd, int S){
		// Complete code here to maximize the value of items in the knapsack
		// Input: Note that items in list svd are SORTED by density ALREADY
		// For 'item', check out the item java class in the folder
		// Output: the value of the knapsack
		
		double value = 0.0;
		// Iterate through the sorted list of items
		for (Item item : svd) {
			// If there is no room left in the algorithm, stop adding items
			if (S <= 0.0)
				break;
			// If there is room, add the whole item; otherwise, add only as
			// much as there is space left in the knapsack
			value += item.value * 1.0*Math.min(S, item.size)/item.size;
			S -= item.size;
		}
		return value;
	}
	
	
	
	
	public static void main(String[] args) {
		int max_qty;  
      
        ArrayList<Item> items = new ArrayList<>();
		// item 1, value 6, size 1
        items.add(new Item(600,4,1));
		// item 2, value 10, size 2
		items.add(new Item(9,2,2));
		// item 3, value 12, size 3
		items.add(new Item(10,3,3));
		// the size of your knapsack
        max_qty=5;  
		// sort items by value to size ratio
		sortitems(items);
 
        System.out.println("The maximum value we can place into the knapsack is "+ greedyfractionalknapsack(items, max_qty));



}
	
	
}
