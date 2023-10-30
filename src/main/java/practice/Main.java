package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    
    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmailList emailList = new EmailList();
        
        while (true) {
            //TODO: write code here
            UserInput userInput = parse(scanner.nextLine());
            switch (userInput.getCommand()) {
                case "LIST":
                    System.out.println(emailList.getSortedEmails());
                    break;
                case "ADD":
                    emailList.add(userInput.getTask());
                    break;

            }
        }
    }


    private static UserInput parse(String input) {
        String[] split = input.split(" ");
        if (split.length == 1) {
            return new UserInput(input.toUpperCase(), null, null);
        }
        try {
            return new UserInput(split[0].toUpperCase(), Integer.valueOf(split[1]), String.join(" ",
                    Arrays.copyOfRange(split, 2, split.length)));
        } catch (NumberFormatException e) {
            return new UserInput(split[0].toUpperCase(), null, String.join(" ",
                    Arrays.copyOfRange(split, 1, split.length)));
        }
    }
    private static class UserInput {

        private final String command;

        private final Integer index;

        private final String task;

        public UserInput(String command, Integer index, String task) {
            this.command = command;
            this.index = index;
            this.task = task;
        }

        public String getCommand() {
            return command;
        }

        public Integer getIndex() {
            return index;
        }

        public String getTask() {
            return task;
        }

    }
}
