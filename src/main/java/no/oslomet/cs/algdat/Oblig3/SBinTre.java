package no.oslomet.cs.algdat.Oblig3;


import java.lang.reflect.Array;
import java.util.*;

public class SBinTre<T> {
    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public SBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        //Avgjør om en verdi ligger i treet eller ikke
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    //Oppgave 1

    public boolean leggInn(T verdi) {
        //Programkode fra 5.2.3 a)
        //Sjekke at referansen "forelder" får korrekt verdi
        Objects.requireNonNull(verdi, "Ulovlig med nullverdier :')");

        Node<T> p = rot, q = null;
        int cmp = 0;

        while (p != null){
            q = p;
            cmp = comp.compare(verdi, p.verdi);
            p = cmp < 0 ? p.venstre : p.høyre;
        }

        p = new Node<> (verdi, q);

        if (q == null) {
            rot = p;
        }
        else if (cmp < 0) {
            q.venstre = p;
        }
        else {
            q.høyre = p;
        }

        antall ++;
        return true;
    }

    //Oppgave 6

    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");

        if(verdi == null) return false;
        Node<T> p = rot;
        Node<T> q = null;

        while(p != null){
            int cmp = comp.compare(verdi, p.verdi);
            if(cmp < 0){
                q = p;
                p = p.venstre;
            } else if (cmp > 0) {
                q = p;
                p = p.høyre;
            } else break;
        }

        if (p == null) {
            return false;
        }

        if (p.venstre == null || p.høyre == null) {
            Node<T> b = p.venstre != null ? p.venstre : p.høyre;

            if (p == rot) {
                rot = b;
            } else if (p == q.venstre) {
                q.venstre = b;
            } else {
                q.høyre = b;
            }
        } else {
            Node<T> s = p;
            Node<T> r = p.høyre;
            while(r.venstre != null){
                s = r;
                r = r.venstre;
            }
            p.verdi = r.verdi;

            if(s != p){
                s.venstre = r.høyre;
            } else {
                s.høyre = r.høyre;
            }
        }

        antall--;
        return true;
    }

    public int fjernAlle(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    //Oppgave 2

    public int antall(T verdi) {

        /*
        Returnere antall forekomster av verdi i treet
        Kan inneholde duplikater - verdier kan forekomme flere ganger
        Returnerer 0 hvis verdien ikke er i treet
         */

        Node<T> p = rot;
        int val = 0;

        while (p != null) {
            int cmp = comp.compare (verdi, p.verdi);

            if (cmp < 0) {
                p = p.venstre;
            }
            else {
                if (cmp == 0){
                    val++;
                }

                p = p.høyre;

            }
        }

        return val;

    }

    //Oppgave 6

    public void nullstill() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    //Oppgave 3

    private static <T> Node<T> førstePostorden(Node<T> p) {

        Objects.requireNonNull(p);
        //if (tom()) {throw new NoSuchElementException ("");

        while (true) {
            if (p.venstre != null){
                p = p.venstre;
            } else if (p.høyre != null) {
                p = p.høyre;
            }
            else {
                return p;
            }
        }

    }

    private static <T> Node<T> nestePostorden(Node<T> p) {

        Objects.requireNonNull(p);

        Node<T> f = p.forelder;

        if (f == null){
            return null;
        }

        if (f.høyre == p || f.høyre == null){
            return f;
        }
        else {
            return førstePostorden(f.høyre);
        }

    }

    //Oppgave 4

    public void postorden(Oppgave<? super T> oppgave) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");

        /*
        //Skrive ut treet i post orden til skjerm
        //Implementere første funksjonen uten bruk av rekursjon eller hjelpevariabler (stack/queue)
        //Bruke nestePostorden

        Node<T> p = rot;

        while (p == nestePostorden(p)){
            //skjønner ingentingggggggg
        }

         */

    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        postordenRecursive(rot, oppgave);
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");



    }

    //Oppgave 5

    /*
    Legge treet inn i en datastruktur (fil-skriving)
    Seralize som gjør om binærtreet til et array
    Deseralize som tar et array og gjør om til et binært søketre

     */

    public ArrayList<T> serialize() {
        //Iterative og må bruke en kø til å traversere treet i nivå orden
        //Arrayet som returneres skal inneholde verdeine i alle nodene i nivå orden

        ArrayList<T> treArray = new ArrayList<>();
        Queue<Node<T>> ko = new LinkedList<>();

        ko.add(rot);

        while(!ko.isEmpty()){
            Node<T> p = ko.remove();
            treArray.add(p.verdi);

            if(p.venstre != null) {
                ko.add(p.venstre);
            }
            if(p.høyre != null){
                ko.add(p.høyre);
            }
        }
        return treArray;
    }

    static <K> SBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        //Tar arrayet og legger inn alle verdiene (nivå orden) og gjenskaper treet

        SBinTre<K> tre = new SBinTre<>(c);

        for(K verdi : data) {
            tre.leggInn(verdi);
        }

        return tre;

    }

/*
    public static void main(String[] args) {
        Integer[] a = {4, 7, 2, 9, 5, 10, 8, 1, 3, 6};
        SBinTre<Integer> tre = new SBinTre<>(Comparator.naturalOrder());
        for (int verdi : a) {
            tre.leggInn(verdi);
        }
        System.out.println(tre.antall());
    }
 */

} // ObligSBinTre
