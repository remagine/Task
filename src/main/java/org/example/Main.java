package org.example;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

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
                Tag tag = null;
                if (arguments.length == 2) {
                    String commandString = arguments[0];
                    commandType = CommandType.from(commandString);
                    String number = arguments[1];
                    tag = Tag.from(number);
                }

                if (arguments.length == 1) {
                    String commandString = arguments[0];
                    commandType = CommandType.from(commandString);
                }

                // tag를 인자로 받아야 될까?
                // 받는다면, tag가 없는 명령은 어떻게 될까 문제가 된다
                // 받지 않는다면 tag는 어떻게 전달되야 하나?
                // 팩토리가 받으면 좋겠다. 받아서 처리하는 경우, 아닌경우도 나눌 수 있겠다
                // 인자가 너무 많은데? 4개는 너무 많다. 어떻게 줄이지?
                // 그리고 어떤 인자는 어떤 command에만 필요한데 이렇게 매번 명령이 추가될때마다 인자도 추가되야한다.
                // 이럴때는 어떤 패턴이 유리할까
                // 일단 팩토리에 넣어주자
                Command command = commandFactory.get(commandType, tag);
                CommandResult commandResult = command.execute();


            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}