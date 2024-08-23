
#1. Obtener todos los registros con celular duplicado:
SELECT id, nombre, correo_electronico
FROM formulario
WHERE celular IN (
    SELECT celular
    FROM formulario
    GROUP BY celular
    HAVING COUNT(celular) > 1
);


#2. Actualizar los registros de la tabla formulario con xml nulo, usando el valor correspondiente de formulario_extras:

UPDATE formulario f
JOIN formulario_extras fe ON f.id = fe.id_formulario
SET f.xml = fe.xml
WHERE f.xml IS NULL AND fe.xml IS NOT NULL;

#3. Encontrar los registros de formulario sin un registro correspondiente en formulario_extras

SELECT f.*
FROM formulario f
LEFT JOIN formulario_extras fe ON f.id = fe.id_formulario
WHERE fe.id_formulario IS NULL;
