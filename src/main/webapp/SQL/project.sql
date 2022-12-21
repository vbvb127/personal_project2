create table members(
    m_num number(5)  not null,
    m_id varchar2(10) unique not null,
    m_password varchar2(15) not null,
    m_name varchar(17) not null,
    m_tel varchar(20),
    m_address varchar(100),
    m_level number(2) default 2 not null,

-- primary key 조건
    constraint  pk_members PRIMARY KEY (m_num)
);


insert into members values(1,'admin','admin','관리자','010-0000-0000','서울특별시 강남구',1);
insert into members  values(2,'guest1','1234','손님1','010-1111-1111','서울특별시 동작구',2);


create table members(
    m_num number(5)  not null,
    m_id varchar2(10) unique not null,
    m_password varchar2(15) not null,
    m_name varchar(17) not null,
    m_tel varchar(20),
    m_address varchar(100),
    m_level number(2) default 2 not null,

-- primary key 조건
    constraint  pk_members PRIMARY KEY (m_num)
);


insert into item values ('1','캐릭터 양말','귀여운 캐릭터 양말입니다.',1500,10);
insert into item values ('2','크리스마크 케이크','맛있는 초코 케이크 팝니다.',25000,3);