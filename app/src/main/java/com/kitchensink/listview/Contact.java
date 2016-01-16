package com.kitchensink.listview;

import java.util.ArrayList;
import java.util.List;

public class Contact {
	
	protected String firstName;
	protected String lastName;
	
	public Contact(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public static List<Contact> getSampleContacts() {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact("Rosenda","Caywood"));
		contacts.add(new Contact("Faye","Baggs"));
		contacts.add(new Contact("Marx","Ratner"));
		contacts.add(new Contact("Rosario","Hambly"));
		contacts.add(new Contact("Elenor","Hipps"));
		contacts.add(new Contact("Harry","Willits"));
		contacts.add(new Contact("Ashlyn","Burbank"));
		contacts.add(new Contact("Lucrecia","Pemberton"));
		contacts.add(new Contact("Gabrielle","Machen"));
		contacts.add(new Contact("Agripina","Odriscoll"));
		contacts.add(new Contact("Xochitl","Caryl"));
		contacts.add(new Contact("Junko","Smythe"));
		contacts.add(new Contact("Kacie","Boydston"));
		contacts.add(new Contact("Layne","Ugalde"));
		contacts.add(new Contact("Lavonda","Stumpf"));
		contacts.add(new Contact("Jannette","Holleran"));
		contacts.add(new Contact("Willis","Baumert"));
		contacts.add(new Contact("Nelly","Puglia"));
		contacts.add(new Contact("Domingo","Bulkley"));
		contacts.add(new Contact("Alba","Coyne"));
		contacts.add(new Contact("Henriette","Villano"));
		contacts.add(new Contact("Guadalupe","Ravenell"));
		contacts.add(new Contact("Lucille","Conyers"));
		contacts.add(new Contact("Breann","Minyard"));
		contacts.add(new Contact("Rosamaria","Simpler"));
		contacts.add(new Contact("Gaynell","Swanson"));
		contacts.add(new Contact("Brigida","Tall"));
		contacts.add(new Contact("Somer","Manney"));
		contacts.add(new Contact("Sade","Dobos"));
		contacts.add(new Contact("Marlen","Halley"));
		contacts.add(new Contact("Rhona","Compos"));
		contacts.add(new Contact("Garret","Bancroft"));
		contacts.add(new Contact("Sandra","Grignon"));
		contacts.add(new Contact("Jayna","Haun"));
		contacts.add(new Contact("Jannie","Damian"));
		contacts.add(new Contact("Dreama","Milstead"));
		contacts.add(new Contact("Lizzie","Demmer"));
		contacts.add(new Contact("Belva","Geier"));
		contacts.add(new Contact("Nyla","Siciliano"));
		contacts.add(new Contact("Ashley","Rolland"));
		contacts.add(new Contact("Shera","Weathersby"));
		contacts.add(new Contact("Hermina","Spillane"));
		contacts.add(new Contact("Harmony","Munsch"));
		contacts.add(new Contact("Arvilla","Borgeson"));
		contacts.add(new Contact("Estelle","Duden"));
		contacts.add(new Contact("Kara","Harden"));
		contacts.add(new Contact("Benedict","Hedlund"));
		contacts.add(new Contact("Zachery","Infantino"));
		contacts.add(new Contact("Forest","Snelgrove"));
		contacts.add(new Contact("Tory","Curfman"));
		return contacts;
	}
	
}
