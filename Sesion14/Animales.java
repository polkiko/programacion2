public class Animales{
  public static void main(String[] args){
    Mamifero m = new Mamifero();
    m.hablar();

    Perro p = new Perro();
    p.hablar();
    p.ladrar();

    Gato g = new Gato();
    g.hablar();
    g.ladrar();

    // Jacva es un lenguaje que hace dynamic dipsathc, no mira la variable sino el objeto
  }
}
