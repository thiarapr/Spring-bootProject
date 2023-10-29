package ca.sheridancollege.thiarapr.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Items {
    private int id;
    private String name;
    private String storeName; // Add the storeName property here
    private double price;
    private String description;
 
}
