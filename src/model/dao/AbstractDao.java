package model.dao;

import java.util.Map;
import java.util.List;

public abstract class AbstractDao<T> {

	private int lastInsertedId;

	private Map data;

	public boolean insert(T record) {
		return false;
	}

	public boolean delete(int id) {
		return false;
	}

	public boolean update(int id, T record) {
		return false;
	}

	public T getById(int id) {
		return null;
	}

	public List<T> getAll() {
		return null;
	}

	public int getLastInsertedId() {
		return 0;
	}

}
