import java.util.Scanner;

public class RPN {
  public static void main(String[] args) {

    // Creo un objeto para leer la entrada estandar
    Scanner sc = new Scanner(System.in);

    // Creo un objeto de mi clase PilaEnteros
    PilaEnteros pila = new PilaEnteros();

    while(sc.hasNext()){

      if(sc.hasNextInt()){ // Si el siguiente numero es un int...
        pila.push(sc.nextInt()); // ...lo guardo en mi pila

      }else{

        String operador = sc.next();

        if("=".equals(operador)){ // Si el operador es =, muestro resultado
          System.out.println(pila.top());
          pila.pop();

        }else{

          int op2 = pila.top(); // Guardo lo que tengo arriba de la pila
          pila.pop(); // Desapilo

          int op1 = pila.top();// Guardo lo que tengo arriba de la pila
          pila.pop(); // Desapilo

        switch(operador){ // Pongo el resultado de mi operacion en la pila
          case "+":
          pila.push(op1 + op2);
          break;

          case "-":
          pila.push(op1 - op2);
          break;

          case "*":
          pila.push(op1 * op2);
          break;

          case "/":
          pila.push(op1 / op2);
          break;

          case "^":
          int potencia = (int) Math.pow(op1, op2);
          pila.push(potencia);
          break;

        }
        }
      }
    }
    }
  }
