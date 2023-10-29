package ca.sheridancollege.thiarapr.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.thiarapr.beans.Store;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class StoreRepository {
	
	private NamedParameterJdbcTemplate jdbc;
	
	public void addStore(Store store) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		
		String query = "INSERT INTO stores (store_name, store_location, phone_no, opening_time)"
				+ "VALUES (:na, :la, :pn, :ot);"
				+ "";
		parameter.addValue("na", store.getStoreName());
		parameter.addValue("la", store.getLocation());
		parameter.addValue("pn", store.getPhoneNo());
		parameter.addValue("ot", store.getOpeningTime());

jdbc.update(query, parameter);

	}
	public List<Store> getStores() {
        String query = "SELECT store_name FROM stores"; // Adjust the SQL query as needed
        MapSqlParameterSource params = new MapSqlParameterSource();
        ArrayList<Store> stores =
				(ArrayList<Store>)jdbc.query(query, params,
				new BeanPropertyRowMapper<Store>(Store.class));
				return stores;
    }
	
	

}
