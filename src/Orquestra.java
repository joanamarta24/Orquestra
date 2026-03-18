
void main() {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Instrumento> banda = new ArrayList<>();

    banda.add(new Bateria());
    banda.add(new Piano());
    banda.add(new Violao());

    int opcao;
    do {
        System.out.println("\n-----MENU DA ORQUESTRA-----");
        System.out.println("1- Adicionar Bateria");
        System.out.println("2- Adicionar Piano");
        System.out.println("3- Adicionar Violão ");
        System.out.println("4. Mostrar instrumento");
        System.out.println("5- Banda tocar (um por um)");
        System.out.println("6- Banda toca Junta");
        System.out.println("7- Tocar com Threads (simultâneo) ");
        System.out.println("0- Sair");
        System.out.println("Escolha: ");


        opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                banda.add(new Bateria());
                System.out.println("Bateria adicionadda!");
                break;
            case 2:
                banda.add(new Piano());
                System.out.println("Piaono adicionado");
                break;
            case 3:
                banda.add(new Violao());
                System.out.println("Violão adicionado!");
                break;
            case 4:
                if (banda.isEmpty()) {
                    System.out.println("Banda está vazia");
                } else {
                    System.out.println("\n Integrantes da banda: ");
                    for (Instrumento i : banda) {
                        i.mostrarNome();
                    }
                }
                break;
            case 5:
                if (banda.isEmpty()) {
                    System.out.println("Nada pra tocar");
                } else {
                    System.out.println("\n Cada um tocando: ");
                    for (Instrumento i : banda) {
                        i.tocar();
                    }
                }
                break;
            case 6:
                if (banda.isEmpty()) {
                    System.out.println("Silencio total....");
                } else {
                    System.out.println("\n BANDA TOCANDO JUNTA: ");
                    tocarJuntos(banda);
                }
                break;
            case 7:
                if (banda.isEmpty()) {
                    System.out.println("Sem músicos no palco");
                } else {
                    System.out.println("\n⚡ BANDA TOCANDO DE VERDADE (Threads):\n");
                    Instrumento.tocarComThreads(banda);
                }
                break;
            case 0:
                System.out.println("Opção inválida!");
        }
    } while (opcao != 0);
    scanner.close();

}
void tocarJuntos(ArrayList<Instrumento> banda){
    for (Instrumento i: banda){
        System.out.println("["+ i.nome + "]");
        i.tocar();
    }
}