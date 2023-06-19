
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final boolean isString(String input) {
        return input.matches("[a-zA-Z]+");
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        UsuarioDAO userDao = new UsuarioDAO();
        SneakerDAO snkDao = new SneakerDAO();

        boolean switchOn = true;

        while (switchOn) {
            System.out.println("\n|-------------------------------------------------|");
            System.out.println("|          MENU INICIAL - [SNEAKERS]              |");
            System.out.println("|-------------------------------------------------|");
            System.out.println("|  01   |    Cadastrar Usuario                    |");
            System.out.println("|-------------------------------------------------|");
            System.out.println("|  02   |    Login                                |");
            System.out.println("|-------------------------------------------------|");
            System.out.println("|  0    |    Sair do programa                     |");
            System.out.println("|-------------------------------------------------|\n");
            System.out.print("Digite a opção: ");
            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o nome do usuario -> ");
                    String name = scan.nextLine();
                    while (!isString(name)) {
                        System.out.println("Nome invalido!");
                        name = scan.next();
                    }

                    System.out.print("Informe a idade do usuario -> ");
                    int age;
                    do {
                        while (!scan.hasNextInt()) {
                            System.out.println("idade invalida");
                        }
                        age = scan.nextInt();
                    } while (age <= 0);
                    scan.nextLine();

                    int functionOpt;
                    System.out.println("\n|-------------------------------------------------|");
                    System.out.println("|          ATENCAO! -[INFORME O CARGO DO USUARIO] |");
                    System.out.println("|-------------------------------------------------|");
                    System.out.println("|  01   |     ADMINISTRADOR-[TOTAL ACESSO]        |");
                    System.out.println("|-------------------------------------------------|");
                    System.out.println("|  02   |     VENDENDOR-[ACESSO PARCIAL]          |");
                    System.out.println("|-------------------------------------------------|\n");
                    functionOpt = scan.nextInt();
                    String function = null;

                    switch (functionOpt) {
                        case 1:
                            function = "Admin";
                            break;
                        case 2:
                            function = "Vendendor";
                            break;
                        default:
                            System.out.println("Opção invalida");
                            break;
                    }

                    System.out.print("Informe sua senha -> ");
                    String password = scan.next();
                    while (!isString(password)) {
                        System.out.println("Senha invalida!");
                        password = scan.next();
                    }

                    Usuario usuario = new Usuario(name, age, function, password);
                    userDao.adicionar_user(usuario);

                case 2:

                    do {
                        System.out.println("\n|-------------------------------------------------|");
                        System.out.println("|          MENU PRINCIPAL - [SNEAKERS]            |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  03   |    Comprar Sneaker                      |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  04   |    Gerenciar Sneaker                    |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  05   |    Gerenciar Usuario                    |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  99    |    Sair do Progama                     |");
                        System.out.println("|-------------------------------------------------|\n");
                        System.out.print("Digite a opção: ");
                        opcao = scan.nextInt();
                        scan.nextLine();

                        switch (opcao) {
                            case 3:

                                List<Sneaker> sneakersBuy = new ArrayList<>();
                                sneakersBuy = snkDao.getSneakers();

                                for (Sneaker s : sneakersBuy) {
                                    System.out.println("ID: " + s.getId() + " Nome: " + s.getName_sneaker() + " Valor: "
                                            + s.getPrice());
                                    System.out.println("");
                                }
                                System.out.print("Informe o ID do Sneaker que deseja Comprar: ");
                                int buySneakerId = scan.nextInt();
                                scan.nextLine();
                                Sneaker sneakerToBuy = snkDao.getSneakerById(buySneakerId);
                                if (sneakerToBuy == null) {
                                    System.out.println("Nenhum tênis encontrado com o ID informado.");
                                } else {

                                    System.out.println("Digite a quantidade desejada: ");
                                    int quantidade = scan.nextInt();

                                    System.out.println("\nDetalhes da compra:");
                                    System.out.println("Tênis: " + sneakerToBuy.getName_sneaker());
                                    System.out.println("Descrição: " + sneakerToBuy.getDescription());
                                    System.out.println("Criador: " + sneakerToBuy.getCreator());
                                    System.out.println("Quantidade: " + quantidade);
                                    System.out.println("Total: R$" + sneakerToBuy.getPrice() * quantidade);

                                    System.out.print("Deseja confirmar a compra?(S/N): ");
                                    String confirm = scan.next();

                                    if (confirm.equalsIgnoreCase("S")) {
                                        snkDao.excluir_sneaker(sneakerToBuy);
                                        System.out.println("Compra realizada com sucesso!");
                                    } else {
                                        System.out.println("Compra cancelada.");
                                    }

                                }
                                break;
                            case 4:

                                do {
                                    System.out.println("\n|-------------------------------------------------|");
                                    System.out.println("|          MENU SNEAKER - [SNEAKERS]              |");
                                    System.out.println("|-------------------------------------------------|");
                                    System.out.println("|  06   |    Cadastrar Sneaker                    |");
                                    System.out.println("|-------------------------------------------------|");
                                    System.out.println("|  07   |    Editar Sneaker                       |");
                                    System.out.println("|-------------------------------------------------|");
                                    System.out.println("|  08   |    Listar Sneaker                       |");
                                    System.out.println("|-------------------------------------------------|");
                                    System.out.println("|  09   |    Excluir Sneaker                      |");
                                    System.out.println("|-------------------------------------------------|");
                                    System.out.println("|  0    |    Sair do Progama                      |");
                                    System.out.println("|-------------------------------------------------|\n");
                                    System.out.print("Digite a opção: ");
                                    opcao = scan.nextInt();
                                    scan.nextLine();

                                    switch (opcao) {
                                        case 6:
                                            System.out.print("Informe o nome do Sneaker -> ");
                                            String snkname = scan.nextLine();

                                            System.out.print("Informe a descrição do Sneaker -> ");
                                            String desc = scan.nextLine();

                                            System.out.print("Informe o valor do Sneaker -> ");
                                            double price;
                                            do {
                                                while (!scan.hasNextDouble()) {
                                                    System.out.println("Valor invalido");
                                                }
                                                price = scan.nextDouble();
                                            } while (price <= 0);
                                            scan.nextLine();

                                            System.out.print("Informe o nome do Criador -> ");
                                            String creator = scan.nextLine();
                                            while (!isString(creator)) {
                                                System.out.println("Nome invalido!");
                                                creator = scan.next();
                                            }

                                            Sneaker sneaker = new Sneaker(snkname, desc, price, creator);
                                            snkDao.adicionar_sneaker(sneaker);
                                            break;
                                        case 7:

                                            boolean isValidEdit = false;
                                            System.out.print("Informe o ID do Sneaker que deseja editar: ");
                                            int editSneakerId = scan.nextInt();
                                            scan.nextLine();
                                            Sneaker sneakerToEdit = snkDao.getSneakerById(editSneakerId);
                                            if (sneakerToEdit == null) {
                                                System.out.println("Sneaker não encontrado!");

                                            } else {
                                                System.out.print("Informe o novo nome do Sneaker -> ");

                                                String newSnkName;
                                                for (newSnkName = scan
                                                        .nextLine(); !isString(newSnkName); newSnkName = scan
                                                                .nextLine()) {
                                                    System.out.println("Nome inválido!");
                                                }

                                                System.out.print("Informe a nova descrição do Sneaker -> ");

                                                String newDesc;
                                                newDesc = scan.nextLine();

                                                System.out.print("Informe o novo valor do Sneaker -> ");

                                                while (true) {
                                                    while (scan.hasNextDouble()) {
                                                        double newPrice = scan.nextDouble();
                                                        if (!(newPrice <= 0.0)) {
                                                            scan.nextLine();
                                                            System.out.print("Informe o novo nome do Criador -> ");
                                                            String newCreator;
                                                            for (newCreator = scan.nextLine(); !isString(
                                                                    newCreator); newCreator = scan
                                                                            .nextLine()) {
                                                                System.out.println("Nome inválido!");
                                                            }

                                                            sneakerToEdit.setName_sneaker(newSnkName);
                                                            sneakerToEdit.setDescription(newDesc);
                                                            sneakerToEdit.setPrice(newPrice);
                                                            sneakerToEdit.setCreator(newCreator);
                                                            snkDao.editar_sneaker(sneakerToEdit);
                                                            System.out.println("Sneaker editado com sucesso!");
                                                            isValidEdit = true;
                                                            break;
                                                        }
                                                    }

                                                    if (isValidEdit) {
                                                        break;
                                                    }

                                                    System.out.println("Valor inválido");
                                                    scan.nextLine();

                                                }

                                            }
                                            break;
                                        case 8:
                                            List<Sneaker> sneakers = new ArrayList<>();
                                            sneakers = snkDao.getSneakers();

                                            for (Sneaker s : sneakers) {
                                                System.out.println("ID: " + s.getId());
                                                System.out.println("Nome: " + s.getName_sneaker());
                                                System.out.println("Valor: " + s.getPrice());
                                                System.out.println("Descrição: " + s.getDescription());
                                                System.out.println("Criador: " + s.getCreator());
                                                System.out.println("");
                                            }
                                            break;

                                        case 9:
                                            System.out.print("Informe o ID do Sneaker que deseja excluir: ");
                                            int deleteSneakerId = scan.nextInt();
                                            scan.nextLine();
                                            Sneaker sneakerToDelete = snkDao.getSneakerById(deleteSneakerId);
                                            if (sneakerToDelete != null) {
                                                snkDao.excluir_sneaker(sneakerToDelete);
                                                System.out.println("Sneaker excluído com sucesso!");
                                            } else {
                                                System.out.println("Sneaker não encontrado!");
                                            }
                                            break;
                                        default:
                                            break;
                                    }

                                } while (opcao != 0);

                                break;

                            case 5:

                                do {
                                    System.out.println("\n|-------------------------------------------------|");
                                    System.out.println("|          MENU USUARIO - [SNEAKERS]              |");
                                    System.out.println("|-------------------------------------------------|");
                                    System.out.println("|  10   |    Editar Usuario                       |");
                                    System.out.println("|-------------------------------------------------|");
                                    System.out.println("|  11   |    Listar Usuarios                      |");
                                    System.out.println("|-------------------------------------------------|");
                                    System.out.println("|  12   |    Excluir Usuario                      |");
                                    System.out.println("|-------------------------------------------------|");
                                    System.out.println("|  0    |    Sair do Progama                      |");
                                    System.out.println("|-------------------------------------------------|\n");
                                    System.out.print("Digite a opção: ");
                                    opcao = scan.nextInt();
                                    scan.nextLine();

                                    switch (opcao) {
                                        case 10:
                                            boolean isValidEdit = false;
                                            System.out.print("Informe o ID do usuário que deseja editar: ");
                                            int editUserId = scan.nextInt();
                                            scan.nextLine();
                                            Usuario userToEdit = userDao.getUsuarioById(editUserId);
                                            if (userToEdit != null) {
                                                System.out.print("Informe o novo nome do usuário -> ");

                                                String newName;
                                                for (newName = scan.nextLine(); !isString(newName); newName = scan
                                                        .nextLine()) {
                                                    System.out.println("Nome inválido!");
                                                }

                                                System.out.print("Informe a nova idade do usuário -> ");

                                                while (true) {
                                                    while (scan.hasNextInt()) {
                                                        int newAge = scan.nextInt();
                                                        if (newAge > 0) {
                                                            scan.nextLine();
                                                            System.out.println(
                                                                    "\n|-------------------------------------------------|");
                                                            System.out.println(
                                                                    "|          ATENÇÃO! - [INFORME O CARGO DO USUÁRIO] |");
                                                            System.out.println(
                                                                    "|-------------------------------------------------|");
                                                            System.out.println(
                                                                    "|  01   |    ADMINISTRADOR - [TOTAL ACESSO]        |");
                                                            System.out.println(
                                                                    "|-------------------------------------------------|");
                                                            System.out.println(
                                                                    "|  02   |    VENDEDOR - [ACESSO PARCIAL]           |");
                                                            System.out.println(
                                                                    "|-------------------------------------------------|\n");
                                                            int newFunctionOpt = scan.nextInt();
                                                            String newFunction = null;
                                                            switch (newFunctionOpt) {
                                                                case 1:
                                                                    newFunction = "Admin";
                                                                    break;
                                                                case 2:
                                                                    newFunction = "Vendedor";
                                                                    break;
                                                                default:
                                                                    System.out.println("Opção inválida");
                                                            }

                                                            System.out.print("Informe a nova senha -> ");

                                                            String newPassword;
                                                            for (newPassword = scan
                                                                    .next(); !isString(newPassword); newPassword = scan
                                                                            .next()) {
                                                                System.out.println("Senha inválida!");
                                                            }

                                                            userToEdit.setName(newName);
                                                            userToEdit.setAge(newAge);
                                                            userToEdit.setFunction(newFunction);
                                                            userToEdit.setPassword(newPassword);
                                                            userDao.editar_usuario(userToEdit);
                                                            System.out.println("Usuário editado com sucesso!");
                                                            isValidEdit = true;
                                                            break;
                                                        }
                                                    }

                                                    if (isValidEdit) {
                                                        break;
                                                    }

                                                    System.out.println("Idade inválida");
                                                    scan.nextLine();
                                                }
                                            }
                                            break;
                                        case 11:
                                            List<Usuario> usuarios = new ArrayList<>();
                                            usuarios = userDao.getUsuarios();

                                            for (Usuario u : usuarios) {
                                                System.out.println("ID: " + u.getId_User());
                                                System.out.println("Nome: " + u.getName());
                                                System.out.println("Idade: " + u.getAge());
                                                System.out.println("Função: " + u.getFunction());
                                                System.out.println("");
                                            }
                                            break;

                                        case 12:
                                            System.out.print("Informe o ID do Usuario que deseja excluir: ");
                                            int deleteUserId = scan.nextInt();
                                            scan.nextLine();
                                            Usuario userToDelete = userDao.getUsuarioById(deleteUserId);
                                            if (userToDelete != null) {
                                                userDao.excluir_usuario(userToDelete);
                                                System.out.println("Usuario excluído com sucesso!");
                                            } else {
                                                System.out.println("Usuario não encontrado!");
                                            }
                                            break;
                                        default:
                                            break;
                                    }
                                } while (opcao != 0);

                                break;

                            default:
                                break;
                        }

                    } while (opcao != 99);

                    break;
                default:
                    switchOn = false;
                    break;
            }
        }
        scan.close();
    }
}
