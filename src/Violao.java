public class Violao extends Instrumento{
    public Violao() {
        super("Violão");
    }

    @Override
    public void tocar() {
        System.out.println("Trim trim");
    }
}
