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