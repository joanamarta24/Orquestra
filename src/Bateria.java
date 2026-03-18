public class Bateria extends Instrumento{

    public Bateria() {
        super("Bateris");
    }

    @Override
    public void tocar() {
        System.out.println("Tum tum pá!!!");
    }
}
