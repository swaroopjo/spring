# Spring - Rabbit - Mongo Integration with RSVP

Overview:

  Integrate Spring with Rabbit to send RSVP feed data and Rabbit MQ forwards the messages to the Listeners. These Listeners inturn save the data into Mongo DB. 
  
Prerequisites: 
  Intall RabbitMQ 3.4.4 : http://www.rabbitmq.com/download.html
  
  Intall Mongo DB 3.0 : http://www.mongodb.org/downloads
  
  Eclipse for Java Programming
  
  Maven for pulling the dependancy jars and Building the project. 
  
  
Startup Process: 

1. RabbitMQ server and MongoDB server needs to be started before the application is run.

2. Import the project into Workspace and run maven Install on the pom.xml 

3. Navigate to com.lio.main.Initializer and Run the java program. 

Internal Functionality: 

Initializer will create tow threads (listener and sender) and starts them. 

1. Listener: 

  Listener is configured to use rabbit-listener-context.xml which contains the Rabbit Server connection configuration. 
For now there is only one Listener (RsvpListener) that listens to the messages whose Routing key starts with "rsvp"
RabbitMQ FEED-EXCHANGE will look at the routing pattern and forwards the message to appropriate Listener. 

2. Sender: 

  Sender is configured to use rabbit-sender-context.xml which contains the Server configuration and the exchange name that the message needs to be forarded to. 
RsvpDataExtractor will create a new thread that makes a http web service call to the http://stream.meetup.com/2/rsvps to pull the data which is added to the BlockingQueue. The DataExctractor polls the Queue for new Data and puclishes the message to the FEED-EXCHANGE. 

3. MongoDB: 

  RsvpDao is configured to use mongo-context.xml for database configuration. Currently it supports only Create operation (in CRUD). The listener's onMessage method is called when the new message is recieved. This message is stored in MongoDB as is. 

Conclusion: 

  The application can be exteded to store Feed data from Facebook or Twitter and many Social networking sites. Rabbit MQ seem to handle the high loads and has good fail-over strategy. When the listener is down, The messages seem o be stored in a cache and when the listener is up, these messages are forwarded to the  appropriate listeners as a bactch. 
  
