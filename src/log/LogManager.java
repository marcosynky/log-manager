package log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogManager {

    // Instância única da classe (variável estática e privada)
    private static LogManager instance;

    // Arquivo de log onde as mensagens serão gravadas
    private PrintWriter writer;

    // Construtor privado para impedir a criação de instâncias fora da classe
    private LogManager() {
        try {
            // Abertura do arquivo de log em modo append para não sobrescrever os logs existentes
            FileWriter fileWriter = new FileWriter("app.log", true);
            writer = new PrintWriter(fileWriter);
            System.out.println("LogManager criado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao inicializar o arquivo de log: " + e.getMessage());
        }
    }

    // Método para acessar a instância única da classe LogManager
    public static synchronized LogManager getInstance() {
        if (instance == null) {
            instance = new LogManager();
        }
        return instance;
    }

    // Método para escrever um log no arquivo
    public void log(String message) {
        // Obtém a data e hora atual para registrar no log
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        writer.println("[" + timestamp + "] " + message);
        writer.flush();  // Garante que o log seja gravado imediatamente no arquivo
    }

    // Método para fechar o arquivo de log quando não for mais necessário
    public void close() {
        if (writer != null) {
            writer.close();
            System.out.println("LogManager fechado com sucesso!");
        }
    }
}
