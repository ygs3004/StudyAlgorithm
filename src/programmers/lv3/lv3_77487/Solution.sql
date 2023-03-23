SELECT *
  FROM PLACES
 WHERE HOST_ID IN (SELECT HOST_ID
                     FROM PLACES
                    GROUP BY HOST_ID
                   HAVING COUNT(*) > 1)
 ORDER BY ID;