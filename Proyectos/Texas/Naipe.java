/**
 * La clase Naipe representa una carta de la baraja francesa, compuesta
 * por un total de 52 cartas, organizadas en 4 palos y 13 valores.
 *
 * @author Jesus Jerez
 */

public class Naipe {

  public enum Palo {
    CORAZONES, DIAMANTES, PALOS, PICAS;
  }

  public enum Valor {
    AS, REY, DAMA, VALET, DIEZ, NUEVE, OCHO, SIETE, SEIS, CINCO, CUATRO, TRES, DOS;
  }

  private Palo palo;
  private Valor valor;

  private Naipe(){
  }

  public Naipe(Palo p, Valor v){
    palo = p;
    valor = v;
  }

}
