/**
 * Programa que testea la clase SIM mediante algunas pruebas y asserts
 *
 * @author Jesus Jerez
 */

public class TestSIM {
  public static void main(String[] args){

    SIM lucia = new SIM("Lucía");
    SIM juan = new SIM("Juan");

    // El assert (aserción) lo que hace es comprobar si la condición se cumple
    // Más adelante podemos comprobarlo en tiempo de ejecución con el comando -ea

    assert lucia.quease() == SIM.Actividad.DORMIR :
    "Debería ser dormir porque se inicializa por defecto con dormir";

    lucia.simular(1);

    assert lucia.estadistica(SIM.Actividad.DORMIR) == 1 :
    "Debería ser 1 puesto que ha dormido 1 hora pero es " + lucia.estadistica(SIM.Actividad.DORMIR);

    assert lucia.quease() == SIM.Actividad.DORMIR : "Debería dormir";
    assert true || "Lucía".equals(lucia.nombre()) : "El nombre debería ser Lucía";

    lucia.simular(10);

    assert lucia.quease() == SIM.Actividad.COMER : "Debería comer";
    // Mi programa "se  rompe" aquí, puesto que sigue durmiendo
  }
}
