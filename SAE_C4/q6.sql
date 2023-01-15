CREATE OR REPLACE FUNCTION autoMajVentes()
RETURNS TRIGGER AS $$
DECLARE
  rec record;
  rec_old record;
  rec_cli record;
  rec_cli_old record;
  boolean_en_stock BOOLEAN;
BEGIN
	if(tg_table_name='ventes') then

			if(tg_op = 'UPDATE') then
			SELECT prix_TTC INTO rec FROM oeuvres WHERE oeuvre_id = NEW.oeuvre_id; 
			SELECT prix_TTC INTO rec_old FROM oeuvres WHERE oeuvre_id = OLD.oeuvre_id;
			select cli_id into rec_cli_old from clients where cli_id in (select cli_id from factures where fac_id = OLD.fac_id);
			select cli_id into rec_cli from clients where cli_id in (select cli_id from factures where fac_id = NEW.fac_id);

			UPDATE oeuvres SET en_stock = true WHERE oeuvre_id = OLD.oeuvre_id;
			UPDATE oeuvres SET en_stock = false WHERE oeuvre_id = NEW.oeuvre_id;
			

			UPDATE factures SET montant_TTC = montant_TTC - rec_old.prix_TTC WHERE fac_id = OLD.fac_id;
			UPDATE factures SET montant_TTC = montant_TTC + rec.prix_TTC WHERE fac_id = NEW.fac_id;
			UPDATE factures SET fac_nb_oeuvre = fac_nb_oeuvre + 1 WHERE fac_id = NEW.fac_id;
			UPDATE factures SET fac_nb_oeuvre = fac_nb_oeuvre - 1 WHERE fac_id = OLD.fac_id;
			

			UPDATE Clients SET cli_nb_oeuvres = cli_nb_oeuvres - 1 WHERE cli_id = rec_cli_old.cli_id;
			UPDATE Clients SET cli_nb_oeuvres = cli_nb_oeuvres + 1 WHERE cli_id = rec_cli.cli_id;
			UPDATE Clients SET cli_ca = cli_ca - rec_old.prix_TTC WHERE cli_id = rec_cli_old.cli_id;
			UPDATE Clients SET cli_ca = cli_ca + rec.prix_TTC WHERE cli_id =  rec_cli.cli_id;

		end if;
		
		if(tg_op = 'INSERT') then
			select en_stock into boolean_en_stock from oeuvres where oeuvre_id = NEW.oeuvre_id;
			if (boolean_en_stock == TRUE) then
				select cli_id into rec_cli from clients where cli_id in (select cli_id from factures where fac_id = NEW.fac_id);
				select prix_TTC into rec from oeuvres where oeuvre_id=NEW.oeuvre_id; 
				UPDATE oeuvres SET en_stock = false	where oeuvre_id = NEW.oeuvre_id;
				UPDATE factures SET fac_nb_oeuvre = fac_nb_oeuvre + 1, montant_TTC = montant_TTC + rec.prix_TTC WHERE fac_id = NEW.fac_id;
				UPDATE Clients SET cli_nb_oeuvres = cli_nb_oeuvres + 1, cli_ca = cli_ca + rec.prix_TTC where cli_id = rec_cli.cli_id;
			else 
				raise notice 'L oeuvre n est plus en stock'
			END if;
			
		end if;
			
		if(tg_op = 'DELETE') then
			select c.cli_id into rec_cli from clients as c inner join factures as f on c.cli_id = f.fac_id where f.fac_id=OLD.fac_id;
			select prix_TTC into rec from oeuvres where oeuvre_id=OLD.oeuvre_id; 
			UPDATE oeuvres SET en_stock = true	where oeuvre_id = OLD.oeuvre_id;
			UPDATE factures SET fac_nb_oeuvre = fac_nb_oeuvre - 1, montant_TTC = montant_TTC - rec.prix_TTC WHERE fac_id = OLD.fac_id;
			UPDATE Clients SET cli_nb_oeuvres = cli_nb_oeuvres - 1, cli_ca = cli_ca - rec.prix_TTC where cli_id = rec_cli.cli_id;
		end if;
		
	end if;
RETURN NEW;	
END;
$$ LANGUAGE plpgsql;


CREATE or replace TRIGGER autoMajVentesTrigger
AFTER INSERT or DELETE or UPDATE ON ventes
FOR EACH ROW
EXECUTE PROCEDURE autoMajVentes();
