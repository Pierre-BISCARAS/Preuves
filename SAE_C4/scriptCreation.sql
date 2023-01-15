
DROP TABLE IF EXISTS oeuvres ;
CREATE TABLE oeuvres (oeuvre_id serial PRIMARY KEY,
oeuvre_titre VARCHAR(50),
oeuvre_descrip text,
oeuvre_dim_larg NUMERIC,
oeuvre_dim_haut NUMERIC,
prix_TTC INTEGER,
en_stock BOOLEAN not NULL,
auteur_id INTEGER);

DROP TABLE IF EXISTS auteurs ;
CREATE TABLE auteurs (auteur_id serial PRIMARY KEY,
auteur_nom VARCHAR(50),
auteur_pnom VARCHAR,
auteur_maxime text,
auteur_A_Propos text,
auteur_dateNai DATE);

DROP TABLE IF EXISTS factures ;
CREATE TABLE factures (fac_id serial PRIMARY KEY,
date_fac DATE,
montant_TTC NUMERIC default 0,
fac_nb_oeuvre INTEGER default 0,
cli_id INTEGER);

DROP TABLE IF EXISTS clients ;
CREATE TABLE clients (cli_id serial PRIMARY KEY,
cli_nom VARCHAR(50),
cli_pnom VARCHAR(50),
cli_adr VARCHAR(50),
cli_CP VARCHAR(50),
cli_ville VARCHAR(50),
cli_mail VARCHAR(100),
cli_CA NUMERIC default 0,
cli_nb_oeuvres INTEGER);

DROP TABLE IF EXISTS ventes;
CREATE TABLE ventes (oeuvre_id INTEGER NOT NULL,
fac_id INTEGER NOT NULL,
vente_id serial PRIMARY KEY );

DROP TABLE IF EXISTS archives_client;
CREATE TABLE archives_client (
cli_id INTEGER,
cli_nom VARCHAR(50),
cli_pnom VARCHAR(50),
cli_adr VARCHAR(50),
cli_CP VARCHAR(50),
cli_ville VARCHAR(50),
cli_mail VARCHAR(100),
cli_CA NUMERIC default 0,
cli_nb_oeuvres INTEGER,
delete_user VARCHAR(50),
archive_date DATE);


ALTER TABLE oeuvres ADD CONSTRAINT FK_Oeuvres_Auteur_id_Auteurs FOREIGN KEY (auteur_id) REFERENCES auteurs (auteur_id);
ALTER TABLE factures ADD CONSTRAINT FK_Factures_Cli_id_Clients FOREIGN KEY (cli_id) REFERENCES clients (cli_id);
ALTER TABLE ventes ADD CONSTRAINT FK_ventes_Oeuvre_Id_Oeuvres FOREIGN KEY (oeuvre_Id) REFERENCES oeuvres (oeuvre_Id);
ALTER TABLE ventes ADD CONSTRAINT FK_ventes_Fac_id_Factures FOREIGN KEY (fac_id) REFERENCES factures (fac_id);
