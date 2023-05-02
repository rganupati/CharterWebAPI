# CharterWebAPI

Problem statement: A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.
 
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every
dollar spent between $50 and $100 in each transaction.
(e.g., a $120 purchase = 2x$20 + 1x$50 = 90 points).
 
Given a record of every transaction during a three-month period, calculate the reward points earned for
each customer per month and total.

There exists 3 API calls in this project. 
1. /rewards - This will showcase all the total rewards earned for each customer
2/ rewards/{customerId} - This API call will show case all the rewards for a specific customer. This would showcase, current previous and second previous months.
3. /transactions - This API will return all the transaction by customer id ASC. This will show case the transaction entry for each and every customer and their bill amounts too. 



