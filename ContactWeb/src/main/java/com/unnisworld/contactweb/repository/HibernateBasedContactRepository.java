package com.unnisworld.contactweb.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unnisworld.contactweb.domainobjects.Contact;

@Repository
public class HibernateBasedContactRepository implements ContactRepository {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	public void addContact(Contact contact) {
		sessionFactory.getCurrentSession().save(contact);		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Contact> listContact() {
		return sessionFactory.getCurrentSession().createQuery("from Contact")
                .list();	
	}

	@Transactional
	public void removeContact(Integer id) {
        Contact contact = (Contact) sessionFactory.getCurrentSession().load(
                Contact.class, id);
        if (null != contact) {
            sessionFactory.getCurrentSession().delete(contact);
        }
	}

}
