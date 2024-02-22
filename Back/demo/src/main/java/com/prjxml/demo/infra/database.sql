-- Pode ser necessário criar uma sequence antes 
CREATE SEQUENCE dadosnfe_seq START 1;

-- public.dadosnfe definition

-- Drop table

-- DROP TABLE public.dadosnfe;

CREATE TABLE public.dadosnfe (
	id bigserial NOT NULL,
	cnpj varchar(255) NULL,
	cnpjdest varchar(255) NULL,
	cuf int4 NULL,
	created_at timestamp(6) NULL,
	dhemi timestamp(6) NULL,
	idnfse varchar(255) NULL,
	nnf int4 NULL,
	vnf float8 NULL,
	vtottrib float8 NULL,
	xfant varchar(255) NULL,
	xnome varchar(255) NULL,
	xmlnfe_id int8 NULL,
	CONSTRAINT dadosnfe_pkey PRIMARY KEY (id),
	CONSTRAINT fkpfao7bjfax67li5xwyf1620af FOREIGN KEY (xmlnfe_id) REFERENCES public.xmlnfe(id)
);

-- public.xmlnfe definition

-- Drop table

-- DROP TABLE public.xmlnfe;

CREATE TABLE public.xmlnfe (
	id int8 NOT NULL,
	xml_content oid NULL,
	CONSTRAINT xmlnfe_pkey PRIMARY KEY (id)
);


-- Zerar o autoincremento
ALTER SEQUENCE dadosnfe_id_seq RESTART WITH 1;
ALTER SEQUENCE xmlnfe_id_seq  RESTART WITH 1;

--encontrar a sequence
SELECT pg_get_serial_sequence('public.dadosnfe', 'id');
SELECT pg_get_serial_sequence('public.xmlnfe', 'id');
