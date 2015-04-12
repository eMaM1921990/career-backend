/**
 * 
 */
package com.career.dao;

import java.util.List;

/**
 * @author emam
 * 
 */

public interface dao<T> {
	public String Presist(T o);

	public T Find(String phone);

	public String remove(int id);

	public List<T> FindAll();

	public List<T> FindByParentId(int parentID);

	public List<T> FindBy(T o);

	public String update(T o);
}
