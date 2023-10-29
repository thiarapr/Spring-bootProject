package ca.sheridancollege.thiarapr.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {
	private int id;
	private String storeName;
	private String location;
	private String phoneNo;
	private String openingTime;
	
}
