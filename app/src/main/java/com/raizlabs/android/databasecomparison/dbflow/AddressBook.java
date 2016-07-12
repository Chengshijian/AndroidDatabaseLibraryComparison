package com.raizlabs.android.databasecomparison.dbflow;

import com.raizlabs.android.databasecomparison.interfaces.IAddressBook;
import com.raizlabs.android.databasecomparison.MainActivity;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.structure.cache.BaseCacheableModel;

import java.util.Collection;

/**
 * Description:
 */
@Table(tableName = "AddressBook", databaseName = DBFlowDatabase.NAME)
@ModelContainer
public class AddressBook extends BaseCacheableModel implements IAddressBook<AddressItem, Contact> {

    @PrimaryKey(autoincrement = true)
    @Column
    long id;

    @Column(name = "name")
    String name;

    @Column(name = "author")
    String author;

    Collection<AddressItem> addresses;

    Collection<Contact> contacts;

    @Override
    public void setId(long id) {
        // not needed because we have autoincrementing keys
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAddresses(Collection<AddressItem> addresses) {
        this.addresses = addresses;
    }

    public Collection<AddressItem> getAddresses() {
        if (addresses == null) {
            addresses = new Select().from(AddressItem.class).where(Condition.column(AddressItem$Table.ADDRESSBOOK_ADDRESSBOOK).is(id)).queryList();
        }
        return addresses;
    }

    public Collection<Contact> getContacts() {
        if (contacts == null) {
            contacts = new Select().from(Contact.class).where(Condition.column(Contact$Table.ADDRESSBOOK_ADDRESSBOOK).is(id)).queryList();
        }
        return contacts;
    }

    public void setContacts(Collection<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public void saveAll() {
        super.insert();
        for (AddressItem addressItem : addresses) {
            addressItem.saveAll();
        }
        for (Contact contact : contacts) {
            contact.saveAll();
        }
    }

    @Override
    public int getCacheSize() {
        return MainActivity.ADDRESS_BOOK_COUNT;
    }

}