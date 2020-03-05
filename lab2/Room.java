package lab2;

public class Room {


	private String nr;
	private String type;
	private int floor;
	
	public Room(String nr,String type, int floor)
	{
		this.nr = nr;
		this.type = type;
		this.floor = floor;
	}
	
	public void nrSetter(String nr)
	{
		this.nr = nr;
		
	}
	
	public void typeSetter(String nr)
	{
		this.type = nr;
	}
	
	public void floorSetter(int floor)
	{
		this.floor = floor;
		
	}
	
	public String nrGetter()
	{
		return this.nr;
	}
	
	public String typeGetter()
	{
		return this.type;
	}
	
	
	public int floorGetter()
	{
		return this.floor;
	}
	
	public void show()
	{
		System.out.println(this.nr);
		System.out.println(this.type);
		System.out.println(this.floor);
	}
	
}
