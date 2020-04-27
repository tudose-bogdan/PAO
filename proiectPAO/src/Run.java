import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Run {

    public static void main(String args[]) throws IOException {


        InfoPoint info = new InfoPoint();

        IO io = IO.getInstance();

        info.adaugaStatii(io.read());

        Station.numarStatii = 0;

        Scanner  s = new Scanner(System.in);

        short option;
        do{
            System.out.println("1) Adauga statii");
            System.out.println("2) Afiseaza statii");
            System.out.println("3) Adauga autobuz");
            System.out.println("4) Sterge statie");
            System.out.println("5) Sterge autobuz");
            System.out.println("6) Cu ce autobuz ajung in statia X?");
            System.out.println("7) Prin ce statii trece autobuzul X?");
            System.out.println("8) Cu ce ajung din statia X in statia Y?");
            System.out.println("9) Numarul de statii: ");
            System.out.println("10) Adauga controlor: "); // to do
            System.out.println("11) Adauga statie de tichete: "); //to do
            System.out.println("10) Exit");

            option = s.nextShort();

            switch(option){

                case 1:{
                    System.out.println("1) Statie rurala");
                    System.out.println("2) Statie urbana");


                    short secondary_option = s.nextShort();

                    switch(secondary_option){

                        case 1: {
                            System.out.println("Introduceti o strada (string) si sectorul strazii\n");
                            String wr = s.next().concat(s.nextLine());
                            int g = s.nextInt();
                            IO.write(wr,g);
                            Station st = new UrbanStation(wr,g);

                            info.adaugaStatie(st);
                            break;
                        }

                        case 2:{
                            System.out.println("Introduceti o strada (string) si sectorul strazii\n");
                            String wr = s.next().concat(s.nextLine());
                            int g = s.nextInt();
                            IO.write(wr,g);
                            Station st = new RuralStation(wr,g);

                            info.adaugaStatie(st);
                            break;

                        }

                        //END INNER SWITCH
                    }

                    //END CASE 1
                    break;
                }

                case 2:{

                    info.afiseazaStatii();


                    //END CASE 2
                    break;
                }


                case 3:{
                    System.out.println("Introduceti numarul autobuzului: ");
                    int no = s.nextInt();
                    System.out.println("Introduceti codul statiei unde sa fie inserat: ");
                    int no2 = s.nextInt();

                    info.adaugaAutobuz(no,no2);

                    //END CASE 3
                    break;
                }

                case 4:{
                    System.out.println("Introduceti numarul statiei care va fi stersa: ");
                    int no = s.nextInt();

                    info.stergeStatieDupaNumar(no);

                    //END CASE 4
                    break;
                }

                case 5:{
                    System.out.println("Introduceti numarul autobuzului");
                    int no = s.nextInt();
                    info.stergeAutobuz(no);

                    //END CASE 6
                    break;
                }

                case 6:{

                    System.out.println("Introduceti numarul statiei: ");
                    int nr = s.nextInt();

                    info.cuCeAjung(nr);

                    //END CASE 6
                    break;
                }

                case 7:{

                    System.out.println("Introduceti numarul autobuzului: ");
                    int nr = s.nextInt();
                    info.prinCeStatiiX(nr);

                    //END CASE 7
                    break;
                }

                case 8:{
                    System.out.println("Introduceti doua coduri de statii: ");
                    int n1 = s.nextInt();
                    int n2 = s.nextInt();

                    info.autobuzeComune(n1,n2);

                    //END CASE 8
                    break;
                }

                case 9:{
                    System.out.println(Station.numarStatii);
                }

        //END SWITCH
            }

            //END WHILE
        }while(option!=10);
    }
}
