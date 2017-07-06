package com.github.analytic.business;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tea {
 private String Name;
 private String Id;
 private  String Colour;
 
public Tea(String name, String id, String colour) {
	super();
	Name = name;
	Id = id;
	Colour = colour;
}

public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
public String getColour() {
	return Colour;
}
public void setColour(String colour) {
	Colour = colour;
}


}
