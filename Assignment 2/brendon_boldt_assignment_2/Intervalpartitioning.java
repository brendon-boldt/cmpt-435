import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Intervalpartitioning {

	public static int greedyPartitioning(ArrayList<Interval> llist){
		
		ArrayList<Room> rooms = new ArrayList<>();
		
		// Complete the code here to schedule n lectures to classrooms and minimize the number of classrooms used
		// input: llist is a list of lectures
		// note that the input list of lectures are SORTED by starting time ALREADY
		// every lecture has a starting time and ending time
		// output: the number of classrooms used
		// In case you need to SORT CLASSROOMS by ending time of last lecture added in ascending order, call method sortrooms(ArrayList<room> roomlist)
		
		if (llist.isEmpty())
			return 0;
		
		rooms.add(new Room());
		rooms.get(0).intervals = new ArrayList<Interval>();
		// Add the first lecture to the first room
		rooms.get(0).intervals.add(llist.get(0));
		// Iterate through the rest of the lectures in order to assign them to rooms
		for (int i = 1; i < llist.size(); ++i) {
			boolean scheduled = false;
			// Find a suitable room for the lecture
			// Note that this iteration is done instead of sorting
			for (int j = 0; j < rooms.size(); ++j) {
				Room room = rooms.get(j);
				// Add the lecture to the room if it starts after the previous lecture ended
				if (llist.get(i).start >= room.intervals.get(room.intervals.size()-1).end) {
					room.intervals.add(llist.get(i));
					scheduled = true;
					break;
				}
			}
			// If no room was found for the lecture, create a new room
			if (!scheduled) {
				rooms.add(new Room());
				rooms.get(rooms.size()-1).intervals = new ArrayList<Interval>();
				rooms.get(rooms.size()-1).intervals.add(llist.get(i));
			}
		}
		
		
		// After scheduling, print out lectures scheduled in each classroom
		for (int i=0;i < rooms.size(); i++) {
			System.out.println("Room "+ i+" :");
			for(int j = 0; j < rooms.get(i).intervals.size(); j++) {
				System.out.print(" (" + rooms.get(i).intervals.get(j).start + ", " + rooms.get(i).intervals.get(j).end + ")");
			}
			System.out.println();
		}
		
		// Return the number of rooms used
		return rooms.size();
	}
	
	
	
	public static void sortrooms(ArrayList<Room> roomlist) // Sort rooms in a list by ending time of last lecture added in ascending order
	{
		
		Collections.sort(roomlist, new Comparator<Room>(){
		    
			public int compare(Room r1, Room r2){
		         if(r1.intervals.get(r1.intervals.size()-1).end == r2.intervals.get(r2.intervals.size()-1).end)
		             return 0;
		         return r1.intervals.get(r1.intervals.size()-1).end < r2.intervals.get(r2.intervals.size()-1).end ? -1 : 1;
		     }
		});
		
		
	}
	
	
	public static void sortintervals(ArrayList<Interval> llist) // Sort lectures by starting time in ascending order
	{
		
		Collections.sort(llist, new Comparator<Interval>(){
		     public int compare(Interval o1, Interval o2){
		         if(o1.start == o2.start)
		             return 0;
		         return o1.start < o2.start ? -1 : 1;
		     }
		});
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create a list of lectures
		ArrayList<Interval> intervallist = new ArrayList<>();
		// Lecture 1 starts at time 0, and finishes at time 6
		intervallist.add(new Interval(0,6));
		// Lecture 2 starts at time 1, and finishes at time 4
		intervallist.add(new Interval(1,4));
		intervallist.add(new Interval(3,5));
		intervallist.add(new Interval(3,8));
		intervallist.add(new Interval(4,7));
		intervallist.add(new Interval(5,9));
		intervallist.add(new Interval(6,10));
		intervallist.add(new Interval(8,11));
		
		// Sort lectures by starting time in increasing order
		sortintervals(intervallist);
		
		for(int i = 0; i < intervallist.size(); i++)
		{
			// Confirm that the list is sorted by starting time
//			System.out.println(i+"_th interval's starting time: "+intervallist.get(i).start);
		}
		
		System.out.println("The number of classrooms we need is "+ greedyPartitioning(intervallist));
		
		
		
	}

}

