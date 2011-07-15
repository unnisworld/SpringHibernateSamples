package com.unnisworld.contactweb.repository;

import java.util.List;

import com.unnisworld.contactweb.domainobjects.Contact;

public interface ContactRepository {
    public void addContact(Contact contact);
    public List<Contact> listContact();
    public void removeContact(Integer id);
}
