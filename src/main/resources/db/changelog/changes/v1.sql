-- changeset author:aguirre

create sequence hibernate_sequence;

alter sequence hibernate_sequence owner to postgres;

create table if not exists book
(
	id bigint not null
		constraint book_pkey
			primary key,
	isbn varchar(255)
		constraint uk_ehpdfjpu1jm3hijhj4mm0hx9h
			unique,
	pages_number integer not null,
	published timestamp not null,
	publisher varchar(255),
	short_description text,
	subtitle varchar(255),
	thumbnail_url varchar(255),
	title varchar(255)
);

alter table book owner to postgres;

create table if not exists book_authors
(
	book_id bigint not null
		constraint fks4xm7q8i3uxvaiswj1c35nnxw
			references book,
	authors varchar(255)
);

alter table book_authors owner to postgres;

create table if not exists person
(
	id bigint not null
		constraint person_pkey
			primary key,
	date_of_birth date,
	email varchar(255),
	name varchar(255),
	password varchar(255),
	username varchar(255)
);

alter table person owner to postgres;

create table if not exists collection
(
	id bigint not null
		constraint collection_pkey
			primary key,
	title varchar(255),
	person_id bigint not null
		constraint fk42dgusyiw014k38rubaurd5xl
			references person
);

alter table collection owner to postgres;

create table if not exists collection_books
(
	collection_book_id bigint not null
		constraint fk32u8w86u5w8ni9bt9ql7vwlhe
			references collection,
	books_id bigint not null
		constraint fktivhew0hev91gmos6oyee1r08
			references book
);

alter table collection_books owner to postgres;

