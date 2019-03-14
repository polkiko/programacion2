class TestRacional{
	public static void main(String[] args) {
		Racional r1;
		r1 = new Racional(2,6);
		
		Racional r2;
		r2 = new Racional(1,3);
		
		r1.sum(r2);
		System.out.println(r1);
	}
}