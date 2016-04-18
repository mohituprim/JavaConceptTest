
public class ThisEx {

	int member1;
	int member2;
	int member3;
	public ThisEx(int member1, int member2) {
		
		//using this to refer current class instance variable
		this.member1 = member1;
		this.member2 = member2;
	}
	
	public ThisEx(int member1, int member2, int member3) {
		
		//using this to reuse and invoke the current class constructor
		this(member1, member2);
		this.member3 =  member3;
	}

}
