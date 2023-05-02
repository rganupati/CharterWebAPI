# CharterWebAPI

Problem statement: A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.
 
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every
dollar spent between $50 and $100 in each transaction.
(e.g., a $120 purchase = 2x$20 + 1x$50 = 90 points).
 
Given a record of every transaction during a three-month period, calculate the reward points earned for
each customer per month and total.

There exists 3 API calls in this project. 
1. /rewards - This will showcase all the total rewards earned for each customer
2. /rewards/{customerId} - This API call will show case all the rewards for a specific customer. This would showcase, current previous and second previous months.
3. /transactions - This API will return all the transaction by customer id ASC. This will show case the transaction entry for each and every customer and their bill amounts too. 

Steps to run the application:
1. Project structure - Controllers, Entities, Models, Service Layer and theie corresponding Implementations, Custom Exceptions are created under the src/main/java packaging structure. 
2. 'application.properties' file and 'data.sql' files are under the resources folder of the project. 
3. data.sql is the file that holds the database schema. Tables are created and transactions related data is also persisted to h2 database. 
4. application.properties will hold all the configuration needed to connect to database, databse initialization etc.
5. 'CharterWebApiApplication' is the main program that is the kick start to start the API service. 
6. Upon starting the application, as the h2 database is present only at runtime, the tables are created and data gets inserted into the database. The databse can be acccessed using http://localhost:8080/h2-console. Data can be reviewed in the browser itself.
7. When all the beans, repositories and beans of different beans of layers like controller, service and repositories are created, then application will be running safely on the default port 8080.
8. The application can be tested on any API testing platforms.



