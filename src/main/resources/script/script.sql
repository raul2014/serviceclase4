create schema if not exists autos ;

use autos;

create table if not exists cars (
   id int(11) not null auto_increment,
   brand varchar(255) null default '',
   model varchar(255) null default '',
   price decimal null,
   primary key (id)
)