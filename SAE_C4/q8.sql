CREATE OR REPLACE FUNCTION best_auteur() RETURNS integer AS $$
BEGIN
  -- On exécute une requête qui retourne le nombre d'oeuvres
  -- de l'auteur ayant le plus grand nombre d'oeuvres
  RETURN (SELECT COUNT(*)
          FROM oeuvres
          WHERE en_stock = false and auteur_id IN (SELECT auteur_id
                              FROM oeuvres
                              GROUP BY auteur_id
                              ORDER BY COUNT(*) DESC
                              LIMIT 1));
END;
$$ LANGUAGE plpgsql;
