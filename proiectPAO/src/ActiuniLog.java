public enum ActiuniLog {
    ADAUGASTATII("ADAUGASTATII",1),
    AFISEAZASTATII("AFISEAZASTATII",2),
    ADAUGAAUTOBUZ("ADAUGAAUTOBUZ",3),
    STERGESTATIE("STERGESTATIE",4),
    STERGEAUTOBUZ("STERGEAUTOBUZ",5),
    CUCEAJUNGINSTATIAX("CUCEAJUNGINSTATIAX",6),
    PRINCESTATIIX("PRINCESTATIIX",7),
    DRUMXY("DRUMXY",8),
    NUMARDESTATII("NUMARDESTATII",9),
    ADAUGACONTROLOR("ADAUGACONTROLOR",10),
    ADAUGASTATIEDETICHETE("ADAUGASTATIEDETICHETE",11);

    public String val;
    public int nr;

    ActiuniLog(String val, int nr){
        this.val = val;
        this.nr = nr;
    }

    @Override
    public String toString() {
        return val + ", " + nr;
    }


}
