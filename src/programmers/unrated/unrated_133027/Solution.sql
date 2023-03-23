SELECT FH.FLAVOR
  FROM FIRST_HALF FH
  JOIN (SELECT FLAVOR
             , SUM(TOTAL_ORDER) SUM_JULY
          FROM JULY
         GROUP BY FLAVOR) J
    ON FH.FLAVOR = J.FLAVOR
  ORDER BY TOTAL_ORDER+SUM_JULY DESC
  LIMIT 3;