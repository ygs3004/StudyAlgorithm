SELECT A.HISTORY_ID
     , ROUND(C.DAILY_FEE*A.RENTAL*A.DISCOUNT_RATE) FEE
  FROM
      (SELECT H.HISTORY_ID 
            , H.RENTAL
            , H.CAR_ID 
            , P.CAR_TYPE
            , P.DURATION
            , (CASE WHEN H.RENTAL >= 7 THEN P.DISCOUNT_RATE ELSE 1 END) DISCOUNT_RATE 
         FROM (SELECT HISTORY_ID
                    , DATEDIFF(END_DATE, START_DATE)+1 RENTAL
                    , CAR_ID
                 FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY) H
         JOIN (SELECT SUBSTRING_INDEX(DURATION_TYPE, '일', 1) DURATION
                    , CAR_TYPE
                    , (100-DISCOUNT_RATE)*0.01 DISCOUNT_RATE
                 FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                WHERE CAR_TYPE = '트럭') P 
        WHERE DURATION = CASE WHEN RENTAL BETWEEN 7 AND 29 THEN 7 
                              WHEN RENTAL BETWEEN 30 AND 89 THEN 30
                              WHEN RENTAL >= 90 THEN 90 
                              ELSE 7 END) A
   JOIN CAR_RENTAL_COMPANY_CAR C ON A.CAR_ID = C.CAR_ID
                                AND C.CAR_TYPE = A.CAR_TYPE
 ORDER BY FEE DESC, HISTORY_ID DESC;