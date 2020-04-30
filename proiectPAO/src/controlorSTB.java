public class ControlorSTB {

    private int numarDeAmenzi;
    private int statie;

    public ControlorSTB() {
        this.numarDeAmenzi = 0;
        this.statie = -1;
    }

    public ControlorSTB(int statie, int numarDeAmenzi) {
        this.numarDeAmenzi = numarDeAmenzi;
        this.statie = statie;
    }

    public int getNumarDeAmenzi() {
        return numarDeAmenzi;
    }

    public void setNumarDeAmenzi(int numarDeAmenzi) {
        this.numarDeAmenzi = numarDeAmenzi;
    }

    public int getAutobuz() {
        return statie;
    }

    public void setAutobuz(int statie) {
        this.statie = statie;
    }
}
