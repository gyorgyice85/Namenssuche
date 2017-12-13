package namenssuche;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        try {

            //Damit erreichen wir das Server an der lokale Host
            Registry registry = LocateRegistry.getRegistry("localhost");

            Suche suche = (Suche)registry.lookup("suche"); // suche bekommt als Wert ein Suche Objekt

            List<String> nachnameListe = new ArrayList<>();
            nachnameListe.add("Farago");
            nachnameListe.add("Rollian");
            nachnameListe.add("Nina");

            for(String vorname :suche.getVornamen(nachnameListe)) {
              System.out.println(vorname);
            }


        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

 /* LocateRegistry wird verwendet, um einen Verweis auf eine Remote-Objektregistrierung
  * auf einem bestimmten Host (einschließlich des lokalen Hosts) abzurufen oder
  * um eine Remote-Objektregistrierung zu erstellen, die Aufrufe an einem bestimmten Port akzeptiert.
  */

 /* getRegistry gibt einen Verweis auf die Registry des Remote-Objekts auf dem angegebenen
  * Host im Default-Port 1099 zurück. Wenn Host null ist, wird der lokale Host verwendet.
  */

  /* lookup sucht nach dem Remotereferenz mit den angegebenen Namen in dieser Registrierung
   * und gibt die Remotereferenz zurück.(Return: Remote)
   * Remote ist ein Objekt, deren Methoden von remote erreichbar sind.
   */