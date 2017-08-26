package com.vabram.hearthum.service;

/**
 * Created by brama051 on 16/08/2017.
 */

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);

    /*void sendSimpleMessageUsingTemplate(String to, String subject, SimpleMailMessage template, String... templateArgs);

    void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment);*/
}

