SELECT au.auteur_nom
FROM auteurs as au
JOIN oeuvres as oe ON oe.auteur_id = au.auteur_id
GROUP BY au.auteur_nom
HAVING COUNT(oe.oeuvre_id) BETWEEN 0.8 * best_auteur() AND 0.9 * best_auteur();

