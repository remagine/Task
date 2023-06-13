package org.example;

import org.example.command.Command;
import org.example.command.CommandFactory;
import org.example.command.CommandResult;
import org.example.command.CommandType;
import org.example.tag.Tag;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
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
            // 인프라 객체들
            CommandFactory commandFactory = CommandFactory.getInstance();
            PriorityQueue<Tag> availableTags = Tag.initAvailableTags();
            Set<Tag> executableTags = Tag.initExecutableTags();

            while (true) {
                // 입력처리
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] arguments = line.split(" ");
                if (arguments.length > 2 || arguments.length == 0) {
                    throw new RuntimeException("입력하신 명령문을 확인하세요.");
                }

                CommandType commandType = null;
                Tag tag = Tag.getEmpty();
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


                // 처리의 입력 생성
                Command command = commandFactory.get(commandType, tag, availableTags, executableTags);
                CommandResult commandResult = command.execute();

                // 실패를 집계해야 하는데
                // 집계는 누구의 책임인가? Tag?


            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}