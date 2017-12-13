package namenssuche;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


/* Suche extend Remote, um die Klasse Suche von remote aufrufbar sein zu werden
 *
 */
public interface Suche extends Remote {

    String getVorname(String nachname) throws RemoteException;
    List<String> getVornamen(List<String> nachnamen) throws RemoteException;


}
