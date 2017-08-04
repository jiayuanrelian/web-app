/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/6/8 16:30:21                            */
/*==============================================================*/


drop table if exists T_GZ_ACTION;

drop table if exists T_GZ_EVENT;

drop table if exists T_GZ_EVENT_WD;

drop table if exists T_GZ_INFO;

drop table if exists T_GZ_INFO_VS_EVENT_WD;

/*==============================================================*/
/* Table: T_GZ_ACTION                                           */
/*==============================================================*/
create table T_GZ_ACTION
(
   ID                   bigint not null auto_increment,
   REF_CHILD_PRODUCT_ID bigint,
   REF_GZ_INFO_ID       bigint,
   REF_WD_ID            bigint,
   POINT_RATE           int,
   POINT_BASE           int,
   REASON               varchar(200),
   STATUS               char(1),
   DEL_FLAG             char(1) comment '0:未删除;1:已删除',
   DATE_CREATED         datetime,
   CREATER_ID           varchar(32),
   DATE_UPDATED         datetime,
   UPDATER_ID           varchar(32),
   primary key (ID)
);

/*==============================================================*/
/* Table: T_GZ_EVENT                                            */
/*==============================================================*/
create table T_GZ_EVENT
(
   id                   bigint not null auto_increment,
   CODE                 varchar(32) comment '用于生成drl文件的 唯一名称',
   NAME                 varchar(20),
   STATUS               char(1) comment '(0:未生效;1:已生效;2:已过期)',
   TYPE                 varchar(32),
   DEL_FLAG             char(1) comment '0:未删除;1:已删除',
   DATE_CREATED         datetime,
   CREATER_ID           varchar(32),
   DATE_UPDATED         datetime,
   UPDATER_ID           varchar(32),
   primary key (id)
);

/*==============================================================*/
/* Table: T_GZ_EVENT_WD                                         */
/*==============================================================*/
create table T_GZ_EVENT_WD
(
   ID                   bigint not null auto_increment,
   CODE                 varchar(32),
   NAME                 varchar(32),
   STATUS               char(1),
   TYPE                 char(1) comment '(0:文本;1:数字;2:枚举;3日期)',
   TYPE_KEY             varchar(32),
   REF_EVENT_ID         bigint,
   IS_COUNTER           char(1) comment '0:否;1:是',
   REF_COUNTER_ID       bigint,
   DEL_FLAG             char(1) comment '0:未删除;1:已删除',
   DATE_CREATED         datetime,
   CREATER_ID           varchar(32),
   DATE_UPDATED         datetime,
   UPDATER_ID           varchar(32),
   IS_PUBLIC            char(1) comment '0:否;1:是',
   PUBLIC_TYPE          varchar(32),
   primary key (ID)
);

/*==============================================================*/
/* Table: T_GZ_INFO                                             */
/*==============================================================*/
create table T_GZ_INFO
(
   ID                   bigint not null auto_increment,
   CODE                 varchar(32) comment '规则文件里面的 rule名称',
   NAME                 varchar(32),
   TYPE                 char(1) comment '(0:活动规则;1:任务规则)',
   BRIEF_INFO           varchar(320),
   STATUS               char(1) comment '(0:未生效;1:已生效;2:已失效)',
   VERSION              int comment '每修改一次,增加一,时刻监控,重新生成规则文件',
   REF_EVENT_ID         bigint,
   REF_ZCD_ID           bigint,
   DEL_FLAG             char(1) comment '0:未删除;1:已删除',
   POINT_VALIDATE       datetime,
   DATE_CREATED         datetime,
   CREATER_ID           varchar(32),
   DATE_UPDATED         datetime,
   UPDATER_ID           varchar(32),
   primary key (ID)
);

/*==============================================================*/
/* Table: T_GZ_INFO_VS_EVENT_WD                                 */
/*==============================================================*/
create table T_GZ_INFO_VS_EVENT_WD
(
   ID                   bigint not null auto_increment,
   INFO_ID              bigint,
   EVENT_WD_ID          bigint,
   OPERATOR             varchar(32),
   OPE_VALUE            varchar(32),
   SORT_NUM             int,
   primary key (ID)
);

