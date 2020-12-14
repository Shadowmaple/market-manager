drop database if exists Supermarket;
create database Supermarket;

use Supermarket;

-- 员工
create table staff(
	staff_id int auto_increment primary key,
	staff_name varchar(20) not null,
	staff_type int default 0 comment "员工类别",
	entry_time datetime,
	password varchar(30) not null
);

insert staff(staff_name, staff_type, entry_time,password)values("admin", 2, now(),'admin');
insert staff(staff_name, staff_type, entry_time,password)values("张三", 0, now(),'123456');

-- 商品
create table goods(
	goods_id int auto_increment primary key,
	goods_name varchar(20) not null,
	goods_num int default 0,
	sell_price float not null,-- 出售价
	pur_price float not null, -- 进货价
	stratey tinyint default 0
);

insert goods(goods_name,goods_num,sell_price,pur_price) values('鸡蛋',1000,10,5);
insert goods(goods_name,goods_num,sell_price,pur_price) values('食用盐',200,7,3);
insert goods(goods_name,goods_num,sell_price,pur_price) values('羽绒服',50,600,450);
insert goods(goods_name,goods_num,sell_price,pur_price) values('可口可乐',1000,3,2);
insert goods(goods_name,goods_num,sell_price,pur_price) values('百事可乐',1000,3,2);
insert goods(goods_name,goods_num,sell_price,pur_price) values('矿泉水',1000,2,1);


-- vip
create table VIP(
	VIP_id int auto_increment primary key,
	VIP_name varchar(20) not null,
	VIP_money float default 0,
	createtime datetime not null,
	validitytime datetime,
	is_use tinyint
);

-- 销售记录
create table sale_record(
	sale_id int auto_increment primary key,
	staff_id int,
	goods_id int,
	number int default 0,
	money float comment "销售总金额",
	stratey tinyint default 0 comment "销售策略", 
	createtime datetime,
	foreign key(staff_id) references staff(staff_id),
	foreign key(goods_id) references goods(goods_id)
);


-- 进货记录
create table pur_record(
	pur_id int auto_increment primary key,
	staff_id int,
	goods_id int,
	number int default 0 comment "进货量",
	price float comment "进货单价",
	money float comment "进货总价",
	createtime datetime,
	foreign key(staff_id) references staff(staff_id),
	foreign key(goods_id) references goods(goods_id)
);


-- 计划进货
create table pur_plan(
	id int auto_increment primary key,
	goods_id int,
	goods_name varchar(20),
	num int default 0,
	pirce float not null comment "进货单价",
	foreign key(goods_id) references goods(goods_id)
);


-- 视图用来缺货以及滞销预警
-- 存货过多有
create view too_much_goods
as select *
from goods
where goods_num > 500;

-- 少货有
create view shortage_goods
as select *
from goods
where goods_num < 50;

-- 缺货有
create view null_goods
as select *
from goods
where goods_num = 0;


-- 触发器，主要用于数据的同步更新

-- 进货更新库存
DELIMITER $
create trigger pur_goods_num
	after insert on pur_record for each row
begin
	update goods 
	set goods_num = goods_num+new.number
	where goods.goods_id = new.goods_id;
end $
DELIMITER ;

-- 出售更新库存
DELIMITER $
create trigger sell_goods_num
	after insert on sale_record for each row
begin
	update goods 
	set goods_num = goods_num-new.number
	where goods.goods_id = new.goods_id;
end $
DELIMITER ;

-- 退货操作
DELIMITER $
create trigger delete_goods_num
	after delete on sale_record for each row
begin
	update goods 
	set goods_num = goods_num +old.number
	where goods.goods_id = old.goods_id;
end $
DELIMITER ;


insert sale_record(staff_id,goods_id,number,money,createtime) values(1,1,10,100,now());
insert sale_record(staff_id,goods_id,number,money,createtime) values(1,1,10,100,now());
insert sale_record(staff_id,goods_id,number,money,createtime) values(1,3,10,6000,now());


insert pur_record(staff_id,goods_id,number,price,money,createtime) values(1,1,50,5,250,now());
insert pur_record(staff_id,goods_id,number,price,money,createtime) values(1,1,50,5,250,now());

delete from sale_record where sale_id = 1;
