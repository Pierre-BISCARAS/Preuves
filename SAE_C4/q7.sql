-- Créez d'abord la fonction déclencheur
CREATE OR REPLACE FUNCTION archive_client_on_delete() RETURNS trigger AS
$BODY$
DECLARE 
date_suppression DATE;
nom_utilisateur text;
BEGIN
  -- Récupérez la date courante
  date_suppression = current_timestamp;

  -- Récupérez le nom de l'utilisateur actuellement connecté
  nom_utilisateur = current_user;

  -- Insérez les données du client supprimé dans la table d'archives,
  -- en incluant la date de suppression et le nom de l'utilisateur
  INSERT INTO archives_client (cli_id, cli_nom, cli_pnom, cli_adr, cli_CP,cli_ville,cli_mail,cli_CA,cli_nb_oeuvres, delete_user, archive_date)
  VALUES (OLD.cli_id, OLD.cli_nom, OLD.cli_pnom, OLD.cli_adr, OLD.cli_CP, OLD.cli_ville, OLD.cli_mail, OLD.cli_CA, OLD.cli_nb_oeuvres,nom_utilisateur ,date_suppression );

  -- Retourne les données du client supprimé
  RETURN OLD;
END;
$BODY$ LANGUAGE plpgsql;

-- Ensuite, créez le déclencheur en associant la fonction déclencheur à la table clients
-- et en spécifiant que le déclencheur doit être exécuté lorsqu'une ligne est supprimée de la table clients
CREATE OR REPLACE TRIGGER archive_client_on_delete
AFTER DELETE ON clients
FOR EACH ROW EXECUTE PROCEDURE archive_client_on_delete();



