SELECT RC.MONT MONTH
     , RC.CAR_ID
     , RC.RECORDS
  FROM (
        SELECT MT.MONT
             , CAR_ID
             , COUNT(*) RECORDS
          FROM (SELECT MONTH(START_DATE) MONT
                     , CAR_ID
                  FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
                 WHERE MONTH(START_DATE) BETWEEN 8 AND 10) MT
         GROUP BY MT.CAR_ID, MT.MONT
        ) RC
  JOIN 
        (
         SELECT CAR_ID
              , COUNT(*) RENTAL
           FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
          WHERE MONTH(START_DATE) BETWEEN 8 AND 10
          GROUP BY CAR_ID
          HAVING RENTAL >= 5
        ) RT
    ON RC.CAR_ID = RT.CAR_ID
 ORDER BY MONTH, CAR_ID DESC;