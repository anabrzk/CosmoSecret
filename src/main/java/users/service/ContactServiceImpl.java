package users.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import users.dao.ContactDao;
import users.model.Contact;

@Service
public class ContactServiceImpl implements ContactService{

    private ContactDao contactDao;

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    @Transactional
    public void addContact(Contact contact) {
        this.contactDao.addContact(contact);
    }
}
