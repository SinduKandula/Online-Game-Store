CREATE TABLE Customer
(
 CustomerID int,
 UserName varchar(100),
 Password varchar(100),
 CustomerName varchar(500),
 CustomerAddress varchar(1000),
 CustomerPhoneNumber varchar(50),
 CONSTRAINT Customer_PK PRIMARY KEY(CustomerID)
);

CREATE TABLE CD
(
 CDASIN int,
 Title varchar(100),
 Price float,
 CONSTRAINT CD_PK PRIMARY KEY(CDASIN)
);

CREATE TABLE Purchasing
(
 CustomerID int,
 CDASIN int,
 PurchasingTime varchar(200),
 CONSTRAINT Purchasing_PK PRIMARY KEY(CustomerID, CDASIN),
 CONSTRAINT Purchasing_CusomterID_FK FOREIGN KEY(CustomerID) REFERENCES Customer(CustomerID),
 CONSTRAINT Purchasing_CDASIN_FK FOREIGN KEY(CDASIN) REFERENCES CD(CDASIN)
);

CREATE TABLE CustomerShoppingCart
(
 CustomerID int,
 CDASIN int,
 CONSTRAINT CustomerShoppingCart_PK PRIMARY KEY(CustomerID, CDASIN),
 CONSTRAINT CustomerShoppingCart_CustID_FK FOREIGN KEY(CustomerID) REFERENCES Customer(CustomerID),
 CONSTRAINT CustomerShoppingCart_CDASIN_FK FOREIGN KEY(CDASIN) REFERENCES CD(CDASIN)
);

CREATE TABLE Login
(
 UserID int,
 UserName varchar(100),
 Password varchar(100),
 CONSTRAINT Login_PK PRIMARY KEY(UserID)
);

CREATE SEQUENCE Customer_Sequence
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE CD_Sequence
START WITH 1
INCREMENT BY 1;

SELECT Table_Name FROM User_Tables;
SELECT Sequence_Name FROM User_Sequences;

-- DROP TABLE Purchasing
-- DROP TABLE CustomerShoppingCart
-- DROP TABLE CD
-- DROP TABLE Customer


SELECT SUM(CD.Price)
FROM CD INNER JOIN Purchasing 
ON CD.CDASIN = Purchasing.CDASIN AND Purchasing.CustomerID = 1

