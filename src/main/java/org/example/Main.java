package org.example;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        String inputData = "execute 11";

        byte[] bytes = inputData.getBytes(StandardCharsets.UTF_8);
        try (InputStream inputStream = new ByteArrayInputStream(bytes);
             InputStreamReader isr = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr, 8192);
        ) {
            CommandFactory commandFactory = CommandFactory.getInstance();
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] arguments = line.split(" ");
                if (arguments.length > 2 || arguments.length == 0) {
                    throw new RuntimeException("입력하신 명령문을 확인하세요.");
                }

                CommandType commandType = null;
                if (arguments.length == 2) {
                    String commandString = arguments[0];
                    commandType = CommandType.from(commandString);
                    String number = arguments[1];
                }

                if (arguments.length == 1) {
                    String commandString = arguments[0];
                    commandType = CommandType.from(commandString);
                }

                Command command = commandFactory.get(commandType);
                command.execute();








            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}