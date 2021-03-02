##Software Requirements Specification

VERBS
CLASSES
Variables
CONSTANTS
The banking system exists with a default admin username and pass set to "admin". Admin logs into admin panel and register an account.  An account includes full name, phone number, account number, password, isNewAccount boolean, balance, account type, and transaction detail. When an admin registers an account, system generates temporary password, and an account number and displays it under the account username, by checking whether the account is new.  
An account can either be saving, checking or credit. A savings account gets 2% interest per month and random users are randomly rewarded once every month upon withdrawing money from the bank, the reward amount will be equivalent to 3% of the banks monthly profit, checking account does not get interest, and credit account gets 3% deduction monthly for unsetteled credit amount in the users bank account, if the credit balance is more than 0 and the account has positive credits, the account gets a 2% monthly interest.

An admin can deduct/withdraw money from any of these accounts, and it gets notified to account. An account owner can login using account number temporary password, and system asks user to enter new password and the isNew value will be changed to false. A users temporary password is a hashcode of users account number.

An account has 3 options, 1. Check balance, 2. Withdraw money, 3. Transfer money, and an admin can do all of these 3 things on a users account but account will be notified of anything that admin does. Admin makes money deposit and notification goes to respective account.

Finally, Admin has access to the bank dashboard, where admin can see the daily transactions, total available amount in all accounts, how much money the bank has made each day, each month, each week, and how much has been spent on loan and credit.
Objects
•	Admin
•	Admin Panel
•	Account (polymorphic to Savings, Credit, Checking)
•	Transaction
•	Reward
•	Notification
•	Bank 
•	Bank Dashboard
##Verbs
•	Login 
•	Register an account
•	Generate temporary password and permanent account number
•	getInterestRate
•	withdraw money
•	reward monthly
•	check whether account is new
•	notify
•	deposit
•	display daily transaction
•	display total available amount in all accounts
•	display how much money bank has made today
•	display how much money bank 
•	calculate total loan and credit



