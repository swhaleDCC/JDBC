/*create database AssetsDB;*/
use AssetsDB;

create table Creature(
    creatureno int auto_increment primary key,
    chinaname varchar(50) not null,   /* 中文学名 */
    latinname varchar(50) not null,   /* 拉丁名 */
    category varchar(50) not null,    /* 分类信息 */
    feature varchar(50) not null,    /* 生物学特征 */
    distributed varchar(50) not null,    /* 生态分布 */
    literature varchar(50),    /* 文献信息 */
    remarks varchar(50)    /* 备注 */
);
