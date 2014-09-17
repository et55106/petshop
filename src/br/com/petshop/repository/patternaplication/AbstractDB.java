package br.com.petshop.repository.patternaplication;

import java.util.List;

public abstract class AbstractDB<T> {
	public abstract Boolean persist(T object);
	public abstract Boolean remove(T object);
	public abstract List<T> list();
	public abstract Boolean update(T objet);
}
