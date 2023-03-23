SELECT TRIM(LEADING '0' FROM DATE_FORMAT(DATETIME, '%H')) AS HOUR
     , COUNT(*)
  FROM ANIMAL_OUTS
 WHERE DATE_FORMAT(DATETIME, '%H:%i') BETWEEN '09:00' AND '19:59'
 GROUP BY HOUR
 ORDER BY DATE_FORMAT(DATETIME, '%H');