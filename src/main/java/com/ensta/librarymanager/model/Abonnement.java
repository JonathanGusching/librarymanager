package com.ensta.librarymanager.model;

import java.util.NoSuchElementException;

public enum Abonnement {
	
	BASIC("BASIC",2), PREMIUM("PREMIUM",5), VIP("VIP",20);
	private String name;
	private int limit;
	
	private Abonnement(String name, int limit) {
		this.setName(name);
		this.setLimit(limit);
	}
	
	private void setLimit(int limit2) {
		limit=limit2;
	}

	public static Abonnement fromString(String value) {
        for (Abonnement abo: Abonnement.values()) {
            if (abo.name.equals(value)) {
                return abo;
            }
        }
        throw new NoSuchElementException("no enum for value " + value);
    }

	public String getName() {
		return name;
	}
	public int getLimit() {
		return limit;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
