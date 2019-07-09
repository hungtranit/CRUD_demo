alter SEQUENCE amigo_team_id_seq RESTART with 1;
insert into amigo_team (mailGroup, members, slogan) values ('amigo@mail.aavn.com', 'five', 'workhard');

alter SEQUENCE member_id_seq RESTART with 1;
insert into member (firstName, lastName, gender, email, amigo_team) values ('Hai', 'Nguyen', 'male', 'nmhai1995@gmail.com',1);
insert into member (firstName, lastName, gender, email, amigo_team) values ('Huy', 'Nguyen', 'male', 'huynguyen@gmail.com', 1);
insert into member (firstName, lastName, gender, email, amigo_team) values ('Thao', 'Doan', 'female', 'nmhai1995@gmail.com', 1);