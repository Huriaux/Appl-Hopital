-- Mettre à jour les informations (prénom) d'un patient
UPDATE patient
SET prenom = 'Jeanne'
WHERE id_patient = 36;

-- Valider la transaction si nécessaire
COMMIT;

-- Vérifier les données après la mise à jour
SELECT prenom, nom FROM patient WHERE id_patient = 36;

