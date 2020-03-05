package lab2;

public class Person{

	private String name;
	private String surname;
	private String age;
	private long id;
	private String type;
	
	public Person(String name, String surname, String age, long id, String type)
	{
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.id = id;
		this.type = type;
	
	}
	
	public void nameSetter(String name) {
		this.name = name;
	}
	
	public void surnameSetter(String name) {
		this.surname = name;
	}
	
	public void  ageSetter(String age) {
		this.age = age;
	}
	
	public void idSetter(long id) {
		this.id = id;
	}
	
	public void typeSetter(String type) {
		this.type = type;
	}
	
	public String nameGetter()
	{
		return this.name;
	}
	
	public String surnameGetter()
	{
		return this.surname;
	}
	
	public String ageGetter()
	{
		return this.age;
	}
	
	public long idGetter()
	{
		return this.id;
	}
	
	public String typeGetter()
	{
		return this.type;
	}
	
	public void show()
	{
		System.out.println(nameGetter());
		System.out.println(surnameGetter());
		System.out.println(ageGetter());
		System.out.println(idGetter());
		System.out.println(typeGetter());
	}
	
	
	
	
}
