package namenssuche;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


// Startet den Java-RMI-Server
public class Launcher {
    public static void main(String[] args) {

        try {
            SucheImplementierung sucheImpl = new SucheImplementierung();
            Suche sucheServerStub = (Suche) UnicastRemoteObject.exportObject(sucheImpl, 0);

            Registry registry = LocateRegistry.createRegistry(1099); //Default port
            registry.bind("suche", sucheServerStub);

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}

 /* UnicastRemoteObject.exportObject(sucheImpl, 0) wandelt das Objekt sucheImpl so um,
  * um das von remote aufrufbar sein zu werden
  * /

 /* createRegistry erstellt einen Java-RMI-Registry Server auf dem lokalen Host,
  * die Requests für den angegebenen Port akzeptiert.
  */

 // bind: Bindet (speichert) das sucheServerStub Objekt mit den angegebenen Namen in diesem Registry.

