-- Pode ser necessário criar uma sequence antes 
CREATE SEQUENCE dadosnfe_seq START 1;

-- public.dadosnfe definition

-- Drop table

-- DROP TABLE public.dadosnfe;

CREATE TABLE public.dadosnfe (
	id int8 NOT NULL,
	cnpj varchar(255) NULL,
	cnpjdest varchar(255) NULL,
	cuf int4 NULL,
	dh_emi timestamp(6) NULL,
	id_nfse varchar(255) NULL,
	nnf int4 NULL,
	vnf float8 NULL,
	v_tot_trib float8 NULL,
	x_fant varchar(255) NULL,
	x_nome varchar(255) NULL,
	CONSTRAINT dadosnfe_pkey PRIMARY KEY (id)
);


-- public.xmlnfe definition

-- Drop table

-- DROP TABLE public.xmlnfe;

CREATE TABLE public.xmlnfe (
	id int8 NOT NULL,
	xml_content oid NULL,
	CONSTRAINT xmlnfe_pkey PRIMARY KEY (id)
);

-- -- Zerar o autoincremento , caso necessário
-- ALTER SEQUENCE xmlnfe_seq RESTART WITH 1;