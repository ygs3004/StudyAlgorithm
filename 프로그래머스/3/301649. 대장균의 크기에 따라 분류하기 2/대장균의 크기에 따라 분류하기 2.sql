WITH ED_RANK AS (
    SELECT ID
         , COUNT(*) OVER () AS COUNT
         , RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) AS RANKING
      FROM ECOLI_DATA
)
SELECT ER.ID
     , CASE WHEN (ER.RANKING / ER.COUNT) <= 0.25
            THEN 'CRITICAL'
            WHEN (ER.RANKING / ER.COUNT) <= 0.50
            THEN 'HIGH'
            WHEN (ER.RANKING / ER.COUNT) <= 0.75
            THEN 'MEDIUM'
            ELSE 'LOW' END AS COLONY_NAME
  FROM ED_RANK ER
 ORDER BY ID