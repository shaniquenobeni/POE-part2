package com.mycompany.chatapp_part1;

import java.util.Random;

public class Message {

    public boolean checkRecipientCell(String cellNumber) {
        if (cellNumber == null) {
            return false;
        }
        return cellNumber.matches("^\\+\\d{10,12}$") || cellNumber.matches("^\\d{10}$");
    }

    public boolean checkMessageLength(String text) {
        if (text == null) {
            return false;
        }
        return text.length() <= 250;
    }

    public String generateMessageID() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder id = new StringBuilder();
        Random rnd = new Random();
        while (id.length() < 10) {
            int index = (int) (rnd.nextFloat() * chars.length());
            id.append(chars.charAt(index));
        }
        return id.toString();
    }

    public String createMessageHash(int num, String id, String text) {
        if (text == null || text.trim().isEmpty()) {
            return num + ":" + id.substring(0, Math.min(id.length(), 2)) + ":NONE";
        }
        String[] words = text.trim().split("\\s+");
        String firstWord = words[0];
        String lastWord = words.length > 1 ? words[words.length - 1] : firstWord;

        return (num + ":" + id.substring(0, Math.min(id.length(), 2)) + ":" + firstWord + "-" + lastWord).toUpperCase();
    }
}