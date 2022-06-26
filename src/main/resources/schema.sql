-- CREATE
-- DATABASE  springit;
-- SET SCHEMA springit;

--
-- SQLINES DEMO *** or table `comment`
--
DROP TABLE IF EXISTS comment;

-- SQLINES LICENSE FOR EVALUATION USE ONLY
-- CREATE SEQUENCE comment_seq;

CREATE TABLE comment
(
    id                 bigint NOT NULL DEFAULT NEXTVAL('comment_seq'),
    created_by         varchar(255)    DEFAULT NULL,
    creation_date      timestamp(0)    DEFAULT NULL,
    last_modified_by   varchar(255)    DEFAULT NULL,
    last_modified_date timestamp(0)    DEFAULT NULL,
    body               varchar(255)    DEFAULT NULL,
    link_id            bigint          DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE INDEX FKoutxw6g1ndh1t6282y0fwvami ON comment (link_id);

--
-- SQLINES DEMO *** or table `link`
--

DROP TABLE IF EXISTS link;
-- SQLINES LICENSE FOR EVALUATION USE ONLY
-- CREATE SEQUENCE link_seq;

-- CREATE SEQUENCE link_seq;

CREATE TABLE link
(
    id                 bigint NOT NULL DEFAULT NEXTVAL('link_seq'),
    created_by         varchar(255)    DEFAULT NULL,
    creation_date      timestamp(0)    DEFAULT NULL,
    last_modified_by   varchar(255)    DEFAULT NULL,
    last_modified_date timestamp(0)    DEFAULT NULL,
    title              varchar(255)    DEFAULT NULL,
    url                varchar(255)    DEFAULT NULL,
    PRIMARY KEY (id)
);
