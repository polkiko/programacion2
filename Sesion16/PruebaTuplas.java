public class PruebaTuplas {

  public static void main(String[] args) {

    Tupla<Integer,Integer> t1 = new Tupla<Integer, Integer>(5,1);
    Tupla<Boolean,Boolean> t2 = new Tupla<Boolean, Boolean>(true, false);
    Tupla<String,String> t3 = new Tupla<String, String>("Ángel","Herranz");
    Tupla<String,Boolean> t4 = new Tupla<String, Boolean>("Ángel",true);

    assert t1.snd().equals(1);
    assert t2.fst();
    assert t3.snd().equals("Herranz");
    assert !t4.snd();

  }

}
