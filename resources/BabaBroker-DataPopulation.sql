/*Author: Nicholas Maffattone
**Date Modified: 20-April-2015
**Title: Baba Broker Data Population
*/

/*Drop all constraints*/
ALTER TABLE Block
DROP CONSTRAINT fk_BlockSymbol;

ALTER TABLE Execution
DROP CONSTRAINT fk_ExecBlock;

ALTER TABLE Security_Config_Mapping
DROP CONSTRAINT fk_MapSecurity;

ALTER TABLE Security_Config_Mapping
DROP CONSTRAINT fk_MapConfig;


/*Delete all data*/
DELETE FROM Block;
DELETE FROM Configuration_Info;
DELETE FROM Execution;
DELETE FROM Security;
DELETE FROM Security_Config_Mapping;
DELETE FROM User_T;

/*Drop and purge tables*/
DROP TABLE Block PURGE;
DROP TABLE Configuration_Info PURGE;
DROP TABLE Execution PURGE;
DROP TABLE Security PURGE;
DROP TABLE Security_Config_Mapping PURGE;
DROP TABLE User_T PURGE;

/*Create tables*/
CREATE TABLE Block(
    BlockID INTEGER PRIMARY KEY,
    Side VARCHAR2(6) NOT NULL,
    Symbol VARCHAR2(10) NOT NULL,
    Status VARCHAR2(30) NOT NULL,
    LimitPrice NUMBER(10, 2),
    StopPrice NUMBER(10, 2),
    TotalQty INTEGER NOT NULL,
    ExecutedQty INTEGER NOT NULL,
    TimeReceived TIMESTAMP NOT NULL,
    TimeExecuted TIMESTAMP
);

CREATE TABLE Configuration_Info(
    ConfigID INTEGER PRIMARY KEY,
    MaxPriceSpread INTEGER NOT NULL,
    MaxNumExecutions INTEGER NOT NULL,
    MaxTimeBtwExecutions INTEGER NOT NULL,
    ProbPercentFullExec INTEGER NOT NULL
);

CREATE TABLE Execution(
    ExecutionID INTEGER PRIMARY KEY,
    BlockID INTEGER NOT NULL,
    Qty INTEGER NOT NULL,
    Price NUMBER(10, 2) NOT NULL,
    TimeOfExecution TIMESTAMP NOT NULL
);

CREATE TABLE Security_Config_Mapping(
    SecuritySymbol VARCHAR2(10) PRIMARY KEY,
    ConfigID INTEGER NOT NULL,
    DateCreated TIMESTAMP
);

CREATE TABLE Security(
    SecuritySymbol VARCHAR2(10) PRIMARY KEY,
    SecurityName VARCHAR2(50) NOT NULL,
    LastTradePrice NUMBER(10, 2) NOT NULL
);

CREATE TABLE User_T(
    Username VARCHAR2(25) PRIMARY KEY,
    Password VARCHAR2(25) NOT NULL,
    Email VARCHAR2(50) NOT NULL,
    IsAdmin NUMBER(1) NOT NULL        /*Should be 1 or 0*/
);

/*Add all foreign key constraints*/
ALTER TABLE Block
ADD CONSTRAINT fk_BlockSymbol FOREIGN KEY (Symbol) REFERENCES Security(SecuritySymbol);

ALTER TABLE Execution
ADD CONSTRAINT fk_ExecBlock FOREIGN KEY (BlockID) REFERENCES Block(BlockID);

ALTER TABLE Security_Config_Mapping
ADD CONSTRAINT fk_MapSecurity FOREIGN KEY (SecuritySymbol) REFERENCES Security(SecuritySymbol);

ALTER TABLE Security_Config_Mapping
ADD CONSTRAINT fk_MapConfig FOREIGN KEY (ConfigID) REFERENCES Configuration_Info(ConfigID);

/*User Data*/
INSERT INTO User_T(Username, Password, Email, IsAdmin)
    VALUES ('Nick', 'bulb', 'nickjomaffa@gmail.com', 1);
INSERT INTO User_T(Username, Password, Email, IsAdmin)
    VALUES ('Utkarsh', 'GMI', 'upujari@sapient.com', 1);
INSERT INTO User_T(Username, Password, Email, IsAdmin)
    VALUES ('Sathwick', 'GMI', 'sgoparapu@sapient.com', 1);
INSERT INTO User_T(Username, Password, Email, IsAdmin)
    VALUES ('abroker', 'broke', 'nmaffattone@sapient.com', 1);
    
/*Security Data*/
INSERT INTO Security(SecuritySymbol, SecurityName, LastTradePrice)
    VALUES('GOOG', 'Google Inc', 539.17);
INSERT INTO Security(SecuritySymbol, SecurityName, LastTradePrice)
    VALUES('APPL', 'Apple Inc', 126.85);
INSERT INTO Security(SecuritySymbol, SecurityName, LastTradePrice)
    VALUES('KO', 'The Coca-Cola Co', 40.70);
INSERT INTO Security(SecuritySymbol, SecurityName, LastTradePrice)
    VALUES('NKE', 'Nike Inc', 99.27);
INSERT INTO Security(SecuritySymbol, SecurityName, LastTradePrice)
    VALUES('FB', 'Facebook Inc', 83.01);
INSERT INTO Security(SecuritySymbol, SecurityName, LastTradePrice)
    VALUES('PEP', 'PepsiCo Inc', 95.53);
INSERT INTO Security(SecuritySymbol, SecurityName, LastTradePrice)
    VALUES('IOC', 'Indian Oil Corporation', 50.46);
INSERT INTO Security(SecuritySymbol, SecurityName, LastTradePrice)
    VALUES('BABA', 'Alibaba Group Holding Ltd', 84.28);
INSERT INTO Security(SecuritySymbol, SecurityName, LastTradePrice)
    VALUES('MCD', 'McDonalds Corporation', 97.44);
INSERT INTO Security(SecuritySymbol, SecurityName, LastTradePrice)
    VALUES('TWTR', 'Twitter Inc', 51.62);
INSERT INTO Security(SecuritySymbol, SecurityName, LastTradePrice)
    VALUES('VOD', 'Vodafone Group Plc', 229.20);
INSERT INTO Security(SecuritySymbol, SecurityName, LastTradePrice)
    VALUES('T', 'AT&T Inc', 32.88);
    
/*Configuration_Info Data*/
INSERT INTO Configuration_Info(ConfigId, MaxPriceSpread, MaxNumExecutions, MaxTimeBtwExecutions, ProbPercentFullExec)
    VALUES(1, 5, 10, 15, 60);
INSERT INTO Configuration_Info(ConfigId, MaxPriceSpread, MaxNumExecutions, MaxTimeBtwExecutions, ProbPercentFullExec)
    VALUES(2, 2, 15, 15, 70);
INSERT INTO Configuration_Info(ConfigId, MaxPriceSpread, MaxNumExecutions, MaxTimeBtwExecutions, ProbPercentFullExec)
    VALUES(3, 8, 10, 15, 80);
    
/*Security_Config_Mapping Data*/
INSERT INTO Security_Config_Mapping(SecuritySymbol, ConfigId)
    VALUES('GOOG', 2);
INSERT INTO Security_Config_Mapping(SecuritySymbol, ConfigId)
    VALUES('APPL', 1);
INSERT INTO Security_Config_Mapping(SecuritySymbol, ConfigId)
    VALUES('BABA', 3);
INSERT INTO Security_Config_Mapping(SecuritySymbol, ConfigId)
    VALUES('KO', 2);
    
/*Block Data*/
INSERT INTO Block(BlockID, Side, Symbol, Status, TotalQty, ExecutedQty, TimeReceived)
    VALUES(1001, 'BUY', 'GOOG', 'NEW', 50, 0, CURRENT_TIMESTAMP);
INSERT INTO Block(BlockID, Side, Symbol, Status, LimitPrice, TotalQty, ExecutedQty, TimeReceived, TimeExecuted)
    VALUES(1002, 'BUY', 'APPL', 'PARTIALLY EXECUTED', 128.00, 70, 20, TO_TIMESTAMP('2015-04-13 15:15:03', 'YYYY-MM-DD HH24:MI:SS'), CURRENT_TIMESTAMP);
INSERT INTO Block(BlockID, Side, Symbol, Status, LimitPrice, TotalQty, ExecutedQty, TimeReceived, TimeExecuted)
    VALUES(1003, 'SELL', 'APPL', 'PARTIALLY EXECUTED', 125.00, 50, 30, TO_TIMESTAMP('2015-04-13 15:21:11', 'YYYY-MM-DD HH24:MI:SS'), CURRENT_TIMESTAMP);
INSERT INTO Block(BlockID, Side, Symbol, Status, TotalQty, ExecutedQty, TimeReceived, TimeExecuted)
    VALUES(1004, 'BUY', 'KO', 'FULLY EXECUTED', 40, 40, TO_TIMESTAMP('2015-04-13 15:21:11', 'YYYY-MM-DD HH24:MI:SS'), CURRENT_TIMESTAMP);
INSERT INTO Block(BlockID, Side, Symbol, Status, TotalQty, ExecutedQty, TimeReceived, TimeExecuted)
    VALUES(1005, 'SELL', 'GOOG', 'PARTIALLY EXECUTED', 100, 30, TO_TIMESTAMP('2015-04-17 15:21:11', 'YYYY-MM-DD HH24:MI:SS'), CURRENT_TIMESTAMP);
    
/*Execution Data*/
INSERT INTO Execution(ExecutionID, BlockID, QTY, Price, TimeOfExecution)
    VALUES(1001, 1002, 20, 127.11, CURRENT_TIMESTAMP);
INSERT INTO Execution(ExecutionID, BlockID, QTY, Price, TimeOfExecution)
    VALUES(1002, 1003, 30, 126.30, CURRENT_TIMESTAMP);
INSERT INTO Execution(ExecutionID, BlockID, QTY, Price, TimeOfExecution)
    VALUES(1003, 1004, 20, 40.70, TO_TIMESTAMP('2015-04-14 11:08:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Execution(ExecutionID, BlockID, QTY, Price, TimeOfExecution)
    VALUES(1004, 1004, 20, 40.75, CURRENT_TIMESTAMP);
INSERT INTO Execution(ExecutionID, BlockID, QTY, Price, TimeOfExecution)
    VALUES(1005, 1005, 4, 539.13, TO_TIMESTAMP('2015-04-17 15:12:30', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Execution(ExecutionID, BlockID, QTY, Price, TimeOfExecution)
    VALUES(1006, 1005, 7, 539.44, TO_TIMESTAMP('2015-04-17 15:12:40', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Execution(ExecutionID, BlockID, QTY, Price, TimeOfExecution)
    VALUES(1007, 1005, 5, 539.71, TO_TIMESTAMP('2015-04-17 15:12:50', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Execution(ExecutionID, BlockID, QTY, Price, TimeOfExecution)
    VALUES(1008, 1005, 2, 540.23, TO_TIMESTAMP('2015-04-17 15:13:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Execution(ExecutionID, BlockID, QTY, Price, TimeOfExecution)
    VALUES(1009, 1005, 6, 540.88, TO_TIMESTAMP('2015-04-17 15:13:10', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Execution(ExecutionID, BlockID, QTY, Price, TimeOfExecution)
    VALUES(1010, 1005, 3, 541.01, TO_TIMESTAMP('2015-04-17 15:13:20', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Execution(ExecutionID, BlockID, QTY, Price, TimeOfExecution)
    VALUES(1011, 1005, 3, 541.22, CURRENT_TIMESTAMP);

​