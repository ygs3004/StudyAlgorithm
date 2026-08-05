SELECT P.ID
      ,P.NAME
      ,P.HOST_ID
  FROM PLACES P
 WHERE EXISTS (SELECT HOST_ID
                 FROM PLACES
                WHERE HOST_ID = P.HOST_ID
                GROUP BY HOST_ID
               HAVING COUNT(1) >= 2)
 ORDER BY P.ID
 