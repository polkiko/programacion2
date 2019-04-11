import acotados.Lista;
import acotados.ListaAcotada;

public class TestsListaAcotada {

  public static void main(String[] args) {

    final int N = 10;
    Lista<String> l = new ListaAcotada<String>(N);

    // Asserts de Herranz
    assert l.size() == 0 : "La lista debería estar vacía al crearla";
    assert !l.isFull() : "La lista no debería estar llena  al crearla";

    // Asserts test
    l.add(0, "Hola"); // Añado "Hola" en la posición 0
    assert "Hola".equals(l.get(0)) : "Lo que hay en la posición 0 debería ser 'Hola'";

    assert l.indexOf("Hola") == 0 : "El índice al buscar 'Hola' debería ser 0";

    assert l.remove("Hola") == true : "Debería devolver true, al encontrar Hola";
    // Por lo tanto, ahora en la posición 0 debería haber null, puesto que hemos hecho remove
    assert l.get(0) == null : "Debería devolver null, pues lo hemos borrado";

    // Ahora puedo añadir un nuevo elemento en la posicón 0, 1 y 2...
    l.add(0, "Preguntarse cuándo los ordenadores podrán pensar es como preguntarse cuándo los submarinos podrán nadar");
    l.add(1, "Si la depuración es el proceso de eliminar errores, entonces la programación debe ser el proceso de introducirlos");
    l.add(2, "El software es como el sexo: mejor si es libre y gratis");

    // ¿Pero qué ocurre si añado un elemento nuevo en la posición 1?
    l.add(1, "Hay sólo dos clases de lenguajes de programación: aquellos de los que la gente está siempre quejándose y aquellos que nadie usa");
    // Lo que debe ocurrir es que todo se desplace una posición, de manera que...
    assert (l.get(0)).equals("Preguntarse cuándo los ordenadores podrán pensar es como preguntarse cuándo los submarinos podrán nadar") :
                            "Lo que hay en la posicion 0 debería ser 'Preguntarse cuándo...', pero hay '" + l.get(0) + "'";
    assert (l.get(1)).equals("Hay sólo dos clases de lenguajes de programación: aquellos de los que la gente está siempre quejándose y aquellos que nadie usa") :
                            "Lo que hay en la posicion 1 debería ser 'Hay solo...', pero hay '" + l.get(1) + "'";
    assert (l.get(2)).equals("Si la depuración es el proceso de eliminar errores, entonces la programación debe ser el proceso de introducirlos") :
                            "Lo que hay en la posicion 2 debería ser 'Si la depuración...', pero hay '" + l.get(2) + "'";
    assert (l.get(3)).equals("El software es como el sexo: mejor si es libre y gratis") :
                            "Lo que hay en la posicion 3 debería ser 'El software...', pero hay '" + l.get(3) + "'";

  }

}
