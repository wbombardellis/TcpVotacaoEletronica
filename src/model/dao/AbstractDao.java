package model.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import model.entity.Identificavel;

public abstract class AbstractDao<T extends Identificavel> {

	private int lastInsertedId = 0;

	private Map<Integer, T> data = new HashMap<>();

	public boolean insert(T record) {
		assert record != null;
		
		T recorded = this.data.get(record.getId());
		
		if (recorded == null) {
			this.lastInsertedId = record.getId();
			this.data.put(this.lastInsertedId, record);
			
			return true;
		} else {
			return false;
		}
	}

	public boolean delete(int id) {
		return (this.data.remove(id) != null);
	}

	public boolean update(int id, T record) {
		T recorded = this.data.get(id);
		
		if (recorded != null) {
			this.data.put(id, record);
			
			return true;
		} else {
			return false;
		}
	}

	public T getById(int id) {
		return this.data.get(id);
	}

	public Collection<T> getAll() {
		return Collections.unmodifiableCollection(this.data.values());
	}

	public int getLastInsertedId() {
		return this.lastInsertedId;
	}

}
