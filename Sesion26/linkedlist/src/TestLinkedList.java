import list.LinkedList;
import list.ListInterface;

public class TestLinkedList {

  public static void main(String[] args) {
    ListInterface<Integer> list1 = new LinkedList<Integer>();

    list1.add(0, 1);
    list1.add(1, 3);
    list1.add(2, 5);
    list1.add(3, 7);	
    assert list1.toString().equals("[ 1, 3, 5, 7 ]");
    assert list1.indexOf(5) == 2;

    list1.remove(5);
    assert list1.indexOf(5) == -1;
    
    assert list1.toString().equals("[ 1, 3, 7 ]");

    list1.removeElementAt(1);
    assert list1.toString().equals("[ 1, 7 ]");

    ListInterface<Integer> list2 = new LinkedList<Integer>();
    list2.add(0, 1);
    list2.add(1, 3);
    list2.add(2, 5);
    list2.add(3, 7);
    assert !list1.equals(list2);
    assert !list2.equals(list1);
    
    list2.removeElementAt(1);
    list2.removeElementAt(1);
    assert list1.equals(list2);
    assert list2.equals(list1);
    
    final int N = 10;
    LinkedList<String> list3 = new LinkedList<String>();
    String dato;
    assert list3.size() == 0;
    for (int i = 1; i < N; i++) {
      dato = "Dato-"+i;
      list3.add(list3.size(), dato);
      assert list3.size() == i;
      assert list3.get(i-1).equals(dato);
    }
    dato = "Dato-"+N;
    list3.add(list3.size(), dato);
    assert list3.size() == N;
    
    for (int i = 0; i < N; i++) {
      dato = "Dato-"+(i+1);
      assert list3.get(i).equals(dato);
    }
    
    dato = "Dato-0";
    list3.add(0,dato);
    assert list3.size() == N + 1;
    assert list3.get(0).equals(dato);

    dato = "Dato-raro";
    list3.add(N/2,dato);
    assert list3.size() == N + 2;
    assert list3.get(N/2).equals(dato);

    list3.remove(dato);
    assert list3.size() == N + 1;
    assert list3.get(N/2).equals("Dato-"+(N/2));

    dato = "Dato-raro";
    list3.set(N/2, dato);
    assert list3.size() == N + 1;
    assert list3.get(N/2).equals(dato);
    
    dato = "Dato-raro";
    list3.removeElementAt(N/2);
    assert list3.size() == N;
    
    assert list3.indexOf(dato) == -1;

    dato = "Dato-"+(N/3);
    assert list3.indexOf(dato) == N/3;
    
    dato = "Dato-Zero";
    list3.set(0,dato);
    assert list3.get(0).equals(dato);
    
    dato = "Dato-Max";
    list3.set(list3.size() - 1, dato);
    assert list3.get(list3.size() - 1).equals(dato);
    
    list3.removeElementAt(0);
    list3.removeElementAt(list3.size() -1);
    assert list3.size() == N - 2;
    
    try {
      list3.removeElementAt(-1);
      assert false;
    }
    catch (IndexOutOfBoundsException e) {
    }
    
    try {
      list3.removeElementAt(list3.size());
      assert false;
    }
    catch (IndexOutOfBoundsException e) {
    }
    
    try {
      list3.add(-1, "");
      assert false;
    }
    catch (IndexOutOfBoundsException e) {
    }
    
    try {
      list3.add(list3.size() + 1, "");
      assert false;
    }
    catch (IndexOutOfBoundsException e) {
    }
    
    try {
      list3.get(-1);
      assert false;
    }
    catch (IndexOutOfBoundsException e) {
    }
    
    try {
      list3.get(list3.size());
      assert false;
    }
    catch (IndexOutOfBoundsException e) {
    }    
  }
}
