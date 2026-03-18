import java.util.ArrayList;

public abstract class Instrumento implements Tocavel {

    protected String nome;

    public Instrumento(String nome) {
        this.nome = nome;
    }

    public void mostrarNome() {
        System.out.println("Instrumento: " + nome);
    }

    // 🔥 MÉTODO COM THREADS DENTRO DA CLASSE ABSTRATA
    public static void tocarComThreads(ArrayList<Instrumento> banda) {

        ArrayList<Thread> threads = new ArrayList<>();

        for (Instrumento instrumento : banda) {

            Thread t = new Thread(() -> {
                for (int i = 0; i < 3; i++) {
                    System.out.print("[" + instrumento.nome + "]: ");
                    instrumento.tocar();

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n🎶 Fim da apresentação!");
    }
}