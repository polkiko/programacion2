import java.util.Scanner;

public class Sesion10 {
  public static void main(String[] args) {

    // Creo un objeto para leer la entrada estandar
    Scanner sc = new Scanner(System.in);

    int[] pila = new int[100]; // Como es un array de enteros, se inicializa todo a 0
    int fin = -1;

    while(sc.hasNext()){
      if(sc.hasNextInt()){
        pila[fin + 1] = sc.nextInt();
        fin++;
      }else{

        String operador = sc.next();

        switch(operador){
          case "+":
          pila[fin-1] = pila[fin-1] + pila[fin];
          fin--;
          break;

          case "-":
          pila[fin-1] = pila[fin-1] - pila[fin];
          fin--;
          break;

          case "*":
          pila[fin-1] = pila[fin-1] * pila[fin];
          fin--;
          break;

          case "/":
          pila[fin-1] = pila[fin-1] / pila[fin];
          fin--;
          break;

          case "^":
          pila[fin-1] = (int) Math.pow(pila[fin-1], pila[fin]);
          fin--;
          break;

          case "=":
          System.out.println(pila[fin]);
          fin--;
          break;
        }
      }
    }
  }
}
