# Service Oriented Architecture
Applications: 
- E-Commerce
- Order Service
- Product Service

E-Commerce : Simple UI that allows Customers to purchase items, Includes Cart, Payment, Order Reviews

Order Service: WebServices that allow Order information to the Users(Customer/Business Users for analytics) 

Product Service: Webservices that allow Product Information to Users(Customers/Business Users/Warehouse managers)

E-Commerce is the Customer facing application used by the customers to order products. The application uses services provided
by the Product services application to get all the product information as Json. When the Customer wants to purchase an item,
An order is created and the Order services are invoked for persisting the order. The Order Service again talks to the Shipping
services(Future) to prepare for the shipment.

E-Commerce application is built using Spring mvc. Angular js
Services are built using Restful web services( Jersey), Spring for integration, Hibernate ORM, Oracle DB. 
Authentication and Roles are designed using Apache Shiro framework and integrated with all the applications using Spring. 
Use Apache Http Client for invoking the services. JaxB for Marshalling and Unmarshalling. All the Bean classes used by the 
applications must be packaged as common-beans.jar 
