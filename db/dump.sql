--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: Account; Type: TABLE; Schema: public; Owner: sora; Tablespace: 
--

CREATE TABLE "Account" (
    pengguna character varying(50) NOT NULL,
    pass character varying(50) NOT NULL,
    section character varying(30) NOT NULL
);


ALTER TABLE "Account" OWNER TO sora;

--
-- Name: Arsip; Type: TABLE; Schema: public; Owner: sora; Tablespace: 
--

CREATE TABLE "Arsip" (
    id_pembelian integer NOT NULL,
    tgl_pembelian date NOT NULL,
    jml_pembelian integer NOT NULL,
    total_harga integer NOT NULL,
    id_bahan integer NOT NULL
);


ALTER TABLE "Arsip" OWNER TO sora;

--
-- Name: Bahan; Type: TABLE; Schema: public; Owner: sora; Tablespace: 
--

CREATE TABLE "Bahan" (
    id_bahan integer NOT NULL,
    nama_bahan character varying(100) NOT NULL,
    jumlah_bahan integer NOT NULL,
    harga_satuan integer NOT NULL,
    id_merk integer NOT NULL,
    id_warna integer NOT NULL,
    id_jenis integer NOT NULL,
    id_supplier integer NOT NULL
);


ALTER TABLE "Bahan" OWNER TO sora;

--
-- Name: Bahan_id_bahan_seq; Type: SEQUENCE; Schema: public; Owner: sora
--

CREATE SEQUENCE "Bahan_id_bahan_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Bahan_id_bahan_seq" OWNER TO sora;

--
-- Name: Bahan_id_bahan_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: sora
--

ALTER SEQUENCE "Bahan_id_bahan_seq" OWNED BY "Bahan".id_bahan;


--
-- Name: Jenis; Type: TABLE; Schema: public; Owner: sora; Tablespace: 
--

CREATE TABLE "Jenis" (
    id_jenis integer NOT NULL,
    nama_jenis character varying(100) NOT NULL
);


ALTER TABLE "Jenis" OWNER TO sora;

--
-- Name: Jenis_id_jenis_seq; Type: SEQUENCE; Schema: public; Owner: sora
--

CREATE SEQUENCE "Jenis_id_jenis_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Jenis_id_jenis_seq" OWNER TO sora;

--
-- Name: Jenis_id_jenis_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: sora
--

ALTER SEQUENCE "Jenis_id_jenis_seq" OWNED BY "Jenis".id_jenis;


--
-- Name: Merk; Type: TABLE; Schema: public; Owner: sora; Tablespace: 
--

CREATE TABLE "Merk" (
    id_merk integer NOT NULL,
    nama_merk character varying(100) NOT NULL
);


ALTER TABLE "Merk" OWNER TO sora;

--
-- Name: Merk_id_merk_seq; Type: SEQUENCE; Schema: public; Owner: sora
--

CREATE SEQUENCE "Merk_id_merk_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Merk_id_merk_seq" OWNER TO sora;

--
-- Name: Merk_id_merk_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: sora
--

ALTER SEQUENCE "Merk_id_merk_seq" OWNED BY "Merk".id_merk;


--
-- Name: Pembelian; Type: TABLE; Schema: public; Owner: sora; Tablespace: 
--

CREATE TABLE "Pembelian" (
    id_pembelian integer NOT NULL,
    tgl_pembelian date NOT NULL,
    jml_pembelian integer NOT NULL,
    total_harga integer NOT NULL,
    id_bahan integer NOT NULL
);


ALTER TABLE "Pembelian" OWNER TO sora;

--
-- Name: Pembelian_id_pembelian_seq; Type: SEQUENCE; Schema: public; Owner: sora
--

CREATE SEQUENCE "Pembelian_id_pembelian_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Pembelian_id_pembelian_seq" OWNER TO sora;

--
-- Name: Pembelian_id_pembelian_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: sora
--

ALTER SEQUENCE "Pembelian_id_pembelian_seq" OWNED BY "Pembelian".id_pembelian;


--
-- Name: Retur; Type: TABLE; Schema: public; Owner: sora; Tablespace: 
--

CREATE TABLE "Retur" (
    id_retur integer NOT NULL,
    tgl_retur date NOT NULL,
    tgl_pembelian date NOT NULL,
    jml_pembelian integer NOT NULL,
    total_harga integer NOT NULL,
    id_bahan integer NOT NULL
);


ALTER TABLE "Retur" OWNER TO sora;

--
-- Name: Retur_id_retur_seq; Type: SEQUENCE; Schema: public; Owner: sora
--

CREATE SEQUENCE "Retur_id_retur_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Retur_id_retur_seq" OWNER TO sora;

--
-- Name: Retur_id_retur_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: sora
--

ALTER SEQUENCE "Retur_id_retur_seq" OWNED BY "Retur".id_retur;


--
-- Name: Supplier; Type: TABLE; Schema: public; Owner: sora; Tablespace: 
--

CREATE TABLE "Supplier" (
    id_supplier integer NOT NULL,
    nama_supplier character varying(100) NOT NULL,
    alamat_supplier character varying(200) NOT NULL
);


ALTER TABLE "Supplier" OWNER TO sora;

--
-- Name: Supplier_alamat_supplier_seq; Type: SEQUENCE; Schema: public; Owner: sora
--

CREATE SEQUENCE "Supplier_alamat_supplier_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Supplier_alamat_supplier_seq" OWNER TO sora;

--
-- Name: Supplier_alamat_supplier_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: sora
--

ALTER SEQUENCE "Supplier_alamat_supplier_seq" OWNED BY "Supplier".alamat_supplier;


--
-- Name: Supplier_id_supplier_seq; Type: SEQUENCE; Schema: public; Owner: sora
--

CREATE SEQUENCE "Supplier_id_supplier_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Supplier_id_supplier_seq" OWNER TO sora;

--
-- Name: Supplier_id_supplier_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: sora
--

ALTER SEQUENCE "Supplier_id_supplier_seq" OWNED BY "Supplier".id_supplier;


--
-- Name: Supplier_nama_supplier_seq; Type: SEQUENCE; Schema: public; Owner: sora
--

CREATE SEQUENCE "Supplier_nama_supplier_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Supplier_nama_supplier_seq" OWNER TO sora;

--
-- Name: Supplier_nama_supplier_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: sora
--

ALTER SEQUENCE "Supplier_nama_supplier_seq" OWNED BY "Supplier".nama_supplier;


--
-- Name: Warna; Type: TABLE; Schema: public; Owner: sora; Tablespace: 
--

CREATE TABLE "Warna" (
    id_warna integer NOT NULL,
    nama_warna character varying(20) NOT NULL
);


ALTER TABLE "Warna" OWNER TO sora;

--
-- Name: Warna_id_warna_seq; Type: SEQUENCE; Schema: public; Owner: sora
--

CREATE SEQUENCE "Warna_id_warna_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Warna_id_warna_seq" OWNER TO sora;

--
-- Name: Warna_id_warna_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: sora
--

ALTER SEQUENCE "Warna_id_warna_seq" OWNED BY "Warna".id_warna;


--
-- Name: id_seq; Type: SEQUENCE; Schema: public; Owner: sora
--

CREATE SEQUENCE id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE id_seq OWNER TO sora;

--
-- Name: id_bahan; Type: DEFAULT; Schema: public; Owner: sora
--

ALTER TABLE ONLY "Bahan" ALTER COLUMN id_bahan SET DEFAULT nextval('"Bahan_id_bahan_seq"'::regclass);


--
-- Name: id_jenis; Type: DEFAULT; Schema: public; Owner: sora
--

ALTER TABLE ONLY "Jenis" ALTER COLUMN id_jenis SET DEFAULT nextval('"Jenis_id_jenis_seq"'::regclass);


--
-- Name: id_merk; Type: DEFAULT; Schema: public; Owner: sora
--

ALTER TABLE ONLY "Merk" ALTER COLUMN id_merk SET DEFAULT nextval('"Merk_id_merk_seq"'::regclass);


--
-- Name: id_pembelian; Type: DEFAULT; Schema: public; Owner: sora
--

ALTER TABLE ONLY "Pembelian" ALTER COLUMN id_pembelian SET DEFAULT nextval('"Pembelian_id_pembelian_seq"'::regclass);


--
-- Name: id_retur; Type: DEFAULT; Schema: public; Owner: sora
--

ALTER TABLE ONLY "Retur" ALTER COLUMN id_retur SET DEFAULT nextval('"Retur_id_retur_seq"'::regclass);


--
-- Name: id_supplier; Type: DEFAULT; Schema: public; Owner: sora
--

ALTER TABLE ONLY "Supplier" ALTER COLUMN id_supplier SET DEFAULT nextval('"Supplier_id_supplier_seq"'::regclass);


--
-- Name: id_warna; Type: DEFAULT; Schema: public; Owner: sora
--

ALTER TABLE ONLY "Warna" ALTER COLUMN id_warna SET DEFAULT nextval('"Warna_id_warna_seq"'::regclass);


--
-- Data for Name: Account; Type: TABLE DATA; Schema: public; Owner: sora
--

COPY "Account" (pengguna, pass, section) FROM stdin;
adit2	adit2	Produksi
adit1	adit1	Gudang
adit3	adit3	Pembelian
\.


--
-- Data for Name: Arsip; Type: TABLE DATA; Schema: public; Owner: sora
--

COPY "Arsip" (id_pembelian, tgl_pembelian, jml_pembelian, total_harga, id_bahan) FROM stdin;
1	2015-01-01	1000	25000000	4
2	2015-01-04	1000	35000000	1
4	2015-01-03	1000	33000000	2
3	2015-01-03	1000	34000000	3
\.


--
-- Data for Name: Bahan; Type: TABLE DATA; Schema: public; Owner: sora
--

COPY "Bahan" (id_bahan, nama_bahan, jumlah_bahan, harga_satuan, id_merk, id_warna, id_jenis, id_supplier) FROM stdin;
4	Benang MD 4020 96% modal 160gr/m2	280	25000	3	12	3	7
2	Benang 100% ctn rib combed 180gr/m2	300	34000	1	17	3	8
5	Kain MT 7558 plain 92% nylon 158gr/m2	250	34000	3	12	3	7
3	Kain Poly CTN	400	32000	2	14	4	7
1	Kain 5% solid 135-145 gr/m2	200	35000	1	15	5	6
\.


--
-- Name: Bahan_id_bahan_seq; Type: SEQUENCE SET; Schema: public; Owner: sora
--

SELECT pg_catalog.setval('"Bahan_id_bahan_seq"', 5, true);


--
-- Data for Name: Jenis; Type: TABLE DATA; Schema: public; Owner: sora
--

COPY "Jenis" (id_jenis, nama_jenis) FROM stdin;
3	100% CTTN
4	100% CTTN NON MERC
5	100% CTTN INTERLOCK
\.


--
-- Name: Jenis_id_jenis_seq; Type: SEQUENCE SET; Schema: public; Owner: sora
--

SELECT pg_catalog.setval('"Jenis_id_jenis_seq"', 5, true);


--
-- Data for Name: Merk; Type: TABLE DATA; Schema: public; Owner: sora
--

COPY "Merk" (id_merk, nama_merk) FROM stdin;
1	Netz
2	Elasthan
3	Spandex
\.


--
-- Name: Merk_id_merk_seq; Type: SEQUENCE SET; Schema: public; Owner: sora
--

SELECT pg_catalog.setval('"Merk_id_merk_seq"', 3, true);


--
-- Data for Name: Pembelian; Type: TABLE DATA; Schema: public; Owner: sora
--

COPY "Pembelian" (id_pembelian, tgl_pembelian, jml_pembelian, total_harga, id_bahan) FROM stdin;
2	2015-01-04	1000	35000000	1
3	2015-01-03	1000	34000000	3
24	2015-06-07	1000	25000000	1
25	2015-06-07	1000	25000000	1
\.


--
-- Name: Pembelian_id_pembelian_seq; Type: SEQUENCE SET; Schema: public; Owner: sora
--

SELECT pg_catalog.setval('"Pembelian_id_pembelian_seq"', 25, true);


--
-- Data for Name: Retur; Type: TABLE DATA; Schema: public; Owner: sora
--

COPY "Retur" (id_retur, tgl_retur, tgl_pembelian, jml_pembelian, total_harga, id_bahan) FROM stdin;
21	2015-06-07	2015-01-01	1000	25000000	4
\.


--
-- Name: Retur_id_retur_seq; Type: SEQUENCE SET; Schema: public; Owner: sora
--

SELECT pg_catalog.setval('"Retur_id_retur_seq"', 21, true);


--
-- Data for Name: Supplier; Type: TABLE DATA; Schema: public; Owner: sora
--

COPY "Supplier" (id_supplier, nama_supplier, alamat_supplier) FROM stdin;
6	Toyobo	Jl. Daan Mogot No.6 Jatiuwung, Tangerang.
7	Kahatex	Jl. Platina No. 2 Sangiang, Tangerang.
8	Leeven	Jl. Jasinga No 10 Tenjo, Bogor.
\.


--
-- Name: Supplier_alamat_supplier_seq; Type: SEQUENCE SET; Schema: public; Owner: sora
--

SELECT pg_catalog.setval('"Supplier_alamat_supplier_seq"', 1, false);


--
-- Name: Supplier_id_supplier_seq; Type: SEQUENCE SET; Schema: public; Owner: sora
--

SELECT pg_catalog.setval('"Supplier_id_supplier_seq"', 8, true);


--
-- Name: Supplier_nama_supplier_seq; Type: SEQUENCE SET; Schema: public; Owner: sora
--

SELECT pg_catalog.setval('"Supplier_nama_supplier_seq"', 1, false);


--
-- Data for Name: Warna; Type: TABLE DATA; Schema: public; Owner: sora
--

COPY "Warna" (id_warna, nama_warna) FROM stdin;
12	White
13	Marine
14	Magenta
15	Compass
16	Green Stripe
17	Cream
18	Grey
\.


--
-- Name: Warna_id_warna_seq; Type: SEQUENCE SET; Schema: public; Owner: sora
--

SELECT pg_catalog.setval('"Warna_id_warna_seq"', 18, true);


--
-- Name: id_seq; Type: SEQUENCE SET; Schema: public; Owner: sora
--

SELECT pg_catalog.setval('id_seq', 1, false);


--
-- Name: Account_pkey; Type: CONSTRAINT; Schema: public; Owner: sora; Tablespace: 
--

ALTER TABLE ONLY "Account"
    ADD CONSTRAINT "Account_pkey" PRIMARY KEY (pengguna);


--
-- Name: Bahan_pkey; Type: CONSTRAINT; Schema: public; Owner: sora; Tablespace: 
--

ALTER TABLE ONLY "Bahan"
    ADD CONSTRAINT "Bahan_pkey" PRIMARY KEY (id_bahan);


--
-- Name: Jenis_pkey; Type: CONSTRAINT; Schema: public; Owner: sora; Tablespace: 
--

ALTER TABLE ONLY "Jenis"
    ADD CONSTRAINT "Jenis_pkey" PRIMARY KEY (id_jenis);


--
-- Name: Merk_pkey; Type: CONSTRAINT; Schema: public; Owner: sora; Tablespace: 
--

ALTER TABLE ONLY "Merk"
    ADD CONSTRAINT "Merk_pkey" PRIMARY KEY (id_merk);


--
-- Name: Pembelian_pkey; Type: CONSTRAINT; Schema: public; Owner: sora; Tablespace: 
--

ALTER TABLE ONLY "Pembelian"
    ADD CONSTRAINT "Pembelian_pkey" PRIMARY KEY (id_pembelian);


--
-- Name: Retur_pkey; Type: CONSTRAINT; Schema: public; Owner: sora; Tablespace: 
--

ALTER TABLE ONLY "Retur"
    ADD CONSTRAINT "Retur_pkey" PRIMARY KEY (id_retur);


--
-- Name: Warna_pkey; Type: CONSTRAINT; Schema: public; Owner: sora; Tablespace: 
--

ALTER TABLE ONLY "Warna"
    ADD CONSTRAINT "Warna_pkey" PRIMARY KEY (id_warna);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

