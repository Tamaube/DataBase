SELECT  nomIndividu,prenomIndividu
FROM ens2004.Individu WHERE rownum<=5;

SELECT Titre,libellegenre
FROM ens2004.FILM NATURAL JOIN ens2004.GenreFilm NATURAL JOIN ens2004.Genre
WHERE rownum<=5;