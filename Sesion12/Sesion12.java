import java.util.Locale;
import org.joda.time.DateTime;
import org.joda.time.Seconds;

public class Sesion12 {
  public static void main(String args[]) {
    DateTime ahora = new DateTime();
    DateTime nuevo = ahora.plusYears(1).withDayOfYear(1).withTime(0,0,0,0);
    System.out.println(Seconds.secondsBetween(ahora, nuevo).getSeconds());
    System.out.println(ahora.monthOfYear().getAsText(new Locale("en")));
    System.out.println(ahora.monthOfYear().getAsText(new Locale("es")));
  }
}
