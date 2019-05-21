public class Test {



  // Insertar



  public static void main(String[] args){
    //////////////////////////////////////////////////////////////////////////
    // Si una lista está vacía... ¿Qué pasa?
    String str = "lugar";
    Nodo<String> list = null;
    Nodo<String> rest;

    rest = list;
    list = new Nodo<String>(str);
    list.siguiente = rest;
    // Lo que pasa es que crearía la lista ["lugar" | null] y la asignaría a l
    //////////////////////////////////////////////////////////////////////////

    Nodo<String> l;
    Nodo<String> resto;
    String s;
    int i;
    int n = 0;
    boolean encontrado;

    // Crear una lista  vacía
    l = null;

    // Comprobar que l es vacía
    if (l == null){
      System.out.println("Vacía");
    }else{
      System.out.println("No vacía");
    }

    // Insertar s = lugar por el princpio de l
    s = "lugar";
    resto = l;
    l = new Nodo<String>(s);
    l.siguiente = resto;

    // Insertar s = un por el princpio
    s = "un";
    resto = l;
    l = new Nodo<String>(s);
    l.siguiente = resto;

    // TODO: más operaciones aquí

    System.out.println(l.longitud());

  }
}
