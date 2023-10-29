package ca.sheridancollege.thiarapr.repository;


import java.util.ArrayList;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.thiarapr.beans.Items;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ItemRepository {
    private NamedParameterJdbcTemplate jdbc;
    
    

    public void addItem(Items item) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        String query = "INSERT INTO items (name, store_name, price, description) " +
                       "VALUES (:name, :storeName, :price, :description )";
        params.addValue("name", item.getName());
        params.addValue("storeName", item.getStoreName());
        params.addValue("price", item.getPrice());
        params.addValue("description", item.getDescription());
       
        jdbc.update(query, params);
    }
    
 
    public ArrayList<Items>  getItems(String sname) {
		MapSqlParameterSource parameters=new MapSqlParameterSource();
		String query="SELECT * FROM items WHERE store_name =:sname";
		parameters.addValue("sname", sname);
		ArrayList<Items> Items= (ArrayList<Items>)jdbc.query(query, parameters,
				new BeanPropertyRowMapper<Items>(Items.class));
		if(Items.size()>0)
			return Items;
			return null;
	}
       
	public void deletebyid(int id) {
		MapSqlParameterSource parametrers=new MapSqlParameterSource();
		String query="DELETE  FROM items WHERE id=:id";
		parametrers.addValue("id",id);
		jdbc.update(query,parametrers);
		
	}
	public Items getItemById(int id) {
		MapSqlParameterSource parameters=new MapSqlParameterSource();
		String query="SELECT * FROM items WHERE id=:id";
		parameters.addValue("id", id);
		ArrayList<Items> contacts= (ArrayList<Items>)jdbc.query(query, parameters,
				new BeanPropertyRowMapper<Items>(Items.class));
		if(contacts.size()>0)
			return contacts.get(0);
			return null;
	}
	public void editItem(Items item) {
		MapSqlParameterSource parametrers=new MapSqlParameterSource();
		String query="UPDATE items SET name=:na,store_name=:sn,price=:pr,description=:de WHERE id=:id";
		parametrers.addValue("id",item.getId());
		parametrers.addValue("na",item.getName());
		parametrers.addValue("sn",item.getStoreName());
		parametrers.addValue("pr",item.getPrice());
		parametrers.addValue("de",item.getDescription());
		jdbc.update(query, parametrers);
	}
	

}
