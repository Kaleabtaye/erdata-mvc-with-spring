
    create table comment (
       id bigint not null auto_increment,
        content varchar(255),
        posted_by varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table donor (
       id bigint not null auto_increment,
        enabled integer,
        name varchar(255) not null,
        passcode varchar(255) not null,
        user_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table donor_comments (
       donor_id bigint not null,
        comments_id bigint not null
    ) engine=InnoDB

    create table donor_free_aid (
       donor_id bigint not null,
        free_aid_id bigint not null
    ) engine=InnoDB

    create table donor_jobs (
       donor_id bigint not null,
        jobs_id bigint not null
    ) engine=InnoDB

    create table donor_news (
       donor_id bigint not null,
        news_id bigint not null
    ) engine=InnoDB

    create table donor_role (
       donor_id bigint not null,
        role_id bigint not null,
        primary key (donor_id, role_id)
    ) engine=InnoDB

    create table free_aid (
       id bigint not null auto_increment,
        aid_type integer not null,
        amount float not null,
        material_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table job (
       id bigint not null auto_increment,
        experience integer not null,
        expiration_date varchar(255),
        have_qualification bit not null,
        salary double precision not null,
        type varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table news (
       id bigint not null auto_increment,
        content varchar(255),
        title varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table reciever (
       id bigint not null auto_increment,
        no_of_family_members integer,
        educational_background varchar(255),
        enabled integer,
        name varchar(255) not null,
        passcode varchar(255) not null,
        user_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table reciever_comments (
       reciever_id bigint not null,
        comments_id bigint not null
    ) engine=InnoDB

    create table reciever_free_aid (
       reciever_id bigint not null,
        free_aid_id bigint not null
    ) engine=InnoDB

    create table reciever_jobs (
       reciever_id bigint not null,
        jobs_id bigint not null
    ) engine=InnoDB

    create table reciever_news (
       reciever_id bigint not null,
        news_id bigint not null
    ) engine=InnoDB

    create table reciever_role (
       reciever_id bigint not null,
        role_id bigint not null,
        primary key (reciever_id, role_id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        enabled integer,
        passcode varchar(255) not null,
        user_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table donor_comments 
       add constraint FKjbqanaow9ai14qygo4rri2g1s 
       foreign key (comments_id) 
       references comment (id)

    alter table donor_comments 
       add constraint FKonvhrhfueke059lpv9xyvf6rj 
       foreign key (donor_id) 
       references donor (id)

    alter table donor_free_aid 
       add constraint FK1oc422h7qhdc1ef98wp6bqoa5 
       foreign key (free_aid_id) 
       references free_aid (id)

    alter table donor_free_aid 
       add constraint FKkx2bhhdemd04thwbe4nhiultj 
       foreign key (donor_id) 
       references donor (id)

    alter table donor_jobs 
       add constraint FKf5aq5ictsnjqgnj22grp6v7ru 
       foreign key (jobs_id) 
       references job (id)

    alter table donor_jobs 
       add constraint FKmhoc29nakb5nw81v0035b21vs 
       foreign key (donor_id) 
       references donor (id)

    alter table donor_news 
       add constraint FK2490fyilsq753wasjr7dq0rkx 
       foreign key (news_id) 
       references news (id)

    alter table donor_news 
       add constraint FKl8qct0tktnkemx95m3e07f6n7 
       foreign key (donor_id) 
       references donor (id)

    alter table donor_role 
       add constraint FKodd1ll8b9o5gcfo6rjlp2enh5 
       foreign key (role_id) 
       references role (id)

    alter table donor_role 
       add constraint FKrdhct8pfv59yai78ickcgaw15 
       foreign key (donor_id) 
       references donor (id)

    alter table reciever_comments 
       add constraint FK3m9m56rwvo0noqqei5p55xg30 
       foreign key (comments_id) 
       references comment (id)

    alter table reciever_comments 
       add constraint FKspabpqo5ecnodxi71vil6p66o 
       foreign key (reciever_id) 
       references reciever (id)

    alter table reciever_free_aid 
       add constraint FKawqqaeqdobe091ne69ffbayq 
       foreign key (free_aid_id) 
       references free_aid (id)

    alter table reciever_free_aid 
       add constraint FK113ih6o0i5cmv24vj08x5kqr 
       foreign key (reciever_id) 
       references reciever (id)

    alter table reciever_jobs 
       add constraint FK6magr5xina1rpc91tcwewpoqt 
       foreign key (jobs_id) 
       references job (id)

    alter table reciever_jobs 
       add constraint FKb9yoy1vm87nslucfprhwqqm74 
       foreign key (reciever_id) 
       references reciever (id)

    alter table reciever_news 
       add constraint FK8vutbr70phhu86fv3kdhj9lim 
       foreign key (news_id) 
       references news (id)

    alter table reciever_news 
       add constraint FKgiqhd52t7t4909ds1rp2jpr6g 
       foreign key (reciever_id) 
       references reciever (id)

    alter table reciever_role 
       add constraint FKd79t40udyv4eab04cs8lq56em 
       foreign key (role_id) 
       references role (id)

    alter table reciever_role 
       add constraint FK96wkx7kmw0n83v01mn6lmso1d 
       foreign key (reciever_id) 
       references reciever (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)
