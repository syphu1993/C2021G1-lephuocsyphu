package mail.service;

import mail.model.Mail;

import java.util.List;

public interface IMail {
    List<Mail> findAll();
    Mail findById(int id);
    void update(Mail mail);
}
