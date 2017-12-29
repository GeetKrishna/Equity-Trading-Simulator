/*Author: Nicholas Maffattone
**Date Modified: 14-April-2015
**Title: Baba Broker Schema
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
	IsAdmin NUMBER(1) NOT NULL		/*Should be 1 or 0*/
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