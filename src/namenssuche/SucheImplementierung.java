package namenssuche;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class SucheImplementierung  implements Suche{

    List<Name> namenListe;


    public SucheImplementierung() {

        namenListe = new ArrayList<>();

        namenListe.add(new Name("Gyögyi","Palatinus"));
        namenListe.add(new Name("Annisa Yustina","Puspakemala"));
        namenListe.add(new Name("Nexhmije","Nina"));
        namenListe.add(new Name("Eridho Buffery","Rollian"));
        namenListe.add(new Name("Cong Long Peter","Pham"));
        namenListe.add(new Name("Gyögyi2","Palatinus"));
        namenListe.add(new Name("Annisa Yustina","Puspakemala"));
        namenListe.add(new Name("Nexhmije","Nina"));
        namenListe.add(new Name("Eridho Buffery","Rollian"));
        namenListe.add(new Name("Cong Long Peter","Pham"));
    }



    @Override
    public String getVorname(String nachname) throws RemoteException {

        for(Name name : namenListe) {
            if(name.nachname.equals(nachname)) {
                return name.vorname;
            }

        }
        return ("Die Namenliste enthät keinen solchen Nachname.");
    }

    @Override
    public List<String> getVornamen(List<String> nachnamenListe) throws RemoteException {
        List<String> ergebnis = new ArrayList<>();
        if(nachnamenListe.size()>= 10) throw new IllegalArgumentException
                ("Die anzahl der Nachnamen darf nicht groesser als 10 sein.");
        for(String name : nachnamenListe) {
            ergebnis.add(getVorname(name));
        }
        try {
            Thread.sleep(3000); // Der Server gibt das Ergebnis 3 Min nach dem Client-Request zurück
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return ergebnis;
    }



    class Name{

        public String vorname;
        public String nachname;

        public Name(String vorname, String nachname) {

            this.vorname = vorname;
            this.nachname = nachname;
        }

    }
}
