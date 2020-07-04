use master
go
create database BTL_LichTrinhBay
go
use BTL_LichTrinhBay
go
create table Admins(
	ID char(30) not null primary key,
	Admin_name nchar(30) not null,
	Admin_email nchar(30) not null,
	Admin_phone nchar(30) not null,
	Admin_password nchar(30) not null,
)
create table Roles(
	ID char(30) not null primary key,
	Title nvarchar(100) not null, 
)
create table Countries(
	ID char(30) not null primary key,
	Name nvarchar(100) not null,
)
create table Aircrafts(
	ID char(30) not null primary key,
	Name nvarchar(100) not null,
	MakeModel nvarchar(100) not null,
	TotalSeats int not null,
	EconomySeats int not null,
	BusinessSeats int not null,
)
create table Offices(
	ID char(30) not null primary key,
	CountryID char(30) not null,
	Title nvarchar(100) not null,
	Phone char(30) not null,
	Contact nvarchar(100) not null,
	Constraint FK_Offices_Countries foreign key(CountryID)
		references Countries(ID),
)
create table Users(
	ID char(30) not null primary key,
	RoleID char(30) not null,
	OfficeID char(30) not null,
	Email varchar(30) not null,
	Password varchar(30) not null,
	FirstName nvarchar(30) not null,
	LastName nvarchar(30) not null,
	BirthDate date not null,
	Active bit not null,
	Constraint FK_Users_Roles foreign key(RoleID)
		references Roles(ID),
	Constraint FK_Users_Offices foreign key(OfficeID)
		references Offices(ID),
)
create table AirPorts(
	ID char(30) not null primary key,
	CountryID char(30) not null,
	IATACode nvarchar(100) not null,
	Name nvarchar(100) not null,
	Constraint FK_AirPorts_Countries foreign key(CountryID)
		references Countries(ID),
)
create table Routes(
	ID char(30) not null primary key,
	DepartureAiportID char(30) not null,
	ArrivalAiportID char(30) not null,
	Distance float not null,
	FlightTime time not null,
	Constraint FK1_Routes_AirPorts foreign key(DepartureAiportID)
		references AirPorts(ID),
	Constraint FK2_Routes_AirPorts foreign key(ArrivalAiportID)
		references AirPorts(ID),
)
create table Schedules(
	ID char(30) not null primary key,
	Date date not null,
	Time time not null,
	AircraftID char(30) not null,
	RouteID char(30) not null,
	FlightNumber char(30) not null,
	EconomyPrice money not null,
	Confirmed bit not null,
	Constraint FK2_Schedules_Aircrafts foreign key(AircraftID)
		references Aircrafts(ID),
		Constraint FK2_Schedules_Routes foreign key(RouteID)
		references Routes(ID),
)

go
insert into Admins values ('AD01','Pham Van Trao','a','123','123')



insert into Roles values ('R01','Admin')
insert into Roles values ('R02','Staff')
insert into Roles values ('R03','Passenger')

insert into Countries values ('VNM',N'Vietnam') 
insert into Countries values ('USA',N'United State') 
insert into Countries values ('FRA',N'France') 
insert into Countries values ('JAP',N'Japan') 
insert into Countries values ('BRA',N'Brazil') 
insert into Countries values ('RUS',N'Russia') 

insert into Aircrafts values ('AC01','Aircraft01','MD01',250,200,50)
insert into Aircrafts values ('AC02','Aircraft02','MD02',300,200,100)
insert into Aircrafts values ('AC03','Aircraft03','MD03',150,0,150)
insert into Aircrafts values ('AC04','Aircraft04','MD04',300,300,0)
insert into Aircrafts values ('AC05','Aircraft05','MD05',400,200,200)

insert into Offices values ('OFF01','VNM','Vietnam office','+84','Hanoi, Vietnam') 
insert into Offices values ('OFF02','VNM','Vietnam office','+84','Ho Chi Minh city, Vietnam') 
insert into Offices values ('OFF03','USA','USA office','+03','Washington D.C, USA') 
insert into Offices values ('OFF04','FRA','France office','+04','Paris, France') 
insert into Offices values ('OFF05','JAP','Japan office','+80','Tokyo, Japan') 
insert into Offices values ('OFF06','RUS','Russia office','+34','Moscow, Russia') 
insert into Offices values ('OFF07','BRA','Brazil office','+13',N'São Paulo, Brazil') 

insert into Users values ('USER01','R01','OFF01','Admin01@gmail.com','123456','Pham','Van Trao','1999-05-21',1) 
insert into Users values ('USER02','R02','OFF02','Staff01@gmail.com','123456','Luis','Felipe','1993-1-3',1) 
insert into Users values ('USER03','R03','OFF03','Passenger01@gmail.com','123456','Tran','Vuong','1994-4-1',1) 
insert into Users values ('USER04','R01','OFF04','Admin02@gmail.com','123456','Pham Ngoc','Bao Cham','1991-2-3',1) 
insert into Users values ('USER05','R02','OFF05','Staff02@gmail.com','123456','Le','Nguyen Toan','1990-12-30',1) 
insert into Users values ('USER06','R03','OFF06','Passenger03@gmail.com','123456','Lionel','Messi','1987-11-30',1) 
insert into Users values ('USER07','R03','OFF07','Passenger04@gmail.com','123456','Lima','Ronaldo','1976-11-30',1) 
insert into Users values ('USER08','R03','OFF02','Staff03@gmail.com','123456','Cristiano','Ronaldo','1985-11-30',1) 

insert into Airports values ('HAN','VNM','HAN',N'Sân bay quốc tế Nội Bài') 
insert into Airports values ('SGN','VNM','SGN',N'Sân bay quốc tế Tân Sơn Nhất') 
insert into Airports values ('LAS','USA','LAS',N'Sân bay quốc tế McCarran') 
insert into Airports values ('MWH','USA','MWH',N'Sân bay quốc tế Quận Grant') 
insert into Airports values ('HIJ','JAP','HIJ',N'Sân bay Hiroshima') 
insert into Airports values ('NGS','JAP','NGS',N'Sân bay Nagasaki') 
insert into Airports values ('AJU','BRA','AJU',N'Sân bay Santa Maria') 
insert into Airports values ('BSB','BRA','BSB',N'Sân bay quốc tế Brasília') 
insert into Airports values ('CAY','FRA','CAY',N'Sân bay Cayenne – Félix Eboué') 
insert into Airports values ('DME','RUS','DME',N'Sân bay quốc tế Domodedovo') 
insert into Airports values ('KHV','RUS','KHV',N'Sân bay NOVY') 
insert into Airports values ('ADH','RUS','ADH',N'Sân bay Amderma') 
insert into Airports values ('CSY','RUS','CSY',N'Sân bay Cheboksary') 

insert into Routes values ('ROU01','HAN','SGN',10,'13:00:00') 
insert into Routes values ('ROU02','SGN','LAS',1000,'13:00:00') 
insert into Routes values ('ROU03','LAS','HAN',13000,'13:00:00') 
insert into Routes values ('ROU04','NGS','KHV',8000,'13:00:00') 
insert into Routes values ('ROU05','DME','KHV',12000,'13:00:00') 
insert into Routes values ('ROU06','KHV','CSY',10000,'13:00:00') 
insert into Routes values ('ROU07','CSY','NGS',11500,'13:00:00') 

insert into Schedules values ('SCH01','2019-8-31','11:00:00','AC01','ROU01',256,$150,1)
insert into Schedules values ('SCH02','2019-8-31','11:00:00','AC01','ROU02',111,$110,1) 
insert into Schedules values ('SCH03','2019-9-1','11:00:00','AC02','ROU03',454,$100,1) 
insert into Schedules values ('SCH04','2019-9-2','11:00:00','AC02','ROU04',7252,$150,1) 
insert into Schedules values ('SCH05','2019-8-3','11:00:00','AC03','ROU05',123,$240,1) 
insert into Schedules values ('SCH06','2019-8-4','11:00:00','AC03','ROU06',451,$90,1) 
insert into Schedules values ('SCH07','2019-8-5','11:00:00','AC04','ROU07',12,$99,1) 
insert into Schedules values ('SCH08','2019-8-30','14:00:00','AC04','ROU07',11,$125,1) 
insert into Schedules values ('SCH09','2019-8-30','16:00:00','AC05','ROU04',123,$130,1) 
insert into Schedules values ('SCH10','2019-8-30','22:00:00','AC05','ROU03',145,$165,1) 

select *from Roles
select *from Countries
select *from Aircrafts
select *from AirPorts
select *from Users
select *from Schedules
select *from Routes
select *from Offices