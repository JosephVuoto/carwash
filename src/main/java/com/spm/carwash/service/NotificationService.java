package com.spm.carwash.service;

import com.spm.carwash.common.Constant;
import com.spm.carwash.pojo.AppointmentForm;
import com.spm.carwash.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author Yangzhe Xie
 * @date 2019-09-07
 */
@Service
public class NotificationService {

    @Value("${spring.mail.username}")
    private String from;

    @Resource
    private JavaMailSender mailSender;

    /**
     * send simple email
     *
     * @param to      email receiver
     * @param subject email subject
     * @param content email content
     */
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        message.setFrom(from);
        mailSender.send(message);
    }

    /**
     * send html email
     *
     * @param to      email receiver
     * @param subject email subject
     * @param content email content
     */
    public void sendHtmlMail(String to, String subject, String content) {

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendAppointmentEmail(String title, AppointmentForm appointmentForm, User user) {
        if (!Constant.SEND_EMAIL) {
            return;
        }
        new Thread(() -> {
            StringBuilder sb = new StringBuilder();
            sb.append("<p>Hi there,</p>");
            sb.append("<p>Here is the information of your appointment: </p><br>");
            sb.append("<p>Name: ").append(user.getFirstname()).append(" ").append(user.getLastname()).append("</p>");
            sb.append("<p>Date: ").append(appointmentForm.getDate()).append("</p>");
            sb.append("<p>Time: ").append(appointmentForm.getTime()).append("</p>");
            sb.append("<p>Option: ").append(appointmentForm.getCarOption()).append("</p>");
            sb.append("<p>Car type: ").append(appointmentForm.getCarType()).append("</p>");
            sb.append("<p>Comment: ").append(appointmentForm.getComment()).append("</p><br>");
            sb.append("<p>Regards</p>");
            sb.append("<p>Gabriel & David</p>");
            sendHtmlMail(user.getEmail(), title, sb.toString());
        }).start();
    }
}
