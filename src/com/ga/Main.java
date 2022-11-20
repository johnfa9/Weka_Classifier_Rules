package com.ga;

// Make sure to state which package IF necessary, or else this code won't run
// ex: package weka.classifiers;;

import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String... args) throws Exception {
        // Create Questions
        Question attribute1 = new Question("What type of travel?", "Personal Travel", "Business travel");
        Question attribute2 = new Question("What type of class?", "Eco", "Eco Plus", "Business");
        Question attribute3 = new BoundsQuestion("How is the in-flight wi-fi service?", "Enter rating between 1 and 5", 0.0, 5.0);
        Question attribute4 = new BoundsQuestion("How is the online boarding?", "Enter rating between 1 and 5", 0.0, 5.0);
        Question attribute5 = new BoundsQuestion("How is the in-flight entertainment?", "Enter rating between 1 and 5", 0.0, 5.0);
        Question attribute6 = new BoundsQuestion("How is the check-in service?", "Enter rating between 1 and 5", 0.0, 5.0);
        Question attribute7 = new BoundsQuestion("How long is the arrival delay in minutes?", "If there is no delay, type 0", 0.0, Double.MAX_VALUE);

        Question[] questions = {attribute1, attribute2, attribute3, attribute4, attribute5, attribute6, attribute7};
        Object[]   userInput = new Object[questions.length]; // Array containing user input

        // Show user questions
        for (int i = 0; i < questions.length; i++) {
            userInput[i] = questions[i].showAndGetUserResponse();
            System.out.println(generateLine('_', 41));
        }

        // Show prediction result
        System.out.println("You will be " +
                (WekaClassifier.classify(userInput) == 1.0 ? "satisfied" : "neutral or dissatisfied"));
    }

    /**
     * Utility function to generate a String horizontal line
     * @param c Character that makes up
     * @param length length of line to generate
     * @return generated string
     */
    public static String generateLine(char c, int length) {
        return String.valueOf(c).repeat(Math.max(0, length));
    }

    private static class Question {
        /** Parse user input */
        protected final Scanner scanner;
        /** Question text */
        protected final String questionText;
        /** Allowable choices for question (if null, any user input is allowed) */
        protected final String[] choices;
        /** User response (empty if no response is given) */
        protected Object userResponse;

        public Question(String questionText, String... choices) {
            this.scanner = new Scanner(System.in);
            this.questionText = questionText;
            this.choices = choices;
            this.userResponse = "";
        }

        /**
         * Show question and set user input
         */
        public Object showAndGetUserResponse() {
            boolean isMultipleChoice = choices != null;

            // Loop forces user to give valid input
            while (true) {
                try {
                    // Show question
                    System.out.println(questionText);

                    // Show allowed choices if any
                    if (isMultipleChoice) {
                        for (String choice : choices) {
                            System.out.println("- " + choice);
                        }
                    }

                    // Get user response
                    System.out.print("Enter response > ");
                    userResponse = scanner.nextLine();

                    // Break from loop if user response matches allowed choices
                    if (!isMultipleChoice || Arrays.asList(choices).contains(userResponse)) {
                        break;
                    }

                    // Throw exception if user input does not match allowed choices
                    throw new IllegalArgumentException();
                } catch (IllegalArgumentException e) {
                    System.out.println("[!] Invalid input provided");
                }
            }

            return userResponse;
        }
    }

    private static class BoundsQuestion extends Question {
        /** Minimum number allowed for user response */
        private final Double minBounds;
        /** Maximum number allowed for user response */
        private final Double maxBounds;

        public BoundsQuestion(String questionText, String boundsMessage, Double minBounds, Double maxBounds) {
            super(questionText, boundsMessage);
            this.minBounds = minBounds;
            this.maxBounds = maxBounds;
        }

        @Override
        public Object showAndGetUserResponse() {
            while (true) {
                try {
                    // Show question and bounds message
                    System.out.println(questionText + "\n - " + choices[0]);

                    // Get user response
                    System.out.print("Enter response > ");
                    double response = scanner.nextDouble();

                    // Break from loop if user response is in the bounds
                    if (response >= minBounds && response <= maxBounds) {
                        userResponse = response;
                        break;
                    }

                    // Throw exception if user input in not in bounds
                    throw new IllegalArgumentException();
                } catch (IllegalArgumentException | InputMismatchException e) {
                    System.out.println("[!] Invalid input provided");

                    if (scanner.hasNext()) {
                        scanner.next();
                    }
                }
            }

            return userResponse;
        }
    }
}