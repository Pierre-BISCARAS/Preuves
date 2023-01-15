CREATE OR REPLACE FUNCTION scan_facture(id_facture INTEGER)
RETURNS TABLE(fac_id INTEGER, date_fac DATE, montant_TTC NUMERIC, fac_nb_oeuvre INTEGER, cli_id INTEGER) AS
$BODY$
BEGIN
  RETURN QUERY SELECT f.fac_id, f.date_fac, f.montant_TTC, f.fac_nb_oeuvre, f.cli_id
                FROM factures f
                WHERE f.fac_id = id_facture;
END;
$BODY$
LANGUAGE plpgsql;




