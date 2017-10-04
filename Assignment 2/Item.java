
public class Item {
	public int id;
	public double value;
	public int size;
	public double density;
	
	
	public Item( double givenvalue, int givensize, int givenid)
	{
		id = givenid;
		
		size = givensize;
		
		value = givenvalue;
		
		density = value/size;
	}
	
}
