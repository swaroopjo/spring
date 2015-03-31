package com.lio.sc.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSourceTest {

	public static void main(String[] args) throws SQLException{
		
		BasicDataSource source = new BasicDataSource(); 
		
		source.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
		source.setUrl("jdbc:derby:SHOPPING_CART;create=true");
		
		ResultSet rs = source.getConnection().createStatement().executeQuery("select product0_.PRODUCTID as PRODUCTID0_, product0_.CATEGORYID as CATEGORYID0_, product0_.PRICE as PRICE0_, product0_.PRODUCTNAME as PRODUCTN4_0_, product0_.SUPPLIERID as SUPPLIERID0_, product0_.UNIT as UNIT0_ from PRODUCTS product0_");
		
		while(rs.next()){
			System.out.println(rs.getString("PRODUCTID0_"));
		}
	}
}
