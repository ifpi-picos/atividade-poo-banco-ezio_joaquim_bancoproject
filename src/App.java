import banco.Cliente;
import banco.ContaPoupanca;
import banco.Email;
import banco.ContaCorrente;
import banco.Endereco;
import banco.Notificacao;
import banco.Sms;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        Random aleatorio = new Random();

        ArrayList<ContaCorrente> bdContasCorrente = new ArrayList<>();
        ArrayList<ContaPoupanca> bdContasPoupanca = new ArrayList<>();
        ArrayList<Integer> bdAgenciasIntegers = new ArrayList<>();
        ArrayList<Integer> bdNumerosCIntegers = new ArrayList<>();
        ArrayList<String> bdCpf = new ArrayList<>();

        String nome, dnString, cpf, uf, rua, bairro, cidade;
        String dnList[];
        int op1, op2, op3, op4, resp, agencia, numero, numeroC;
        double saldo = 0, txRendimento = 0.10, cheque = 5000, rendimento = saldo * txRendimento, transferencia,
                txTransferencia = 0.05, saque, deposito;

        Notificacao notificacao = null;
        LocalDate dataNascimento;

        while (true) {
            System.out.println("\n------------------------------------------------------------------------");
            System.out.println("\n-----------------BANCO MAUT----------------");
            System.out.println("\n------------Bem vindo ao nosso APP!------------");
            System.out.println("\nEscolha uma das opções abaixo:");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("\n (1) Criar conta || (2) Entrar na conta || (3) Sair do APP");
            System.out.println("\n------------------------------------------------------------------------");
            System.out.println("\nDigite sua opção abaixo: ");
            op1 = leitor.nextInt();

            if (op1 == 1) {
                System.out.println("\n------------------------------------------------------------------------");
                System.out.println("\nAntes de continuarmos, vamos te mostrar os benefícios de cada conta!");
                System.out.println("\n------------------------------------------------------------------------");
                System.out.println("\nBeneficios Conta Poupança:");
                System.out.println(
                        "A conta poupança cobra uma taxa de 5% do valor da transferência para cada transferência realizada;");
                System.out.println(
                        "\nA conta poupança tem um rendimento de 10% (porcentagem inicial quando a conta é criada, mas esse valor de rendimento pode variar) em cima do valor de cada depósito;");
                System.out.println("\n------------------------------------------------------------------------");
                System.out.println("\nBeneficios Conta Corrente:");
                System.out.println(
                        "\nA conta corrente pode ter cheque especial, que é um valor que o cliente pode sacar além do seu saldo;");
                System.out.println("\nA conta corrente permite fazer até 2 transferências sem cobrar taxa;");
                System.out.println("\n------------------------------------------------------------------------");
                System.out.println("\nQual tipo de conta você deseja criar?");
                System.out.println("\n (1) CONTA CORRENTE  || (2) CONTA POUPANCA ");
                op2 = leitor.nextInt();

                if (op2 == 1 || op2 == 2) {
                    System.out.println("\nPreencha seus dados abaixo!");
                    System.out.println("\n------------------------------------------------------------------------");
                    System.out.print("\nNome Completo: ");
                    nome = leitor.nextLine();
                    System.out.print("\nCPF: ");
                    cpf = leitor.next();

                    if (op2 == 1) {
                        for (ContaCorrente iterable_element : bdContasCorrente) {
                            if (cpf.equals(iterable_element.getCliente().getCpf())) {
                                System.out.println("\nEsse CPF ja se encontra no sistema, tente novamente! ");
                                System.out.print("\nCPF: ");
                                cpf = leitor.next();
                            }
                        }
                    } else if (op2 == 2) {
                        for (ContaPoupanca iterable_element : bdContasPoupanca) {
                            if (cpf.equals(iterable_element.getCliente().getCpf())) {
                                System.out.println("\nEsse CPF ja se encontra no sistema, tente novamente! ");
                                System.out.print("\nCPF: ");
                                cpf = leitor.next();
                            }
                        }
                    }
                    System.out.print("\nInsira sua data de nascimento abaixo nesse padrão: (DD/MM/AAAA): ");
                    dnString = leitor.next();
                    dnList = dnString.split("/");

                    dataNascimento = LocalDate.of(Integer.parseInt(dnList[2]),
                            Integer.parseInt(dnList[1]),
                            Integer.parseInt(dnList[0]));

                    System.out.print("\nRua: ");
                    rua = leitor.nextLine();

                    System.out.print("\nBairro: ");
                    bairro = leitor.nextLine();

                    System.out.print("\nNúmero: ");
                    numero = leitor.nextInt();

                    System.out.print("\nCidade: ");
                    cidade = leitor.nextLine();

                    System.out.print("\nUF: ");
                    uf = leitor.next();

                    System.out.println("\nComo você deseja receber nossas notificações?");
                    System.out.println("\n(1) EMAIL  (2) SMS");

                    System.out.print("\nSelecione uma das opções abaixo: ");
                    op3 = leitor.nextInt();

                    if (op3 == 1) {
                        Notificacao email = new Email();
                        notificacao = email;
                    }

                    else if (op3 == 2) {
                        Notificacao sms = new Sms();
                        notificacao = sms;
                    }
                    agencia = aleatorio.nextInt(1, 100);
                    bdCpf.add(cpf);

                    if (bdAgenciasIntegers.contains(agencia) == false) {
                        bdAgenciasIntegers.add(agencia);
                    }
                    numeroC = aleatorio.nextInt(10000, 100000);

                    while (bdNumerosCIntegers.contains(numeroC)) {
                        numeroC = aleatorio.nextInt(10000, 100000);
                    }

                    bdAgenciasIntegers.add(numeroC);

                    if (op2 == 1) {

                        Endereco endereco = new Endereco(rua, uf, bairro, cidade, numero);
                        Cliente cliente = new Cliente(nome, cpf, dataNascimento, endereco);
                        ContaCorrente contaCorrente = new ContaCorrente(saldo, agencia, numeroC, cliente, cheque,
                                notificacao);
                        bdContasCorrente.add(contaCorrente);
                    }
                    if (op2 == 2) {
                        Endereco endereco = new Endereco(rua, uf, bairro, cidade, numero);

                        Cliente cliente = new Cliente(nome, cpf, dataNascimento, endereco);

                        ContaPoupanca contaPoupanca = new ContaPoupanca(agencia, numeroC, cliente, rendimento, saldo,
                                notificacao);

                        bdContasPoupanca.add(contaPoupanca);
                    }

                    System.out.println("\nSua conta foi criada!");
                }

                else if (op1 == 2) {

                    System.out.println("\n|Acesso a conta|");
                    System.out.println("\nEscolha uma das opções abaixo:");

                    System.out.println("\n(1) CONTA CORRENTE  (2) CONTA POUPANÇA");

                    System.out.print("\nQual das contas deseja acessar?: ");
                    op2 = leitor.nextInt();

                    System.out.println("\nPreencha os dados de Login");

                    System.out.print("\nCPF(XXX.XXX.XXX-XX): ");
                    cpf = leitor.next();

                    while (bdCpf.contains(cpf) == false) {

                        System.out.println("\nESSE CPF NÃO SE ENCONTRA NO SISTEMA!");

                        System.out.print("\nInsira seu CPF novamente: ");
                        cpf = leitor.next();

                    }

                    if (op2 == 1) {
                        for (ContaCorrente dados : bdContasCorrente) {
                            if (cpf.equals(dados.getCliente().getCpf())) {

                                while (true) {

                                    System.out.println("\n(DADOS DA CONTA)");
                                    System.out.println("\nAgencia: " + dados.getAgencia());
                                    System.out.println("\nConta: " + dados.getNumeroC());
                                    System.out.println("\nSaldo: " + dados.getSaldo());
                                    System.out.println("\nTIPO DE NOTIFICAÇÃO: " + dados.getNotificacao());
                                    System.out.println("\nCheque Especial: " + dados.getCheque());
                                    System.out.println("\n-------------------------------------");
                                    System.out.println("\nNome: " + dados.getCliente().getNome());
                                    System.out
                                            .println("\nData de Nascimento: " + dados.getCliente().getDataNascimento());
                                    System.out.println("\nCPF: " + dados.getCliente().getCpf());
                                    System.out.println("\n-------------------------------------");
                                    System.out.println("\nUF: " + dados.getCliente().getEndereco().getUf());
                                    System.out.println("\nRua: " + dados.getCliente().getEndereco().getLogradouro());
                                    System.out.println("\nNumero: " + dados.getCliente().getEndereco().getNumero());
                                    System.out.println("\nBairro: " + dados.getCliente().getEndereco().getBairro());
                                    System.out.println("\nCidade: " + dados.getCliente().getEndereco().getCidade());

                                    while (true) {
                                        System.out.println("\nOPERAÇÕES]");

                                        System.out.println("\nOPÇÕES:");
                                        System.out.println("\n|(1) Deposito |(2) Saque |(3) Transferencia");
                                        System.out.print("\nQual operação deseja efetuar? ");
                                        op3 = leitor.nextInt();

                                        if (op3 == 1) {

                                            System.out.println("\n[DEPÓSITO]");

                                            System.out.print("\nValor: ");
                                            deposito = leitor.nextDouble();

                                            dados.depositar(deposito);
                                            System.out.println("\nDeposito realizado com sucesso!");

                                            System.out.println("\nSaldo atual da conta: " + dados.getSaldo());

                                        } else if (op3 == 2) {
                                            System.out.println("\n[SAQUE]");

                                            System.out.print("\nValor: ");
                                            saque = leitor.nextDouble();

                                            while (saque > dados.getSaldo()) {
                                                System.out.println("\nVocê não possui esse valor no saldo da conta!");

                                                System.out.print("\nValor: ");
                                                saque = leitor.nextDouble();
                                            }
                                            System.out.println("\nValor sacado com sucesso: " + dados.sacar(saque));

                                            System.out.println("\nSaldo atual da conta: " + dados.getSaldo());
                                        } else if (op3 == 3) {
                                            System.out.println("\n[TRANSFERÊNCIA]");

                                            System.out.println("\nOpções:");
                                            System.out.println("\n(1) Conta Corrente (2) Conta Poupança");

                                            System.out.print("\nDigite a conta que deseja utilizar: ");
                                            op4 = leitor.nextInt();

                                            System.out.print("\nAgência: ");
                                            agencia = leitor.nextInt();
                                            System.out.print("\nConta: ");
                                            numeroC = leitor.nextInt();
                                            System.out.print("\nValor da transferência: ");
                                            transferencia = leitor.nextInt();

                                            while ((transferencia + (transferencia * txTransferencia)) > dados
                                                    .getSaldo()) {
                                                System.out.println("\nVocê não possui esse valor no saldo da conta!");

                                                System.out.print("\nValor: ");
                                                transferencia = leitor.nextDouble();
                                            }
                                            if (op4 == 1) {
                                                for (ContaCorrente contaCorrente : bdContasCorrente) {
                                                    if (agencia == contaCorrente.getAgencia()
                                                            && numeroC == contaCorrente.getNumeroC()) {
                                                        dados.sacar((transferencia * txTransferencia));
                                                        dados.transferir(transferencia, contaCorrente);
                                                        System.out
                                                                .println("\nSaldo atual da conta: " + dados.getSaldo());
                                                    }

                                                    else {
                                                        System.out.println(
                                                                "\nConta não encontrada em nosso banco de dados!");
                                                    }
                                                }
                                            }
                                        }
                                        System.out.println("\nDeseja encerrar as operações?");
                                        System.out.println("\n(1) SIM (2) NÃO");

                                        System.out.print("\nDigite aqui: ");
                                        resp = leitor.nextInt();

                                        if (resp == 1) {
                                            break;
                                        }
                                    }
                                    System.out.println("\nDeseja sair da conta?");
                                    System.out.println("\n(1) SIM (2) NÃO");

                                    System.out.print("\nDigite aqui: ");
                                    resp = leitor.nextInt();

                                    if (resp == 1) {
                                        break;
                                    }
                                }
                            }
                        }
                    } else if (op2 == 2) {
                        for (ContaPoupanca dados : bdContasPoupanca) {
                            if (cpf.equals(dados.getCliente().getCpf())) {
                                while (true) {

                                    System.out.println("\n\t\t[DADOS DA CONTA]");
                                    System.out.println("\nAgencia: " + dados.getAgencia());
                                    System.out.println("\nConta: " + dados.getNumeroC());
                                    System.out.println("\nSaldo: " + dados.getSaldo());
                                    System.out.println("\nRendimento: " + dados.getRendimento());
                                    System.out.println("\nTIPO DE NOTIFICAÇÃO: " + dados.getNotificacao());
                                    System.out.println("\n-------------------------------------");
                                    System.out.println("\nNome: " + dados.getCliente().getNome());
                                    System.out.println("\nCPF: " + dados.getCliente().getCpf());
                                    System.out
                                            .println("\nData de Nascimento: " + dados.getCliente().getDataNascimento());
                                    System.out.println("\n-------------------------------------");
                                    System.out.println("\nRua: " + dados.getCliente().getEndereco().getLogradouro());
                                    System.out.println("\nNúmero: " + dados.getCliente().getEndereco().getNumero());
                                    System.out.println("\nBairro: " + dados.getCliente().getEndereco().getBairro());
                                    System.out.println("\nCidade: " + dados.getCliente().getEndereco().getCidade());
                                    System.out.println("\nUF: " + dados.getCliente().getEndereco().getUf());

                                    while (true) {
                                        System.out.println("\n[Transferencia");

                                        System.out.println("\nOPÇÕES:");
                                        System.out.println("\n(1) CONTA CORRENTE (2) CONTA POUPANÇA");

                                        System.out.print("\nDigire aqui: ");
                                        op4 = leitor.nextInt();

                                        System.out.print("\nAgencia: ");
                                        agencia = leitor.nextInt();
                                        System.out.print("\nConta ");
                                        numeroC = leitor.nextInt();
                                        System.out.print("\nValor: ");
                                        transferencia = leitor.nextInt();

                                        while ((transferencia + (transferencia * txTransferencia)) > dados.getSaldo()) {
                                            System.out.println("\nVocê não possui esse valor no saldo da conta!");

                                            System.out.print("\nValor: ");
                                            transferencia = leitor.nextDouble();
                                        }
                                        if (op4 == 1) {
                                            for (ContaCorrente contaCorrente : bdContasCorrente) {
                                                if (agencia == contaCorrente.getAgencia()
                                                        && numeroC == contaCorrente.getNumeroC()) {
                                                    dados.sacar((transferencia * txTransferencia));
                                                    dados.transferir(transferencia, contaCorrente);
                                                    dados.setRendimento((dados.getRendimento() * txRendimento));
                                                    System.out.println("\nSaldo da conta: " + dados.getSaldo());
                                                    System.out.println("\nRendimento: " + dados.getRendimento());
                                                } else {
                                                    System.out
                                                            .println("\nConta não encontrada em nosso banco de dados!");
                                                }
                                            }
                                        }
                                        System.out.println("\nDeseja encerrar as operações?");
                                        System.out.println("\n(1) SIM (2) NÃO");

                                        System.out.print("\nDigite aqui: ");
                                        resp = leitor.nextInt();

                                        if (resp == 1) {
                                            break;
                                        }
                                    }
                                    System.out.println("\nDeseja sair da conta?");
                                    System.out.println("\n(1) SIM (2) NÃO");

                                    System.out.print("\nDigite aqui: ");
                                    resp = leitor.nextInt();

                                    if (resp == 1) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    System.out.println();
                }
                else if (op1 == 3) {
                    System.out.println("\nSISTEMA FINALIZADO\n");
                    break;
                }
            }
            leitor.close();
        }
    }
}
