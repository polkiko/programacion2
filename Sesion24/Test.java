class Test{
  public static void main (String[] args){

    Nodo<String> nuevo = new Nodo<String>(s);
    if (l == null) {
      l = nuevo;
    } else {
      Nodo<String> aux = l;
      while (aux.siguiente != null) {
        aux = aux.siguiente;
      }
        aux.siguiente = nuevo;
      }
  }
}
