package mail.service.iplm;

import mail.model.Mail;
import mail.service.IMail;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MailImpl implements IMail {
    static List<Mail> listMail = new ArrayList<>();
    static {
        Mail mail1 = new Mail(1,"English",15,true,"abc");
        Mail mail2 = new Mail(2,"France",25,false,"abc-zyx");
        listMail.add(mail1);
        listMail.add(mail2);
    }

    @Override
    public List<Mail> findAll() {


        return listMail;
    }

    @Override
    public Mail findById(int id) {
        Mail mail = null;
        List<Mail> listMail = new ArrayList<>();
        listMail  = findAll();
        for (Mail m:listMail) {
            if (m.getId() == id){
                mail = m;
            }
        }
        return mail;
    }

    @Override
    public void update(Mail mail) {
        for (int i = 0; i <listMail.size() ; i++) {
            if (listMail.get(i).getId() == mail.getId()){
                listMail.get(i).setLanguage(mail.getLanguage());
                listMail.get(i).setPageSize(mail.getPageSize());
                listMail.get(i).setEnable(mail.isEnable());
                listMail.get(i).setSignature(mail.getSignature());
            }
        }
    }
}
