import log.LogManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Obter a instância única do LogManager
        LogManager logManager1 = LogManager.getInstance();
        LogManager logManager2 = LogManager.getInstance();

        // Verificar se as duas instâncias são iguais
        System.out.println("São as mesmas instâncias? " + (logManager1 == logManager2));

        // Usar o LogManager para registrar mensagens de log
        logManager1.log("Aplicação iniciada.");
        logManager1.log("Executando uma operação importante.");

        // Simulação de erro
        logManager1.log("Erro ao conectar ao banco de dados.");

        // Fechar o LogManager (salvando todos os logs)
        logManager1.close();
    }
}