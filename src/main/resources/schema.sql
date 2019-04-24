create table if not exists user (
    user_no bigint not null auto_increment,
    nickname varchar(10) not null,
    primary key(user_no)
);