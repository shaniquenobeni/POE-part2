package com.mycompany.chatapp_part1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Messagetest {

    @Test
    public void testCheckMessageLengthValid() {
        Message msg = new Message();
        assertTrue(msg.checkMessageLength("Hello, this is a valid test message under 250 characters."));
    }

    @Test
    public void testCheckMessageLengthInvalid() {
        Message msg = new Message();
        String longText = "A".repeat(251);
        assertFalse(msg.checkMessageLength(longText));
    }

    @Test
    public void testGenerateMessageID() {
        Message msg = new Message();
        String id = msg.generateMessageID();
        assertNotNull(id);
        assertEquals(10, id.length());
    }

    @Test
    public void testCheckRecipientCellValid() {
        Message msg = new Message();
        assertTrue(msg.checkRecipientCell("0821234567") || msg.checkRecipientCell("+27821234567"));
    }

    @Test
    public void testCheckRecipientCellInvalid() {
        Message msg = new Message();
        assertFalse(msg.checkRecipientCell("12345"));
    }

    @Test
    public void testCreateMessageHash() {
        Message msg = new Message();
        String hash = msg.createMessageHash(1, "AB1234CD56", "Catch you later");
        assertEquals("1:AB:CATCH-LATER", hash);
    }
}