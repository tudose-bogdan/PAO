
import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Run {
    public Run() {
    }

    public static void main(String[] args) throws IOException, SQLException {
        InfoPoint info = new InfoPoint();
        Station.numarStatii = 0;
        //
        Database d = new Database();
        d.setUp();
        d.loadStation();
        d.loadBus();
        d.loadControl();
        d.loadControl();
        //

        /*
        IO io = IO.getInstance();
        Audit log = Audit.getInstance();

        info.adaugaStatii(IO.readStations());
        IO.readBuses(info);
        IO.readCont(info);
        IO.readTickets(info);
        */


        Scanner s = new Scanner(System.in);

        short option;
        do {
            System.out.println("1) Adauga statii");
            System.out.println("2) Afiseaza statii");
            System.out.println("3) Adauga autobuz");
            System.out.println("4) Sterge statie");
            System.out.println("5) Sterge autobuz");
            System.out.println("6) Cu ce autobuz ajung in statia X?");
            System.out.println("7) Prin ce statii trece autobuzul X?");
            System.out.println("8) Cu ce ajung din statia X in statia Y?");
            System.out.println("9) Numarul de statii: ");
            System.out.println("10) Adauga controlor: ");
            System.out.println("11) Activeaza o statie ca fiind statie de tichete: ");
            System.out.println("12) Exit");
            option = s.nextShort();
            int n;
            int n2;
            switch(option) {
                case 1: {
                    //Audit.logEvent(ActiuniLog.ADAUGASTATII);
                    System.out.println("1) Statie rurala");
                    System.out.println("2) Statie urbana");
                    short secondary_option = s.nextShort();
                    int g;
                    String wr;
                    switch (secondary_option) {
                        case 1:
                            System.out.println("Introduceti o strada (string) si sectorul strazii\n");
                            wr = s.next().concat(s.nextLine());
                            g = s.nextInt();
                            //IO.writeStations(wr, g);
                            d.addStation(wr,g);

                            Station st = new UrbanStation(wr, g);
                            info.adaugaStatie(st);
                            break;
                        case 2:
                            System.out.println("Introduceti o strada (string) si sectorul strazii\n");
                            wr = s.next().concat(s.nextLine());
                            g = s.nextInt();
                            //IO.writeStations(wr, g);
                            Station st2 = new RuralStation(wr, g);
                            info.adaugaStatie(st2);
                            d.addStation(wr,g);
                            break;
                    }
                    break;
                    }
                case 2: {
                    //Audit.logEvent(ActiuniLog.AFISEAZASTATII);
                    info.afiseazaStatii();
                    break;
                }
                case 3:{
                    //Audit.logEvent(ActiuniLog.ADAUGAAUTOBUZ);
                    System.out.println("Introduceti numarul autobuzului: ");
                    n = s.nextInt();
                    System.out.println("Introduceti codul statiei unde sa fie inserat: ");
                    n2 = s.nextInt();

                    d.addBus(n,n2);
                    //IO.writeBuses(n, n2);
                    info.adaugaAutobuz(n, n2);
                    break;}
                case 4:{
                    //Audit.logEvent(ActiuniLog.STERGESTATIE);
                    System.out.println("Introduceti numarul statiei care va fi stersa: ");
                    n = s.nextInt();
                    info.stergeStatieDupaNumar(n);
                    break;}
                case 5:{
                  //  Audit.logEvent(ActiuniLog.STERGEAUTOBUZ);
                    System.out.println("Introduceti numarul autobuzului");
                    n = s.nextInt();
                    info.stergeAutobuz(n);
                    break;}
                case 6:{
                  //  Audit.logEvent(ActiuniLog.CUCEAJUNGINSTATIAX);
                    System.out.println("Introduceti numarul statiei: ");
                    n = s.nextInt();
                    info.cuCeAjung(n);
                    break;}
                case 7:{
                  //  Audit.logEvent(ActiuniLog.PRINCESTATIIX);
                    System.out.println("Introduceti numarul autobuzului: ");
                    n = s.nextInt();
                    info.prinCeStatiiX(n);
                    break;}
                case 8:{
                   // Audit.logEvent(ActiuniLog.DRUMXY);
                    System.out.println("Introduceti doua coduri de statii: ");
                    n = s.nextInt();
                    n2 = s.nextInt();
                    info.autobuzeComune(n, n2);
                    break;}
                case 9:{
                    //Audit.logEvent(ActiuniLog.NUMARDESTATII);
                    System.out.println(Station.numarStatii);
                    break;}
                case 10:{
                   // Audit.logEvent(ActiuniLog.ADAUGACONTROLOR);
                    System.out.println("Introduceti codul statiei: ");
                    n = s.nextInt();
                    Station c = info.getStationById(n);
                    d.addControl(n,0);
                   // IO.writeCont(new ControlorSTB(n, 0));
                    c.adaugaControlor(new ControlorSTB(n, 0));
                    break;}
                case 11:{
                    System.out.println("Introduceti numarul statiei: ");
                    n = s.nextInt();
                    Station c = info.getStationById(n);
                    c.activeazaTichete();
                    d.addTicket(n);
                 //   IO.writeTickets(n);

                    break;}
            }
        } while(option != 12);

    }
}
